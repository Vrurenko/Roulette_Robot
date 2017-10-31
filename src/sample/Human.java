package sample;

import java.awt.*;
import java.io.*;

class Human {
    private static final String file = "C:\\Users\\Comandante\\Desktop\\Roulette Robot\\resources\\history.txt";

    static void wait(int time){
        try {
            Robot robot = new Robot();
            robot.delay(time*1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static void write(String text) {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true), true)) {
            printStream.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
