import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue = new int[1000000];
		int[] stack = new int[1000000];
		int head = 0; 
		int tail = 0;
		int top = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			queue[i] = rand.nextInt(10000);
			tail = (tail+1)%1000000;
		}
		while(head!=tail) {
			int k = queue[head];
			head = (head+1)%1000000;
			if(stack[top]<k) {
				while(top!=0 && stack[top]<k) {
					queue[tail]=stack[top];
					tail = (tail+1)%1000000;
					top--;
				}
			}
			stack[++top]=k;		
		}
		for(int i=1; i<=n; i++) {
			System.out.println(stack[i]+" ");
		}
	}
}
