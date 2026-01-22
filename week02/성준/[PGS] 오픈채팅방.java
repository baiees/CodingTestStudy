package week02;

import java.util.HashMap;

/*
    유저 아이디 기억
    uid1234 -> Prodo
    uid4567 -> Ryan

    명령어 / Enter, Leave, Change

    HashMap -> 유저 ID , 닉네임

    for (String r 에 recode 담아)
        공백으로 쪼개서 담고
        첫index 에 명령어 나오는거 체크
        if ( Enter or Change)
            index 1 index 2 넣어


 */
public class week02_1 {
    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();

        for (String r : record) {
            String[] temp = r.split(" ");
            String cmd = temp[0];

            if ("Enter".equals(cmd) || "Change".equals(cmd)) {
                map.put(temp[1], temp[2]);
            }
        }

        int count = 0;
        for (String r : record) {
            String cmd = r.split(" ")[0];
            if (!"Change".equals(cmd)) {
                count++;
            }
        }

        String[] answer = new String[count];
        int idx = 0;

        for (String r : record) {
            String[] temp = r.split(" ");
            String cmd = temp[0];
            String uid = temp[1];


            // 총 4번말 실행을 하면 된다!!
            if ("Enter".equals(cmd)) {
                answer[idx++] = map.get(uid) + "님이 들어왔습니다.";
            }
            else if ("Leave".equals(cmd)) {
                answer[idx++] = map.get(uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
