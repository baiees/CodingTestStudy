package StudyCodingTest.String;

import java.util.Scanner;
/*
    T로 테스트 케이스 개수를 먼저 받고
    S로 문자열을 받고
    R번 번복할거면 for문 돌려
*/
public class StringMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇번 반복할거야?");
        int T = sc.nextInt();
        // T 번 문자열 S 받기
        System.out.println("입력해봐.");
        for(int i = 0; i<T; i++){
            int R = sc.nextInt();
            String S = sc.next();

            String answer = "";
            // S 길이 만큼 반복 출력
            for (int j = 0; j < S.length(); j++){
                char ch = S.charAt(j); // 문자열 하나씩 받아.
                for(int k =0; k < R; k++){
                    answer += ch;
                }
            }
            System.out.println("결과"+answer);
        }
        sc.close();
    }
}
