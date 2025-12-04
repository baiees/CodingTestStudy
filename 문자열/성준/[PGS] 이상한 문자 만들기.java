package StudyCodingTest.String;

import java.util.Scanner;

/*
    중요한 점 : 공백이면 index 초기화 하라는데?
    그럼 공백은 그대로 가지고 가면서 index = 0 초기화
    for문
        S.charAt()
        if문
            i 가 홀수
            toLowerCase()
            i 가 짝수
            toUperCase()
 */
public class StrangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 S 입력: ");
        String s = sc.nextLine();

        Solution sol = new Solution();
        String result = sol.solution(s);

        System.out.println("결과: " + result);

        sc.close();
    }

    private static class Solution {
        public String solution(String s) {
            String answer = "";
            int idx = 0; // 단어별 인덱스

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == ' ') {
                    answer += " ";
                    idx = 0;    // 공백일 때 단어 인덱스 초기화
                    continue;
                }

                if (idx % 2 == 0) {
                    answer += Character.toUpperCase(ch);
                } else {
                    answer += Character.toLowerCase(ch);
                }

                idx++;
            }
            return answer;
        }
    }
}
