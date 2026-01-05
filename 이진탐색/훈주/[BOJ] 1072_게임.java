import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
“게임을 k판 더 했을 때, 승률 Z가 증가하는지 아닌지를 빠르게 판단할 수 있을까?” →  “**k판이면 Z가 바뀌나?**”

1. 현재 승률 Z 계산 `Z = (Y * 100) / X`
2. k판 더 이겼다고 가정 `newZ = ((Y + k) * 100) / (X + k)`
3. 목표 조건 `newZ > Z`
4. k가 커질수록 newZ는 증가 (단조성 O)
5. ❗ 최소 k를 찾아야 함 
→ 이진 탐색

한 번 증가하면 이후는 계속 증가
*/

public class Main {

    public static void main(String[] args) throws Exception {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X, Y 입력 (게임 수, 이긴 게임 수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken()); // 총 게임 수
        long Y = Long.parseLong(st.nextToken()); // 이긴 게임 수

        // 2. 현재 승률 Z 계산

        // 현재 승률 (소수점 버림!)
        long Z = (Y * 100) / X; // 현재 승률 (소수점 버림!)
        
        // 3. 절대 변하지 않는 경우 처리
        if (Z >= 99) { // 승률이 이미 99 이상이면
            System.out.println(-1); // 아무리 이겨도 100으로 올라갈 수 없음
            return;
        }
        
        // 4. 이진 탐색 준비

        // left, right는 "정답 후보 범위"
        // → 몇 판을 더 이길 수 있는지에 대한 범위
        long left = 1;
        long right = 1_000_000_000L; // 문제 조건 상 최대 가능 범위
        long answer = -1;            // 정답 저장용
        
        // 5. 정답 공간 이진 탐색 시작
        while (left <= right) {

            // 이번에 시험해볼 "추가 게임 수"
            long mid = (left + right) / 2;

            // mid 판을 모두 이겼다고 가정했을 때의 승률
            long newZ = ((Y + mid) * 100) / (X + mid);

            // 승률이 증가했다면
            if (newZ > Z) {
                answer = mid;        // 일단 정답 후보로 저장
                right = mid - 1;     // 더 적은 판수로 가능한지 왼쪽 탐색
            }
            // 승률이 그대로라면
            else {
                left = mid + 1;      // 더 많은 판수가 필요 → 오른쪽 탐색
            }
        }
        System.out.println(answer); // 결과 출력
    }
}