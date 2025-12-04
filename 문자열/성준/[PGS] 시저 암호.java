package StudyCodingTest.String;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 S 입력: ");
        String s = sc.nextLine();

        System.out.println("n 만큼 밀어: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        String result = sol.solution(s,n);
        System.out.println("결과" + result);
        sc.close();

    }
    /*
    아스키 코드로 접근을 해야 하는걸까?
    대문자 아스키코드 65~90
    소문자 아스키코드 97~122
    대문자Z에는 +1이 나오면 +1 + 6 해주면 되는거고
    나머지는 +n
    for문 해주고 -> 아스키코드 변환 넣어서 +n
*/
    private static class Solution {
        public String solution(String s, int n) {
            String answer = "";
            for(int i = 0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {  // 대문자
                    ch = (char)((ch - 'A' + n) % 26 + 'A');
                }
                else if (ch >= 'a' && ch <= 'z') { // 소문자
                    ch = (char)((ch - 'a' + n) % 26 + 'a');
                }
                else if (ch == ' ') { // 공백
                    // 공백은 그대로
                }
                answer += ch;
            }
            return answer;
        }
    }
}

