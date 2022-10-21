/*
*File: CellTests.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class CellTests{

	public static void main(String[] args){

		//case 1: testing Cell(int row, int col, Type type)
		{
			System.out.println("TESTING: Cell()");

			// setup
			Cell cell = new Cell(0, 0, Cell.Type.FREE);

			// verify
			System.out.println(cell.getObjType() + " == Cell");
			System.out.println(cell.row + " == 0");
			System.out.println(cell.col + " == 0");
			System.out.println(cell.type + " == FREE");

			// test
			assert cell.getObjType() == "Cell" : "Error in Cell::Cell()";
			assert cell.row == 0 : "Error in Cell::Cell()";
			assert cell.col == 0 : "Error in Cell::Cell()";
			assert cell.type == Cell.Type.FREE : "Error in Cell::Cell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		//case 2: testing getRow()
		{
			System.out.println("TESTING: getRow()");

			// setup
			Cell cell = new Cell(0,0,Cell.Type.FREE);

			// verify
			System.out.println(cell.getRow() + " == 0");

			// test
			assert cell.getRow() == 0 : "Error in Cell::getRow()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing getCol()
		{
			System.out.println("TESTING: getCol()");

			// setup
			Cell cell = new Cell(0,0,Cell.Type.FREE);

			// verify
			System.out.println(cell.getCol() + " == 0");

			// test
			assert cell.getCol() == 0 : "Error in Cell::getCol()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 4: getType()
		{
			System.out.println("TESTING: getType()");

			// setup
			Cell cell = new Cell(0,0,Cell.Type.FREE);

			// verify
			System.out.println(cell.getType() + " == FREE");

			// test
			assert cell.getType() == Cell.Type.FREE : "Error in Cell::getType()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 5: testing setType()
		{
			System.out.println("TESTING: setType");

			// setup
			Cell cell = new Cell(0,0,Cell.Type.FREE);
			cell.setType(Cell.Type.OBSTACLE);

			// verify
			System.out.println(cell.type + " == OBSTACLE");

			// test
			assert cell.type == Cell.Type.OBSTACLE : "Error in Cell::setType()";

			System.out.println("Testing complete!");
			System.out.println("");			
		}

		// case 6: testing visited()
		{
			System.out.println("TESTING: visited()");

			// setup
			Cell cell = new Cell(0,0,Cell.Type.FREE);
			cell.visited = true;

			// verify
			System.out.println(cell.visited + " == true");

			// test
			assert cell.visited == true : "Error in Cell::visited()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 7: testing getPrev()
		{
			System.out.println("TESTING: getPrev()");

			// setup
			Cell cell1 = new Cell(0,0,Cell.Type.FREE);
			Cell cell2 = new Cell(0,1,Cell.Type.FREE);
			cell1.prev = cell2;

			// verify
			System.out.println(cell1.getPrev() + "== FREE");

			// test
			assert cell1.getType() == Cell.Type.FREE : "Error in Cell::getPrev()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 8: testing visitFrom()
		{
			System.out.println("TESTING: visitedFrom()");

			// setup
			Cell cell1 = new Cell(0,0,Cell.Type.FREE);
			Cell cell2 = new Cell(0,1,Cell.Type.FREE);
			cell1.visitFrom(cell2);

			// test
			System.out.println(cell1.visited + " == true");
			System.out.println(cell1.getPrev() + " == FREE");

			assert cell1.visited == true : "Error in Cell::visitedFrom()";
			assert cell1.getPrev() == cell2 : "Error in Cell::visitedFrom()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 9: testing reset()
		{
			System.out.println("TESTING: reset()");

			// setup
			Cell cell = new Cell(2,2,Cell.Type.FREE);
			cell.reset();

			// verify
			System.out.println(cell.visited + " == false");
			System.out.println(cell.prev + " == null");

			// test
			assert cell.visited == false : "Error in Cell::reset()";
			assert cell.prev == null : "Error in Cell::reset()";

			System.out.println("Testing complete!");
			System.out.println("");

			System.out.println("***TESTING FINISHED***");
		}
	}
}