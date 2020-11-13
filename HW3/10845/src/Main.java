import java.util.Scanner;
class Queue{
	int head = 0;
	int tail = -1;
	int[] queue;
	Queue(){}
	Queue(int n){
		queue = new int[n];
	}
	public void push(int x) {
		queue[++tail] = x;
	}
	public int size() {
		return tail-head+1;
	}
	public boolean isEmpty() {
		if(size()==0) {
			return true;
		}
		else return false;
	}
	public int pop() {
		if(isEmpty())
			return -1;
		else return queue[head++];
	}
	public int front() {
		if(isEmpty())
			return -1;
		else return queue[head];
	}
	public int back() {
		if(isEmpty())
			return -1;
		else return queue[tail];
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue queue = new Queue(n);
		for(int i=0; i<n; i++) {
			String text = sc.next();
			switch(text) {
			case "push":
				int x = sc.nextInt();
				queue.push(x);
				break;
			case "pop":
				System.out.println(queue.pop());
				break;
			case "empty":
				if(queue.isEmpty()) System.out.println("1");
				else System.out.println("0");
				break;
			case "front":
				System.out.println(queue.front());
				break;
			case "back":
				System.out.println(queue.back());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			}
		}
	}
}
