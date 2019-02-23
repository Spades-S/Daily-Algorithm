class Solution {
    public String reorganizeString(String S) {
        int length = S.length();
        if(length<=1){
            return S;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Character> list = new ArrayList<Character>();
        Character most = S.charAt(0);
        int maxNum = 0;
        
        for(int i = 0; i < length; i++){
            Character c = new Character(S.charAt(i));
            if(list.contains(c)){
                int value = map.get(c) + 1;
                if(value > (length+1)/2){
                    return "";
                }
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
                list.add(c);
            }
            if(map.get(c)>maxNum){
                most = c;
                maxNum = map.get(c);
            }
        }
        return helper(list, map, most, length);
    }
    
    public String helper(ArrayList<Character> list, HashMap<Character, Integer> map, Character most, int length){
        char[] res = new char[length];
        Character c = most;
        list.remove(c);
        int counter = 0, index=0;
        while(counter<length){
            if(index>=length){
                index=1;
            }
            if(map.get(c)==0){
                c = list.get(0);
                list.remove(0);
            }
            res[index] = c;
            map.put(c, map.get(c)-1);
            index += 2;
            counter++;
        }
        return String.valueOf(res);
        
    }
}