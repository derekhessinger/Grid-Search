/*
*File: LandscapeTests.java
*Derek Hessinger
*CS231
*10/21/22
*/

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class GridSearch{

	// Fields for GridSearch class
	Landscape scape;
	LandscapeDisplay display;


	// Constructs GridSearch
	public GridSearch(){

		this.scape = new Landscape(10, 10, 0.3);
		this.display = new LandscapeDisplay(this.scape, 20);
	}

	// TODO: doesnt appear to stop looking for path after Target is found
	public boolean depthFirstSearch(int delay) throws InterruptedException{

		// Create an empty Stack of Cells
		CellStack cs = new CellStack();

		// Mark the start as visited
		Cell start = this.scape.getStart();
		start.setVisited(true);

		// Push the start onto the stack
		cs.push(start);

		while (cs.size() != 0){

			if (delay > 0){

				Thread.sleep(delay);
				display.repaint();
			}

			Cell cur = cs.pop();

			ArrayList<Cell> curNeighbors = this.scape.getNeighbors(cur);

			for(Cell n: curNeighbors){

				if (n.getType() != Cell.Type.OBSTACLE && n.visited() == false){

					n.visitFrom(cur);

					if (n.getType() == Cell.Type.TARGET){

						return true;
					}

					cs.push(n);
				}
			}
		}
		return false;
	}

	// TODO: Same as depthFirstSearch, doesn't break once Target is found
	public boolean breadthFirstSearch(int delay) throws InterruptedException{

		// Create an empty Queue of Cells
		CellQueue cq = new CellQueue();

		// Mark the start as visited
		Cell start = this.scape.getStart();
		start.setVisited(true);

		cq.offer(start);

		while(cq.size() != 0){

			if (delay > 0){

				Thread.sleep(delay);
				display.repaint();
			}

			Cell cur = cq.poll();
			ArrayList<Cell> curNeighbors = this.scape.getNeighbors(cur);

			for (Cell n: curNeighbors){

				if (n.getType() != Cell.Type.OBSTACLE && n.visited() == false){

					n.visitFrom(cur);

					if (n.getType() == Cell.Type.TARGET){

						return true;
					}

					cq.offer(n);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException{

		GridSearch gs = new GridSearch();
		// gs.depthFirstSearch(500);

		// gs.reset();

		gs.breadthFirstSearch(500);
	}
}