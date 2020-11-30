package _00_Text_Funkifier;

public class CustomString extends SpecialString{

	public CustomString(String s) {
		super(s);
	}

	@Override
	public String funkifyText(String s) {
		String output = "";
		for (int i = 0; i < s.length(); i+=2) {
			output = output + s.charAt(i);
		}
		return output;
	}

}
