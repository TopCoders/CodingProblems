public class Queue<T>{
	// initialize data
	public class Node<T>{
		public T data;
		public Node<T> next;
		public Node(T da){
			data = da;
			next = null;
		}
	}
	
	// head used to delete node
	Node<T> head = null;
	// tail used to add new node
	Node<T> tail = null;
	
	public void enqueue(T da){
		Node<T> node = new Node<T>(da);
		// if head and tail is null
		// we initialize head and tail
		if(head == null){
			head = tail = node;
		}
		// if head and tail are the same node, we update head.next to node
		// tail to node; For Java, this may can be eliminated?
		else if(head == tail){
			head.next = node;
			tail = node;
		}
		// head and tail are different nodes
		else{
			tail.next = node;
			tail = node;
		}
	}
	
	public Node<T> dequeue(){
		if(tail == null) return null;
		Node<T> node;
		// if only one element is in the queue
		node = head;
		if(tail == head){
			tail = head = null;
		}
		// tail and head are different
		else{
			head = head.next;
		}	
		return node;
	}
	
	public static void main(String[] args){
		Queue<Integer> queue = new Queue<Integer>();
		System.out.println(queue.dequeue()==null);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue()==null);
	}
}