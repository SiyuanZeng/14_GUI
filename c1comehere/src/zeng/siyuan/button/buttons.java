package zeng.siyuan.button;

import javax.swing.*;

public class buttons extends JFrame {

    JButton button = new JButton("Press");
    Timer timer = new Timer(5000, e -> button.setEnabled(true));

    public buttons() {

        add(button);
        button.addActionListener(e -> {
            button.setEnabled(false);
            timer.start();
        });

        timer.setRepeats(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {


    }
}