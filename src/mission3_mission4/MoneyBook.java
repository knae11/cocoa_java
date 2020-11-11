package mission3_mission4;

import java.util.Scanner;

public class MoneyBook {

    MoneyBookSystem system = new MoneyBookSystem();

    public void init() {
        Scanner sc = new Scanner(System.in);
        boolean userCheck= system.getUserInfo();
        system.setIdByReadingExistingFile();
        while (userCheck) {
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
                    system.printMenu();
                    break;
                case "q":
                    system.beforeClose();
                    sc.close();
                    return;
            }
        }
    }
}
