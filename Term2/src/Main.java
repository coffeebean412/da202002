import java.util.Scanner;
import java.util.Random;
public class Main {
	static void func(int n, int k) {
		int[] data = new int[n];
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			data[i] = rand.nextInt();
			System.out.println((i+1)+"번째 수="+data[i]);
		}
		for(int i=0; i<k; i++) {
			int a = rand.nextInt(n);
			int b = rand.nextInt(n);
			if(a>b) {
				int tmp;
				tmp = a;
				a = b;
				b = tmp;
			}
			if(a==0) a++;
			int min = data[a-1];
			int max = data[a-1];
			long sum = 0;
			for(int j=(a-1); j<b; j++) {
				sum += data[j];
				if(data[j]<min) {
					min = data[j];
				}
				if(data[j]>max) {
					max = data[j];
				}
			}
			System.out.println("a, b구간의 최소값, 최대값, 합계 = "+min+" "+max+" "+sum);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("N과 K 입력");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long t = System.currentTimeMillis();
		func(n, k);
		t = System.currentTimeMillis() - t;
		System.out.println(t+"ms");
		sc.close();
	}
	

}
