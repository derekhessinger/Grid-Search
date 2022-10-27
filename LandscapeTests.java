/*
*File: LandscapeTests.java
*Derek Hessinger
*CS231
*10/26/22
*/
import java.util.ArrayList;

public class LandscapeTests{

	public static void main(String[] args){

		// case 1: testing Landscape()
		{
			System.out.println("TESTING: Landscape()");

			// setup
			Landscape ld = new Landscape(10,10,0.1);

			// verify
			System.out.println(ld.getObjType() + " == Landscape");
			System.out.println(ld.rows + " == 10");
			System.out.println(ld.cols + " == 10");

			// test
			assert ld.getObjType() == "Landscape" : "Error in Landscape::Landscape()";
			assert ld.rows == 10 : "Error in Landscape::Landscape()";
			assert ld.cols == 10 : "Error in Landscape::Landscape()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing getStart()
		{
			System.out.println("TESTING: getStart()");

			// setup
			Landscape ld = new Landscape(10,10,0.1);
			ld.setStart(0,0);

			// verify
			System.out.println(ld.getStart() + " == START");

			// test
			assert ld.getStart() == ld.getCell(0,0) : "Error in Landscape::getStart()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing getTarget()
		{
			System.out.println("TESTING: getTarget()");

			// setup
			Landscape ld = new Landscape(10,10,0.1);
			ld.setTarget(0,0);

			// verify
			System.out.println(ld.getTarget() + " == TARGET");

			// test
			assert ld.getTarget() == ld.getCell(0,0) : "Error in Landscape::getTarget()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 4: testing getRows()
		{
			System.out.println("TESTING: getRows()");

			// setup
			Landscape ld = new Landscape(10, 10, 0.5);

			// verify
			System.out.println(ld.getRows() + " == 10");

			// test
			assert ld.getRows() == 10 : "Error in Landscape::getRows()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 5: testing getCols()
		{
			System.out.println("TESTING: getCols()");

			// setup
			Landscape ld = new Landscape(10, 10, 0.5);

			// verify
			System.out.println(ld.getCols() + " == 10");

			// test
			assert ld.getCols() == 10 : "Error in Landscape::getCols()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 6: testing getCell()
		{
			System.out.println("TESTING: getCell()");

			// setup
			Landscape ld = new Landscape(10, 10, 0.5);
			ld.setStart(0,0);

			// verify
			System.out.println(ld.getCell(0,0) + " == START");

			// test
			assert ld.getCell(0,0) == ld.getStart() : "Error in Landscape::getCell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 7: testing getNeighbors()
		{
			System.out.println("TESTING: getNeighbors()");

			// setup
			Landscape ld1 = new Landscape(10, 10, 0);
			Landscape ld2 = new Landscape(10, 10, 1);

			Cell c1 = ld1.getCell(0,0);
			Cell c2 = ld2.getCell(0,0);

			ArrayList<Cell> a1 = ld1.getNeighbors(c1);
			ArrayList<Cell> a2 = ld2.getNeighbors(c2);

			// verify
			System.out.println(a1.size() + " == 2");
			System.out.println(a2.size() + " == 0");

			// test
			assert a1.size() == 2 : "Error in Landscape::getNeighbors()";
			assert a2.size() == 0 : "Error in Landscape::getNeighbors()";


			System.out.println("Testing complete!");
			System.out.println("");
		}

		System.out.println("***TESTING FINISHED***");
	}
}