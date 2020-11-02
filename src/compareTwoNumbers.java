import java.util.Scanner;

public class compareTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 수를 입력하세요");
        int firstNum = sc.nextInt();
        System.out.println("두번째 수를 입력하세요");
        int secondNum =sc.nextInt();
        if( firstNum > secondNum) {
            System.out.println(">");
        }
        if( firstNum < secondNum){
            System.out.println("<");
        }
        if( firstNum == secondNum){
            System.out.println("==");
        }

        sc.close();
    }
}
