import java.util.Scanner;

public class Gugudan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작단를 입력하세요");
        int start_number = sc.nextInt();
        System.out.println("끝단을 입력하세요");
        int end_number = sc.nextInt();

        for (int j = start_number; j <= end_number; j++) {
            System.out.println(j + "단 만들기");
            for (int i = 1; i < 10; i++) {
                System.out.println(j + "*" + i + "=" + j * i);
            }
        }
        sc.close();
    }

}
