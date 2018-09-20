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

【思路-2】一位一位地往上加，比如题目中的示例`[1,2,3]`，最开始是空集，当需要处理`1`的时候，在空集上加上元素`1`，将产生新的子集`[1]`，至此就可以得到两个子集`[]`和`[1]`，以此类推，将会得到所有的子集。在算法实现上比较简单：遍历数组所有元素，在当前的每个子集上加上当前遍历的元素，产生新的子集。

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





