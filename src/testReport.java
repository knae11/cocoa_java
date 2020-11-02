import java.util.Scanner;

public class testReport {
    public static boolean isBetween (int x, int lower, int upper){
        return lower <= x && x< upper;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시험점수를 입력하세요");
        int score = sc.nextInt();

        switch(score/10){
            case 10:
                System.out.println("A");
                break;
            case 9:
                System.out.println("B");
                break;
            case 8:
                System.out.println("C");
                break;
            case 7:
                System.out.println("D");
                break;
            case 6:
                System.out.println("E");
                break;
            default:
                System.out.println("F");
                break;


        }
    }
}
