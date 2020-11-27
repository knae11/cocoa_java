package Algorithm.week4;

import java.util.HashMap;
import java.util.Map;

public class AlgoWeek4 {

    //https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for ( int i = 0; i < nums.length; i++ ) {
            for ( int j = i+1; j < nums.length; j++ ){
                if( nums[i] + nums[j] == target ){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    //https://leetcode.com/problems/reverse-integer/
    //인터넷에서 알게된 코드인데 뒷자리부터 하나씩 빼서 처리하고 있다..!! 똑똑하다..! 문자열로 안 바꿔도 되서 좋다!
    //answer을 int로 하면 범위 넘어가서 long으로 해주어야 함, 문제 상세조건 예외처리 잘 읽기!!
    public static int reverse(int x) {
        long answer = 0;
        while(x!=0){
            int digit = x % 10;
            answer = answer*10 + digit;
            if( answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE ){
                return 0;
            }
            x /= 10;
        }
        return (int)answer;
    }

    //https://leetcode.com/problems/palindrome-number/
    //내 풀이 좀 별로인 것 같은데ㅠ
    //다른 풀이 보니까 -일땐 그냥 false 처리하고 양수인 경우 위에 숫자 거꾸로 로직 비교하면 될 듯
    public static boolean isPalindrome(int x) {
        boolean answer = false;
        String reversedX = "";
        String stringX = String.valueOf(x);
        String[] stringArr = stringX.split("");
        for ( int i = stringArr.length-1; i > -1; i-- ){
            reversedX += stringArr[i];
        }
        if ( stringX.equals(reversedX) ){
            answer = true;
        }
        return answer;
    }

    //https://leetcode.com/problems/roman-to-integer/
    //음.. 다른 풀이 보고싶다..!
    public static int romanToInt(String s) {
        int answer = 0;

        Map<String, Integer> romanNum = new HashMap<>();
        romanNum.put("I", 1);
        romanNum.put("V", 5);
        romanNum.put("X", 10);
        romanNum.put("L", 50);
        romanNum.put("C", 100);
        romanNum.put("D", 500);
        romanNum.put("M", 1000);
        String[] sArr = s.split("");
        for ( int i = sArr.length-1; i > -1 ; i--){
            if( i != sArr.length-1 && romanNum.get(sArr[i]) < romanNum.get(sArr[i+1])) {
                answer -= romanNum.get(sArr[i]);
                continue;
            }
            answer += romanNum.get(sArr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt( "MCMXCIV"));
    }
}
