import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);   // 기본값 -1

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장

        for (int i = 0; i < n; i++) {
            // 현재 값이 스택 top보다 크면 답 확정
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}


// public class Solution {


//    public int[] solution(int[] numbers) {
      
//       int[] answer = new int[numbers.length];
//       int now = 0;
      
//       for(int i = 0; i < numbers.length; i ++ ) {
//          if( i == numbers.length - 1) {
//             answer[i] = -1;
//             break;
//          }
//          now = i;
//          answer[i] = numbers[i] < numbers[i+1] ? numbers[i+1]: process(i + 1, now ,numbers);
         
//       }
      
//       return answer;
//    }
   
//    public int process (int i, int now,int[] numbers ) {
      
//       int result;
//       if(i == numbers.length - 1) {
//          result = - 1;
//          return result;
//       }
//       result = numbers[i+1] > numbers[now]? numbers[i+1]: process(i+1, now, numbers);
      
//       return result;
//    }

// }
