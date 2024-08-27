import java.util.Scanner;

public class Solution {
	
	static int N, L; // 재료의 수, 칼로리 제한
	static int[] T, K; // i번째 재료의 맛, 칼로리 배열
	static int max; // 최댓값
	
	static boolean[] selected; // i번째 재료가 선택됐는지 여부
	// 부분집합에 포함되었는지 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 테스트 케이스 수
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			T = new int[N];
			K = new int[N];
			
			selected = new boolean[N];
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				T[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			
			// select(idx): 부분집합을 구하는 재귀함수
			// idx번째 인덱스를 선택하거나 선택하지 않고 그 다음으로 넘어감
			select(0);
			
			System.out.println("#"+tc+" "+max);
			
			
		}
		
	}

	private static void select(int idx) {
		// 기저조건
		if(idx == N) {
			int sumK = 0; // 칼로리의 합
			int sumT = 0; // 맛의 합
			
			for(int i=0; i<N; i++) {
				if(selected[i]) { // 해당 부분집합에 i번째 재료가 포함됐으면
					sumK += K[i];
					sumT += T[i];
				}
			}
			// 칼로리의 합이 L을 넘지 않았다면
			// 최댓값의 후보가 될 수 있으므로, 최댓값 갱신
			if(sumK <= L) {
				if(sumT > max) max = sumT;
			}
			
			return;
		}
		
		// 유도조건
		
		selected[idx] = true;
		select(idx+1);
		selected[idx] = false;
		select(idx+1);
	}
}