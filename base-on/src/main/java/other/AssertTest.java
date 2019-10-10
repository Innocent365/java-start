package other;

import org.junit.Assert;

/**
 * 断言
 * @author hw
 * @version on 2019/4/24
 */
public class AssertTest {

    public static void main(String[] args) {
        Assert.assertNotNull("sd");

        Assert.assertEquals(1, 1.0);

        Assert.assertSame(1, 1.0);
        Assert.assertTrue("shit", new String("1") == "1");

    }
}
