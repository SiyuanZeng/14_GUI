package zeng.siyuan.button;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.*;

// ww  w .  j av a  2 s . c  o m

/**
 * Created by SiyuanZeng's on 9/11/2016.
 */
public class grouplayout {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GroupLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        GroupLayout groupLayout =
                new GroupLayout(contentPane);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        contentPane.setLayout(groupLayout);

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button Second");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");

        groupLayout.setHorizontalGroup(groupLayout
                .createSequentialGroup()
                .addGroup(
                        groupLayout.createParallelGroup(LEADING).addComponent(b1)
                                .addComponent(b3))
                .addGroup(
                        groupLayout.createParallelGroup(TRAILING).addComponent(b2)
                                .addComponent(b4)));

        groupLayout.setVerticalGroup(groupLayout
                .createSequentialGroup()
                .addGroup(
                        groupLayout.createParallelGroup(BASELINE).addComponent(b1)
                                .addComponent(b2))
                .addGroup(
                        groupLayout.createParallelGroup(BASELINE).addComponent(b3)
                                .addComponent(b4)));

        frame.pack();
        frame.setVisible(true);
    }
}
