package aero.nettracer.kitems;

import aero.nettracer.kitems.utils.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtilsTests {
    @Before
    public void setup() {}

    @After
    public void teardown() {}

    @Test
    public void getApplicationProperties() {
        Properties props = FileUtils.getApplicationProperties();
        Assert.assertNotNull(props);
        Assert.assertEquals("y", props.get("random.flag").toString());
    }

    @Test
    public void getArrayFileFromResources() {
        List arrayList = FileUtils.getArrayFileFromResources();
        Assert.assertNotNull(arrayList);
        Assert.assertTrue(arrayList.size() > 0);
    }
}