package kakaotest.intern2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KI4 {
    static class node {
        int to, weight, state;

        public node(int t, int w, int s) {
            this.to = t;
            this.weight = w;
            this.state = s;
        }
    }

    public static void main(String[] args) {

    }

    static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = Integer.MAX_VALUE;

        ArrayList<node>[] graph = new ArrayList[n+1];
        ArrayList<node>[] reverseGraph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(new node(roads[i][1], roads[i][2], 0));
            reverseGraph[roads[i][1]].add(new node(roads[i][0], roads[i][2], 0));
        }

        HashMap<Integer, Integer> trapInfo = new HashMap<>();

        for (int i = 0; i < traps.length; i++) {
            trapInfo.put(traps[i], 1 << (i + 1));
        }

        int[][] dist = new int[n+1][1 << 11];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<node> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        dist[start][0] = 0;
        queue.add(new node(start, 0, 0));

        while (!queue.isEmpty()) {
            node cur = queue.poll();

            if (cur.to == end) {
                break;
            }

            boolean isCurTrapOn = false;
            boolean isNextTrapOn = false;

            if (trapInfo.containsKey(cur.to)) {
                if ((cur.state & trapInfo.get(cur.to)) == trapInfo.get(cur.to)) {
                    isCurTrapOn = true;
                }
            }

            for (node next : graph[cur.to]) {
                int nextState = cur.state;
                if (trapInfo.containsKey(next.to)) {
                    isNextTrapOn = ((cur.state & trapInfo.get(next.to)) != 0);
                    if (isNextTrapOn) {
                        nextState = cur.state ^ trapInfo.get(next.to);
                    } else {
                        nextState = cur.state | trapInfo.get(next.to);
                    }
                    if (isCurTrapOn == isNextTrapOn) {
                        if (dist[next.to][cur.state] > cur.weight + next.weight) {
                            dist[next.to][cur.state] = cur.weight + next.weight;
                            queue.add(new node(next.to, dist[next.to][cur.state], nextState));
                        }
                    }
                } else {
                    if (!isCurTrapOn) {
                        if (dist[next.to][cur.state] > cur.weight + next.weight) {
                            dist[next.to][cur.state] = cur.weight + next.weight;
                            queue.add(new node(next.to, dist[next.to][cur.state], nextState));
                        }
                    }
                }
            }

            isNextTrapOn = false;
            for (node next : reverseGraph[cur.to]) {
                int nextState = cur.state;
                if (trapInfo.containsKey(next.to)) {
                    isNextTrapOn = ((cur.state & trapInfo.get(next.to)) != 0);
                    if (isNextTrapOn) {
                        nextState = cur.state ^ trapInfo.get(next.to);
                    } else {
                        nextState = cur.state | trapInfo.get(next.to);
                    }
                }
                if (isCurTrapOn ^ isNextTrapOn) {
                    if (dist[next.to][cur.state] > cur.weight + next.weight) {
                        dist[next.to][cur.state] = cur.weight + next.weight;
                        queue.add(new node(next.to, dist[next.to][cur.state], nextState));
                    }
                }
            }
        }

        for (int d : dist[end]) {
            answer = Math.min(answer, d);
        }

        return answer;
    }
}
