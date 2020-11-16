package mission5;

import java.util.Scanner;

public class ShellCommander {
    public void run()  {
        Scanner sc = new Scanner(System.in);
        CreateProcess process = new CreateProcess();
        while(true){
            System.out.print("Java Shell>");
            String command = sc.nextLine().trim();
            if(command.equals("q")){
                System.out.println("종료합니다.");
                return;
            }
            process.shell(command);

        }
    }
}
