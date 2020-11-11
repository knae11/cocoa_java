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

    //각종 저장될 자료구조
    private HashMap<Integer, MoneyDataSet> moneyBookMapById;
    private HashMap<Integer, ArrayList<Integer>> moneyBookMapByDate;

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
                setHashMapByExistingFile(lineCnt, moneyDataSet);
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

    public void readMoneyBookData() {
        int yearAndMonth = prompt.fourReadData();
        sortBySearching(yearAndMonth);
        prompt.selectWhatToDo();
    }

    private void sortBySearching(int yearAndMonth) {
        String key = prompt.selectSearchType();
        SortingSystem sorting = new SortingSystem(this.moneyBookMapById, this.moneyBookMapByDate);
        switch (key){
            case "a":
                sorting.sortByDate(yearAndMonth);
                break;
            case "b":
                sorting.sortByContents(yearAndMonth);
                break;
            case "c":
                sorting.sortByMoney(yearAndMonth);
                break;
            case "d":
                sorting.sortByIncome(yearAndMonth);
                break;
            case "e":
                sorting.sortBySpending(yearAndMonth);
                break;
            case "f":
                sorting.sortBySpendingMethod(yearAndMonth);
                break;
            case "z":
                sorting.readWholeDataByMonth(yearAndMonth);
                break;
        }
    }

    // h. 메뉴 보여주기
    public void printMenu() {
        prompt.hMenu(this.userName);
    }

    // 종료하기전 저장
    public void saveBeforeClose() {
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
