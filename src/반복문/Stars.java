package 반복문;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 별을 찍을래요?");
        int num = sc.nextInt();
        for(int i=1; i<=num; i++){
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
            }
        }
    }

