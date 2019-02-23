class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int length = nums.length,mid=-1;
        if(length<=0||target<nums[0]||target>nums[length-1]){
            return result;
        }
        if(nums[0]==target){
            mid = 0;
            result = new int[]{0,0};
            if(nums[length-1]==target){
                result = new int[]{0,length-1};
                return result;
            }
        }else if(nums[length-1]==target){
            result = new int[]{length-1,length-1};
            mid = length-1;
        }

        int start = 0, end = length - 1;
        while(start<end-1 && result[0]==-1){
            mid = (start+end)/2;
            if(nums[mid]==target){
                result = new int[]{mid, mid};
                break;
             
            }else if(nums[mid]>target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(result[0]!=-1){
            int sEnd = mid, eStart = mid;
            if(nums[start]<target && nums[start+1]==target){
                result[0] = start+1;
            }else{
                while(start<sEnd-1){
                    int sMid = (start + sEnd)/2;
                    if(nums[sMid]<target && nums[sMid+1]==target){
                        result[0]=sMid+1;
                        break;
                    }else if(nums[sMid+1]<target){
                        start = sMid;
                    }else if(nums[sMid]==target){
                        sEnd = sMid;
                    }
                }
            }
            if(nums[end]>target && nums[end-1] == target){
                result[1] = end-1;
            }else{
                while(eStart<end-1){
                    int eMid = (eStart+end)/2;
                    if(nums[eMid]>target && nums[eMid-1]==target){
                        result[1] = eMid-1;
                        break;
                    }else if(nums[eMid] == target){
                        eStart = eMid;
                    }else if(nums[eMid] > target){
                        end = eMid;
                    }
                }
            }            
        }

        return result;
        
        
    }
}