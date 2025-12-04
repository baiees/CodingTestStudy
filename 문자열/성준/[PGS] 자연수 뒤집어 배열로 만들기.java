/*
https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
split 써서 쪼개려면 long -> String 바꿔주기
바꿔준거 배열에 담아
그리고 뒤부터 출력해
*/
package StudyCodingTest.String;


public class NaturalNumberReverseArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(12345);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
    static class Solution {
        public int[] solution(long n) {
            String str = Long.toString(n); // long -> string
            String[] arr = str.split(""); // 쪼개
            int[] answer = new int[arr.length]; // int 배열 담을거 만들어

            for(int i = 0; i<arr.length; i++){
                answer[i] = Integer.parseInt(arr[i]); // 1,2,3,4,5 담아
            }

            int[] reverse = new int[answer.length];
/*        // 배열 뒤집기
        for (int i = answer.length - 1; i >= 0; i--) {
            reverse[answer.length - 1 - i] = answer[i];
        }*/
            // int[] reverse  해서 만들기 싫은데 temp 해서 값교환 하면 안됌?
            // 생각은 있는데 작성법을 몰라서 gpt 돌려봄
            for(int i = 0; i < answer.length / 2; i++){
                int temp = answer[i];
                answer[i] = answer[answer.length -1 -i];
                answer[answer.length -1 -i] = temp;
            }
            return answer;
            /*return reverse;*/

        }
    }
        /*// 풀고 나니까 보이는거
    // 그냥 String 일때 reverse 쓰고 split 쓰고 배열 넣으면 되는거 아닌가??
    // reverse는 아는데 구조 잘 몰라서 구글링 해봄
    class Solution {
        public int[] solution(long n) {
            //
            StringBuilder sb = new StringBuilder(String.valueOf(n));
            String reversed = sb.reverse().toString();

            String[] arr = reversed.split("");

            int[] answer = new int[arr.length];
            for (int i = 0; i<arr.length; i++){
                answer[i] = Integer.parseInt(arr[i]);
            }
            return answer;
        }
    }*/

}






