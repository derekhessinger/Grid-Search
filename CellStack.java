/*
*CellStack.java
*Derek Hessinger
*CS231
*10/4/22
*/

public class CellStack<T>{

	private class Node{
		Cell cell;
		Node next;

		//same ideas from last week

		public Node(Cell cell){
	      this.cell = cell;
	      this.next = null;
	    }

	    public Node(Cell cell, Node next){
	      this.cell = cell;
	      this.next = next;
	    }

	    public Cell getCell(){
	      return cell;
	    }

	    public void setNext(Node newNext){
	      this.next = newNext;
	    }

	    public Node getNext(){
	      return next;
	    }
	}

	Node head;	//the top of the stack

	int size; //number of items in stack

	public CellStack(){

		this.head = null;
		this.size = 0;
	}

	//Dont think this is necessary for constructor
	/*public CellStack(Node head, int size){
	*
	*	this.head = head;
	*	this.size = size;
	*}
	*/
	
	public void push(Cell c){

		//should look very similiar to an add method for linked list

		//Make new node to store data`
    	Node newNode = new Node(c);
		//set new node next to whatever first item was
		newNode.setNext(head);
		//set the first item to be this new node
		head = newNode;
		//increment size
		size++;
	}

	public Cell peek(){

		return head.getCell();
	}

	public Cell pop(){

		Node deleted = head;
    	head = head.getNext();
    	--size;
    	return deleted.getCell();
	}

	public int size(){

		return this.size;
	}

	public boolean empty(){
		if (size == 0){
			return true;
		}
		else{
			return false;
		}
	}

}
