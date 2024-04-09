package ventureSmith;

public class MapPoint {
	
	String name;
	int[] loc = new int[2];
	MapPoint[] links = {};
	int[] linkLevel = {};
	
	public MapPoint(int[] loc, String name) {
		this.loc = loc;
		this.name = name;
	}
	
	public void addLink(MapPoint point, boolean back) {
		MapPoint[] temp = new MapPoint[this.links.length+1];
		for(int i = 0; i < this.links.length; i++)
			temp[i] = this.links[i];
		temp[temp.length-1] = point;
		this.links = temp;
		int[] tempLevel = new int[this.linkLevel.length+1];
		for(int i = 0; i < this.linkLevel.length; i++)
			tempLevel[i] = this.linkLevel[i];
		tempLevel[tempLevel.length-1] = 0;
		this.linkLevel = tempLevel;
		if(back)
			point.addLink(this, false);
	}
	
	public void upgradeLink(MapPoint point, boolean back) {
		for(int i = 0; i < this.links.length; i++) {
			if(this.links[i] == point) {
				this.linkLevel[i] += 1;
				if(back)
					point.upgradeLink(this, false);
				return;
			}
		}
	}
	
	public String checkType() {
		return "MapPoint";
	}
	
}
