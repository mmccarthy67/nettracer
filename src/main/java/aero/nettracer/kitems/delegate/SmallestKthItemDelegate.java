package aero.nettracer.kitems.delegate;

import aero.nettracer.kitems.utils.SmallestKthItemUtil;

import java.util.List;

public class SmallestKthItemDelegate {
    public int processArrayFile(List<Integer> list, int k) {
        System.out.println("Processing smallest Kth item.");
        System.out.println("list = [" + list + "], k = [" + k + "]");
        return SmallestKthItemUtil.findKthSmallest2(list, k);
    }
}