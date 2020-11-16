package mission5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hangleClock {

    private static final String[][] clock = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"오", "이", "삼", "사", "오", "십"},
            {"전", "일", "이", "삼", "사", "오"},
            {"후", "육", "칠", "팔", "구", "분"}
    };

    private static String[] now;

    public static void getTime() {
        Date nowTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String time = timeFormat.format(nowTime);
        now = time.split(":");
        makeClock(now);

    }

    private static void partHour(String hour) {
        int numHour = Integer.parseInt(hour);
//        if(numHour > 12)

    }

    private static void partMinute(String minute) {
        System.out.println(minute);
    }

    private static void makeClock(String[] time) {
        partHour(time[0]);
        partMinute(time[1]);
    }

    public static void print() {
        for (int j = 0; j < clock.length; j++) {
            for (int i = 0; i < clock[0].length; i++) {
                System.out.print(clock[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getTime();
        print();
    }
}
