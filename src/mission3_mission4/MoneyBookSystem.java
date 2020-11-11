package mission3_mission4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class MoneyBookSystem {
    //class instance 만들기
    Prompt prompt = new Prompt();
    CalculateMoneyData calculateMoneyData = new CalculateMoneyData();

    //각종 저장될 자료구조
    private HashMap<Integer, MoneyDataSet> moneyBookMapById;
    private HashMap<Integer, ArrayList<Integer>> moneyBookMapByDate;
    private HashMap<String, ArrayList<Integer>> moneyBookMapBySpendingMethod;
    private HashMap<Integer,ArrayList<Integer>> moneyBookMapByIncome;
    private HashMap<Integer,ArrayList<Integer>> moneyBookMapBySpending;

    //개인정보 일치
    private String userName = "나나";
    private String password = "1111";

    private int id;

    //초기 생성
    public MoneyBookSystem() {
        moneyBookMapById = new HashMap<>();
        moneyBookMapByDate = new HashMap<>();
    }

    //초기 사용자 체크
    public boolean getUserInfo() {
        String[] userInfo = prompt.zeroUserInfo();
        if (this.userName.equals(userInfo[0]) && this.password.equals(userInfo[1])) {
            prompt.hMenu(this.userName);
            return true;
        }
        System.out.println("잘못된 유저이기 때문에 종료합니다.");
        return false;
    }

    //줄번호로 id값 셋팅하기
    public void setIdByReadingExistingFile() {
        int lineCnt = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/mission3_mission4/SaveData.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                lineCnt++;
                String[] parsedItem = line.split(",");
                MoneyDataSet moneyDataSet = new MoneyDataSet(parsedItem[1], parsedItem[2], Integer.parseInt(parsedItem[3]), Integer.parseInt(parsedItem[4]), parsedItem[5]);
                setHashMapByExistingFile(Integer.parseInt(parsedItem[0]), moneyDataSet);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            this.id = lineCnt + 1;
        }
    }

    private void setHashMapByExistingFile(int id, MoneyDataSet line) {
        moneyBookMapById.put(id, line);
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(id);
        if (moneyBookMapByDate.containsKey(line.getYearAndMonth())) {
            idList.addAll(moneyBookMapByDate.get(line.getYearAndMonth()));
        }
        moneyBookMapByDate.put(line.getYearAndMonth(), idList);
    }


    // 1. 자료 추가하기 - 파일로 저장하기
    public void addMoneyBookData() {
        MoneyDataSet moneyDataSet = prompt.oneAddData();
        moneyBookMapById.put(this.id, moneyDataSet);
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(id);
        if (moneyBookMapByDate.containsKey(moneyDataSet.getYearAndMonth())) {
            idList.addAll(moneyBookMapByDate.get(moneyDataSet.getYearAndMonth()));
        }
        moneyBookMapByDate.put(moneyDataSet.getYearAndMonth(), idList);
        this.id++;
        prompt.selectWhatToDo();
    }

    //2. 데이터 삭제
    public void removeMoneyBookData() {
        int id = Integer.parseInt(prompt.twoDeleteData());
        moneyBookMapById.remove(id);
        prompt.selectWhatToDo();
    }

    // 3. 데이터 업데이트
    public void updateMoneyBookData() {
        int id = Integer.parseInt(prompt.threeUpdateData());
        MoneyDataSet newContents = prompt.printUpdateMessage(moneyBookMapById.get(id));
        moneyBookMapById.put(id, newContents);
        prompt.selectWhatToDo();
    }
    // 4. 데이터 보기 - 검색, 정렬 옵션 추가하기

    private void calculateThisMonthMoney(int key, MoneyDataSet value) {
        System.out.println(key + ", " + value);
        calculateMoneyData.addIncome(value.getIncome());
        calculateMoneyData.addSpending(value.getSpending());
    }

    private void readDataByMonth(int yearAndMonth) {
        calculateMoneyData.setIncome(0);
        calculateMoneyData.setSpending(0);

        System.out.println("id, 날짜, 내용, 수입, 지출, 지출방식");
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);

            calculateThisMonthMoney(key, value);
        }
        prompt.printThisMonthMoney(calculateMoneyData.getIncome(), calculateMoneyData.getSpending(), calculateMoneyData.getTotal());

    }

    private void sortBySearching(int yearAndMonth) {
        String key = prompt.selectSearchType();
        switch (key){
            case "a":
                sortByDate(yearAndMonth);
                break;
            case "b":
                sortByContents(yearAndMonth);
                break;
            case "c":
                sortByMoney(yearAndMonth);
                break;
            case "d":
                sortByIncome(yearAndMonth);
                break;
            case "e":
                sortBySpending(yearAndMonth);
                break;
            case "f":
                sortBySpendingMethod(yearAndMonth);
                break;
            case "z":
                readDataByMonth(yearAndMonth);
                break;
        }
    }

    private void sortByContents(int yearAndMonth) {
        String keyword = prompt.selectKeyword();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getContents().contains(keyword)){
                System.out.println(key + ", " + value);
            }
        }
    }

    private void sortByDate(int yearAndMonth) {
        int day = prompt.selectDay();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getDay() == day){
                System.out.println(key + ", " + value);
            }
        }
    }

    private void sortBySpendingMethod(int yearAndMonth) {
        String method = prompt.selectSpendingMethod();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getSpendingMethod().equals(method)){
                System.out.println(key + ", " + value);
            }
        }
    }

    private void sortByMoney(int yearAndMonth) {
        int money = prompt.selectMoney();
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getIncome() == money || value.getSpending() == money){
                System.out.println(key + ", " + value);
            }
        }
    }

    private void sortByIncome(int yearAndMonth){
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getIncome() != 0){
                System.out.println(key + ", " + value);
            }
        }
    }
    private void sortBySpending(int yearAndMonth){
        for (int key : moneyBookMapByDate.get(yearAndMonth)) {
            if( !moneyBookMapById.containsKey(key)){
                continue;
            }
            MoneyDataSet value = moneyBookMapById.get(key);
            if(value.getSpending() != 0){
                System.out.println(key + ", " + value);
            }
        }
    }


    public void readMoneyBookData() {
        int yearAndMonth = prompt.fourReadData();
        sortBySearching(yearAndMonth);
        prompt.selectWhatToDo();
    }

    // h. 메뉴 보여주기
    public void printMenu() {
        prompt.hMenu(this.userName);
    }

    // 종료하기전 저장
    public void beforeClose() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("src/mission3_mission4/SaveData.txt"));
            for (int key : moneyBookMapById.keySet()) {
                MoneyDataSet value = moneyBookMapById.get(key);
                String data = "" + key + "," + value;
                writer.println(data);
            }
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
