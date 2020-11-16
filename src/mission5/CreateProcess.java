package mission5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateProcess {
    public void shell(String cmd){
        System.out.println("shell을 실행한다");
        System.out.println();
        ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd.exe", "/c", cmd);
            try {
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                int exitCode = process.waitFor();
                System.out.println("\nExisted with error code: " + exitCode);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
    }



}
