package ventureSmith;

public class Chunk {
	
	int loc[];
	Tile[][] tiles = new Tile[50][50];
	
	public Chunk(int loc[]) {
		this.loc = loc;
	}
	
	public void setTile(Tile tile, int[] address) {
		this.tiles[address[0]][address[1]] = tile;
	}
	
}
