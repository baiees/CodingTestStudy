package week02;

import java.util.ArrayDeque;
import java.util.Deque;

public class week02_2 {
    class Solution {
        public int[] solution(int[] numbers) {
            int n = numbers.length;
            int[] answer = new int[n];

            // 기본값 -1로 초기화
            for (int i = 0; i < n; i++) {
                answer[i] = -1;
            }

            // 인덱스를 저장하는 스택
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // 현재 값이 스택 top이 가리키는 값보다 크면
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }

            return answer;
        }
    }

}
