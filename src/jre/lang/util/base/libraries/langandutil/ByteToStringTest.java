package jre.lang.util.base.libraries.langandutil;

import static org.junit.Assert.*;

import org.junit.Test;

public class ByteToStringTest {
	byte a = 1;
	byte b = 1<<1;
	byte c = 1<<6;
	
	@Test
	public void test() {
		System.out.println(b);
		assertEquals("1",ByteToString.byteToString(a));
		assertEquals("2",ByteToString.byteToString(b));
		assertEquals((1<<6) + "",ByteToString.byteToString(c));
	}

}
