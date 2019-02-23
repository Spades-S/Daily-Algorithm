class Solution {
    public int[] map = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
    public HashSet<String> res = new HashSet<String>();
    public List<String> readBinaryWatch(int num) {
        helper(num, 0, new ArrayList<Integer>());
        return new ArrayList<String>(res);
    }
    
    public void helper(int num, int deep, List<Integer> list){
        if(deep == 10){
            if(num == 0){
                int hour = 0, min = 0;
                for(int i = 0; i < 10; i++){
                    if(i<4){
                        hour += map[i]*list.get(i);
                    }else{
                        min += map[i]*list.get(i);
                    }
                }
                if(hour < 12 && min < 60){
                    String time = hour + ":";
                    if(min < 10) {
                        time += "0";
                    }
                    res.add(time + min);
                }  
            }
            return;
        }
        
        if(num > 0){
            list.add(1);
            helper(num - 1, deep + 1, new ArrayList<Integer>(list));
        }else{
            list.add(0);
            helper(num, deep + 1, new ArrayList<Integer>(list));
        }
        list.remove(list.size() - 1);
        list.add(0);
        helper(num, deep + 1, new ArrayList<Integer>(list));
    }
}