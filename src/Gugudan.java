import java.util.Scanner;

public class Gugudan {

    public int start;
    public int end;

    public void getStartEndNumOfGugudan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("시작단를 입력하세요");
        start = sc.nextInt();
        System.out.println("끝단을 입력하세요");
        end = sc.nextInt();
        sc.close();
    }
     private void printOneGugudan(int j){
        for (int i = 1; i < 10; i++) {
            System.out.println(j + "*" + i + "=" + j * i);
        }
    }
    public void printGugudans(){
        for (int j = start; j <= end; j++) {
            System.out.println(j + "단 만들기");
            printOneGugudan(j);
            System.out.println();
        }
    }


}
