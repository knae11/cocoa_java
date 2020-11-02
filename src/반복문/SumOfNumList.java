package 반복문;

import java.util.Scanner;

public class SumOfNumList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자의 개수?");
        int num = sc.nextInt();
        System.out.println("숫자?");
        String numbers = sc.next();
        String[] nums = numbers.split("");
        int result=0;
        for (int i=0; i<num; i++){
            result += Integer.parseInt(nums[i]);
        }
        System.out.println(result);
        sc.close();
    }
}
