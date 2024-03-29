import java.util.EmptyStackException;

public class Stack {
	private final int MaxSize=10;
	private int[] date;
	private int top;
	public  SeqStack() {
		top=-1;
		date=new int[MaxSize];
	}
	public  SeqStack(int n) {
		top=-1;
		date=new int[n];
	}
	public void push(int x) {//入栈
		if (isFull()) {
			int [] p=new int[2*top+2];
			for (int i = 0; i <=top; i++) {
				p[i]=date[i];
			}
			date=p;
		}
		top++;
		date[top]=x;
	}
	public int pop() {//出栈
		if (isEmpty()) {
			throw new EmptyStackException();
		}
//		int ele=date[top--];
//		return ele;
//		top=top+1;
		return date[top--];
	}
	public int peek() {//输出栈顶
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return date[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top==date.length-1;
	}
	public int size() {
		return top+1;
	}
	public void printstack() {
		for (int i = top; i >=0; i--) {
			System.out.print(date[i]+" ");
		}
		System.out.println();
	}
	public void clear() {
		 top=-1;
		}
	public static void main(String[] args) {
		SeqStack s=new SeqStack();
		int [] a= {12,13,14,15};
		for (int i = 0; i < a.length; i++) {
			s.push(a[i]);
		}
		System.out.println("栈中元素为：");
		s.printstack();
		System.out.println("出栈："+s.pop());
		System.out.println("栈顶元素为："+s.peek());
		System.out.println("栈的长度为："+s.size());
	}
}
