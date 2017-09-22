package aero.nettracer.kitems;

import aero.nettracer.kitems.delegate.SmallestKItemsDelegate;
import aero.nettracer.kitems.utils.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Queue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmallestKItemsDelegateTests {
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
            SmallestKItemsDelegate delegate = new SmallestKItemsDelegate();
            Queue<Integer> pq = delegate.processArrayFile(list, DEFAULT_K);
            Assert.assertNotNull(pq);
            Assert.assertTrue(pq.size() == DEFAULT_K);
            System.out.println(pq);
        } else {
            System.out.println("Unable to continue processing.  Array file missing or empty.");
            Assert.fail();
        }
    }
}
