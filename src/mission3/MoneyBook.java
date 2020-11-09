package mission3;

import java.util.HashMap;
import java.util.Scanner;

public class MoneyBook {
    private int increasingId = 1;
    private HashMap<Integer, String> moneyBookMap;

    public MoneyBook() {
        moneyBookMap = new HashMap<>();
    }

    Prompt prompt = new Prompt();

    public void addMoneyBookData(int id) {
        Scanner sc = new Scanner(System.in);
        String contents = sc.nextLine();
        moneyBookMap.put(id, contents);
    }

    public void readMoneyBookData(){
        for (int key : moneyBookMap.keySet()) {
            String value = moneyBookMap.get(key);
            System.out.println(key + " : " + value);
        }
    }


    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        prompt.hMenu();
        while (true) {
            String key = sc.next();
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
                    prompt.selectWhatToDo();
                    break;
                case "3":
                    prompt.threeUpdateData();
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
