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
    public JToggleButton btn2 = new JToggleButton("sg ");
    public JToggleButton btn4 = new JToggleButton("ufgt");
    public JToggleButton btn5 = new JToggleButton("sho");
    public JToggleButton btn6 = new JToggleButton("add");
    public JToggleButton btn7 = new JToggleButton("deldiary");
    public JToggleButton btn8 = new JToggleButton("laod");

    public static void main(String[] args) {
//        new untoggle();
    }

    public untoggle(JFrame frame, JPanel panel) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }


                // My code
                frame.pack ();
                frame.setLocationRelativeTo ( null );
                frame.setVisible ( true );

                bg.add(btn1);
                bg.add(btn3);
                bg.add(btn2);
                bg.add(btn4);
                bg.add(btn5);
                bg.add(btn6);
                bg.add(btn7);
                bg.add(btn8);

                panel.add(btn1);
                panel.add(btn3);
                panel.add(btn2);
                panel.add(btn4);
                panel.add(btn5);
                panel.add(btn6);
                panel.add(btn7);
                panel.add(btn8);



                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        });
    }

}

