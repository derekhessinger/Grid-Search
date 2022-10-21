/*
*File: CellQueue.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class CellQueue<T>{

	private class Node{

		//Fields
		Node next;
		Cell cell;
		Node prev;


		public Node(Cell cell){

			this.cell = cell;
			this.next = null;
			this.prev = null;
		}

		public Node(Cell cell, Node next, Node prev){

			this.cell = cell;
			this.next = next;
			this.prev = prev;
		}

		public Cell getCell(){

			return this.cell;
		}

		public Node getNext(){

			return this.next;
		}

		public void setNext(Node next){

			this.next = next;
		}

		public Node getPrev(){

			return this.prev;
		}

		public void setPrev(Node prev){

			this.prev = prev;
		}
	}

	//Fields for CellQueue
	Node head;
	Node tail;
	int size;

	public CellQueue(){

		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public String getType(){

		return "CellQueue";
	}

	//Adds cell at the end of the queue
	public void offer(Cell c){

		//Make new node
		Node newNode = new Node(c);

		//If size is 0, set head to newNode
		if (size == 0){

			this.head = newNode;
			this.tail = newNode;
		}

		// tail.setNext = newNode
		// newNode.prev = tail;
		// tail = newNode;
		// size++;

		//Set prev to null
		newNode.setPrev(tail);

		//Set old tail prev cell to new tail
		this.tail.setPrev(newNode);

		//Set next to tail
		newNode.setNext(this.tail);

		//Set tail to newNode
		this.tail = newNode;

		//Increase size by 1
		size++;
	}

	//Returns cell at front of queue
	public Cell peek(){

		return this.head.cell;
	}

	//Returns and removes cell at front of queue
	public Cell poll(){

		//Create deleted node at head
		Node deleted = this.head;

		if (size == 1){

			this.head = null;
			this.tail = null;
			this.size--;
			return deleted.cell;
		}

		//Set head to the previous node
		this.head = head.getPrev();

		//Set the next node of head to be null
		this.head.setNext(null);

		//Set previous of deleted to null so it no longer has any references
		deleted.setPrev(null);

		size--;

		return deleted.cell;
	}

	//Returns size of queue
	public int size(){

		return this.size;
	}

	public String toString(){

		return "" + size;
	}

	public static void main(String[] args){

		CellQueue<Cell> cq = new CellQueue<Cell>();
		Cell c1 = new Cell(0, 0, Cell.Type.FREE);
		cq.offer(c1);
		System.out.println(cq.size());
		System.out.print(cq.poll());
	}
}