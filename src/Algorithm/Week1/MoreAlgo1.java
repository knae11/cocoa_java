package Algorithm.Week1;

import java.util.Scanner;

public class MoreAlgo1 {/*
정답 제출용 템플릿

import java.util.*;
 public class Main{
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }

    }
 }
*
* */

    public void bj1001(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a-b);
    }
    public void bj1008(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((double)a/b);
    }

    public void bj1152(){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().trim();
        //공백 문자열인 경우 예외처리 의문...ㅠㅠ
        // nextLine은 문자열로 주고, split()은 배열을 반환
        if( word.isEmpty() ){
            System.out.println(0);
        }else {
            System.out.println(word.split(" ").length);
        }
    }

    public void bj1157(){
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        //toLowerCase는 새 String을 반환
        int[] alpha = new int[26];
        for( int i = 0; i< word.length(); i++){
            alpha[(int)word.charAt(i)-97] +=1;
        }
        int max =0;
        char result ='?';
        // 가장 큰 값 찾기,, 이 생각을 못 했다. 중복되는 경우 확인
        for (int i =0; i<26; i++){
            if(alpha[i]> max){
                max = alpha[i];
                result = (char)(i+65);
            }else if (alpha[i] == max){
                result = '?';
            }
        }

        System.out.println(result);
    }

    public void bj1546(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0 ;
        float sum =0;
        int[] scores = new int[n];
        float[] newScores = new float[n];
        for (int i =0; i<n ; i++){
            scores[i] = sc.nextInt();
            if(scores[i] > max){
                max = scores[i];
            }
        }
        for (int i =0; i<n ; i++){
            //float 해 줄 수식에 괄호 넣으면 제대로 안됨..ㅠㅠ
            newScores[i] = (float)scores[i]/max*100;
            sum += newScores[i];
        }
        System.out.println(sum/n);
    }

    public void bj2475(){
        Scanner sc = new Scanner(System.in);
        int result =0;
        for( int i =0; i<5; i++){
            int a = sc.nextInt();
            result += a*a;
        }
        System.out.println(result%10);
    }

    public void bj2562(){
        Scanner sc = new Scanner(System.in);
        int max =0;
        int maxIndex =0;
        for(int i =0; i<9; i++){
            int a = sc.nextInt();
            if(a>max){
                max = a;
                maxIndex = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }

    public void bj2675(){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i =0; i<tc ; i++){
            int a = sc.nextInt();
            String word = sc.next();
            for (int j=0; j<word.length(); j++){
                for (int k =0; k<a; k++){
                    System.out.print(word.charAt(j));
                }
            }
            System.out.println();
        }
    }

    public void bj10818(){
        //94퍼 가서 오답처리;  ==> 왜냐면 주어지는 수가 '음수'인 경우 처리 안해서! *제발 조건파악 잘하자*
        //라이브러리 Math.min Math.max 를 불러와서 해결할 수도 있다!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min= 1000000;
        int max =-1000000;
        for (int i =0; i<n;i++){
            int a = sc.nextInt();
            if(a>max){
                max =a;
            }
            if(a<min){
                min =a;
            }
        }
        System.out.println(min + " "+ max);
    }

    public void bj10869(){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

    }

    public void bj10950(){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }


    }

    public static void main(String[] args) {
    MoreAlgo1 solution = new MoreAlgo1();
    solution.bj10950();
    }
}
