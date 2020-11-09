package mission3;

import java.util.Scanner;

public class Prompt {
    Scanner scanner = new Scanner(System.in);

    public void hMenu(String name) {
        System.out.println("-- "+name + "님 무엇을 하시겠습니까?--");
        System.out.println("아래 키 중 하나를 입력해 주세요.");
        System.out.println("1: 데이터 입력");
        System.out.println("2: 데이터 삭제");
        System.out.println("3: 데이터 수정");
        System.out.println("4: 데이터 보기");
        System.out.println("h: 도움말");
        System.out.println("q: 끝내기");
        System.out.println("-----------------------------------");
    }

    public void selectWhatToDo() {
        System.out.println();
        System.out.println("--------무엇을 하시겠습니까?--------");
        System.out.println(" 1,2,3,4,h,q 중 하나를 입력해 주세요.");
        System.out.println("---------------------------------");
    }

    public String zeroUserInfo() {
        System.out.println("사용자 이름을 입력해 주세요.");
        String user = scanner.nextLine();
        System.out.println("비밀번호를 입력해 주세요");
        int password = Integer.parseInt(scanner.nextLine().trim());
        return user;
    }

    public String oneAddData() {
        System.out.println("(yyyy-mm-dd)형식으로 날짜를 입력해 주세요.");
        String date = scanner.nextLine().trim();
        System.out.println("내용을 입력해 주세요.");
        String contents = scanner.nextLine();
        System.out.println("수입을 입력해 주세요. 단위는 [원]입니다.");
        int income = scanner.nextInt();
        System.out.println("지출을 입력해 주세요. 단위는 [원]입니다.");
        int spending = scanner.nextInt();
        scanner.nextLine();
        return date + ", " + contents + ", " + income + ", " + spending;
    }

    public void twoDeleteData() {
        System.out.println("삭제 할 데이터의 순번(숫자)을 입력해 주세요.");
    }

    public void threeUpdateData() {
        System.out.println("업데이트 할 데이터의 순번(숫자)을 입력해 주세요.");
    }

    public void fourReadData() {
        System.out.println("가계부를 확인 할 년도-월(yyyy-mm)을 입력해 주세요.");
    }

    public void printWhichMonth(int year, int month) {
        System.out.println(year + "년  " + month + "월의 가계부");
        System.out.println();
        System.out.println("순번 : 날짜, 내용, 하루수입, 하루지출 => 잔액");
    }

    public void printThisMonthMoney(int income, int spending, int total) {
        System.out.println();
        System.out.println("이번달 총 수입 : " + income);
        System.out.println("이번달 총 지출 : " + spending);
        System.out.println("이번달 총 잔액 : " + total);
    }
    public String printUpdateMessage(String contents){
        System.out.println("< 기존내용 : " + contents+ " >");
        System.out.println("기존내용을 참고하여 업데이트 할 내용을 새롭게 입력해 주세요 :)");
        return oneAddData();
    }
}

