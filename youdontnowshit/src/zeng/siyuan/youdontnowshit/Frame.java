package zeng.siyuan.youdontnowshit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Frame implements Serializable {

    public static final long serialVersionUID = 1L;
    public static final int TEXT_AREA_ROWS = 100;
    public static final int TEXT_AREA_COLUMNS = 40;
    public static Frame serializedFrame;
    public ArrayList<Shit> shits = new ArrayList<Shit>();
    public transient ArrayList<Shit> tastyShiter = new ArrayList<Shit>();
    public transient TrayIcon trayIcon;
    public transient SystemTray tray;
    public static int count = 1;
    public static JFrame lastFrame = null;
    public JPanel controlPanel;
    public static JTextArea textArea1;
    public static JTextArea textArea2;
    public static JTextArea textArea3;
    public static JTextArea textArea_answer;
    public static JTextArea textArea_missing;
    public static JFrame frame;
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    public static int idx;
    public static String sybject;
    public int shitAnInt;
    public Font font = new Font("Serif", Font.PLAIN, 20);

    // set size
    JFrame temp = new JFrame();
    Insets insets = temp.getInsets();
    public Dimension dimension = new Dimension(insets.left + insets.right + 700,
            insets.top + insets.bottom + 900);

    public Dimension buttonDesimon = new Dimension(110, 50);

    public Frame() {
    }

    public static void configureLookAndFeel() {
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
        } catch (Exception e) {
        }
    }


    public void showFrame() {
        frame = new JFrame("Beeper " + count++);

        Container content = frame.getContentPane();
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS); // top to bottom
        frame.setLayout(boxLayout);
