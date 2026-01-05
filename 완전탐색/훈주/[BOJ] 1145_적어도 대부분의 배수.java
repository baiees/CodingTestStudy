import java.util.Scanner;

public class Main {

    // 최대공약수 (유클리드 호제법)
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 최소공배수
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;

        // 5개 중 3개 조합
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {

                    int temp = lcm(arr[i], arr[j]);
                    temp = lcm(temp, arr[k]);

                    answer = Math.min(answer, temp);
                }
            }
        }

        System.out.println(answer);
    }
}