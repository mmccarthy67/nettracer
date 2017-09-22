package aero.nettracer.kitems.utils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestKItemUtil {
    /*comparator to create max heap*/
    static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

    public static Queue<Integer> FindSmallestKItems(List<Integer> list, int k) {
        MaxHeapComparator maxHeapComparator = new MaxHeapComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, maxHeapComparator);

        for (Integer i : list) {
            if (maxHeap.size() < k) {
                maxHeap.add(i);
            } else if (maxHeap.peek() > i) {
                maxHeap.remove();
                maxHeap.add(i);
            }
        }
        return maxHeap;
    }
}