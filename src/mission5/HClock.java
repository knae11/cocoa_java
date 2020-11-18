package mission5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HClock {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private static final String[][] clock = {
            {"한", "두", "세", "네", "다섯"},
            {"여섯", "일곱", "여덟"},
            {"아홉", "열", "한", "두", "시"},
            {"오", "이", "삼", "사", "오", "십"},
            {"전", "일", "이", "삼", "사", "오"},
            {"후", "육", "칠", "팔", "구", "분"}
    };

    private  List<int[]> posInfo = new ArrayList<>();

    private  void insertPos ( int i, int j){
        int[] pos = { i, j};
        posInfo.add(pos);
    }
    private void getTime() {
        LocalDateTime currTime = LocalDateTime.now();
        int hour = currTime.getHour();
        int minute = currTime.getMinute();
        makeClock(hour, minute);
    }

    private void partHour(int hour) {
        int numHour = hour % 12;
        if (0 < numHour && numHour < 6) {
            insertPos(0, numHour-1);
            //System.out.println(clock[0][numHour - 1]);
        }
        switch (numHour) {
            case 0:
                insertPos(2,1);
                insertPos(2,3);
                //System.out.println(clock[2][1] + clock[2][3]);
                break;
            case 6:
                insertPos(1,0);
                //System.out.println(clock[1][0]);
                break;
            case 7:
                insertPos(1,1);
                //System.out.println(clock[1][1]);
                break;
            case 8:
                insertPos(1,2);
                //System.out.println(clock[1][2]);
                break;
            case 9:
                insertPos(2,0);
                //System.out.println(clock[2][0]);
                break;
            case 10:
                insertPos(2,1);
                //System.out.println(clock[2][1]);
                break;
            case 11:
                insertPos(2,1);
                insertPos(2,2);
                //System.out.println(clock[2][1] + clock[2][2]);
                break;
        }
        insertPos(2,4);
        //System.out.println(clock[2][4]);

    }

    private void partDayOrNight(int hour) {
        insertPos(3,0);
        //System.out.println(clock[3][0]);
        if (hour < 12) {
            insertPos(4,0);
          //  System.out.println(clock[4][0]);
        } else {
            insertPos(5,0);
           // System.out.println(clock[5][0]);

        }
    }

    private void partMinute(int minute) {
        int onesMinute = minute %10;
        int tensMinute = minute / 10;
        //십분단위
        if( 1< tensMinute) {
            insertPos(3,tensMinute-1);
            //System.out.println(clock[3][tensMinute-1]);
        }
        if( 0< tensMinute){
            insertPos(3,5);
            //System.out.println(clock[3][5]);
        }

        //일분단위
        if( 0<onesMinute && onesMinute <6  ){
            insertPos(4,onesMinute);
            //System.out.println(clock[4][onesMinute]);
        }
        if( 5< onesMinute && onesMinute < 10){
            insertPos(5,onesMinute%5);
            //System.out.println(clock[5][onesMinute%5]);
        }
        insertPos(5,5);
        //System.out.println(clock[5][5]);


    }

    private void makeClock(int hour, int minute) {
        partHour(hour);
        partDayOrNight(hour);
        partMinute(minute);
    }
    private void onColor (int i, int j){
      System.out.print(ANSI_PURPLE + clock[i][j] + ANSI_RESET);
    }

    private void print() {

        Collections.sort(posInfo, (e1, e2) ->{
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0] -e2[0];
            }
        });

        int count =0;

        for (int i = 0; i < clock.length; i++) {
            for (int j = 0; j < clock[i].length; j++) {
                if( i == posInfo.get(count)[0] && j ==posInfo.get(count)[1]){
                    onColor(i,j);
                    count +=1;
                    continue;
                }
                System.out.print(clock[i][j]);
            }
            System.out.println();
        }
    }


    public void clockRun(){

        getTime();
        print();
    }
}
