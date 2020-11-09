package mission3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MoneyBook {
    private int increasingId = 1;
    private HashMap<Integer, String> moneyBookMap;

    Scanner scanner = new Scanner(System.in);

    public MoneyBook() {
        moneyBookMap = new HashMap<>();
    }

    Prompt prompt = new Prompt();
    MoneyData moneyData = new MoneyData();

    public void parsingStringData(int key, String contents, int[] inputDate) {
        String[] parsedString = contents.split(",");
        int[] parsedDate = Arrays.stream(parsedString[0].split("-")).mapToInt(Integer::parseInt).toArray();
        if (inputDate[0] == parsedDate[0] && inputDate[1] == parsedDate[1]) {
            moneyData.addIncome(Integer.parseInt(parsedString[2].trim()));
            moneyData.addSpending(Integer.parseInt(parsedString[3].trim()));
            System.out.println(key + " : " + contents + ", " + moneyData.getTotal());
        }
        return;
    }

    public void addMoneyBookData(int id) {
        String contents = scanner.nextLine();
        moneyBookMap.put(id, contents);
    }

    public void removeMoneyBookData() {
        int id =Integer.parseInt(scanner.nextLine());
        moneyBookMap.remove(id);
    }

    public void updateMoneyBookData() {
        int id =Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        System.out.println("기존내용 : " + moneyBookMap.get(id));
        System.out.println("기존내용을 참고하여 업데이트 할 내용을 새롭게 입력해 주세요 :)");
        String newContents = scanner.nextLine();
        moneyBookMap.put(id, newContents);
    }

    public void readMoneyBookData() {
        String yearAndMonth = scanner.nextLine().trim();
        int[] dateArr = Arrays.stream(yearAndMonth.split("-")).mapToInt(Integer::parseInt).toArray();
        System.out.println(dateArr[0] + "년  "+dateArr[1] +"월의 가계부");
        moneyData.setIncome(0);
        moneyData.setSpending(0);
        System.out.println("순번, 날짜, 내용, 하루수입, 하루지출, 총잔액");
        for (int key : moneyBookMap.keySet()) {
            String value = moneyBookMap.get(key);
            parsingStringData(key, value, dateArr);
        }
        System.out.println("이번달 총 수입 : " + moneyData.getIncome());
        System.out.println("이번달 총 지출 : " + moneyData.getSpending());
        System.out.println("이번달 총액 합계 : " + moneyData.getTotal());
    }


    public void runPrompt() {

        Scanner sc = new Scanner(System.in);
        prompt.hMenu();
        while (true) {
            String key = sc.nextLine().trim();
            switch (key) {
                case "0":
                    prompt.zeroUserInfo();
                    prompt.selectWhatToDo();
                    break;
                case "1":
                    prompt.oneAddData();
                    addMoneyBookData(increasingId);
                    increasingId++;
                    prompt.selectWhatToDo();
                    break;
                case "2":
                    prompt.twoDeleteData();
                    removeMoneyBookData();
                    prompt.selectWhatToDo();
                    break;
                case "3":
                    prompt.threeUpdateData();
                    updateMoneyBookData();
                    prompt.selectWhatToDo();
                    break;
                case "4":
                    prompt.fourReadData();
                    readMoneyBookData();
                    prompt.selectWhatToDo();
                    break;
                case "h":
                    prompt.hMenu();
                    prompt.selectWhatToDo();
                    break;
                case "q":
                    return;
            }
        }
    }

    public void init() {
        runPrompt();
    }

}
