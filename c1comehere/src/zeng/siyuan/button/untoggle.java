package zeng.siyuan.button;

/**
 * Created by SiyuanZeng's on 9/5/2016.
 */

import javax.swing.*;
import java.awt.*;

public class untoggle {
    public ButtonGroup bg = new ButtonGroup();

    public JToggleButton btn1 = new JToggleButton("delete");
    public JToggleButton btn3 = new JToggleButton("fgt");
    public JToggleButton btn4 = new JToggleButton("ufgt");
    public JToggleButton btn5 = new JToggleButton("sho");
    public JToggleButton btn6 = new JToggleButton("add");

    public static void main(String[] args) {
//        new untoggle();
    }

    public untoggle(JFrame frame) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {


/*
                boolean deleteCommand = text.contains("delete") && text.contains("=");
                String key = text.substring(0, 3);
                boolean isThoughtRecorderCommand = key.equalsIgnoreCase("rec");
                boolean isHow2ForegertCommand = key.equalsIgnoreCase("fgt");
                boolean isHow2ForegertCommand_u = textArea.getText().contains(" ufgt ");
                boolean isShowCommand = key.equalsIgnoreCase("sho");// shw
*/
            bg.add(btn1);
            bg.add(btn3);
            bg.add(btn4);
            bg.add(btn5);
            bg.add(btn6);

            add(btn1);
            add(btn3);
            add(btn4);
            add(btn5);
            add(btn6);
        }

    }

}

