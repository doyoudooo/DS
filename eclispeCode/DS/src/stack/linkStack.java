package stack;

/*链栈
 * 
 */
public class linkStack {
	private int size;
	private Node top;
	public linkStack() {
		size=0;
		top=null;
	}
	public static class Node {
		int date;
		Node next;
		public Node(int date, Node next) {
			super();
			this.date = date;
			this.next = next;
		}
		public Node(Node x) {
			this.next=x;
		}
	}
	//入栈
	public void push(int obj) {
		top=new Node(obj, top);
		size++;
	}
	//出栈
	public int pop() {
		if (isEmpty()) {
			System.out.println("栈为空无法删除元素");
		}
		int x=top.date;
		top=top.next;
		size--;
		return x;
	}
	//取栈顶元素
	public int getHend() {
		if (top==null) {
			System.out.println("栈为空，无法获取元素");
			return -1;
		}
		return top.date;
	}
	public int length() {
		return size;
	}
	public boolean isEmpty() {
		return top==null;
	}
	public void printstack() {
		Node p=top;
		while (p!=null) {
			System.out.print(p.date+" ");
			p=p.next;
		}
		System.out.println();
	}
	public void clear() {
		top=null;
	}
	public static void main(String[] args) {
		linkStack stack=new linkStack();
		int[] a= {1,5,6,8,9};
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		stack.printstack();
		System.out.println("出栈："+stack.pop());
		System.out.println("栈长："+stack.size);
	}

}
