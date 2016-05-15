

/*
 * PROBLEM: Find the middle of a singly linked list.
 * 
 */
public class FindMiddleOfLinkedList_v1 {

	public static void main(String[] args) {

		//create dummy LL
		int dataStart = 7;
		Node head = new Node(dataStart);
		createDummyLL(head, 3, ++dataStart);
		
		//expect 1
		System.out.println(findMiddle(head, 0));
		

	}

	/*
	 * Since in this scenario, we dont know length of LL, 
	 * need to iterate through until end, and divide by 2.
	 * 
	 * Could be optimized depending upon estimated average length of LL.
	 * (e.g. skip by n nodes at a time, when the recursive call hits a null,
	 * binary search within the last group of n nodes to find length of LL,
	 * divide to calculate answer.
	 * 
	 * Potential problems:
	 *  - stack overflow
	 *  
	 * Features:
	 * 
	 * @param	head: head of LL
	 * @param	index: recursive index
	 * @return	index of the middle node in Singly LL.
	 */
	static int findMiddle(Node head, int index)
	{
		//null seed check
		if(head == null){
			return -1;
		}
		
		if(head.getNext() != null){
			return findMiddle(head.getNext(), ++index);
		}
		return (int) Math.floor((index/2));
	}
	
	static void createDummyLL(Node head, int numNodes, int dataStart){
		int data = dataStart;
		Node[] contextList = new Node[2];
		contextList[0] = head;
		for(int i = 0; i < numNodes; i++)
		{
			Node n = new Node(data++);
			contextList[i%2].setNext(n);
			contextList[(i%2)+1]=n;
		}
	}
	
}

class Node {
	private Object data;
	private Node next;
	
	public Node(Object data){
		this.data = data;
	}
	public Node(Node copy){
		this.data = copy.data;
		this.next = copy.next;
	}
	
	public void setData(Object data){
		this.data = data;
	}
	public void setNext(Node next){
		this.next = next;
	}
	
	public Object getData(){
		return data;
	}
	public Node getNext(){
		return next;
	}
}