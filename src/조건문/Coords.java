package 조건문;

import java.util.Scanner;

public class Coords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("x값을 입력하세요");
        int x = sc.nextInt();
        System.out.println("y값을 입력하세요");
        int y = sc.nextInt();
        sc.close();
        if(x>0 && y>0){
            System.out.println("1");

        }
        if(x<0 && y>0){
            System.out.println("2");

        }
        if(x<0 && y<0){
            System.out.println("3");

        }
        if(x>0 && y<0){
            System.out.println("4");

        }
    }
}
