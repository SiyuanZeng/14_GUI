package zeng.siyuan.button;

/**
 * Created by SiyuanZeng's on 9/5/2016.
 */

import zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal.findthebestexample;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;

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
    public static JToggleButton btnD1 = new JToggleButton("Ddelete");
    public static JToggleButton btnD3 = new JToggleButton("Dfgt");
    public static JToggleButton btnD2 = new JToggleButton("Dsg ");
    public static JToggleButton btnD4 = new JToggleButton("Dufgt");
    public static JToggleButton btnD5 = new JToggleButton("Dsho");
    public static JToggleButton btnD6 = new JToggleButton("Dadd");
    public static JToggleButton btnD7 = new JToggleButton("Ddeldiary");
    public static JToggleButton btnD8 = new JToggleButton("Dlaod");
    public static JToggleButton btnD9 = new JToggleButton("Dcodeja");
    public static JToggleButton btnD10 = new JToggleButton("Dsaerchdiary");

    public static void main(String[] args) {
//        new untoggle();
    }

    public untoggle(JFrame frame, JPanel panel, JTextArea jTextArea, JLabel label, Component scroll) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
// MEESSY VS ORganized there are the good thing and bad things organized and disorganized there are different ways of thinking one is logincal thetohter i s visual
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

                bg.add(btn1);
                bg.add(btn3);
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

// i need to textarea but i odn't have so i have to pass the parameter helel ot here
                btnD9.addActionListener(e -> {
                    findthebestexample f = new findthebestexample(jTextArea);
                    f.returnshowsearchquetsry();
                });


                bg.add(btnD1);
                bg.add(btnD3);
                bg.add(btnD2);
                bg.add(btnD4);
                bg.add(btnD5);
                bg.add(btnD6);
                bg.add(btnD7);
                bg.add(btnD8);
                bg.add(btnD9);
                bg.add(btnD10);


                Container contentPane = frame.getContentPane();


                GroupLayout groupLayout = new GroupLayout(contentPane);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);
                contentPane.setLayout(groupLayout);

                panel.add(scroll);
                groupLayout.setHorizontalGroup(groupLayout
                        .createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(label))
                        .addGroup(groupLayout.createParallelGroup(TRAILING)
                                        .addComponent(btn1)
                                        .addComponent(btn2)
                                        .addComponent(btn3)
                                        .addComponent(btn4)
                                        .addComponent(btn5)
                                        .addComponent(btn6)
                                        .addComponent(btn7)
                                        .addComponent(btn8)
                                        .addComponent(btn9)
                                        .addComponent(btn10)
                        )
                        .addGroup(groupLayout.createParallelGroup(TRAILING)
                                        .addComponent(btnD1)
                                        .addComponent(btnD2)
                                        .addComponent(btnD3)
                                        .addComponent(btnD4)
                                        .addComponent(btnD5)
                                        .addComponent(btnD6)
                                        .addComponent(btnD7)
                                        .addComponent(btnD8)
                                        .addComponent(btnD9)
                                        .addComponent(btnD10)
                        )
                        .addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(panel)));

                groupLayout.setVerticalGroup(groupLayout
                        .createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(label))
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                addComponent(btn1).
                                addComponent(btnD1))
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn2).
                                        addComponent(btnD2)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn3).
                                        addComponent(btnD3)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn4).
                                        addComponent(btnD4)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn5).
                                        addComponent(btnD5)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn6).
                                        addComponent(btnD6)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn7).
                                        addComponent(btnD7)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn8).
                                        addComponent(btnD8)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn9).
                                        addComponent(btnD9)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).
                                        addComponent(btn10).
                                        addComponent(btnD10)
                        )
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(panel)));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}