package aero.nettracer.kitems;

import aero.nettracer.kitems.delegate.SmallestKItemsDelegate;
import aero.nettracer.kitems.delegate.SmallestKthItemDelegate;
import aero.nettracer.kitems.utils.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Queue;

public class SmallestKthItemDelegateTests {
    private static List<Integer> list;
    private static final int DEFAULT_K = 3;

    @Before
    public void setup() {
        list = FileUtils.getArrayFileFromResources();
    }

    @After
    public void teardown() {}

    @Test
    public void processArrayFile() {
        if (list != null && list.size() > 0) {
            SmallestKthItemDelegate delegate = new SmallestKthItemDelegate();
            int i = delegate.processArrayFile(list, DEFAULT_K);
            Assert.assertTrue(i > -1);
            System.out.println(i);
        } else {
            System.out.println("Unable to continue processing.  Array file missing or empty.");
            Assert.fail();
        }
    }
}