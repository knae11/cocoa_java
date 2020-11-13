package mission2.셔플;

import java.util.Arrays;
import java.util.Random;
public class FourByFourNumberShuffle {

    private final static int SIZE = 4;
    private int[][] board;

    public void puzzle() {
        this.board = new int[SIZE][SIZE];
        // 내부 숫자값 배열
        int[] a = new int[SIZE * SIZE];
        //숫자배열 초기화
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        //System.out.println(Arrays.toString(a));
        shuffle(a);

        //2중 배열에 넣기
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = a[i * SIZE + j];
            }
        }

        //2중 배열 출력하기
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3d",board[i][j]);
            }
            System.out.println();
        }
    }

    private void swap(int[] a, int i, int j) {
        // 뒤에서부터 랜덤 인텍스와 자리 바꿔줌!
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        System.out.println(Arrays.toString(a));
    }

    private void shuffle(int[] a) {
        Random rd = new Random();
        // 거꾸로 돌아야 된다! index 범위 안넘어 가려면 a.length-1 로 해야한다.
        for (int i = a.length-1; i > 0; i--) {
            swap(a, i, rd.nextInt(i));
        }
    }


    public void printShuffleBox() {
    }

}