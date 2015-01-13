/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> list) {
        Interval[] intervals = new Interval[list.size()];
        for (int i = 0; i < intervals.length; i++)
            intervals[i]  = list.get(i);
            
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i0, Interval i1) {
                return Integer.compare(i0.start, i1.start);
            }
        });
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i+1].start <= intervals[i].end) {
                intervals[i+1] = new Interval(intervals[i].start, Math.max(intervals[i].end, intervals[i+1].end));
                intervals[i] = null;
            }
        }
        
        list = new ArrayList<Interval>();
        for (int i = 0; i < intervals.length; i++)
            if (intervals[i] != null)
                list.add(intervals[i]);
        return list;
    }
}