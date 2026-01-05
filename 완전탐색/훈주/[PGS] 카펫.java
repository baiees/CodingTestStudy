/*
why √N?
`a × b = n`  `a > √n` `b < √n`

1. total = brown + yellow
2. total의 모든 약수 쌍 (w, h)을 본다
3. 각 쌍에 대해 `(w - 2) × (h - 2) == yellow ?`
4. 맞는 유일한 쌍이 정답
*/

class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;

        // total = width * height
        // width >= height
        for (int height = 1; height * height <= total; height++) {

            // 약수가 아니면 skip
            if (total % height != 0) continue;

            int width = total / height;

            // 내부 노란 영역 검사
            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }

        // 문제 조건상 반드시 정답이 존재
        return new int[]{};
    }
}