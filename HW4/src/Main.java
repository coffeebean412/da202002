//	Lecture 14 히스토그램에서 가장 큰 직사각형 넓이 구하기
//	히스토그램은 도수를 그래프로 그린 것
//	이때 만들어지는 히스트그램 그래프에서 가장 넓은 직사각형의 넓이를 구하는 문제로
//	분할정복 알고리즘의 대표적 문제
//	입력은 샘플의 수(N)을 입력받고 각 샘플의 도수를 입력받습니다.
//	{ 3, 1, 4, 3 }의 도수를 가진 경우라면 입력으로
//	4 3 1 4 3
//	이 됩니다.
//	결과는 가장 큰 직사각형 넓이를 출력하면 됩니다.
//	6
import java.util.Scanner;
public class Main {
	//	분할정복을 위한 histo 함수
	static long histo(int[] v, int a, int b) {
		if(a==b) return v[a];
		
		int mid = (a+b)/2;
		
		long ans = Math.max(histo(v, a, mid), histo(v, mid+1, b));
		int left = mid;
		int right = mid+1;
		
		long height = (long)Math.min(v[left], v[right]);
		ans = (long)Math.max(ans, height*2);
		
		while(a<left || right<b) {
			if(a<left && right<b) {
				if(v[left-1]<v[right+1]) {
					height=(long)Math.min(height, v[++right]);
				}
				else {
					height = (long)Math.min(height, v[--left]);
				}
			}
			else if(a<left) {
				height = (long)Math.min(height,  v[--left]);
			}
			else if(right<b) {
				height=(long)Math.min(height, v[++right]);
			}
			ans = Math.max(ans, height*(right-left+1));
		}
		return ans;
	}
	//	가장 큰 직사각형의 넓이를 반환합니다.
	//	n : 샘플의 수
	//	v : n개의 샘플들의 도수
	//	반환 : 직사각형의 넓이
	static long histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	스캐너 오브젝트 생성
		Scanner scan = new Scanner(System.in);
		//	샘플의 수 입력
		int n = scan.nextInt();
		//	도수를 저장할 배열 생성
		int[] v = new int [n];
		//	n개의 도수를 입력받아 배열 v에 저장
		for(int i=0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	가장 큰 직사각형 넓이 계산
		long r = histo(v,n);
		//	출력
		System.out.println(r);
	}

}
