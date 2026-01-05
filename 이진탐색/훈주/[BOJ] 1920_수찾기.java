import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
“100,000개짜리 배열을 100,000번 매번 처음부터 끝까지 훑어도 괜찮을까?” →  “**한 번 정리해두고**, 빠르게 찾자” 탐색을 빠르게 만드는 Binary Search (이진 탐색)

1. 많이 찾는다 (M이 큼)
2. 매번 전체를 보면 안 된다
3. 탐색을 빠르게 해야 한다
4. 이진 탐색은 O(log N)
5. 이진 탐색은 정렬이 필요
6. 정렬 + 이진 탐색

정렬 전 `[4, 1, 5, 2, 3]`
정렬 후 `[1, 2, 3, 4, 5]`
이제 `7`을 찾는다고 생각:
중간 → 3
7 > 3 → 오른쪽 절반만 본다

중간 → 4
7 > 4 → 오른쪽 절반만 본다

중간 → 5
7 > 5 → 더 이상 없음 → ❌
“찾는 횟수가 너무 많으니, 한 번 정렬해서 탐색 비용을 log로 줄이자.”
*/

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
           1. 수가 저장된 배열 입력 받기
        */
        int N = Integer.parseInt(br.readLine()); // 첫 줄: 배열의 크기 N
        int[] arr = new int[N]; // N개의 정수를 저장할 배열

        // 두 번째 줄: N개의 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
           2. 이진 탐색을 위한 준비 → 정렬
        */
        Arrays.sort(arr); // 이진 탐색은 "정렬된 배열"에서만 가능

        /*
           3. 찾을 숫자들 입력 받기
        */
        int M = Integer.parseInt(br.readLine()); // 찾을 숫자의 개수 M
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()); // 찾을 숫자들

        /*
           4. 하나씩 이진 탐색 수행
        */
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 이진 탐색 결과에 따라 1 또는 0 출력
            if (binarySearch(arr, target)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.print(sb); // 최종 출력
    }

    /*
    이진 탐색 메서드
       - 배열 arr 안에 target이 존재하는지 확인
       - 존재하면 true, 없으면 false
    */
    static boolean binarySearch(int[] arr, int target) {
        int left = 0; // 탐색 범위의 시작과 끝 (index 기준)
        int right = arr.length - 1;
   
        while (left <= right) { // 탐색할 구간이 남아 있는 동안 반복
            int mid = (left + right) / 2; // 현재 범위의 가운데 index

            if (arr[mid] == target) { // 가운데 값이 찾는 값이면 성공
                return true;
            }
            if (arr[mid] < target) { // 찾는 값이 가운데 값보다 크면
                left = mid + 1; // → 오른쪽 절반만 탐색
            }
            else { // 찾는 값이 가운데 값보다 작으면
                right = mid - 1; // → 왼쪽 절반만 탐색
            }
        }
        return false; // 끝까지 못 찾았으면 존재하지 않음
    }
}