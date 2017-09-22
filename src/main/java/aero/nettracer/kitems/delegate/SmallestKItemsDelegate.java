package aero.nettracer.kitems.delegate;

import aero.nettracer.kitems.utils.SmallestKItemUtil;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestKItemsDelegate {
    public Queue<Integer> processArrayFile(List<Integer> list, int k) {
        System.out.println("Processing smallest K items.");
        System.out.println("list = [" + list + "], k = [" + k + "]");
        return SmallestKItemUtil.FindSmallestKItems(list, k);
    }
}