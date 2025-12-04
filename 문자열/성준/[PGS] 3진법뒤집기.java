package StudyCodingTest.String;

import java.util.Scanner;

public class ReversingANumberInBase3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 n 입력: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.solution(n);

        System.out.println("결과: " + result);

        sc.close();
    }

    /*
        3지법 만드는것부터
        while(n>0)
            나머지 저장
            다시 /3 실행

    */
    private static class Solution {
        public int solution(int n) {
            String share = ""; // 나머지 저장

            while (n > 0) {
                share += (n % 3);
                n /= 3;
            }
            System.out.println(share); // 출력값 0021

            // 10진법 어떻게 바꾸는거지?
            // 일단 쪼개 보고
            String[] arr = share.split("");
            int sum = 0;
            int exponentiation  = 1; // 이거 거듭제곱이다!!

            for(int i = arr.length -1; i>=0; i--){
                int num = Integer.parseInt(arr[i]);
                sum += num * exponentiation;
                exponentiation *= 3;
            }

            return sum;
        }
    }
}
