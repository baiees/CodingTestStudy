package StudyCodingTest.String;

public class StringCountpAndy {

    public static void main(String[] args) {
        Solution sol = new Solution();  // 내부 클래스 호출
        System.out.println(sol.solution("pPoooyY"));
        System.out.println(sol.solution("Pyy"));
    }
    /*
        pcount++ ccount++ 두 개 따로 만들어서 비교 하면 될거 같고
        대소문자 비교 안한다니까 그냥 toUpperCase() 만들면 될거 같고
        for문으로 charAt() 써서 비교 하면 되는거 같은데
        if(== 'P')
        else if (=='Y')
    */
    private static class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            int pCount = 0;
            int yCount = 0;
            s = s.toUpperCase();

            for (int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='P'){
                    pCount++;
                }else if(s.charAt(i)=='Y'){
                    yCount++;
                }
            }
            answer = (pCount == yCount);

            return answer;
        }
    }
}
