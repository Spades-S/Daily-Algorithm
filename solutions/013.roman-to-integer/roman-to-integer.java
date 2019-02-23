class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String,Integer>() {
            {
            put("M",1000);
            put("CM",900);
            put("D",500);
            put("CD",400);
            put("C",100);
            put("XC",90);
            put("L",50);
            put("XL",40);
            put("X",10);
            put("IX",9);
            put("V",5);
            put("IV",4);
            put("III",3);
            put("II",2);
            put("I",1);
        }
        };
        String item = "";
        int result = 0;
        for(int i = 0;i < s.length(); i++){
            if(i==s.length()-1){
                item = String.valueOf(s.charAt(i));
                result += map.get(item);
                break;
            }
            switch(s.charAt(i)){
                case 'C':
                    if(s.charAt(i+1) == 'M'){
                        item = "CM";
                        i = i+1;
                    }else if(s.charAt(i+1)=='D'){
                        item = "CD";
                        i = i+1;
                    }else{
                        item = String.valueOf(s.charAt(i));

                    }
                    break;
                case 'X':
                    if(s.charAt(i+1)=='C'){
                        item = "XC";
                        i = i+1;
                    }else if(s.charAt(i+1)=='L'){
                        item = "XL";
                        i = i+1;
                    }else{
                        item = String.valueOf(s.charAt(i));
                    }
                    break;
                case 'I':
                    if(s.charAt(i+1)=='X'){
                        item = "IX";
                        i = i+1;
                    }else if(s.charAt(i+1)=='V'){
                        item = "IV";
                        i = i+1;
                    }else{
                        item = String.valueOf(s.charAt(i));
                    }
                    break;
                default:
                   item = String.valueOf(s.charAt(i));
                    break;
            }

            
                    result += map.get(item);
            
            
        }
    return result;
        
    }
}