package kakaotest.blind2021;

public class KB1 {
    public static void main(String[] args) {
        System.out.println(solution("z-+.^."));
    }

    static String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        // 아이디의 길이는 3자 이상 15자 이하
        // 아이디는 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 문자만 사용 가능
        // 마침표는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

        // 처리 단계
        // 1. 모든 대문자를 대응되는 소문자로 치환
        // 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거합니다.
        // 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        // 4. 마침표가 처음이나 끝에 위치한다면 제거
        // 5. 빈 문자열 이면 "a"를 대입
        // 6. 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 7. 길이가 2자 이하라면, 마지막 문자를 3이 될 때까지 반복해서 붙인다.

        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^0-9a-z_.-]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        if (new_id.length() >= 1) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }
        }
        if (new_id.length() >= 1) {
            if (new_id.charAt(new_id.length() - 1) == '.') {
                if (new_id.length() == 1) {
                    new_id = "";
                } else {
                    new_id = new_id.substring(0, new_id.length() - 1);
                }
            }
        }
        if (new_id.length() == 0) {
            new_id += "a";
        }
        for (int i = 0; i < new_id.length(); i++) {
            if (i == 14 && new_id.charAt(i) == '.') {
                continue;
            }
            if (i == 15) {
                break;
            }
            answer.append(new_id.charAt(i));
        }
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }
        return answer.toString();
    }
}
