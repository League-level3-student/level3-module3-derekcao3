package _00_Text_Funkifier;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class _00_TestSpecialString {

	//1. Take a look at the TextFunkifier interface and 
	//   the abstract class SpecialString. Notice that the
	//   SpecialString class implements TextFunkifier. Then 
	//   take a look at the BackwardsString class. Notice 
	//   that it extends SpecialString. This means that is also
	//   implements TextFunkifier. Therefore, it must overwrite the
	//   funkifyText method.
	
	//2. Fill in the funkifyText method in the BackwardsString class
	//   to make the JUnitTest pass.
	@Test
	public void testBackwardsString() {
		SpecialString bs = new BackwardsString("This is a test");
		System.out.println(bs);
		assertEquals("tset a si sihT", bs.toString());
	}
	
	//3. Fill in the funkifyTxt method in the MixedCapsString class
	//   to make the JUnitTest case pass.
	@Test
	public void testMixedCapsString() {
		SpecialString mcs = new MixedCapsString("This is also a test");
		System.out.println(mcs);
		assertEquals("tHiS Is aLsO A TeSt", mcs.toString());
	}
	
	//4. Create your own class that extends SpecialString.
	//   Override the funkifyText method to make any kind of 
	//   new String you want. Then use the assertEquals method in
	//   the JUnitTest case below to test your customized Special String.
	@Test
	public void testCustomString() {
	
	}
}
