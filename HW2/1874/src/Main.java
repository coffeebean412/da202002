import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		String data = "";
		int n = sc.nextInt();
		int[] arr = new int[n+1]; 
		for (int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = 1;
		
		for (int i=1; i<=n; i++) {
			stack.push(i);
			data = data+"+";
			while (!stack.empty() && stack.peek() == arr[k]) {
				stack.pop();
				data = data+"-";
				k++;
			}
		}
		if (stack.empty()) {
				System.out.println(data);
			} 
		else {
			System.out.println("NO");
		}
		sc.close();
	}
}

