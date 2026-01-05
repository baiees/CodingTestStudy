import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
첫 - 이후 등장하는 수들을 전부 합, 한번에 빼기.
괄호는 첫 - 부터 식 끝까지 한 번만 존재.
중간에 +, -가 다시 나와도 이미 모두 빼기로 묶여있어서 상관 없다.
*/

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();

        //String[] parts = expr.split("-"); // '-' 기준 식 분리

        int result = sumPart(parts[0]); // 첫 합

        for (int i = 1; i < parts.length; i++) { // 첫 합 이후로 묶어 빼기
            result -= sumPart(parts[i]);
        }

        System.out.println(result);
    }

    // ex) "50+40+30" 문자열 -> '+' 기준으로 나눈 뒤 숫자들의 합
    private static int sumPart(String part) {
        // StringTokenizer st = new StringTokenizer(part, "+"); // '+'기준 문자열 분리
        int sum = 0;

        while (st.hasMoreTokens()) { // 분리 숫자들 하나씩 꺼내어 정수로 변환 후 누적
            sum += Integer.parseInt(st.nextToken());
        }

        return sum; // 총합
    }
}