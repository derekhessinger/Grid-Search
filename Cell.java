/*
*File: Cell.java
*Derek Hessinger
*CS231
*10/18/22
*/

import java.awt.Graphics;
import java.awt.Color;

public class Cell{

	//TODO: create better toString()

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

	public void setType(Type type){

		this.type = type; 
	}

	//Return if cell has been visited
	public boolean visited(){

		return this.visited;
	}

	public void setVisited(boolean visit){

		this.visited = visit;
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

		return "" + this.type;
	}

	// Draw method
	public void draw(Graphics g, int scale, Landscape scape) {
    g.setColor(Color.BLACK);
    g.drawRect(getCol() * scale, getRow() * scale, scale, scale);
    switch (getType()) {
        case FREE:
            g.setColor(visited() ? Color.YELLOW : Color.GRAY);
            break;
        case OBSTACLE:
            g.setColor(Color.BLACK);
            break;
        case START:
            g.setColor(Color.BLUE);
            break;
        case TARGET:
            g.setColor(Color.RED);
            break;
    }
    g.fillRect(getCol() * scale + 2, getRow() * scale + 2, scale - 4, scale - 3);

    g.setColor(Color.RED);
    if (getPrev() != null && getPrev() != this) {
        int midX = ((getCol() + getPrev().getCol()) * scale + scale) / 2;
        int midY = ((getRow() + getPrev().getRow()) * scale + scale) / 2;
        g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                midX, midY);
    }
    for (Cell neighbor : scape.getNeighbors(this)) {
        if (neighbor.getPrev() == this) {
            int midX = ((getCol() + neighbor.getCol()) * scale + scale) / 2;
            int midY = ((getRow() + neighbor.getRow()) * scale + scale) / 2;
            g.drawLine(getCol() * scale + scale / 2, getRow() * scale + scale / 2,
                    midX, midY);
        }
    }
	} 

	public static void main(String[] args){

		Cell cell = new Cell(0, 0, Cell.Type.FREE);

		System.out.println(cell.visited());

		cell.setVisited(true);

		System.out.println(cell.visited());
	}
}