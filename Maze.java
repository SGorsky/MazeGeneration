import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {
    static Random rand = new Random();
    Tile[][] mazeGrid;

    public Maze(int size) {
        mazeGrid = new Tile[size][size];
        for (int y = 0; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                mazeGrid[y][x] = new Tile();
            }
        }
		
        Point current = new Point(1, 1);
        mazeGrid[current.getY()][current.getX()].SetEmpty();
        List<Point> moves = new ArrayList<Point>();
        moves.add(current);
        while (!moves.isEmpty()) {
            List<Point> neighbours = GetNeighbours(current);
            if (!neighbours.isEmpty()) {
                int index = rand.nextInt(neighbours.size());
                Point dir = new Point(neighbours.get(index).getX() - current.getX(), neighbours.get(index).getY() - current.getY());
                
				mazeGrid[current.getY() + dir.getY()][current.getX() + dir.getX()].SetEmpty();
                mazeGrid[current.getY() + dir.getY() / 2][current.getX() + dir.getX() / 2].SetEmpty();
                
				current.IncrementX(dir.getX());
                current.IncrementY(dir.getY());
                
				moves.add(new Point(current.getX(), current.getY()));
            }
            else {
                current = moves.get(moves.size() - 1);
                moves.remove(current);
            }
        }
    }

    private List<Point> GetNeighbours(Point loc) {
        List<Point> neighbours = new ArrayList<Point>();
        if (loc.getY() > 1 && mazeGrid[loc.getY() - 2][loc.getX()].getTileType() == 1) {
            neighbours.add(new Point(loc.getX(), loc.getY() - 2));
        }
        if (loc.getY() < MainClass.MAZE_SIZE - 3 && mazeGrid[loc.getY() + 2][loc.getX()].getTileType() == 1) {
            neighbours.add(new Point(loc.getX(), loc.getY() + 2));
        }
        if (loc.getX() > 1 && mazeGrid[loc.getY()][loc.getX() - 2].getTileType() == 1) {
            neighbours.add(new Point(loc.getX() - 2, loc.getY()));
        }
        if (loc.getX() < MainClass.MAZE_SIZE - 3 && mazeGrid[loc.getY()][loc.getX() + 2].getTileType() == 1) {
            neighbours.add(new Point(loc.getX() + 2, loc.getY()));
        }
        return neighbours;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < MainClass.MAZE_SIZE; ++i) {
            for (int j = 0; j < MainClass.MAZE_SIZE; ++j) {
                switch (mazeGrid[i][j].getTileType()) {
                    case 0 :
                        output += " ";
                        break;
                    case 1 :
                        output += "X";
                        break;
                }
            }
            output += "\n";
        }
        return output + "\n";
    }
}

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
