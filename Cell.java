/*
*File: Cell.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class Cell{

	public enum Type{

		FREE, OBSTACLE, START, TARGET
	}

	//Fields for Cell class
	boolean visited;
	Cell prev;
	int row, col;
	Type type;

	//Constuctor
	public Cell (int row, int col, Type type){

		this.row = row;
		this.col = col;
		this.type = type;
	}

	public String getObjType(){

		return "Cell";
	}

	//Returns row of cell
	public int getRow(){

		return this.row;
	}

	//Returns col of cell
	public int getCol(){

		return this.col;
	}

	//Returns type of cell
	public Type getType(){

		return this.type;
	}

	//Return if cell has been visited
	public boolean visited(){

		return this.visited;
	}

	//Returns previous cell
	public Cell getPrev(){

		return this.prev;
	}

	//Sets visited to true and prev to c
	public void visitFrom(Cell c){

		this.visited = true;
		this.prev = c;
	}

	//Sets visited to false and prev to null
	public void reset(){

		this.visited = false;
		this.prev = null;
	}

	public String toString(){

		return "" + this.row + ", " + this.col + ", " + this.type + ", " + this.visited;
	}
}