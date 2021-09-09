package kakaotest.blind2021;

public class KB5 {
    public static void main(String[] args) {

    }

    static String solution(String play_time, String adv_time, String[] log) {
        int playRuntime = timeParseInt(play_time);
        int advRuntime = timeParseInt(adv_time);
        int[] count = new int[360000];

        for (int i = 0; i < log.length; i++) {
            String[] cur = log[i].split("-");
            int start = timeParseInt(cur[0]);
            int end = timeParseInt(cur[1]);

            for (int t = start; t < end; t++) {
                count[t]++;
            }
        }

        int sum = 0;
        int max = 0;
        int idx = 0;

        for (int i = 0; i < advRuntime; i++) {
            sum += count[i];
        }
        max = sum;

        for (int i = advRuntime; i < playRuntime; i++) {
            sum += count[i] - count[i - advRuntime];
            if (sum > max) {
                max = sum;
                idx = i - advRuntime + 1;
            }
        }

        return timeParseString(idx);
    }

    static int timeParseInt(String time) {
        String[] times = time.split(":");
        int multiplier = 3600;
        int total = 0;
        for (String t : times) {
            total += Integer.parseInt(t) * multiplier;
            multiplier /= 60;
        }

        return total;
    }

    static String timeParseString(int time) {
        String result = "";

        int hour = time / 3600;
        time %= 3600;
        if (hour < 10) {
            result += "0" + hour + ":";
        } else {
            result += hour + ":";
        }

        int min = time / 60;
        time %= 60;
        if (min < 10) {
            result += "0" + min + ":";
        } else {
            result += min + ":";
        }

        if (time < 10) {
            result += "0" + time;
        } else {
            result += time;
        }

        return result;
    }
}
