### 078 Subsets

#### Problem

Given a set of **distinct** integers, *nums*, return all possible subsets (the power set).

**Note:** The solution set must not contain duplicate subsets.

#### Example

```
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

#### Solutions

【分析】

【思路-1】最开始我的想法是按照从数组中取出0个、1个、2个…length个，得到所有的子集，这在思路上来说是可行的，但是实现起来很困难，难点在于需要从数组中取出i个(2<=i<length)时，如何保证当次取出的数据不会和之前取出的数据重复，这是这个思路最关键的一个点，我没有想到好的处理方法。只能放弃这个思路。

【思路-2】一个元素一个元素地往上加，比如题目中的示例`[1,2,3]`，最开始是空集，当需要处理`1`的时候，在空集上加上元素`1`，将产生新的子集`[1]`，至此就可以得到两个子集`[]`和`[1]`，以此类推，将会得到所有的子集。在算法实现上比较简单：遍历数组所有元素，在当前的每个子集上加上当前遍历的元素，产生新的子集。

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i : nums){
            List<List<Integer>> newItems = new ArrayList<List<Integer>>();
            for(List<Integer> item : result){
                List<Integer> newItem = new ArrayList<Integer>();
                newItem.addAll(item);
                newItem.add(i);
                newItems.add(newItem);
            }
            result.addAll(newItems);
        }
        return result;
    }
}
```

【思路-3】构造二叉树

```
                        []           
                   /          \        
                  /            \     
                 /              \
              [1]                []          --------------------   1
           /       \           /    \
          /         \         /      \        
       [1 2]       [1]       [2]     []      --------------------   2   
      /     \     /   \     /   \    / \
  [1 2 3] [1 2] [1 3] [1] [2 3] [2] [3] []   --------------------   3 
```

对于numbers数组中的每一个元素在子集中只有两种状态，要么存在要么不存在，可以根据这个性质构造一棵二叉树，左子树代表选择该元素，右子树代表不选择。叶子结点的集合就是子集集合。

```java 
class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<Integer>());
        return result;
    }
    private void dfs(int nth, int[] nums, List<Integer> list){
        if(nth == nums.length){
            result.add(list);
            return;
        }
        dfs(nth+1, nums, new ArrayList(list));
        list.add(nums[nth]);
        dfs(nth+1, nums, new ArrayList(list));
    }
}
```



【思路-4】我们可以换一种思路，以 `[1,2,3]` 为例，在寻找子集时，可以这么考虑：子集中**包含`元素1`**的情况；子集中**不包含`元素1`但包含`元素2`**；子集中**不包含`元素1`和`元素2`但包含`元素3`**；子集中为空集。
按照上述思路，我们可以得到如下树状结构：
![20181009202035.png](https://i.loli.net/2018/10/09/5bbc9d185139b.png)
该方法本质还是DFS。

``` java 
class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == a || a.length == 0) return res;
        powerSet(res, new ArrayList<>(), a, 0);
        return res;
    }
    
    private void powerSet(List<List<Integer>> res, List<Integer> cur, int [] a, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < a.length; i++) {
          cur.add(a[i]);
          powerSet(res, cur, a, i+1);
          cur.remove(cur.size()-1);
        }
    }
}
```


### 090 Subsets II


#### Problem
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.


#### Example
```
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

#### Solutions

【分析】**090** 和 **078** 有什么不同呢？唯一的区别在于数组中是否包含重复元素。当数组中包含重复元素时，再按照 **078** 中一位元素一位元素往上加的方式去寻找所有子集时，会出现重复。

**以 [1, 2, 2] 为例**
| 元素|旧有子集集合    |  新生成的子集集合  | 
| :--- |:---- | :----- | 
| 1    |[]      | [1] | 
|2  | [], [1] | [2], [1,2]|
|2 | [], [1], [2], [1, 2]| [2], [1, 2], [2, 2], [1, 2, 2]|


上面的表格有三列，分别表示，加入当前元素前，已有的子集集合，新生成的子集集合表示把当前元素加入到当前旧有子集集合而生成的集合。全部子集集合 = `旧有子集集合` + `新生成子集集合`。我们可以发现当数组中包含重复元素时，按照一位元素一位元素往上加的方式寻找全部子集会出现重复子集。

【思路-1】**可以通过如下方式避免：当前元素为重复元素且非首次出现，只将当前元素加入到上一次的新生成子集集合中。** 为了确定当前元素是 `重复元素且非首次出现，我们首先要对数组进行排序。`

``` java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> oldList = new ArrayList<List<Integer>>(), newList = new ArrayList<List<Integer>>();
        oldList.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            ArrayList<List<Integer>> tempList = new ArrayList<List<Integer>>();
            if(i == 0 || nums[i] != nums[i-1]){
                for(List<Integer> oldItem : oldList){
                    ArrayList<Integer> temp = new ArrayList<>(oldItem);
                    temp.add(nums[i]);
                    tempList.add(temp);
                }
            }
            for(List<Integer> newItem : newList){
                ArrayList<Integer> temp = new ArrayList<>(newItem);
                temp.add(nums[i]);
                tempList.add(temp);
            }
            
            oldList.addAll(newList);
            newList = tempList;
        }
        oldList.addAll(newList);
        return oldList;
        
    }
}
```

【思路-2】可以参考 **078** 中的思路二，如果当前元素是 `重复元素且非首次出现`，跳过即可。
![20181009213148.png](https://i.loli.net/2018/10/09/5bbcadc70645d.png)

``` java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == a || a.length == 0) return res;
        Arrays.sort(a);
        powerSet(res, new ArrayList<>(), a, 0);
        return res;
    }
    
    private void powerSet(List<List<Integer>> res, List<Integer> cur, int [] a, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < a.length; i++) {
            if(i!=start && a[i] == a[i-1]) continue;
            cur.add(a[i]);
            powerSet(res, cur, a, i+1);
            cur.remove(cur.size()-1);
        }
    }
}

```








