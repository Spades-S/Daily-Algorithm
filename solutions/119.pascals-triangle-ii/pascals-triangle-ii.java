class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> result = new ArrayList<Integer>();
            result.add(1);
            return result;
        }
        if(rowIndex == 1){
            List<Integer> result = new ArrayList<Integer>();
            result.add(1);
            result.add(1);
            return result;
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        pre.add(1);
        
        for(int i = 2; i <= rowIndex; i++){ // i-th row
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < i; j++ ){ // j-th  item
                int value = pre.get(j) + (j == 0 ? 0 : pre.get(j-1));
                temp.add(value);
            }
            temp.add(1);
            pre = temp;
        }
        
        return pre;
    }
}