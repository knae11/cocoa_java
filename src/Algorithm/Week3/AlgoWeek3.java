package Algorithm.Week3;

import java.util.ArrayList;
import java.util.List;

public class AlgoWeek3 {

    //https://www.hackerrank.com/challenges/grading/problem
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> results = new ArrayList<>();
        for ( Integer result : grades ){
            int multiFive = 5*(result / 5 + 1);
            if(result <38){
                results.add(result);
            }else if(multiFive - result < 3){
                results.add(multiFive);
            } else {
                results.add(result);
            }

        }
        return results;
    }

    //https://www.hackerrank.com/challenges/compare-the-triplets/problem
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> results = new ArrayList<>();
        int aScore = 0;
        int bScore = 0;
        // for in range 의 다른 방법이 없나ㅠㅠㅠ
        for ( int i =0 ; i< a.size(); i++ ){
            if( a.get(i) > b.get(i)){
                aScore ++;
            }
            if( a.get(i) < b.get(i)){
                bScore ++;
            }
        }
        results.add(aScore);
        results.add(bScore);
        return results;
    }

    //https://www.hackerrank.com/challenges/a-very-big-sum/problem
    //long[] a = {1000000001L ,1000000002L ,1000000003L, 1000000004L ,1000000005L};
    static long aVeryBigSum(long[] ar) {
        long answer = 0L;
        for( long num : ar){
            answer += num;
        }
        return answer;
    }

    //https://www.hackerrank.com/challenges/time-conversion/problem
    //String s = "07:05:45PM";
    //이 풀이 별로인 것 같다..ㅠ
    static String timeConversion(String s) {
        String answer = "";
        String dayOrNight = s.substring(s.length()-2);
        String hourInfo = s.substring(0, s.length()-2);
        int hour = Integer.parseInt(hourInfo.substring(0, 2));

        if(dayOrNight.equals("AM") ){
            if(hour == 12) {
                answer += "00" + hourInfo.substring(2);
            }else{
                answer = hourInfo;
            }
        }

        if(dayOrNight.equals("PM")){
            if( hour <12){
                answer += (hour+12) + hourInfo.substring(2);
            }
            if (hour == 12){
                answer = hourInfo;
            }
        }
        return answer;
    }

    //https://www.hackerrank.com/challenges/kangaroo/problem
    // 나머지 값을 못 빼는 이유는 같은 경우 때문에!
    // 2차 방정식 함수로 체크! 정수가 되어야 한다는 조건 추가해야한다~ ✨
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String answer = "NO";
        if( x2-x1>0 && v1-v2>0 && (x2 - x1) % (v1 - v2) == 0){
            answer = "YES";
        }
        if( x2-x1<0 && v1-v2<0 && (x2 - x1) % (v1 - v2) == 0){
            answer = "YES";
        }
        if( x2==x1  && v1==v2){
            answer = "YES";
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(kangaroo(43, 2, 70 ,2));
    }
}
