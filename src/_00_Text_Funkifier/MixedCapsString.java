package _00_Text_Funkifier;

public class MixedCapsString extends SpecialString{

	public MixedCapsString(String s) {
		super(s);
	}

	@Override
	public String funkifyText(String s) {
		String output = "";
		for (int i = 0; i < s.length(); i++) {
		if(i%2==0) {
		output = output + s.toLowerCase().charAt(i);
		}
		else {
			output = output + s.toUpperCase().charAt(i);
			
		}
		
		}
		return output;
	
	}
	}
