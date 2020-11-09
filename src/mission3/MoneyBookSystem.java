package mission3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MoneyBookSystem {
    private HashMap<Integer, String> moneyBookMap;

    Scanner scanner = new Scanner(System.in);
    Prompt prompt = new Prompt();
    MoneyData moneyData = new MoneyData();

    public MoneyBookSystem() {
        moneyBookMap = new HashMap<>();
    }

    public void parsingStringData(int key, String contents, int[] inputDate) {
        String[] parsedString = contents.split(",");
        int[] parsedDate = Arrays.stream(parsedString[0].split("-")).mapToInt(Integer::parseInt).toArray();
        if (inputDate[0] == parsedDate[0] && inputDate[1] == parsedDate[1]) {
            moneyData.addIncome(Integer.parseInt(parsedString[2].trim()));
            moneyData.addSpending(Integer.parseInt(parsedString[3].trim()));
            System.out.println(key + " : " + contents + " => " + moneyData.getTotal());
        }
    }

    public void addMoneyBookData() {
        int id =moneyData.getId();
        String contents = prompt.oneAddData();
        moneyBookMap.put(id, contents);
        moneyData.addId();
        prompt.selectWhatToDo();
    }

    public void removeMoneyBookData() {
        prompt.twoDeleteData();
        int id = Integer.parseInt(scanner.nextLine());
        moneyBookMap.remove(id);
        prompt.selectWhatToDo();
    }

    public void updateMoneyBookData() {
        prompt.threeUpdateData();
        int id = Integer.parseInt(scanner.nextLine().trim());
        String newContents =prompt.printUpdateMessage(moneyBookMap.get(id));
        moneyBookMap.put(id, newContents);
        prompt.selectWhatToDo();
    }

    public void readMoneyBookData() {
        prompt.fourReadData();
        String yearAndMonth = scanner.nextLine().trim();
        int[] dateArr = Arrays.stream(yearAndMonth.split("-")).mapToInt(Integer::parseInt).toArray();
        prompt.printWhichMonth(dateArr[0], dateArr[1]);
        moneyData.setIncome(0);
        moneyData.setSpending(0);
        for (int key : moneyBookMap.keySet()) {
            String value = moneyBookMap.get(key);
            parsingStringData(key, value, dateArr);
        }
        prompt.printThisMonthMoney(moneyData.getIncome(),moneyData.getSpending(),moneyData.getTotal());
        prompt.selectWhatToDo();
    }
}
