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
    private static Frame serializedFrame;
    private ArrayList<Shit> shits = new ArrayList<Shit>();
    private transient ArrayList<Shit> tastyShiter = new ArrayList<Shit>();
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
    private static String subject;
    private int shitAnInt;

    public ArrayList<Shit> getTastyShiter() {
        return tastyShiter;
    }

    public void setTastyShiter(ArrayList<Shit> tastyShiter) {
        this.tastyShiter = tastyShiter;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        Frame.subject = subject;
    }

    public int getShitAnInt() {
        return shitAnInt;
    }

    public void setShitAnInt(int shitAnInt) {
        this.shitAnInt = shitAnInt;
    }

    public static Frame getSerializedFrame() {
        return serializedFrame;
    }

    public static void setSerializedFrame(Frame serializedFrame) {
        Frame.serializedFrame = serializedFrame;
    }

    public static JTextArea getTextArea3() {
        return textArea3;
    }

    public static void setTextArea3(JTextArea textArea3) {
        Frame.textArea3 = textArea3;
    }

    public static String getWithDelimiter() {
        return WITH_DELIMITER;
    }

    public static int getIdx() {
        return idx;
    }

    public static void setIdx(int idx) {
        Frame.idx = idx;
    }

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



    private static void configureLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break; //preferred!
                }
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {}
    }


    public void showFrame() {
        frame = new JFrame("Beeper " + count++);

        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(12, 1));
        Border border = LineBorder.createGrayLineBorder();

        JLabel label0 = new JLabel("Real, you dont know fuckign shit!!!!!!!!!!");
        label0 .setBorder(border);
        content.add(label0);

        frame.pack();
        frame.setTitle("youdontnowshit");

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

        settastyshiterButton(content, border);
        setendofworldButton(content, border);
        setoriginofeverythingButton(content, border);


        setSerializeBeforeCloseWindow();


        setSaveButton(content, border);

        setTextArea3(border, content);

        setDeserializeButton(content, border);

        initSystemTray();

        frame.setVisible(true);
        if(null !=shits && shits.size()>0) {
            textArea1.setText(shits.get(idx).getQuestion());
            textArea2.setText(shits.get(idx).getAnswer());
        }

    }
    public void deserialize(String subject, int shitAnInt){
        try
        {
            this.subject = subject;
            this.shitAnInt =shitAnInt;
            FileInputStream fileIn = new FileInputStream(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.ser", subject, shitAnInt) );
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serializedFrame = (Frame) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f){
            System.out.println("File not found");
            serializedFrame = new Frame();
            f.printStackTrace();
            return;
        } catch(IOException i)
        {
            i.printStackTrace();
            return;
        } catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            serializedFrame = new Frame();
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
    }
    private void settastyshiterButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Tastyshiter!!!!");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {
                tastyShiter();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }


    private void setDeserializeButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Let's begin and play!!!!");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {

                if (textArea3.getText().split(" ").length == 1){
                    deserialize(textArea3.getText().split(" ")[0],0);
                } else {
                    deserialize(textArea3.getText().split(" ")[0], Integer.parseInt(textArea3.getText().split(" ")[1]));
                }

                frame.dispose();
                configureLookAndFeel();
                serializedFrame.tastyShiter = new ArrayList<Shit>();
                serializedFrame.showFrame();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    private void setendofworldButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("endo fo world");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {
                idx=shits.size()-1;
                textArea1.setText(shits.get(idx).getQuestion());
                textArea2.setText(shits.get(idx).getAnswer());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    private void setoriginofeverythingButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("origin of everythig");
        beep.setSize(new Dimension(100, 100));
        beep.addActionListener((e) -> {
            try {
                idx=0;
                    textArea1.setText(shits.get(idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
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
                insets.top + insets.bottom + 700));
        frame.setResizable(false);
    }

    private void setIforgertButton(Container content, Border border) {
        BeepingButton previous= new BeepingButton("OMG!!!  I forgert!");
        previous.setSize(new Dimension(100, 100));
        previous.setBorder(border);
        previous.addActionListener((e) -> {
            try {
                shits.get(idx).setQuestion(textArea1.getText());
                shits.get(idx).setAnswer(textArea2.getText());

                if (idx==0) {
                    textArea1.setText(shits.get(idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
                }

                if (idx-1 >=0) {
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

        textArea1.setText(shits.get(idx).getQuestion());
        textArea2.setText("");
        textArea3.setText("");

    }


    private BeepingButton setNextButton(Container content, Border border) {
        BeepingButton gotIt= new BeepingButton("Bring it on!!! Baby!!!");
        gotIt.setSize(new Dimension(100, 100));
        gotIt.setBorder(border);
        gotIt.addActionListener((e) -> {
            try {
                if(idx==0){
                    shits.get(idx).setQuestion(textArea1.getText());
                    shits.get(idx).setAnswer(textArea2.getText());
                } else if(idx-1>=0 && idx <= shits.size()){
                    shits.get(idx-1).setQuestion(textArea1.getText());
                    shits.get(idx-1).setAnswer(textArea2.getText());
                }
                if (idx >=0 && idx < shits.size()-1){
                    textArea1.setText(shits.get(++idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
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
                        if(null != tastyShiter){
                            writeToTexttastyShiter();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    serialize();
                    if(null != tastyShiter){
                        serializetastyShiter();
                    }
                    System.exit(0);
                }
            }
        });
    }

    private void setTextArea1(Border border, Container content) {
        textArea1 =
                new JTextArea(10,40);
        textArea1.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea1);

        scrollPane.setBorder(border);
        content.add(scrollPane);
    }


    private void setTextArea2(Border border, Container content) {
        textArea2 =
                new JTextArea(10,40);
        textArea2.setLineWrap(true);

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
            String PATH = String.format("c:/c1/youdontnowshit/%s/", subject);
            File directory = new File(String.valueOf(PATH));
            if (! directory.exists()){
                directory.mkdir();
            }
            FileOutputStream fileOut =
                    new FileOutputStream(String.format("c:/c1/youdontnowshit/%s/youdontnowshit.ser", subject));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf(String.format("c:/c1/youdontnowshit/%s/youdontnowshit.ser", subject));


        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    private void writeToText() throws IOException {
        FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit.txt", subject));
        for(Shit shit: shits) {
            writer.write(shit.getQuestion());
            writer.write(System.getProperty( "line.separator" ));
            writer.write(shit.getAnswer());
            writer.write(System.getProperty( "line.separator" ));
            writer.write(System.getProperty( "line.separator" ));
        }
        writer.close();
    }


    // next tastyShitter
    public void serializetastyShiter(){
        shits = tastyShiter;
        try
        {
            String PATH = String.format("c:/c1/youdontnowshit/%s/", subject);
            File directory = new File(String.valueOf(PATH));
            if (! directory.exists()){
                directory.mkdir();
            }
            FileOutputStream fileOut =
                    new FileOutputStream(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.ser", subject,shitAnInt));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.ser", subject,shitAnInt));


        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    private void writeToTexttastyShiter() throws IOException {
        shitAnInt++;
        FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.txt", subject, shitAnInt));
        for(Shit shit: tastyShiter) {
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


    public void tastyShiter(){
        tastyShiter.add(shits.get(idx));
    }
}
