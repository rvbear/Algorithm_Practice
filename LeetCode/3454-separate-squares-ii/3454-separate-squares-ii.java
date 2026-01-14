import java.util.*;

class Solution {
    private static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Interval o) {
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }

            return Integer.compare(this.end, o.end);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Interval interval = (Interval) o;
            return this.start == interval.start && this.end == interval.end;
        }
    }

    private static class Event implements Comparable<Event> {
        int y, type, xStart, xEnd;

        Event(int y, int t, int s, int e) {
            this.y = y;
            type = t;
            xStart = s;
            xEnd = e;
        }

        public int compareTo(Event o) {
            return Integer.compare(this.y, o.y);
        }
    }

    private double getUnionWidth(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        List<Interval> sorted = new ArrayList<>(intervals);
        Collections.sort(sorted);

        double unionLength = 0;
        double currentEnd = Double.MIN_VALUE;

        for (Interval i : sorted) {
            if (i.start >= currentEnd) {
                unionLength += (i.end - i.start);
                currentEnd = i.end;
            } else if (i.end > currentEnd) {
                unionLength += (i.end - currentEnd);
                currentEnd = i.end;
            }
        }

        return unionLength;
    }

    public double separateSquares(int[][] squares) {
        List<Event> sweepEvents = new ArrayList<>();

        for (int[] s : squares) {
            int x = s[0];
            int y = s[1];
            int l = s[2];
            sweepEvents.add(new Event(y, 1, x, x + l));
            sweepEvents.add(new Event(y + l, -1, x, x + l));
        }

        Collections.sort(sweepEvents);

        List<Interval> activeIntervals = new ArrayList<>();
        List<double[]> processedStrips = new ArrayList<>();

        double totalArea = 0;
        int prevY = sweepEvents.get(0).y;

        for (Event e : sweepEvents) {
            if (e.y > prevY) {
                double unionWidth = getUnionWidth(activeIntervals);
                double height = (double) e.y - prevY;

                if (unionWidth > 0) {
                    processedStrips.add(new double[] { prevY, height, unionWidth});
                    totalArea += height * unionWidth;
                }
            }

            Interval currentInterval = new Interval(e.xStart, e.xEnd);
            if (e.type == 1) {
                activeIntervals.add(currentInterval);
            } else {
                activeIntervals.remove(currentInterval);
            }

            prevY = e.y;
        }

        double targetArea = totalArea / 2.0;
        double accumulatedArea = 0;

        for (double[] s : processedStrips) {
            double bottomY = s[0];
            double height = s[1];
            double width = s[2];
            double stripArea = height * width;

            if (accumulatedArea + stripArea >= targetArea) {
                double missingArea = targetArea - accumulatedArea;
                return bottomY + (missingArea / width);
            }
            
            accumulatedArea += stripArea;
        }

        return 0.0;
    }
}