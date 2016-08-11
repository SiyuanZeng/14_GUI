package zeng.siyuan.forgert;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
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
    private ArrayList<Ebbinghaus> ebbinghauses = new ArrayList<Ebbinghaus>();
    private  transient TrayIcon trayIcon;
    private  transient SystemTray tray;
    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea1;
    private static JTextArea textArea2;
    private static JFrame frame;
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static Task currentTask = new Task();

    private static Display d;
    private static Add add;

    private static Thread threadD;
    private static Thread threadadd;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public void setTrayIcon(TrayIcon trayIcon) {
        this.trayIcon = trayIcon;
    }

    public SystemTray getTray() {
        return tray;
    }

    public void setTray(SystemTray tray) {
        this.tray = tray;
    }

    public static JTextArea getTextArea2() {
        return textArea2;
    }

    public static void setTextArea2(JTextArea textArea2) {
        Frame.textArea2 = textArea2;
    }

    public static Task getCurrentTask() {
        return currentTask;
    }

    public static void setCurrentTask(Task currentTask) {
        Frame.currentTask = currentTask;
    }

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

    public  ArrayList<Ebbinghaus> getEbbinghauses() {
        return ebbinghauses;
    }

    public void setEbbinghauses(ArrayList<Ebbinghaus> ebbinghauses) {
        this.ebbinghauses = ebbinghauses;
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

    public static JTextArea getTextArea1() {
        return textArea1;
    }

    public static void setTextArea1(JTextArea textArea1) {
        Frame.textArea1 = textArea1;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        Frame.frame = frame;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
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

        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(6, 1));
        Border border = LineBorder.createGrayLineBorder();


        setSaveButton(content, border);


        JLabel label0 = new JLabel("Real, how to gofort?");
        label0 .setBorder(border);
        content.add(label0);

        frame.pack();
        frame.setTitle("HowToForgert");

        setDimension();


        if (lastFrame == null) {
            frame.setLocationByPlatform(true);
        } else {
            Point p = lastFrame.getLocation();
            p.translate(50, 50);
            frame.setLocation(p);
        }
        lastFrame = frame;

        setTextArea1(border, content);
        setTextArea2(border, content);


        BeepingButton gotIt = setGotItButton(content, border);


        setIforgertButton(content, border);


        setSerializeBeforeCloseWindow();


        initSystemTray();

        frame.setVisible(true);
    }

    private void setSaveButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Save");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {
                insert();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    private void setDimension() {
        JFrame temp = new JFrame();
        temp.pack();
        Insets insets = temp.getInsets();
        temp = null;
        frame.setSize(new Dimension(insets.left + insets.right + 500,
                insets.top + insets.bottom + 500));
        frame.setResizable(false);
    }

    private void setIforgertButton(Container content, Border border) {
        BeepingButton iforgert= new BeepingButton("OMG!!!  I forgert!");
        iforgert.setSize(new Dimension(100, 100));
        iforgert.setBorder(border);
        iforgert.addActionListener((e) -> {
            try {
                if (null != getCurrentTask()) {
                    iForgert();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        content.add(iforgert);
    }

    private BeepingButton setGotItButton(Container content, Border border) {
        BeepingButton gotIt= new BeepingButton("Got it");
        gotIt.setSize(new Dimension(100, 100));
        gotIt.setBorder(border);
        gotIt.addActionListener((e) -> {
            try {
                if (null != getCurrentTask()) {
                    markGotIt(currentTask);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        content.add(gotIt);
        return gotIt;
    }

    private void iForgert() {
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTask.getDate());
        long diff = calendar.getTimeInMillis();
        currentTask.setDate(new Date(diff + (20 * ONE_MINUTE_IN_MILLIS)));
        restartPopThread();
    }

    private void markGotIt(Task currentTask) {
        currentTask.setIsDone(true);
    }

    private void initSystemTray() {
        try{
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            System.out.println("Unable to set LookAndFeel");
        }
        if(SystemTray.isSupported()){
            System.out.println("system tray supported");
            tray=SystemTray.getSystemTray();

            Image image=Toolkit.getDefaultToolkit().getImage("/img/bulb16x16.gif");
            ActionListener exitListener=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting....");
                    System.exit(0);
                }
            };
            PopupMenu popup=new PopupMenu();
            MenuItem defaultItem=new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem=new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);
                    frame.setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon=new TrayIcon(image, "SystemTray Demo", popup);
            trayIcon.setImageAutoSize(true);
        }else{
            System.out.println("system tray not supported");
        }

        trayIcon.setImageAutoSize(true);// Autosize icon base on space
        // available on
        // tray

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("omt click");
                // This will display small popup message from System Tray
                trayIcon.displayMessage("Real,",
                        "how to gofort?",
                        TrayIcon.MessageType.INFO);
                frame.setVisible(true);
                frame.setExtendedState(JFrame.NORMAL);
            }
        };

        trayIcon.addMouseListener(mouseAdapter);


        frame.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == frame.ICONIFIED) {
                    try {
                        tray.add(trayIcon);
                        frame.setVisible(false);
                        System.out.println("added to SystemTray");
                    } catch (AWTException ex) {
                        System.out.println("unable to add to tray");
                    }
                }
                if (e.getNewState() == 7) {
                    try {
                        tray.add(trayIcon);
                        frame.setVisible(false);
                        System.out.println("added to SystemTray");
                    } catch (AWTException ex) {
                        System.out.println("unable to add to system tray");
                    }
                }
                if (e.getNewState() == frame.MAXIMIZED_BOTH) {
                    tray.remove(trayIcon);
                    frame.setVisible(true);
                    System.out.println("Tray icon removed");
                }
                if (e.getNewState() == frame.NORMAL) {
                    tray.remove(trayIcon);
                    frame.setVisible(true);
                    System.out.println("Tray icon removed");
                }
            }
        });

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/img/bulb16x16.gif"));
    }

    private void displayTask() {
        for(Task t : getTasks()){
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
                        textArea1.setText(t.getQuestion());
                        textArea2.setText(t.getQuestion());
                        currentTask = t;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            } else if (!t.isDone() && t.getDate().before(new Date())){
                t.setIsDone(true);
            }
        }
    }

    private void setSerializeBeforeCloseWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
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

    private void setTextArea1(Border border, Container content) {
        textArea1 =
                new JTextArea(10,40);
        textArea1.setLineWrap(true);

        textArea1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea1.setText("");
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea1);

        scrollPane.setBorder(border);
        content.add(scrollPane);
    }


    private void setTextArea2(Border border, Container content) {
        textArea2 =
                new JTextArea(10,40);
        textArea2.setLineWrap(true);

        textArea2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea2.setText("");
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea2);

        scrollPane.setBorder(border);
        content.add(scrollPane);
    }

    private void setLable(Border border, Container content) {
        JLabel label1 = new JLabel();
        label1.setText("Left-Bottom");
        label1.setHorizontalTextPosition(JLabel.LEFT);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setBorder(border);
        content.add(label1);
    }


    public void serialize(){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("c:/HowToForgert/v2/howtoforgert.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in c:/HowToForgert/v2/howtoforgert.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public void addWord(){
        Ebbinghaus ebbinghaus = new Ebbinghaus(textArea1.getText(), textArea2.getText());
        getEbbinghauses().add(ebbinghaus);
        textArea1.setText("");
        textArea2.setText("");
    }

    public void loadTask(){
        for (Ebbinghaus e : getEbbinghauses()){
            ArrayList<Task> t = e.getTasks();
            for (Task task: t){
                getTasks().add(task);
            }
        }
        Collections.sort(getTasks(), new Task());
    }

    public void popup(){
        loadTask();
        displayTask();
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
