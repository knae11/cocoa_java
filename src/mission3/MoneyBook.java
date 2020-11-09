package mission3;

import java.util.Scanner;

public class MoneyBook {

    MoneyBookSystem system = new MoneyBookSystem();
    Prompt prompt = new Prompt();

    public void init() {
        Scanner sc = new Scanner(System.in);
        String name = prompt.zeroUserInfo();
        prompt.hMenu(name);
        while (true) {
            String key = sc.nextLine().trim();
            switch (key) {
                case "1":
                    system.addMoneyBookData();
                    break;
                case "2":
                    system.removeMoneyBookData();
                    break;
                case "3":
                    system.updateMoneyBookData();
                    break;
                case "4":
                    system.readMoneyBookData();
                    break;
                case "h":
                    prompt.hMenu(name);
                    break;
                case "q":
                    return;
            }
        }
    }


}
