import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 그래프 생성 (무방향 인접 리스트)
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 여부 + 부모 배열
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];

        // BFS 시작 (루트 = 1)
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            // 현재 노드와 연결된 노드 탐색
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);

                // 아직 방문 안 했다면
                if (!visited[next]) {
                    visited[next] = true;   // 방문 처리
                    parent[next] = cur;     // 부모 기록
                    queue.offer(next);      // 큐에 추가
                }
            }
        }

        // 결과 출력 (2번 노드부터)
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }
}