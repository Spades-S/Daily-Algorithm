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