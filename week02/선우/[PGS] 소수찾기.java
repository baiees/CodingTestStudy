import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;

    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];

        dfs("");

        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    void dfs(String cur) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        if(n == 2 ) return true;
        if(n%2 == 0) return false;
        for (int i = 3; i * i <= n; i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
