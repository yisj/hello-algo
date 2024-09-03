
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map; // 2차원 행렬 정보 저장
	static boolean[][] visited; // 방문 체크.
	
	static int W, H; // 너비, 높이
	static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1}; // 8방 탐색용.
	static int[] dc = {-1, 1, 0, 0,-1, 1, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		// 0 0이 올때까지 입력받기
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 1. 먼저 W, H 입력 받고 0 0인지 검사.
			W = Integer.parseInt(st.nextToken()); // 너비 = 열의 개수
			H = Integer.parseInt(st.nextToken()); // 높이 = 행의 개수
			
			if(W == 0 && H == 0)
				return;
			
			// 2. 2차원 행렬 입력받기
			map = new int[H][W];
			
			for(int r=0; r<H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[H][W];
			int cnt = 0;
			
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					if(map[r][c] == 1 && !visited[r][c]) { // 아직 방문하지 않은 노드 발견 == 새로운 그래프를 찾았음.
						cnt++; // 새로운 그래프를 찾았으므로 개수 카운팅 1 증가
						visited[r][c] = true; // 해당 지점을 방문처리 후.
						dfs(r, c); // 해당 지점을 기점으로 하여 DFS 탐색 시작 => 연결된 모든 노드의 방문 처리
					}
				}
			}
			
			// 3. 그래프의 개수 찾기
			//  - 미리 방문체크 배열을 만들어 놓는다.
			//  - 개수를 저장할 변수 cnt
			
			//  - 다시 2차원 행렬을 행 우선순회
			//  - 만약에 "아직 방문하지 않은" 노드를 발견했다면 (1 - 땅)
			//    => 현재 새로운 그래프를 발견했다.
			//    => 이 노드를 기점으로 하여 DFS 탐색하면서(현재 노드도 방문처리 후 탐색시작)
			//       연결된 모든 노드를 방문처리.
			
			//  연결성 판단 : 8방 탐색하여, 인접한 1이 있다면 연결된 것임. => 8방 탐색용 배열도 만들어 놓는다.
			
			// DFS 탐색은 함수를 호출해서 System 스택을 이용하므로,
			// => DFS 탐색 함수와 공통으로 사용할 변수는 다 static으로 빼 놓아야 함.
			
			System.out.println(cnt); // 섬의 개수 출력.
						
		}
		
	}


	private static void dfs(int r, int c) {
		
		// 인접한 8방향을 보면서, 만약에 아직 방문하지 않은 연결된 노드가 있다면, => 탐색을 이어나간다.
		for(int d=0; d<8; d++) {
			// 인접 노드의 좌표 만들기.
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= H || nc < 0 || nc >= W) // 인접 노드가 배열의 범위를 벗어났다면
				continue; // 그 다음으로 넘어간다.
			
			if(map[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		
	}

}
