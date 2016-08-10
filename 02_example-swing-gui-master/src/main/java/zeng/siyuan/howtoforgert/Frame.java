package zeng.siyuan.howtoforgert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Frame implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ArrayList<Ebbinghaus> ebbinghauses = new ArrayList<Ebbinghaus>();

    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea;
    private static JFrame frame;
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    private static Display d;
    private static Add add;

    private static Thread threadD;
    private static Thread threadadd;

    public static Thread getThreadD() {
        return threadD;
    }

    public static void setThreadD(Thread threadD) {
        Frame.threadD = threadD;
    }

    public static Thread getThreadadd() {
        return threadadd;
    }

    public static void setThreadadd(Thread threadadd) {
        Frame.threadadd = threadadd;
    }

    public static ArrayList<Ebbinghaus> getEbbinghauses() {
        return ebbinghauses;
    }

    public static void setEbbinghauses(ArrayList<Ebbinghaus> ebbinghauses) {
        Frame.ebbinghauses = ebbinghauses;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Frame.count = count;
    }

    public static JFrame getLastFrame() {
        return lastFrame;
    }

    public static void setLastFrame(JFrame lastFrame) {
        Frame.lastFrame = lastFrame;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(JPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    public static void setTextArea(JTextArea textArea) {
        Frame.textArea = textArea;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        Frame.frame = frame;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ArrayList<Task> tasks) {
        Frame.tasks = tasks;
    }

    public static Display getD() {
        return d;
    }

    public static void setD(Display d) {
        Frame.d = d;
    }

    public static Add getAdd() {
        return add;
    }

    public static void setAdd(Add add) {
        Frame.add = add;
    }

    public Frame() {
    }

    public ArrayList<Ebbinghaus> getWordList() {
        return ebbinghauses;
    }

    public void setWordList(ArrayList<Ebbinghaus> wordList) {
        this.ebbinghauses = wordList;
    }

    public void showFrame() {
        frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Real, how to gofort?"));
        frame.add(new BeepingButton("Save"));
        frame.pack();
        frame.setTitle("HowToForgert");

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

        setTextArea();


        serializeBeforeCloseWindow();

        frame.setVisible(true);
    }

    private void serializeBeforeCloseWindow() {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    serialize();
                    System.exit(0);

                }
            }
        });
    }

    private void setTextArea() {
        textArea =
                new JTextArea(10,40);

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);

        controlPanel.add(scrollPane);
    }

    public void serialize(){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("c:/HowToForgert/howtoforgert.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in c:/HowToForgert/howtoforgert.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public static void addWord(){
        Ebbinghaus ebbinghaus = new Ebbinghaus(textArea.getText());
        ebbinghauses.add(ebbinghaus);
        textArea.setText("");
    }

    public static void loadTask(){
        for (Ebbinghaus e : ebbinghauses){
            ArrayList<Task> t = e.getTasks();
            for (Task task: t){
                tasks.add(task);
            }
        }
        Collections.sort(tasks, new Task());
    }

    public static void popup(){
        loadTask();
        displayTask();
    }

    private static void displayTask() {
        for(Task t : tasks){
            if (!t.isDone() && t.getDate().after(new Date())){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(t.getDate());
                long diff = calendar.getTimeInMillis()- Calendar.getInstance().getTimeInMillis();
                if(diff>0)
                    try {
                        System.out.println("Before sleep");
                        Thread.sleep(diff);
                        System.out.println("After sleep");
                        frame.repaint();
                        frame.toFront();
                        textArea.setText(t.getWord());
                        t.setIsDone(true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            } else if (!t.isDone() && t.getDate().before(new Date())){
                t.setIsDone(true);
            }
        }
    }

    private class BeepingButton extends JButton {
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

        public void insert() throws IOException {
            addWord();
            restartPopThread();
        }

        private void restartPopThread() {
            threadD.interrupt();
            d = new Display(Frame.this);
            threadD = new Thread(d);
            Frame.this.setD(d);
            Frame.this.setThreadD(threadD);
            threadD.start();
        }
    }
}
