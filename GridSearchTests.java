/*
*File: GridSearch.java
*Derek Hessinger
*CS231
*10/26/22
*/

public class GridSearchTests{

	public static void main(String[] args) throws InterruptedException{

		// case 1: testing GridSearch()
		{
			System.out.println("TESTING: GridSearch()");

			// setup
			GridSearch gs = new GridSearch(0);

			// verify
			System.out.println(gs.getObjType() + " == GridSearch");

			// test
			assert gs.getObjType() == "GridSearch" : "Error in GridSearch::GridSearch()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing depthFirstSearch
		{
			System.out.println("TESTING: depthFirstSearch()");

			// setup
			GridSearch gs1 = new GridSearch(0);
			GridSearch gs2 = new GridSearch(1);
			boolean result1 = gs1.depthFirstSearch(0);
			boolean result2 = gs2.depthFirstSearch(0);
			// verify
			System.out.println(result1 + " == true");
			System.out.println(result2 + " == false");

			// test
			assert result1 == true : "Error in GridSearch::depthFirstSearch()";
			assert result2 == false : "Error in GridSearch::depthFirstSearch()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing breadthFirstSearch
		{
			System.out.println("TESTING: breadthFirstSearch()");

			// setup
			GridSearch gs1 = new GridSearch(0);
			GridSearch gs2 = new GridSearch(1);
			boolean result1 = gs1.breadthFirstSearch(0);
			boolean result2 = gs2.breadthFirstSearch(0);
			// verify
			System.out.println(result1 + " == true");
			System.out.println(result2 + " == false");

			// test
			assert result1 == true : "Error in GridSearch::breadthFirstSearch()";
			assert result2 == false : "Error in GridSearch::breadthFirstSearch()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		System.out.println("***TESTING FINISHED***");
	}
}