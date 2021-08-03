package segtree;

import java.io.*;
import java.util.Arrays;

/**
 * 플랫폼 : 백준
 * 문제번호 : 2517
 * 문제제목 : 달리기
 * 난이도 : 플래티넘 4
 * 제한사항 : 1초/256MB
 * 알고리즘 분류 : 세그먼트 트리, 좌표 압축
 *
 * 알고리즘 설명
 * 1. 선수는 객체로 표현(현재 등수(인덱스)와 실력)
 * 2. 세그먼트 트리 선언
 * 3. 실력 작은 사람부터 보기 위해 정렬
 * 4. 처음부터 현재 등수까지의 구간 합 -> 앞지를 수 있는 선수
 * 5. 구간 합 확인 후 현재 등수 값 1로 변경
 * 좌표 압축 풀이법 도전해보기
 *
 * 채점 결과 : 1940ms/155432KB
 * 풀이 날짜 : 2021/07/07
**/

public class B2517 {
	static class Player implements Comparable<Player> {
		int idx;
		int speed;
		
		Player(int idx, int speed) {
			this.idx = idx;
			this.speed = speed;
		}

		@Override
		public int compareTo(Player o) {
			if (this.speed < o.speed) {
				return -1;
			} else if (this.speed > o.speed) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	static int n, segN;
	static Player[] players;
	static int[] segmentTree;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		segN = (int) Math.pow(2, n);
		segmentTree = new int[segN * 2 + 2];

		players = new Player[n];

		for (int i = 0; i < n; i++) {
			players[i] = new Player(i+1, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(players);

		result = new int[n + 1];

		for (segN = 1; segN < n; segN *= 2);

		segmentTree = new int[(int)(1 * Math.pow(2, (int)Math.ceil(Math.log10(segN) / Math.log10(2)) + 1))];

		for (Player p : players) {
			int idx = p.idx;
			result[idx] = idx - sum(1, idx - 1);
			update(idx, 1);
		}

		for (int i = 1; i <= n; i++) {
			bw.write(String.valueOf(result[i]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	static void update(int idx, int value) {
		idx += segN - 1;
		segmentTree[idx] = value;
		while ((idx /= 2) != 0) {
			segmentTree[idx] = segmentTree[idx * 2] + segmentTree[idx * 2 | 1];
		}
	}
	
	static int sum(int a, int b) {
		int sum = 0;
		a += segN - 1;
		b += segN;
		while (a < b) {
			if (a % 2 == 1) {
				sum += segmentTree[a];
				a++;
			}
			if (b % 2 == 0) {
				sum += segmentTree[b];
				b--;
			}
			a /= 2;
			b /= 2;
		}
		if (a == b) sum += segmentTree[a];
		return sum;
	}
}
