### 216 Combination Sum III

#### Problem
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.

#### Examples
```
Input: k = 3, n = 7
Output: [[1,2,4]]

```

```
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

```

#### Solution
【分析】这题很像子集那题，不能重复，combination中都是不同的元素，所以就写了个DFS。

``` java
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < k || n > k*9){
            return res;
        }
        dfsHelper(1, k, 1, n, new ArrayList<Integer>());
        return res;
    }
    public void dfsHelper(int nth, int k,int start, int sum, List<Integer> list){
        if(nth == k){
            if(sum >= start && sum < 10){
                list.add(sum);
                res.add(list);
            }
            return;
        }
        for(int i = start; i < 10; i++){
            list.add(i);
            helper(nth + 1, k, i + 1,sum - i, new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
        }
    }
}
```

【优化】上述解法在思路上是没有问题的，但是可以做一点小优化。上述解法中用了ArrayList去做每一个combination的记录，这个是从子集那题来的，但是本题和子集不同的是，子集长度是不定的，但是本题的combination的长度是固定的，因此我们可以用定长的数组来替换ArrayList，以降低由ArrayList造成的时间复杂度。

``` java
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < k || n > k*9){
            return res;
        }
        helper(1, k, 1, n, new int[k]);
        return res;
    }
    public void helper(int nth, int k,int start, int sum, int[] buffer){
        if(nth == k){
            if(sum >= start && sum < 10){
                List<Integer> list = new ArrayList<Integer>();
                buffer[nth - 1] = sum;
                for(int item : buffer){
                    list.add(item);
                }
                res.add(list);
            }
            return;
        }
        if(sum <= 0){
            return;
        }
        for(int i = start; i < 10; i++){
            buffer[nth - 1] = i;
            helper(nth + 1, k, i + 1,sum - i, buffer);
			// 这里的 list.remove(list.size() - 1)也被删除了，因为每次循环都会更新数组的相同位置，这相当于完成了回溯，也就无需通过remove这种方式去回溯了。
        }
    }
}
```