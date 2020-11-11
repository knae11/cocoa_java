package mission3_mission4;

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

    public String[] zeroUserInfo() {
        System.out.println("사용자 이름을 입력해 주세요.");
        String user = scanner.nextLine();
        System.out.println("비밀번호를 입력해 주세요");
        String password = scanner.nextLine().trim();
        String[] userData = {user, password};
        return userData;
    }

    public MoneyDataSet oneAddData() {
        System.out.println("(yyyymm-dd)형식으로 날짜를 입력해 주세요.");
        String date = scanner.nextLine().trim();
        System.out.println("내용을 입력해 주세요.");
        String contents = scanner.nextLine();
        System.out.println("수입을 입력해 주세요. 단위는 [원]입니다.");
        String income = scanner.nextLine().trim();
        System.out.println("지출을 입력해 주세요. 단위는 [원]입니다.");
        String spending = scanner.nextLine().trim();
        System.out.println("현금, 카드 여부를 적어주세요.");
        String spendingMethod = scanner.nextLine().trim();
        MoneyDataSet moneyDataSet = new MoneyDataSet( date, contents, Integer.parseInt(income), Integer.parseInt(spending), spendingMethod);
        return moneyDataSet;
    }

    public String twoDeleteData() {
        System.out.println("삭제 할 데이터의 순번(숫자)을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public String threeUpdateData() {
        System.out.println("업데이트 할 데이터의 순번(숫자)을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public int fourReadData() {
        System.out.println("가계부를 확인 할 년월(yyyymm)을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public void printWhichMonth(int yearAndMonth) {
        System.out.println();
        System.out.println("----<< " + yearAndMonth + "의 가계부 >>----");
        System.out.println();
        System.out.println("id, 날짜, 내용, 수입, 지출, 지출방식");
        System.out.println();

    }

    public void printThisMonthMoney(int income, int spending, int total) {
        System.out.println();
        System.out.println("이번달 총 수입 : " + income);
        System.out.println("이번달 총 지출 : " + spending);
        System.out.println("이번달 총 잔액 : " + total);
    }
    public MoneyDataSet printUpdateMessage(MoneyDataSet contents){
        System.out.println("< 기존내용 : " + contents.toString() + " >");
        System.out.println("기존내용을 참고하여 업데이트 할 내용을 새롭게 입력해 주세요 :)");
        return oneAddData();
    }

    public String selectSearchType(){
        System.out.println("a : 날짜로 검색, b : 내용으로 검색, c: 금액으로 검색, d: 수입으로 검색, e: 지출로 검색, f: 소비유형으로 검색, z: 전체보기");
        return scanner.nextLine().trim();
    }

    public int selectMoney(){
        System.out.println("검색할 금액은? [원]");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String selectSpendingMethod(){
        System.out.println("현금? 카드?");
        return scanner.nextLine();
    }

    public int selectDay() {
        System.out.println("검색할 일자는?");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String selectKeyword() {
        System.out.println("검색할 키워드는?");
        return scanner.nextLine();
    }
}

