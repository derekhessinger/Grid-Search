/*
*File: Landscape.java
*Derek Hessinger
*CS231
*10/20/22
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

		this.rows = rows;
		this.cols = cols;
		this.landscape = new Cell[this.rows][this.cols];

		Random ran = new Random();

		for (int i = 0; i < this.rows; i++){

			for(int j = 0; j < this.cols; j++){

				this.landscape[i][j] = new Cell(i, j, Cell.Type.FREE);
			}
		}

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

	public void setStart(int row, int col){

		this.start.setType(Cell.Type.FREE);
		this.landscape[row][col].setType(Cell.Type.START);
		this.start = this.landscape[row][col];
	}

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

	public ArrayList<Cell> getNeighbors(Cell c){

		neighbors = new ArrayList<Cell>();
		int cRow = c.getRow();
		int cCol = c.getCol();

		// Arraylist adds in order of up, right, down, left

		// Check if cell c not a perimeter or corner cell
		if (cRow != 0 && cRow != this.rows - 1){

			if (cCol != 0 && cCol != this.cols - 1){

				if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow-1][cCol].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow-1][cCol]);
				}

				if (this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow][cCol+1]);
				}

				if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow+1][cCol].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow+1][cCol]);
				}

				if (this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol-1].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow][cCol-1]);
				}
			}
		}

		// Check if cell c is a perimeter or corner cell
		if (cRow == 0 || cRow == this.rows - 1){

			// If cell is a corner cell
			if (cCol == 0 || cCol == this.cols - 1){

				// Top left corner
				if (cRow == 0 && cCol == 0){

					if (this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol+1]);
					}

					if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow+1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow+1][cCol]);
					}
				}

				// Top right corner
				if (cRow == 0 && cCol == this.cols - 1){

					if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow+1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow+1][cCol]);
					}

					if (this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol-1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol-1]);
					}
				}

				// Bottom left corner
				if (cRow == this.rows - 1 && cCol == 0){

					if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow-1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow-1][cCol]);
					}

					if (this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol+1]);
					}
				}

				// Bottom right corner
				if (cRow == this.rows - 1 && cCol == this.cols - 1){

					if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow-1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow-1][cCol]);
					}

					if (this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol-1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol-1]);
					}
				}
			}

			// If cell is not a corner cell
			else{

				// If cell is in top row
				if (cRow == 0){

					if(this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol+1]);
					}

					if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow+1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow+1][cCol]);
					}

					if(this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol-1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol-1]);
					}
				}

				// If cell is in bottom row
				else{

					if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow-1][cCol].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow-1][cCol]);
					}

					if(this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol+1]);
					}

					if(this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol-1].getType() == Cell.Type.TARGET){

						neighbors.add(this.landscape[cRow][cCol-1]);
					}
				}
			}
		}

		// If cell is on column perimeter
		else{

			// If cell is on right perimeter
			if (cCol == 0){
				if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow-1][cCol].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow-1][cCol]);
				}

				if(this.landscape[cRow][cCol+1].getType() == Cell.Type.FREE || this.landscape[cRow][cCol+1].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow][cCol+1]);
				}

				if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE || this.landscape[cRow+1][cCol].getType() == Cell.Type.TARGET){

					neighbors.add(this.landscape[cRow+1][cCol]);
				}
			}

			// If cell is on left perimeter
			else{

				if (this.landscape[cRow-1][cCol].getType() == Cell.Type.FREE){

					neighbors.add(this.landscape[cRow-1][cCol]);
				}

				if(this.landscape[cRow][cCol-1].getType() == Cell.Type.FREE){

					neighbors.add(this.landscape[cRow][cCol-1]);
				}

				if (this.landscape[cRow+1][cCol].getType() == Cell.Type.FREE){

					neighbors.add(this.landscape[cRow+1][cCol]);
				}
			}
		}

		return neighbors;
	}

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

		Landscape ld = new Landscape(10, 10, 0.5);

		System.out.println(ld);

		ld.setStart(0,0);

		System.out.println(ld.getStart());

		System.out.println(ld);

		System.out.print(ld.getNeighbors(ld.getCell(9,5)));
	}
}