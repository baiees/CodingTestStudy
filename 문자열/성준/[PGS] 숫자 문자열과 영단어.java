package StudyCodingTest.String;

public class NumberStringEngishWords {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("one4seveneight"));   // 1478
        System.out.println(sol.solution("23four5six7"));      // 234567
        System.out.println(sol.solution("2three45sixseven")); // 234567
        System.out.println(sol.solution("123"));              // 123
    }
    /*
        이거 그냥 case 노가다 하라는건가....개싫은데...
        근데 그거 아니고서야...1을 어떻게 one으로 하냐 ㅇㅈ?
        하나만 체크를 해보고 영단어는 뒤는 gpt 부탁했어요....
    */
    private static class Solution {
        public int solution(String s) {
            StringBuffer sb = new StringBuffer();
            String temp = "";

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 숫자
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                    continue;
                }

                // 영어 조립
                temp += c;

                // 영어 case 문
                switch (temp) {
                    case "zero":
                        sb.append("0");
                        temp = "";
                        break;
                    case "one":
                        sb.append("1");
                        temp = "";
                        break;
                    case "two":
                        sb.append("2");
                        temp = "";
                        break;
                    case "three":
                        sb.append("3");
                        temp = "";
                        break;
                    case "four":
                        sb.append("4");
                        temp = "";
                        break;
                    case "five":
                        sb.append("5");
                        temp = "";
                        break;
                    case "six":
                        sb.append("6");
                        temp = "";
                        break;
                    case "seven":
                        sb.append("7");
                        temp = "";
                        break;
                    case "eight":
                        sb.append("8");
                        temp = "";
                        break;
                    case "nine":
                        sb.append("9");
                        temp = "";
                        break;
                }
            }

            return Integer.parseInt(sb.toString());
        }
    }

}
