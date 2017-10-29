package sample;

import java.awt.*;

public class Human {

    public static void wait(int time){
        try {
            Robot robot = new Robot();
            robot.delay(time*1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
