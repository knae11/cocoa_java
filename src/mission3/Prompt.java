package mission3;

import java.util.Scanner;

public class Prompt {
    public void selectWhatToDo() {
        System.out.println("--무엇을 하시겠습니까?--");
        System.out.println("아래 키 중 하나를 입력해 주세요.");
        System.out.println("0: 사용자 로그인 및 등록");
        System.out.println("1: 데이터 입력");
        System.out.println("2: 데이터 삭제");
        System.out.println("3: 데이터 수정");
        System.out.println("4: 데이터 보기");
        System.out.println("h: 도움말");
        System.out.println("q: 끝내기");
        System.out.println("----------------------");
    }

    public void zeroUserInfo() {
        System.out.println("사용자 이름과 비밀번호를 입력해 주세요.");
    }

    public void oneAddData() {
        System.out.println("날짜(yyyy-mm-dd), 내용, 수입, 지출 순으로 입력해 주세요.");
    }

    public void twoDeleteData() {
        System.out.println("삭제 할 데이터의 순번을 입력해 주세요.");
    }

    public void threeUpdateData() {
        System.out.println("업데이트 할 데이터의 순번을 입력해 주세요.");
    }

    public void fourReadData() {
        System.out.println("가계부를 확인 할 년도,월(yyyy-mm)을 입력해 주세요.");
    }

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        selectWhatToDo();
        while (true) {
            String key = sc.next();
            switch (key) {
                case "0":
                    zeroUserInfo();
                    break;
                case "1":
                    oneAddData();
                    break;
                case "2":
                    twoDeleteData();
                    break;
                case "3":
                    threeUpdateData();
                    break;
                case "4":
                    fourReadData();
                    break;
                case "h":
                    selectWhatToDo();
                    break;
                case "q":
                    return;
            }
        }
    }
}
