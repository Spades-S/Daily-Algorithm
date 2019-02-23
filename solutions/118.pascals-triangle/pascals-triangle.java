class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int cnt = 1; cnt <= numRows; cnt++){
            List<Integer> row = new ArrayList<Integer>();
            for(int i = 0; i < cnt; i++){
                if(i == 0 || i == cnt-1){
                    row.add(1);
                }else{
                    int value = result.get(cnt - 2).get(i-1) + result.get(cnt - 2).get(i);
                    row.add(value);
                }
            }
            result.add(row);
        }
      return result;  
    }
}