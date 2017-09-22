package aero.nettracer.kitems.utils;

import java.util.*;

public class SmallestKthItemUtil {
    /**
     * Randomized quick select
     * Average/Best case: O(n)
     * Worst case: O(n^2)
     *
     */
    public static int findKthSmallest(int[] arr, int k){
        if(k < 1 || k > arr.length) return -1;
        return findKthSmallest(arr, k - 1, 0, arr.length - 1);
    }

    public static int findKthSmallest(int[] arr, int k, int start, int end){
        int partitionIndex = partition(arr, start, end);
        if(partitionIndex > k){
            return findKthSmallest(arr, k, start, partitionIndex - 1);
        }else if(partitionIndex < k){
            return findKthSmallest(arr, k, partitionIndex + 1, end);
        }else{
            return arr[partitionIndex];
        }
    }

    public static int partition(int[] arr, int start, int end){
        Random random = new Random();
        int pivotIndex = start + random.nextInt(end - start + 1);
        swap(arr, pivotIndex, end);
        int pivot = arr[end];
        int i = start, j = start;
        while(j < end){
            if(arr[j] < pivot){
                swap(arr, j, i);
                i++;
            }
            j++;
        }
        swap(arr, i, end);
        return i;
    }

    public static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    /**
     * Min heap
     * Time: O(n + klogn)
     *
     */
    public static int findKthSmallest2(List<Integer> arr, int k){
        Queue<Integer> queue = new PriorityQueue<Integer>(arr.size());
        for(int num : arr){
            queue.add(num);
        }

        for(int i = 0; i < k - 1; i++){
            queue.poll();
        }
        return queue.poll();
    }

    /**
     * Max heap
     * Time: O(k + (n - k)logk)
     *
     */
    public static int findKthSmallest3(int[] arr, int k){
        if(k < 1 || k > arr.length) return -1;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Queue<Integer> queue = new PriorityQueue<Integer>(k, comparator);
        for(int i = 0; i < k; i++){
            queue.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.poll();
    }
}