/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // 选择排序
        int length = intervals.size();
        for(int i = 0; i < length; i++){
            int index = i;
            for(int j = i; j < length; j++){
                if(intervals.get(j).start < intervals.get(index).start){
                    index = j;                    
                }
            }
            Interval temp = intervals.get(index);
            intervals.set(index, intervals.get(i));
            if(i > 0 && temp.start <= intervals.get(i-1).end){ //从第二个开始决定是否要合并
                intervals.get(i-1).end = Math.max(temp.end, intervals.get(i-1).end);
                intervals.remove(i);
                length -= 1;
                i -= 1;
            }else{
                intervals.set(i,temp);                 
            }
        }
        return intervals;
    }
}