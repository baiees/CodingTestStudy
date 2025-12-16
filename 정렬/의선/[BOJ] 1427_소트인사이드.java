package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        String result ="";
        int len = num.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = num.charAt(i) - '0';
        }

        Arrays.sort(arr);

        for(int i=len-1;i>=0;i--){
            sb.append(arr[i]);
        }



        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
