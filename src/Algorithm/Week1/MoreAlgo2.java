package Algorithm.Week1;

import java.util.Scanner;

public class MoreAlgo2 {
    /*   정답 제출용 템플릿

import java.util.*;
    public class Main{
        public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i =0; i<tc ; i++){
            int h = sc.nextInt();
            int w  = sc.nextInt();
            int n = sc.nextInt();
            String result ="";
            int Y = n%h;
            if( Y==0){
                Y=h;
            }
            result +=Y;
            int X = (n-1)/h+1;
            if(X/10==0){
                result +="0"+X;
            }else{
                result +=X;
            }
            System.out.println(result);

        }

        }
    }
 */
    public void bj1085(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int min = 1000;

        if(w-x<min){
            min = w-x;
        }
        if(h-y<min){
            min = h-y;
        }
        if(x<min){
            min = x;
        }
        if(y<min){
            min = y;
        }
        System.out.println(min);

    }
    public void bj10250(){
        //뭔가 좀 마음에 안들지만.. 다른풀이에서 100으로 처리하는 건 뭘까?
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i =0; i<tc ; i++){
            int h = sc.nextInt();
            int w  = sc.nextInt();
            int n = sc.nextInt();
            String result ="";
            int Y = n%h;
            if( Y==0){
                Y=h;
            }
            result +=Y;
            int X = (n-1)/h+1;
            if(X/10==0){
                result +="0"+X;
            }else{
                result +=X;
            }
            System.out.println(result);
        }
    }

    public void bj2798(){
        // 주소 : https://www.acmicpc.net/problem/2798
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cards = new int[n];
        for(int i=0; i<n; i++){
            cards[i] = sc.nextInt();
        }
        //combination 구현하기..?



    }


    public static void main(String[] args) {
        MoreAlgo2 solution = new MoreAlgo2();
        solution.bj2798();
    }
}
