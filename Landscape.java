/*
*File: Landscape.java
*Derek Hessinger
*CS231
*10/26/22
*/

import java.util.Random;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Landscape{

	// Fields for Landscape
	int rows;
	int cols;
	Cell[][] landscape;
	Cell start;
	Cell target;
	ArrayList<Cell> neighbors;

	// Create landscpe
	public Landscape(int rows, int cols, double chance){

		// Fields for Landscape class
		this.rows = rows;
		this.cols = cols;
		this.landscape = new Cell[this.rows][this.cols];

		// Create random object
		Random ran = new Random();


		// Create and place a free cell at point in landscape
		for (int i = 0; i < this.rows; i++){

			for(int j = 0; j < this.cols; j++){

				this.landscape[i][j] = new Cell(i, j, Cell.Type.FREE);
			}
		}

		// Randomly assign obstacles based on double passed as argument
		for (int i = 0; i < this.rows; i++){

			for(int j = 0; j < this.cols; j++){

				if (ran.nextDouble() <= chance){

					this.landscape[i][j].setType(Cell.Type.OBSTACLE);
				}
			}
		}

		// Create random points for start and end cells
		int startX = ran.nextInt(rows);
		int startY = ran.nextInt(cols);

		int targetX = ran.nextInt(rows);
		int targetY = ran.nextInt(cols);

		this.landscape[startX][startY].setType(Cell.Type.START);
		this.landscape[targetX][targetY].setType(Cell.Type.TARGET);

		this.start = this.landscape[startX][startY];
		this.target = this.landscape[targetX][targetY];
	}


	// Returns the object type
	public String getObjType(){

		return "Landscape";
	}

	// Returns start cell
	public Cell getStart(){

		return this.start;
	}

	// Returns target cell
	public Cell getTarget(){

		return this.target;
	}

	// Sets the start point
	public void setStart(int row, int col){

		this.start.setType(Cell.Type.FREE);
		this.landscape[row][col].setType(Cell.Type.START);
		this.start = this.landscape[row][col];
	}

	// Sets the target point
	public void setTarget(int row, int col){

		this.target.setType(Cell.Type.FREE);
		this.landscape[row][col].setType(Cell.Type.TARGET);
		this.target = this.landscape[row][col];
	}

	// Returns number of rows
	public int getRows(){

		return this.rows;
	}

	// Returns number of cols
	public int getCols(){

		return this.cols;
	}

	// Returns cell at specified row and col
	public Cell getCell(int row, int col){

		return this.landscape[row][col];
	}

	// Resets all cells on landscape
	public void reset(){

		for (int i = 0; i < this.rows; i++){

			for (int j = 0; j < this.cols; j++){

				this.landscape[i][j].reset();
			}
		}
	}

	// Returns an array list for the cell c passed
	public ArrayList<Cell> getNeighbors(Cell c){

		// Create empty arraylist of type cell
		ArrayList<Cell> neighbors = new ArrayList<Cell>();

		// For each row above and below the cell
		for (int i = c.getRow()-1; i < c.getRow() + 2; i++){

			// For each column in front and behind the cell
			for(int j = c.getCol()-1; j < c.getCol() +2; j++){

				// If the row and columns passed are valid
				if(i >= 0 && i < this.rows && j >= 0 && j < this.cols){ 

					// If i does not equal the row and j does not equal the column of c
					if (i != c.getRow() || j != c.getCol()){

						// If i is the row of c or j is the row of c, and the type is not an obstacle, add the cell to neighbors
						if ((i == c.getRow() || j == c.getCol()) && this.landscape[i][j].getType() != Cell.Type.OBSTACLE){

							neighbors.add(this.landscape[i][j]);
						}
					}
				}
			}
		}	return neighbors;
	}

	// To string method
	public String toString(){

		String str = "";

		for (int i = 0; i < this.rows; i++){

			for(int j = 0; j < this.cols; j++){

				str += this.landscape[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}

	public void draw(Graphics g, int scale) {
    for(int r = 0; r < getRows(); r++){
        for(int c = 0; c < getCols(); c++){
            getCell(r, c).draw(g, scale, this);
        }
    }
    g.setColor(Color.RED);
    CellQueue queue = new CellQueue();
    queue.offer(start);
    while (!(queue.size() == 0)) {
        Cell cur = queue.poll();

        for (Cell neighbor : getNeighbors(cur)) {
            if (neighbor.getPrev() == cur) {
                queue.offer(neighbor);
                g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                        neighbor.getCol() * scale + scale / 2, neighbor.getRow() * scale + scale / 2);
            }
        }
    }

    if (target.visited()) {
        Cell cur = target.getPrev();
        while (cur != start) {
            g.setColor(Color.GREEN);
            g.fillRect(cur.getCol() * scale + 2, cur.getRow() * scale + 2, scale - 4, scale - 3);
            cur = cur.getPrev();
        }
        cur = target;
        while (cur != start) {
            g.setColor(Color.BLUE);
            g.drawLine(cur.getCol() * scale + scale / 2, cur.getRow() * scale + scale / 2,
                    cur.getPrev().getCol() * scale + scale / 2, cur.getPrev().getRow() * scale + scale / 2);
            cur = cur.getPrev();
        }
    }
	}

	public static void main(String[] args){


		// Tests for Landscape

		// Landscape ld = new Landscape(10, 10, 0.5);

		// System.out.println(ld);

		// ld.setStart(0,0);

		// System.out.println(ld.getStart());

		// System.out.println(ld);

		// System.out.print(ld.getNeighbors(ld.getCell(9,5)));
	}
}