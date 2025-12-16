package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        String[] arr = temp.split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        String s = br.readLine();
        int[] box = new int[n];

        String[] temp1 = s.split(" ");

        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(temp1[i]);
        }
        Arrays.sort(box);

        bw.write(box[k-1]+"");

        bw.flush();
        bw.close();




    }
}
