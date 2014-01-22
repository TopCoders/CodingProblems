public class Stack<T>{
	// initialize data
	public class StackNode<T>{
		public T data;
		public StackNode<T> next;
		public StackNode(T da){
			data = da;
			next = null;
		}
	}
	
	StackNode<T> head = null;
	
	public void push(T da){
		StackNode<T> node = new StackNode<T>(da);
		if(head==null){
			head = node;
		}
		else{
			node.next = head;
			head = node;
		}
	}
	
	public T pop(){
		if(head == null) return null;
		T da = head.data;
		head = head.next;
		return da;
	}
	
	public T peek(){
		if(head == null) return null;
		return head.data;
	}
	
	public boolean isempty(){
		return head==null;
	}
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.peek()==null);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}