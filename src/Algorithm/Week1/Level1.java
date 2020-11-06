package Algorithm.Week1;

import java.util.Scanner;
/*
정답 제출용 템플릿

import java.util.*;
 public class Main{
     public static void main(String[] args) {

             Scanner sc = new Scanner(System.in);
        char text = sc.next().charAt(0);
        int num = (int)text;
        System.out.println(num);

    }
 }
*
* */

public class Level1 {
    public void bj1000(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a+b);
    }

    public void bj1008(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((double) a/b);
    }
    public void bj2438(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for( int i = 1; i < a+1 ; i ++){
            for ( int j = 0; j < i; j ++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void bj2920(){
        //맞추고 남의 답 참고
        //String[] seq = reader.readLine().split(" "); 이런식으로 한 줄 공백으로 입력받아  배열 넣기 가능한듯
        //아래와 같이 셋팅하고 비교도 가능
        // private static boolean asc(int[] music) {
        //		int[] ascending = {1,2,3,4,5,6,7,8};
        //		for (int i = 0; i < ascending.length; i++) {
        //			if(music[i]!=ascending[i]) {
        //				return false;
        //			}
        //		}
        //		return true;
        //	}
        //
        //	private static boolean des(int[] music) {
        //		int[] descending = {8,7,6,5,4,3,2,1};
        //		for (int i = 0; i < descending.length; i++) {
        //			if(music[i]!=descending[i]) {
        //				return false;
        //			}
        //		}
        //		return true;
        //	}
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        boolean asc = true;
        boolean des = true;
        for ( int i = 0 ; i < 8 ; i++ ){

            arr[i] = sc.nextInt();
            if(i>1){
               if(arr[i-1] > arr[i]){
                   asc = false;
               }
               if(arr[i-1]<arr[i]){
                   des = false;
               }
           }
        }
        if(asc){
            System.out.println("ascending");
        }
        else if(des){
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }
    }

    public void bj8958(){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i =0 ; i < tc ; i ++) {
            //nextline 쓰면 1개 빠져.. 차이 공부하기
            String s = sc.next();
            int score =0;
            int beforeScore =0;
            for(int j=0; j<s.length(); j++){
                //char 타입은 ''
                if(s.charAt(j)=='O'){
                    beforeScore +=1;
                    score+=beforeScore;
                }
                if(s.charAt(j) =='X'){
                    beforeScore=0;
                }
            }
            System.out.println(score);

        }
    }

    public void bj11654(){
        Scanner sc = new Scanner(System.in);
        char text = sc.next().charAt(0);
        System.out.println(text);
        int num1 = (int)text;
        System.out.println(num1);

    }


    public static void main(String[] args) {
        Level1 solution = new Level1();
        solution.bj11654();
    }
}

