package zeng.siyuan.youdontnowshit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Frame implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<Shit> shits = new ArrayList<Shit>();
    private  transient TrayIcon trayIcon;
    private  transient SystemTray tray;
    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea1;
    private static JTextArea textArea2;
    private static JTextArea textArea3;
    private static JFrame frame;
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private static int idx;

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

    public  ArrayList<Shit> getShits() {
        return shits;
    }

    public void setShits(ArrayList<Shit> shits) {
        this.shits = shits;
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

    public Frame() {
    }

    public ArrayList<Shit> getWordList() {
        return shits;
    }

    public void setWordList(ArrayList<Shit> wordList) {
        this.shits = wordList;
    }

    public void showFrame() {
        frame = new JFrame("Beeper " + count++);

        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(7, 1));
        Border border = LineBorder.createGrayLineBorder();

        JLabel label0 = new JLabel("Real, you dont know fuckign shit!!!!!!!!!!");
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


        BeepingButton gotIt = setNextButton(content, border);


        setIforgertButton(content, border);

        setSerializeBeforeCloseWindow();


        setSaveButton(content, border);

        setTextArea3(border, content);

        initSystemTray();

        frame.setVisible(true);
    }

    private void setSaveButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Save");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {
                load();
            } catch (Exception e1) {
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
        BeepingButton previous= new BeepingButton("OMG!!!  I forgert!");
        previous.setSize(new Dimension(100, 100));
        previous.setBorder(border);
        previous.addActionListener((e) -> {
            try {
                if (idx >=0) {
                    textArea1.setText(shits.get(--idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        content.add(previous);
    }


    // load into the list and then disply one by one
    // click next and save and go tot the next
    // ... need to have a item to save the passowquestion and anserwr
    // need to go back to last qustion
    // just like what the guy did to create a software that can load the gwd
    // stro
    private void load() {
        Scanner in = null;
        in = new Scanner(textArea3.getText());
        while(in.hasNext()) {
            String line = in.nextLine();
            if (line.contains("?") && line.endsWith("?")) {
                Shit shit = new Shit(line);
                shits.add(shit);
            }
        }

        textArea1.setText(shits.get(0).getQuestion());
        textArea2.setText("");
        textArea3.setText("");

    }


    private BeepingButton setNextButton(Container content, Border border) {
        BeepingButton gotIt= new BeepingButton("Bring it on!!! Baby!!!");
        gotIt.setSize(new Dimension(100, 100));
        gotIt.setBorder(border);
        gotIt.addActionListener((e) -> {
            try {
                if (idx < shits.size()){
                    textArea1.setText(shits.get(idx).getQuestion());
                idx++;
                textArea2.setText("");

            }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        content.add(gotIt);
        return gotIt;
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

    private void setSerializeBeforeCloseWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    try {
                        writeToText();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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


    private void setTextArea3(Border border, Container content) {
        textArea3 =
                new JTextArea(10,40);
        textArea3.setLineWrap(true);

        textArea3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea3.setText("");
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea3);

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
                    new FileOutputStream("c:/c1/youdontnowshit/v1/youdontnowshit.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in c:/c1/youdontnowshit/v1/youdontnowshit.ser");


        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    private void writeToText() throws IOException {
        FileWriter writer = new FileWriter("c:/c1/youdontnowshit/v1/youdontnowshit.txt");
        for(Shit shit: shits) {
            writer.write(shit.getQuestion());
            writer.write(System.getProperty( "line.separator" ));
            writer.write(shit.getAnswer());
            writer.write(System.getProperty( "line.separator" ));
            writer.write(System.getProperty( "line.separator" ));
        }
        writer.close();
    }

    public void addQuestion(){
        Shit shit = new Shit(textArea3.getText());
        getShits().add(shit);
    }
}
