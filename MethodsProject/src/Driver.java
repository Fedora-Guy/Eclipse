
public class Driver {
	public static void main(String[] args) {
		
		KeithReisMethods t = new KeithReisMethods();
		
		System.out.println(t.minOf3(0, 0, -5));
		
		System.out.println(t.lollipopParty(-3, false));
		
		String[] myArray = {"a","b","c","d","c","b","b"};
		System.out.println(t.countDuplicates(myArray, 7));
		
		System.out.println(t.connectStrings("Hello", "There"));
		
		System.out.println(t.equallyApart(5, 8, 2));
		
		System.out.println(t.grumpyHost(5, 8));
		
		System.out.println(t.sumFactors(4));
		
		System.out.println(t.excitedString("java!!!"));
		
		String[] battingOrder = {"Hayes","Newman","Reynolds","Tsutsugo","Alford","Perez","Tucker","Park","Wilson"};
		String[] newBattingOrder = t.comingUp(battingOrder, 5);
		for(int i = 0; i < newBattingOrder.length; i++) {
			System.out.print(newBattingOrder[i] + ", ");
		}
		
		System.out.println();
		
		System.out.println(t.evilE("E"));
		
		MenuItem[] order = new MenuItem[2];
		order[0] = new MenuItem("Salad", 4.95);
		order[1] = new MenuItem("Steak", 14.50);
		System.out.println(t.avoidWashingDishes(20.70, order));
		
		String[] sentence = t.parseString("The cat was fast");
		for(int i = 0; i < sentence.length; i++) {
			System.out.print(sentence[i] + " ");
		}	
	}
}