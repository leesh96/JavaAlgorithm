package kakaotest.intern2021;

import java.io.*;

public class KI1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        bw.write(solution(input) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); ) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                answer = answer * 10 + (s.charAt(i) - '0');
                i++;
                continue;
            }
            if (s.charAt(i) == 'z' && s.charAt(i + 1) == 'e') {
                answer = answer * 10;
                i += 4;
            } else if (s.charAt(i) == 'o' && s.charAt(i + 1) == 'n') {
                answer = answer * 10 + 1;
                i += 3;
            } else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'w') {
                answer = answer * 10 + 2;
                i += 3;
            } else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'h') {
                answer = answer * 10 + 3;
                i += 5;
            } else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'o') {
                answer = answer * 10 + 4;
                i += 4;
            } else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'i') {
                answer = answer * 10 + 5;
                i += 4;
            } else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'i') {
                answer = answer * 10 + 6;
                i += 3;
            } else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'e') {
                answer = answer * 10 + 7;
                i += 5;
            } else if (s.charAt(i) == 'e' && s.charAt(i + 1) == 'i') {
                answer = answer * 10 + 8;
                i += 5;
            } else if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'i') {
                answer = answer * 10 + 9;
                i += 4;
            }
        }
        return answer;
    }
}
