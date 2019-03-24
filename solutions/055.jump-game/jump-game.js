/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let index = 0;
    let cnt = nums[0];
    while(cnt > 0 && index < nums.length - 1){
        let tempIndex = index;
        for(let i = 0; i <= cnt; i++){
            if(i + nums[index + i] > cnt){
                tempIndex += i;
                break;
            }
        }
        if(tempIndex === index){
            index += cnt;
            cnt =0;
        }else{
            cnt = nums[tempIndex];
            index = tempIndex;
        }
        
    }
    return index >= nums.length - 1
};