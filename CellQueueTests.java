/*
*File: CellQueueTests.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class CellQueueTests{

	public static void main(String[] args){

		// case 1: testing CellQueue()
		{

			// setup
			CellQueue<Cell> cq = new CellQueue<Cell>();

			// verify
			System.out.println(cq.getType() + " == CellQueue");

			// test 
			assert cq.getType() == "CellQueue" : "Error in CellQueue::CellQueue()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: Testing offer()
		{

			// setup
			CellQueue<Cell> cq = new CellQueue<Cell>();
			Cell c1 = new Cell(0, 0, Cell.Type.FREE);
			Cell c2 = new Cell(0, 1, Cell.Type.FREE);
			Cell c3 = new Cell(0, 2, Cell.Type.FREE);
			Cell c4 = new Cell(0, 3, Cell.Type.FREE);
			cq.offer(c1);
			cq.offer(c2);
			cq.offer(c3);
			cq.offer(c4);

			// verify
			System.out.println(cq + " == 4");

			// test
			assert cq.size() == 4 : "Error in CellQueue::offer()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: Testing peek()
		{

			// setup
			CellQueue<Cell> cq = new CellQueue<Cell>();
			Cell c1 = new Cell(0, 0, Cell.Type.FREE);
			Cell c2 = new Cell(0, 1, Cell.Type.FREE);
			Cell c3 = new Cell(0, 2, Cell.Type.FREE);
			Cell c4 = new Cell(0, 3, Cell.Type.FREE);
			cq.offer(c1);
			cq.offer(c2);
			cq.offer(c3);
			cq.offer(c4);

			// verify
			System.out.println(cq.peek() + " == FREE");

			// test
			assert cq.peek() == c1 : "Error in CellQueue::peek()";

			System.out.println("Testing complete!");
			System.out.println("");

		}

		// case 4: Testing poll()
		{

			// setup
			CellQueue<Cell> cq = new CellQueue<Cell>();
			Cell c1 = new Cell(0, 0, Cell.Type.FREE);
			Cell c2 = new Cell(0, 1, Cell.Type.FREE);
			Cell c3 = new Cell(0, 2, Cell.Type.FREE);
			Cell c4 = new Cell(0, 3, Cell.Type.FREE);
			cq.offer(c1);
			cq.offer(c2);
			cq.offer(c3);
			cq.offer(c4);
			Cell deleted1 = cq.poll();

			CellQueue<Cell> cq1 = new CellQueue<Cell>();
			Cell c5 = new Cell(0, 4, Cell.Type.FREE);
			cq1.offer(c5);
			Cell deleted2 = cq1.poll();

			// verify
			System.out.println(cq.poll() + " == FREE");
			System.out.println(cq1.size() + " == 0");

			// test
			assert deleted1 == c1 : "Error in CellQueue::poll()";
			assert deleted2 == c5 : "Error in CellQueue::poll()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		System.out.println("***TESTING FINISHED***");
	}
}