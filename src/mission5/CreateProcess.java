package mission5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateProcess {

    public void shell(String cmd) {
        System.out.println("shell을 실행한다");
        System.out.println();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", cmd);
        processBuilder.directory(new File("src/mission5"));
        //    if(cmd.contains("cd")){
//           // System.out.println(cmd.split(" ")[1]);
        //      processBuilder.directory(new File("src/mission5/"+cmd.split(" ")[1]));
        //  }
        try {
            Process process = processBuilder.start();
            //"MS949"로 해도 한글은 변환됨.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
