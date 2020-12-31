package stack;

/*��ջ
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
	//��ջ
	public void push(int obj) {
		top=new Node(obj, top);
		size++;
	}
	//��ջ
	public int pop() {
		if (isEmpty()) {
			System.out.println("ջΪ���޷�ɾ��Ԫ��");
		}
		int x=top.date;
		top=top.next;
		size--;
		return x;
	}
	//ȡջ��Ԫ��
	public int getHend() {
		if (top==null) {
			System.out.println("ջΪ�գ��޷���ȡԪ��");
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
		System.out.println("��ջ��"+stack.pop());
		System.out.println("ջ����"+stack.size);
	}

}