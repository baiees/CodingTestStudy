package StudyCodingTest.String;

import java.util.Scanner;

/*
    이게 왜 기초인데?
    숫자 하나 당 => 2초
    뭔가 알고리즘 있는거 같은데 그걸 모르겠어서 생각나는게 if문 or switch case?
    // 문자열 받는거 필요하고 count 로 초 적는거 필요함

 */
public class Dial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();

        int count=0;

        for(int i = 0; i<code.length(); i++){
            switch (code.charAt(i)){
                case 'A','B','C':
                    count += 3;
                    break;
                case 'D','E','F':
                    count += 4;
                    break;
                case 'G','H','I':
                    count += 5;
                    break;
                case 'J','K','L':
                    count += 6;
                    break;
                case 'M','N','O':
                    count += 7;
                    break;
                case 'P','Q','R','S':
                    count += 8;
                    break;
                case 'T','U','V':
                    count += 9;
                    break;
                case 'W','X','Y','Z':
                    count += 10;
                    break;
            }
        }
        System.out.println(count);
    }
}
