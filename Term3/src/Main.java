import java.util.Scanner;
import java.util.Random;

public class Main {	
	static void func(int[] data, int n, int[] a, int[] b, int k, int[] rmin, int[] rmax) {
		long[] arr = new long[n+1];
		arr[0] = 0;
		long sum = 0;
		for(int i=0; i<n; i++) {
			//System.out.println((i+1)+"번째 수="+data[i]);
			sum += data[i];
			arr[i+1] = sum;
		}
		for(int t=0; t<k; t++) {
			if(a[t]==0) a[t]++;
			int x = a[t];
			int y = b[t];
			int min = data[a[t]-1];
			int max = data[a[t]-1];
			for(int i=a[t]; i<b[t]; i++) {
				if(min > data[i]) min = data[i];
				if(max < data[i]) max = data[i];
			}
			rmin[t] = min;
			rmax[t] = max;
			sum = arr[y] - arr[x-1];
			//System.out.println("a, b구간의 최소값, 최대값, 합계 = "+x+" "+y+" "+rmin[t]+" "+rmax[t]+" "+sum);
		}
	}
	public static void main(String[] args) {
		System.out.println("N과 K 입력");
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int n = sc.nextInt();
		int[] data = new int[n];
		for(int i=0; i<n; i++) {
			data[i] = rand.nextInt();
		}
		int k = sc.nextInt();
		int[] a = new int[k];
		int[] b = new int[k];
		for(int i=0; i<k; i++) {
			int x = rand.nextInt(n);
			int y = rand.nextInt(n);
			if(x>y) {
				int tmp;
				tmp = x;
				x = y;
				y = tmp;
			}
			a[i] = x;
			b[i] = y;
		}
		int[] min = new int[k];
		int[] max = new int[k];
		long t = System.currentTimeMillis();
		func(data, n, a, b, k, min, max);
		t = System.currentTimeMillis() - t;
		System.out.println(t+"ms");
		sc.close();
	}
	

}
