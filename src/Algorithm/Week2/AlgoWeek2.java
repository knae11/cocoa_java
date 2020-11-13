package Algorithm.Week2;

import java.util.*;

public class AlgoWeek2 {

    public static int[] programmers12910(int[] arr, int divisor) {
        int[] answer;
        List<Integer> array = new ArrayList<>();
        for (int i : arr){
            if( i % divisor == 0){
                array.add(i);
            }
        }
        if (array.size() == 0){
            array.add(-1);
        }
        answer = new int[array.size()];
        for(int i=0; i<array.size(); i++ ){
            answer[i] = array.get(i);
        }
        Arrays.sort(answer);
        return answer;
        /* 다른사람 코드
        public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
        }
        * */
    }

    public static int programmers64061(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> toys = new ArrayList<>();
        for ( int i : moves){
            for (int j =0; j<board.length; j++){
                if(board[j][i-1] == 0 ){
                    continue;
                }
                if( toys.size()>0 && toys.get(toys.size()-1) == board[j][i-1] ){
                    answer+=2;
                    toys.remove(toys.size()-1);
                    board[j][i-1] =0;
                    break;
                }
                toys.add(board[j][i-1]);
                board[j][i-1] =0;
                break;
            }
        }
        return answer;
    }

    public static List<Integer> programmers68644(int[] numbers) {

        Set<Integer> setNums = new HashSet<>();
        for(int i = 0; i<numbers.length-1; i++){
            for (int j =i+1; j<numbers.length; j++){
                setNums.add(numbers[i]+ numbers[j]);
            }
        }
        List<Integer> answer = new ArrayList<>(setNums);
        Collections.sort(answer);
        return answer;
        /*
        * 다른사람 풀이
        public int[] solution(int[] numbers) {
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<numbers.length; i++) {
                for(int j=i+1; j<numbers.length; j++) {
                   set.add(numbers[i] + numbers[j]);
                }
            }
            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
        * */

    }
    public static List<Integer> programmers42840(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int max=0;
        int[] corrects ={0,0,0};
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++){
            if( answers[i] == supo1[i%5] ){
                corrects[0]+=1;
            }
            if(answers[i] == supo2[i%8]){
                corrects[1]+=1;
            }
            if(answers[i] == supo3[i%10]){
                corrects[2]+=1;
            }
        }
        for(int i : corrects){
            if(i>max){
                max = i;
            }
        }
        for( int i=0; i<3; i++){
            if(corrects[i] == max){
                answer.add(i+1);
            }
        }
        return answer;
        /* 최대 숫자 구해서 더하는 방식 처리부분(다른사람 풀이) return 값은 int[]이다
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
         */
    }

    public static String programmers12901(int a, int b) {
        String answer = "";
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] yoil = {"THU","FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int day=0;
        for(int i=0; i<a-1; i++){
            day+=days[i];
        }
        day+=b;
        answer = yoil[day%7];
        return answer;
    }

    public static int programmers12928(int n) {
        int answer = 0;
        //1인경우 예외처리
        if(n==1){
            return 1;
        }
        Set<Integer> yaksu = new HashSet<>();
        //반까지 돌릴거면 그냥 나눠지는 거 + 자기자신 하면됨! 굳이 set까지 쓸 필요도 없다.
        for(int i =1; i<n/2+1;i++ ) {
            if(n%i==0){
                yaksu.add(i);
                yaksu.add(n/i);
            }
        }
        for (int i : yaksu){
            answer+=i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(programmers12928(12));
    }
}
