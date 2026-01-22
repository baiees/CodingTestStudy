package coding_4;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	// 1. 파싱하기
	// 2. 맵으로 유저아이디와 닉네임 저장
	// 3. Enter, Leave, Change case를 나눠서 메서드 실행
	// 4. 주의사항으로는 대소문자구분하고, 특수문자는 사용 금지

		public String[] solution(String[] record) {

		    Map<String, String> map = new HashMap<>();

		    // 1️⃣ 닉네임 최신화
		    for (String r : record) {
		        String[] parts = r.split(" ");
		        if (parts[0].equals("Enter") || parts[0].equals("Change")) {
		            map.put(parts[1], parts[2]);
		        }
		    }

		    // 2️⃣ 결과 개수 계산
		    int count = 0;
		    for (String r : record) {
		        String cmd = r.split(" ")[0];
		        if (cmd.equals("Enter") || cmd.equals("Leave")) {
		            count++;
		        }
		    }

		    String[] answer = new String[count];
		    int idx = 0;

		    // 3️⃣ 메시지 생성
		    for (String r : record) {
		        String[] parts = r.split(" ");
		        switch (parts[0]) {
		            case "Enter":
		                answer[idx++] = map.get(parts[1]) + "님이 들어왔습니다.";
		                break;
		            case "Leave":
		                answer[idx++] = map.get(parts[1]) + "님이 나갔습니다.";
		                break;
		        }
		    }

		    return answer;
		}

}
