package zeng.siyuan.button;

/**
 * Created by SiyuanZeng's on 9/5/2016.
 */

import zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal.findthebestexample;

import javax.swing.*;
import java.awt.*;

public class untoggle {
    public static ButtonGroup bg = new ButtonGroup();

    public static JToggleButton btn1 = new JToggleButton("delete");
    public static JToggleButton btn3 = new JToggleButton("fgt");
    public static JToggleButton btn2 = new JToggleButton("sg ");
    public static JToggleButton btn4 = new JToggleButton("ufgt");
    public static JToggleButton btn5 = new JToggleButton("sho");
    public static JToggleButton btn6 = new JToggleButton("add");
    public static JToggleButton btn7 = new JToggleButton("deldiary");
    public static JToggleButton btn8 = new JToggleButton("laod");
    public static JToggleButton btn9 = new JToggleButton("codeja");
    public static JToggleButton btn10 = new JToggleButton("saerchdiary");

    public static void main(String[] args) {
//        new untoggle();
    }

    public untoggle(JFrame frame, JPanel panel, JTextArea jTextArea) {
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

                btn2.addActionListener(e -> {
                    String inntuitive = "";
                    inntuitive += "sg :";
                    inntuitive += "\n";
                    inntuitive += "sd :";
                    inntuitive += "\n";
                    inntuitive += "su :";
                    inntuitive += "\n";
                    inntuitive += "st :";
                    inntuitive += "\n";
                    inntuitive += "sy :";
                    inntuitive += "\n";
                    inntuitive += "sm :";
                    inntuitive += "\n";
                    inntuitive += "si :";
                    inntuitive += "\n";
                    inntuitive += "sl :";
                    inntuitive += "\n";
                    inntuitive += "sb :";
                    inntuitive += "\n";

                    jTextArea.setText(inntuitive);


                });

                bg.add(btn2);
                bg.add(btn4);
                bg.add(btn5);
                bg.add(btn6);
                bg.add(btn7);
                bg.add(btn8);

// i need to textarea but i odn't have so i have to pass the parameter helel ot here
                btn9.addActionListener(e -> {
                    findthebestexample f = new findthebestexample(jTextArea);
                    f.returnshowsearchquetsry();
                });
                bg.add(btn9);
                bg.add(btn10);

                panel.add(btn1);
                panel.add(btn3);
                panel.add(btn2);
                panel.add(btn4);
                panel.add(btn5);
                panel.add(btn6);
                panel.add(btn7);
                panel.add(btn8);
                panel.add(btn9);
                panel.add(btn10);



                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        });
    }

}

