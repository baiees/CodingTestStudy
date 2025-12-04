package StudyCodingTest.String;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatingBinaryTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("이진 문자열 s 입력: ");
        String s = sc.nextLine();

        Solution sol = new Solution();
        int[] result = sol.solution(s);

        System.out.println("결과: " + Arrays.toString(result));

        sc.close();
    }

    /*
       이거 한국말이 맞음?
    * */
    private static class Solution {
        public int[] solution(String s) {


            int[] answer = new int[2];

            return answer;
        }
    }
}
