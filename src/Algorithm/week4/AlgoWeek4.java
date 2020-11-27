package Algorithm.week4;

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


    public static void main(String[] args) {
        System.out.println((reverse( 1534236469)));
    }
}
