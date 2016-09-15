package zeng.siyuan.routine;

import javax.swing.*;

/**
 * Created by SiyuanZeng's on 9/14/2016.
 */
public class a {
    public static JTextArea textArea;

    public a(JTextArea textArea) {
        this.textArea = textArea;
    }



    public void returnshowsearchquetsry() {
        resetfiles();
    }


    public static void resetfiles() {
        String  inntuitive = "";
        inntuitive += "0.Daily standup";
        inntuitive += "\n";
        inntuitive += "0.Email";
        inntuitive += "\n";
        inntuitive += "1.Task";
        inntuitive += "\n";
        inntuitive += "2.Image";
        inntuitive += "\n";
        inntuitive += "3.Link";
        inntuitive += "\n";
        inntuitive += "4.Review document";
        inntuitive += "\n";
        inntuitive += "5.Review Yesterday";
        inntuitive += "\n";
        inntuitive += "6.Shower";
        inntuitive += "\n";
        inntuitive += "7. Call my mom";
        inntuitive += "\n";
        inntuitive += "8. Blog";
        inntuitive += "\n";
        inntuitive += "9. Survive";
        inntuitive += "\n";
        inntuitive += "10. Don't talk!";
        textArea.setText(inntuitive);
    }
}
