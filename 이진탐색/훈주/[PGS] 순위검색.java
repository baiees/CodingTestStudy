import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/*
“info를 미리 정리해두고, query는 빠르게 처리”

1. 조건은 총 4개
2. 각 조건은 “선택하거나(-) 무시”
3. → 경우의 수: `2⁴ = 16`
4. 지원자 1명당 16가지 조건 조합 생성
5. 각 조합별로 점수 리스트 저장
6. 점수 리스트를 정렬
7. query마다:
    • 조건 key 찾고
    • 점수 ≥ X 개수 계산 (이진 탐색)
⇒ 전처리 + 이진 탐색
*/

class Solution {

    // 조건 조합(key) → 점수 리스트(value)
    Map<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 1. 지원자 정보(info)를 미리 정리 (전처리)

        for (String s : info) { // 지원자 한 명씩 처리
            String[] arr = s.split(" ");
            // arr[0]~arr[3] : 조건 4개
            // arr[4]         : 점수

            // 조건 4개로 만들 수 있는 모든 경우(16개) 생성
            makeKey(arr, "", 0);
        }
        
        // 2. 각 조건(key)에 해당하는 점수 리스트 정렬

        // 이진 탐색을 쓰기 위해 정렬 필수
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        // 3. query 처리
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            answer[i] = count(query[i]);
        }
        return answer;
    }
    
    /* 조건 조합 생성 함수 */
    void makeKey(String[] arr, String key, int depth) {
    
        if (depth == 4) { // 조건 4개를 다 선택했으면
            int score = Integer.parseInt(arr[4]);

            // key에 해당하는 리스트가 없으면 생성
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score); // 점수 추가
            return;
        }

        // ① 해당 조건을 사용하는 경우
        makeKey(arr, key + arr[depth], depth + 1);

        // ② '-' 로 대체하는 경우
        makeKey(arr, key + "-", depth + 1);
    }
    
    /* query 하나 처리하는 함수 */
    int count(String q) {
        q = q.replaceAll(" and ", ""); // "and" 제거

        String[] arr = q.split(" "); // 조건 key 와 점수 분리
        String key = arr[0];
        int score = Integer.parseInt(arr[1]);

        if (!map.containsKey(key)) return 0; // 해당 조건 자체가 없으면 0명

        ArrayList<Integer> list = map.get(key);

        /*점수 리스트에서 score 이상이 처음 나오는 위치 찾기(lower bound)*/
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - left; // 전체 개수 - 기준 미만 개수
    }
}