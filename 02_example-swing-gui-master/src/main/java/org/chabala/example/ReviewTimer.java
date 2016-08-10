package org.chabala.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Example Swing GUI.
 * <p>
 * Inspired by <a href="http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm">
 *                      http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm</a>
 *
 * @author Greg Chabala
 * @since Sep 29, 2010
 */
public class ReviewTimer {

    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea;
    private static JFrame frame;
    public static void main(String[] args) {
        new ReviewTimer();
    }

    public ReviewTimer() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {
        frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Teel me Real, what did you just learn?"));
        frame.add(new BeepingButton("Save"));
        frame.pack();

        JFrame temp = new JFrame();
        temp.pack();
        Insets insets = temp.getInsets();
        temp = null;
        frame.setSize(new Dimension(insets.left + insets.right + 500,
                insets.top + insets.bottom + 500));
        frame.setResizable(false);


        if (lastFrame == null) {
            frame.setLocationByPlatform(true);
        } else {
            Point p = lastFrame.getLocation();
            p.translate(50, 50);
            frame.setLocation(p);
        }
        lastFrame = frame;

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        frame.add(controlPanel);

        textArea =
                new JTextArea(10,40);

        JScrollPane scrollPane = new JScrollPane(textArea);

        controlPanel.add(scrollPane);
        frame.setVisible(true);
    }

    private static class BeepingButton extends JButton {
        BeepingButton(final String text) {
            super(text);
            setPreferredSize(new Dimension(140, 60));
            addActionListener((e) -> {
                try {
                    insert();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }

        public static void insert() throws IOException {
            RandomAccessFile r = new RandomAccessFile(new File("./files/filename.txt"), "rw");
            RandomAccessFile rtemp = new RandomAccessFile(new File("./files/filename.txt" + "~"), "rw");
            long fileSize = r.length();
            FileChannel sourceChannel = r.getChannel();
            FileChannel targetChannel = rtemp.getChannel();
            sourceChannel.transferTo(0, (fileSize - 0), targetChannel);
            sourceChannel.truncate(0);
            r.seek(0);
            r.writeBytes(System.getProperty("line.separator"));
            r.writeBytes(new Date().toString());
            r.writeBytes(System.getProperty("line.separator"));
            r.writeBytes(textArea.getText());
            r.writeBytes(System.getProperty("line.separator"));
            long newOffset = r.getFilePointer();
            targetChannel.position(0L);
            sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - 0));
            sourceChannel.close();
            targetChannel.close();
            System.out.println("Done");
            textArea.setText("");
            // Your code goes here.

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {

                               @Override
                               public void run() {
                                   frame.repaint();
                                   frame.toFront();
                               }
                           },
                    // starting now
                    new Date(),
                    // 15 minutes
                    900000
            );



        }


    }


}
