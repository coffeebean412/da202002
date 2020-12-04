//	Lecture 14 ������׷����� ���� ū ���簢�� ���� ���ϱ�
//	������׷��� ������ �׷����� �׸� ��
//	�̶� ��������� ����Ʈ�׷� �׷������� ���� ���� ���簢���� ���̸� ���ϴ� ������
//	�������� �˰����� ��ǥ�� ����
//	�Է��� ������ ��(N)�� �Է¹ް� �� ������ ������ �Է¹޽��ϴ�.
//	{ 3, 1, 4, 3 }�� ������ ���� ����� �Է�����
//	4 3 1 4 3
//	�� �˴ϴ�.
//	����� ���� ū ���簢�� ���̸� ����ϸ� �˴ϴ�.
//	6
import java.util.Scanner;
public class Main {
	//	���������� ���� histo �Լ�
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
	//	���� ū ���簢���� ���̸� ��ȯ�մϴ�.
	//	n : ������ ��
	//	v : n���� ���õ��� ����
	//	��ȯ : ���簢���� ����
	static long histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	��ĳ�� ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	������ �� �Է�
		int n = scan.nextInt();
		//	������ ������ �迭 ����
		int[] v = new int [n];
		//	n���� ������ �Է¹޾� �迭 v�� ����
		for(int i=0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	���� ū ���簢�� ���� ���
		long r = histo(v,n);
		//	���
		System.out.println(r);
	}

}
