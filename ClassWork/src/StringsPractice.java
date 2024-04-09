
public class StringsPractice {
	public String beginToEnd(String str) {
		if(str.length() < 1) {
			return str;
		}
		String displayString = str;
		displayString = displayString.substring(1) + displayString.substring(0,1);
		return displayString;
	}
	
	public String endToBegin(String str) {
		String displayString = str;
		displayString = displayString.substring(displayString.length()-1) + str.substring(0, str.length()-1);
		return displayString;
	}
	
	public int addSubtractArray(int[] addArray, int[] subtractArray) {
		int addTotal = 0;
		int subtractTotal = 0;
		for(int i = 0; i < addArray.length; i++) {
			addTotal += addArray[i];
		}
		
		for(int i = 0; i < subtractArray.length; i++) {
			subtractTotal += subtractArray[i];
		}
		
		return addTotal - subtractTotal;
	}
}
