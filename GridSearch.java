/*
*File: GridSearch.java
*Derek Hessinger
*CS231
*10/26/22
*/

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class GridSearch{

	// Fields for GridSearch class
	Landscape scape;
	LandscapeDisplay display;

	// Constructs GridSearch
	public GridSearch(double chance){

		this.scape = new Landscape(10, 10, chance);
		this.display = new LandscapeDisplay(this.scape, 20);
	}
	
	// Returns object type
	public String getObjType(){

		return "GridSearch";
	}
	// Executes depth first search
	public boolean depthFirstSearch(int delay) throws InterruptedException{

		// Create an empty Stack of Cells
		CellStack cs = new CellStack();

		// Mark the start as visited
		Cell start = this.scape.getStart();
		start.setVisited(true);

		// Push the start onto the stack
		cs.push(start);

		// Updates the display
		while (cs.size() != 0){

			if (delay > 0){

				Thread.sleep(delay);
				display.repaint();
			}

			// Pops off a cell
			Cell cur = cs.pop();

			// Creates an array list of neighbors of popped cell cur
			ArrayList<Cell> curNeighbors = this.scape.getNeighbors(cur);

			// For each neighbor in curNeighbors
			for (int i = 0; i < curNeighbors.size(); i++){

				// Create a cell to check the neighbor
				Cell curCell = curNeighbors.get(i);

				// If the neighboring cell is not an obstacle and has not been visited
				if (curCell.getType() != Cell.Type.OBSTACLE && curCell.visited() == false){

					// Set the cell to visited from cur
					curCell.visitFrom(cur);

					// If the cell is the target return true
					if (curCell.getType() == Cell.Type.TARGET){

						return true;
					}
					// Push the cell to the stack
					cs.push(curCell);
				}
			}
		}
		// Returns false if there is no viable path to the target
		return false;
	}

	// Executes breadth first search
	public boolean breadthFirstSearch(int delay) throws InterruptedException{

		// Create an empty Queue of Cells
		CellQueue cq = new CellQueue();

		// Mark the start as visited
		Cell start = this.scape.getStart();
		start.setVisited(true);

		// Offer the start to the queue
		cq.offer(start);

		// Updates the display
		while(cq.size() != 0){

			if (delay > 0){

				Thread.sleep(delay);
				display.repaint();
			}

			// Poll the first cell from the queue
			Cell cur = cq.poll();

			// Create an array list to hold the neighbors of cur
			ArrayList<Cell> curNeighbors = this.scape.getNeighbors(cur);

			// For each cell n in curNeighbors
			for (Cell n: curNeighbors){

				// If the cell is not an obstacle and has not been visited
				if (n.getType() != Cell.Type.OBSTACLE && n.visited() == false){

					// Set the neighboring cell to visited from cur
					n.visitFrom(cur);

					// If the cell is the target return true
					if (n.getType() == Cell.Type.TARGET){

						return true;
					}

					// Offer the cell to the queue
					cq.offer(n);
				}
			}
		}
		// Returns false if there is no viable path to the target
		return false;
	}

	public static void main(String[] args) throws InterruptedException{

		// Tests for GridSearch

		GridSearch gs = new GridSearch(0.2);
		gs.depthFirstSearch(0);

		// gs.reset();

		// gs.breadthFirstSearch(25);
	}
}