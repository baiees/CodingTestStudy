package StudyCodingTest.String;

public class StringDealWith {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("a234"));  // false
        System.out.println(sol.solution("1234"));  // true
    }

    /*
      if 문으로 4 랑 6 아님 false 하고
      하나씩 검사해서 if(숫자가 아니면) false
      통과하면 true
    * */
    private static class Solution {
        public boolean solution(String s) {
            if(s.length() != 4 && s.length() != 6){
                return false;
            }
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 숫자가 아니면 false
                // 숫자가 들어간거만 찾는다면 && 적는다.
                // 숫자가 아닌거를 찾는다면 || 적는다.
                if(c < '0' || c > '9') {
                    return false;
                }
            }

            return true;  // 모두 숫자면 true
        }
    }
}
