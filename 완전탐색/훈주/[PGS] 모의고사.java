import java.util.ArrayList;
import java.util.List;

/*
모든 문제를 하나씩 보면서 수포자 1, 2, 3이 찍은 답을 대조,
그 답이 정답일 경우 해당 수포자의 점수를 올린다.
*/

class Solution {
    public int[] solution(int[] answers) {

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        // 모든 문제를 하나씩 검사
        for (int i = 0; i < answers.length; i++) {

            // 수포자 1 정답 체크
            if (answers[i] == p1[i % p1.length]) {
                score[0]++;
            }

            // 수포자 2 정답 체크
            if (answers[i] == p2[i % p2.length]) {
                score[1]++;
            }

            // 수포자 3 정답 체크
            if (answers[i] == p3[i % p3.length]) {
                score[2]++;
            }
        }

        // 최고 점수 구하기
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        // 최고 점수 받은 사람 찾기
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) count++;
        }

        int[] answer = new int[count];
        int idx = 0;

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answer[idx++] = i + 1;
            }
        }

        return answer;
    }
}


/*
for (int i = 0; i < answers.length; i++) {
    if (answers[i] == pattern[i % pattern.length]) {
        score++;
    }
}
if (answers[i] == p1[i % p1.length]) score[0]++;
if (answers[i] == p2[i % p2.length]) score[1]++;
if (answers[i] == p3[i % p3.length]) score[2]++;
*/

for (int i = 0; i < answers.length; i++) {

    // 수포자 1
    if (answers[i] == p1[i % p1.length]) {
        score[0]++;
    }

    // 수포자 2
    if (answers[i] == p2[i % p2.length]) {
        score[1]++;
    }

    // 수포자 3
    if (answers[i] == p3[i % p3.length]) {
        score[2]++;
    }
}
