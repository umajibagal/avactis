import org.testng.Assert;
import org.testng.annotations.Test;

public class A3 {
int i=1;
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
