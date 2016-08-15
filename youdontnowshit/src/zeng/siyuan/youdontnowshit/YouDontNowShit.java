package zeng.siyuan.youdontnowshit;

import javax.swing.*;
import java.io.Serializable;

//Created by Real
public class YouDontNowShit implements Serializable{
    private static final long serialVersionUID = 1L;

    private static Frame e;
    private static String subject;

    public static void main(String[] args) {

        configureLookAndFeel();
        e = new Frame();

        e.showFrame();
    }


    private static void configureLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break; //preferred!
                }
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {}
    }
}
