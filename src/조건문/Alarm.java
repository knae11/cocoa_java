package 조건문;

import java.util.Scanner;

public class Alarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시간을 입력하세요");
        int hour = sc.nextInt();
        int min = sc.nextInt();
        min-=45;
        if((min) < 0){
            min +=60;
            hour-=1;
            if(hour <0){
                hour = 23;
            }
        }



        System.out.println(hour+ " " + min);
    }
}
