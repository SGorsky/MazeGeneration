public class Point {
	private int X;
	private int Y;
	public Point(int x, int y) {
		X = x;
		Y = y;
	}
	public Point(Point newPoint){
		X = newPoint.X;
		Y = newPoint.Y;
	}
	
	@Override
	public String toString() {
		return "{ X = " + X + ", Y = " + Y + " }";
	}
	/**
	 * @return the x coordinate
	 */
	public int getX() {
		return X;
	}
	/**
	 * @return the y coordinate
	 */
	public int getY() {
		return Y;
	}
	
	/**
	 * @param value is the value to increment X by. If the value is negative then X will be decremented
	 */
	public void IncrementX(int value) {
		X += value;
	}
	
	/**
	 * @param value is the value to increment Y by. If the value is negative then Y will be decremented
	 */
	public void IncrementY(int value) {
		Y += value;
	}
}
