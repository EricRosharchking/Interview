import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all
     * overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the
     * intervals in the input.
     * 
     * 
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * 
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2 }, { 3, 4 }, { 5, 8 } };
        int[][] arr2 = { { 1, 3 }, { 2, 4 }, { 5, 8 } };
        int[][] arr3 = { { 1, 4 }, { 2, 3 }, { 5, 8 } };
        int[][] arr4 = { { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 }, { 7, 8 } };
        int[][] res = mergeIntervals(arr3);
        Arrays.deepToString(res);
    }

    public static int[][] mergeIntervals(int[][] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        List<Interval> res = new ArrayList<>();
        List<Interval> list = new ArrayList<>();
        MergeIntervals en = new MergeIntervals();
        for (int[] interval : arr) {
            list.add(en.new Interval(interval[0], interval[1]));
        }
        Comparator<Interval> comparator = (Interval o1, Interval o2) -> ((Integer) o1.getStart())
                .compareTo(o2.getEnd());
        Collections.sort(list);

        System.out.println(list);
        System.out.println("====================");

        int slow = 0, fast = slow + 1;
        boolean overlaps = false;
        while (slow < list.size() && fast < list.size()) {
            if (list.get(fast - 1).getEnd() >= list.get(fast).getStart()) {
                overlaps = true;
            } else {
                if (overlaps) {
                    res.add(en.new Interval(list.get(slow).getStart(),
                            list.get(slow).getEnd() > list.get(fast - 1).getEnd() ? list.get(slow).getEnd()
                                    : list.get(fast - 1).getEnd()));
                } else {
                    res.add(list.get(slow));
                }
                slow = fast;
                overlaps = false;
            }
            fast++;
            // System.out.println(slow + "," + fast);
        }

        if (overlaps) {
            res.add(en.new Interval(list.get(slow).getStart(),
                    list.get(slow).getEnd() > list.get(fast).getEnd() ? list.get(slow).getEnd()
                            : list.get(fast).getEnd()));
        } else {
            res.add(list.get(slow));
        }
        System.out.println(res);

        int[][] resArr = new int[res.size()][2];
        for (int k = 0; k < resArr.length; k++) {
            resArr[k][0] = res.get(k).getStart();
            resArr[k][1] = res.get(k).getEnd();
        }
        return resArr;
    }

    class Interval implements Comparable<Interval> {
        private Integer start;
        private Integer end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (start == o.getStart()) {
                return end.compareTo(o.getEnd());
            }
            return start.compareTo(o.start);
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
