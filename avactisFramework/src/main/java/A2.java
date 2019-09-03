import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.paratus.avactis.testbase.TestBase;

public class A2 extends TestBase{

	int i = 1;

	@Test
	public void demoTest() {
		if (i == 3) {
			Assert.assertTrue(true);
		} else {
			i++;
			Assert.assertTrue(false);
		}
	}
}