//        content.setLayout(new GridLayout(12, 1));
        Border border = LineBorder.createGrayLineBorder();

        JLabel label0 = new JLabel("Real, you dont know fuckign shit!!!!!!!!!!");
        label0.setBorder(border);
        label0.setFont(font);
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

        BeepingButton gotIt = setNextButton(content, border);


        setIforgertButton(content, border);
        setTextArea1(border, content);

        JLabel labe2 = new JLabel(sybject);
        labe2.setBorder(border);
        labe2.setFont(font);
        content.add(labe2);

        setTextArea2(border, content);


        JLabel labe3 = new JLabel("I missing you");
        labe3.setBorder(border);
        labe3.setFont(font);
        content.add(labe3);

        setTextArea_Missing(border, content);

        JLabel labe4 = new JLabel("this ideal dream");
        labe4.setBorder(border);
        labe4.setFont(font);
        content.add(labe4);
        setShowMeButton(content, border);

        setTextArea_Answer(border, content);


        settastyshiterButton(content, border);
        setendofworldButton(content, border);
        setoriginofeverythingButton(content, border);


        setSerializeBeforeCloseWindow();


        setTextArea3(border, content);


        setDeserializeButton(content, border);

        initSystemTray();


        frame.setVisible(true);
        if (null != shits && shits.size() > 0) {
            idx = 0;
            textArea1.setText(shits.get(idx).getQuestion());
            textArea2.setText(shits.get(idx).getAnswer());
        }
    }

    public void setTextArea_Missing(Border border, Container content) {
        textArea_missing =
                new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        textArea_missing.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea_missing);
        textArea_missing.setFont(font);
        scrollPane.setBorder(border);
        content.add(scrollPane);
    }

    public void setShowMeButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Show me your pussy!!!!");
        beep.setSize(buttonDesimon);
        beep.setMinimumSize(buttonDesimon);
        beep.setFont(font);
        beep.setAlignmentX(Component.CENTER_ALIGNMENT);
        beep.addActionListener((e) -> {
            try {
                textArea_missing.setText(shits.get(idx).missing);
                textArea_answer.setText(shits.get(idx).originalAnswer);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    public void deserializeSLoDAOLDFILE(String subject, int shitAnInt) {
        try {
            this.sybject = subject;
            this.shitAnInt = shitAnInt;
            FileInputStream fileIn = new FileInputStream(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.ser", subject, shitAnInt));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serializedFrame = (Frame) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
            serializedFrame = new Frame();
            f.printStackTrace();
            return;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            serializedFrame = new Frame();
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
    }


    public void serializeS() {
        Gson gson = new Gson();
        try {
            String PATH = String.format("c:/c1/youdontnowshit/%s/", sybject);
            File directory = new File(String.valueOf(PATH));
            if (!directory.exists()) {
                directory.mkdir();
            }

            String str = gson.toJson(shits);
            System.out.println(gson.toJson(shits));

            FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.txt", sybject, shitAnInt));
            writer.write(str);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(String subject, int shitAnInt) {
        final Type REVIEW_TYPE = new TypeToken<List<Shit>>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d.txt", subject, shitAnInt)));
            shits = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
            System.out.println("Hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void settastyshiterButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Tastyshiter!!!!");
        beep.setSize(buttonDesimon);
        beep.setMinimumSize(buttonDesimon);
        beep.setFont(font);
        beep.setAlignmentX(Component.CENTER_ALIGNMENT);
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


    public void setDeserializeButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("Let's begin and play!!!!");
        beep.setSize(buttonDesimon);
        beep.setMinimumSize(buttonDesimon);
        beep.setFont(font);
        beep.setAlignmentX(Component.CENTER_ALIGNMENT);
        beep.addActionListener((e) -> {
            try {

                if (textArea3.getText().split(" ").length == 1) {
                    deserialize(textArea3.getText().split(" ")[0], 0);
                } else {
                    deserialize(textArea3.getText().split(" ")[0], Integer.parseInt(textArea3.getText().split(" ")[1]));
                }

                frame.dispose();
                configureLookAndFeel();
                this.tastyShiter = new ArrayList<Shit>();
                this.showFrame();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    public void setendofworldButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("endo fo world");
        beep.setSize(buttonDesimon);
        beep.setMinimumSize(buttonDesimon);
        beep.setFont(font);
        beep.setAlignmentX(Component.CENTER_ALIGNMENT);
        beep.addActionListener((e) -> {
            try {
                idx = shits.size() - 1;
                textArea1.setText(shits.get(idx).getQuestion());
                textArea2.setText(shits.get(idx).getAnswer());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    public void setoriginofeverythingButton(Container content, Border border) {
        BeepingButton beep = new BeepingButton("origin of everythig");
        beep.setSize(buttonDesimon);
        beep.setMinimumSize(buttonDesimon);
        beep.setFont(font);
        beep.setAlignmentX(Component.CENTER_ALIGNMENT);
        beep.addActionListener((e) -> {
            try {
                idx = 0;
                textArea1.setText(shits.get(idx).getQuestion());
                textArea2.setText(shits.get(idx).getAnswer());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        beep.setBorder(border);
        content.add(beep);
    }

    public void setDimension() {
        JFrame temp = new JFrame();
        temp.pack();
        Insets insets = temp.getInsets();
        temp = null;
        frame.setSize(dimension);
        frame.setResizable(false);
    }

    public void setIforgertButton(Container content, Border border) {
        BeepingButton previous = new BeepingButton("OMG!!!  I forgert!");
        previous.setSize(buttonDesimon);
        previous.setMinimumSize(buttonDesimon);
        previous.setBorder(border);
        previous.setFont(font);
        previous.setAlignmentX(Component.CENTER_ALIGNMENT);

        previous.addActionListener((e) -> {
            try {
                shits.get(idx).setQuestion(textArea1.getText());
                shits.get(idx).setAnswer(textArea2.getText());

                if (idx == 0) {
                    textArea1.setText(shits.get(idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
                }

                if (idx - 1 >= 0) {
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
    public void load() {
        if (null != shits && shits.size() > 0 && 0 <= idx && idx <= shits.size() - 1) {
            shits.get(idx).question = textArea1.getText();
            shits.get(idx).answer = textArea2.getText();
            if (textArea_missing.getText() != "") {
                shits.get(idx).missing = textArea_missing.getText();
            }

            if (textArea_answer.getText() != "") {
                shits.get(idx).originalAnswer = textArea_answer.getText();
            }
        }

        Scanner in = null;

        if (null != textArea3 && !("".equalsIgnoreCase(textArea3.getText()))) {

            in = new Scanner(textArea3.getText());
            if (null == shits || shits.size() == 0) {
                idx = -1;
                while (in.hasNext()) {
                    idx++;
                    String line = in.nextLine();
                    if (line.contains("?") && line.endsWith("?")) {
                        Shit shit = new Shit(line);
                        shits.add(shit);
                    } else {
                        shits.get(idx).originalAnswer += line;
                    }
                }
            } else {
                while (in.hasNext()) {
                    String line = in.nextLine();
                    if (line.contains("?") && line.endsWith("?")) {
                        Shit shit = new Shit(line);
                        idx++;
                        shits.add(idx, shit);
                    } else {
                        shits.get(idx).originalAnswer += line;
                    }
                }
            }

            textArea1.setText((null == shits || 0 == shits.size() || null == shits.get(idx).getQuestion() || ("").equalsIgnoreCase(shits.get(idx).getQuestion())) ? "" : shits.get(idx).getQuestion());
            textArea1.setText((null == shits || 0 == shits.size() || null == shits.get(idx).answer || ("").equalsIgnoreCase(shits.get(idx).answer)) ? "" : shits.get(idx).answer);
            textArea2.setText("");
            textArea3.setText("");
            textArea_missing.setText("");
            textArea_answer.setText("");
        }
    }


    public BeepingButton setNextButton(Container content, Border border) {
        BeepingButton gotIt = new BeepingButton("Bring it on!!! Baby!!!");
        gotIt.setSize(buttonDesimon);
        gotIt.setMinimumSize(buttonDesimon);
        gotIt.setBorder(border);
        gotIt.setFont(font);
        gotIt.setAlignmentX(Component.CENTER_ALIGNMENT);
        gotIt.addActionListener((e) -> {
            try {
                if (0 <= idx && idx <= shits.size() - 1) {
                    shits.get(idx).question = textArea1.getText();
                    shits.get(idx).answer = textArea2.getText();

                    if (textArea_answer.getText() != "") {
                        shits.get(idx).originalAnswer = textArea_answer.getText();
                    }

                    if (textArea_missing.getText() != "") {
                        shits.get(idx).missing = textArea_missing.getText();
                    }
                }
                if (0 <= idx && idx < shits.size() - 1) {
                    idx++;
                    textArea1.setText(shits.get(idx).getQuestion());
                    textArea2.setText(shits.get(idx).getAnswer());
                    textArea_answer.setText("");
                    textArea_missing.setText("");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        content.add(gotIt);
        return gotIt;
    }

    public void initSystemTray() {
        try {
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to set LookAndFeel");
        }
        if (SystemTray.isSupported()) {
            System.out.println("system tray supported");
            tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage("/img/bulb16x16.gif");
            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting....");
                    System.exit(0);
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem = new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);
                    frame.setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon = new TrayIcon(image, "SystemTray Demo", popup);
            trayIcon.setImageAutoSize(true);
        } else {
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

    public void setSerializeBeforeCloseWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    try {
                        writeToText();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    serializeS();
                    if (null != tastyShiter) {
                        try {
                            writeToTexttastyShiter();
                            writeToTexttastyShiter();
                            serializetastyShiterS();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.exit(0);
                }
            }
        });
    }

    public void setTextArea1(Border border, Container content) {
        textArea1 =
                new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        textArea1.setLineWrap(true);


        JScrollPane scrollPane = new JScrollPane(textArea1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textArea1.setFont(font);

        scrollPane.setBorder(border);
        content.add(scrollPane);

    }


    public void setTextArea2(Border border, Container content) {
        textArea2 =
                new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        textArea2.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea2);
        textArea2.setFont(font);
        scrollPane.setBorder(border);
        content.add(scrollPane);
    }


    public void setTextArea_Answer(Border border, Container content) {
        textArea_answer =
                new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        textArea_answer.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea_answer);
        textArea_answer.setFont(font);
        scrollPane.setBorder(border);
        content.add(scrollPane);
    }

    public void setTextArea3(Border border, Container content) {
        textArea3 =
                new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
        textArea3.setLineWrap(true);
        textArea3.setFont(font);

        textArea3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea3.setText("");
            }
        });

        textArea3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }

            ;

            public void focusLost(FocusEvent e) {
                load();
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea3);

        scrollPane.setBorder(border);
        content.add(scrollPane);
    }

    public void setLable(Border border, Container content) {
        JLabel label1 = new JLabel();
        label1.setText("Left-Bottom");
        label1.setHorizontalTextPosition(JLabel.LEFT);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setBorder(border);
        content.add(label1);
    }


    public void writeToText() throws IOException {
        FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d_readable.txt", sybject, shitAnInt));
        for (Shit shit : shits) {
            writer.write(shit.getQuestion());
            writer.write(System.getProperty("line.separator"));
            writer.write(shit.getAnswer());
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(null == shit.originalAnswer ? "" : "Origianl answer......" + System.getProperty("line.separator") + shit.originalAnswer);
            writer.write(null == shit.missing ? "" : "missing answer......" + System.getProperty("line.separator") + shit.missing);
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
        }
        writer.close();
    }

    // next tastyShitter
    public void serializetastyShiterS() {
        shitAnInt++;
        shits = tastyShiter;
        try {
            Gson gson = new Gson();
            String PATH = String.format("c:/c1/youdontnowshit/%s/", sybject);
            File directory = new File(String.valueOf(PATH));
            if (!directory.exists()) {
                directory.mkdir();
            }

            String str = gson.toJson(shits);
            System.out.println(gson.toJson(shits));

            FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d_readable.txt", sybject, shitAnInt));
            writer.write(str);
            writer.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void writeToTexttastyShiter() throws IOException {
        shitAnInt++;
        FileWriter writer = new FileWriter(String.format("c:/c1/youdontnowshit/%s/youdontnowshit%d_readable.txt", sybject, shitAnInt));
        for (Shit shit : tastyShiter) {
            writer.write(shit.getQuestion());
            writer.write(System.getProperty("line.separator"));
            writer.write(shit.getAnswer());
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));

            writer.write("Origianl answer......");
            writer.write(System.getProperty("line.separator"));
            writer.write(shit.missing);
            writer.write(shit.originalAnswer);
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
        }
        writer.close();
    }

    public void addQuestion() {
        Shit shit = new Shit(textArea3.getText());
        shits.add(idx, shit);
    }


    public void tastyShiter() {
        tastyShiter.add(shits.get(idx));
    }
}
