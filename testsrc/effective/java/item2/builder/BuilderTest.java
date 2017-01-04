package effective.java.item2.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BuilderTest {
	
	Message.Builder builder = null;
	
	@Before
	public void setUp() throws Exception {
		builder = new Message.Builder(1).body("Body").charset("utf-8").checksum("Y").from("Host").header("Header").protocol("Fix4.4");
	}

	@Test
	public void test() {
		Message message = builder.build();
		assertEquals(message.getBody(),"Body");
		assertTrue(message.getId()==1);
	}

}
