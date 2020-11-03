import java.util.Scanner;

public class Gugudan {

    static int[] getStartEndNumOfGugudan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("시작단를 입력하세요");
        int[] startAndEnd = new int[2];
        startAndEnd[0] = sc.nextInt();
        System.out.println("끝단을 입력하세요");
        startAndEnd[1] = sc.nextInt();
        sc.close();
        return startAndEnd;
    }
    static void printOneGugudan(int j){
        for (int i = 1; i < 10; i++) {
            System.out.println(j + "*" + i + "=" + j * i);
        }
    }
    public static void main(String[] args) {

        int[] startEnd =  getStartEndNumOfGugudan();

        for (int j = startEnd[0]; j <= startEnd[1]; j++) {
            System.out.println(j + "단 만들기");
            printOneGugudan(j);
            System.out.println();
        }
    }

}
