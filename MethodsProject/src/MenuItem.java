
public class MenuItem {
	private String itemName;
	private double itemCost;
	
	public MenuItem(String argItemName, double argItemCost)
	{
		itemName = argItemName;
		itemCost = argItemCost;
	}
	
	public String toString()
	{
		return "{" + itemName + " " + itemCost + "}";
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public double getItemCost()
	{
		return itemCost;
	}
}