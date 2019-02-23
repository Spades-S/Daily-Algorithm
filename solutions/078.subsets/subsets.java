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