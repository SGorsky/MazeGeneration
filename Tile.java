public class Tile {
	/* 0 = Empty Tile
	 * 1 = Wall Tile
	 */
	private int tileType;
  
	public Tile(){
		tileType = 1;
	}

	public int getTileType() {
		return tileType;
	}
	
	public void SetEmpty(){
		tileType = 0;
	}
}
