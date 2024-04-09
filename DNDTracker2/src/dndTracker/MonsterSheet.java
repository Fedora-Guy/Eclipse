package dndTracker;
public class MonsterSheet 
{
    String name;
    int maxHealth, currentHealth, armorClass, number, slot;
    
    public MonsterSheet(String n, int mH, int aC, int num) {
        this.name = n;
        this.maxHealth = mH;
        this.currentHealth = mH;
        this.armorClass = aC;
        this.number = num;
    }
    
    public void changeHealth(int d) {
        this.currentHealth = d;
    }
    
    public void setSlot(int s) {
    	this.slot = s;
    }
    
    public int getSlot() {
    	return this.slot;
    }
    
}