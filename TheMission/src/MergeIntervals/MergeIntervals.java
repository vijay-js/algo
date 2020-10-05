package MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        intervals.sort((Interval i1,Interval i2) -> i1.start - i2.start);
        if(intervals.size() < 2) return mergedIntervals;

        Interval previous = intervals.get(0);
        for(int i=1;i<intervals.size();i++) {
            Interval current = intervals.get(i);
            if(previous.end < current.start) {
                mergedIntervals.add(previous);
                previous = current;
            }
            else {
                //Two previous and current merge --> Set previous with start and end
                int start = previous.start;
                int end = previous.end > current.end ? previous.end : current.end;
                Interval temp = new Interval(start,end);
                previous = temp;
            }
        }
        mergedIntervals.add(previous);
        return mergedIntervals;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(7, 9));
        input.add(new Interval(2, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
