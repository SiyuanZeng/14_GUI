package zeng.siyuan.C1comehere;

import zeng.siyuan.autocomplete.JTextAreaExample;
import zeng.siyuan.betteresearchennebetterthangoogleandfindweehtehrething.findessentioal.findthebestexample;
import zeng.siyuan.button.untoggle;
import zeng.siyuan.howt2forgert.How2Forgert;
import zeng.siyuan.youknowwhat.YouKnowWhat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class C1comehere implements Serializable {
    public transient JFrame lastFrame = null;
    public static JPanel controlPanel;
    public static transient JTextArea textArea;
    public static JFrame frame;
    public How2Forgert how2Forgert;
    public static C1comehere c1comehere;
    public static Font font = new Font("Serif", Font.PLAIN, 20);
    public static untoggle untoggle;
    public transient Properties prop;
    public transient static Map<String, Search> searchEngines = new HashMap<String, Search>();


    public static void main(String[] args) {
        configureLookAndFeel();
        c1comehere = new C1comehere();
        c1comehere.showFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextAreaExample(frame, textArea, controlPanel);
            }
        });

//        SwingUtilities.invokeLater(() -> new buttons());
        untoggle untog = new untoggle(frame, controlPanel, textArea);
        untoggle = untog;
    }


    public void c1come2melater(String c1, String c1Path) {

        OutputStream output = null;
        OutputStream output_solr = null;
        try {

            output = new FileOutputStream("C:\\c1\\c1comehere\\c1s.txt");
            c1 = c1.replace(" ", "%20");
            // set the properties value
            prop.setProperty(c1, c1Path);

            // save properties to project root folder
            prop.store(output, null);


            output_solr = new FileOutputStream("C:\\c1\\c1comehere\\c1s_solr.txt");

            int count = 0;
            for (Map.Entry<Object, Object> e : prop.entrySet()) {
                String key = ((String) e.getKey()).replace("%20", " ");
                String v = (String) e.getValue();
                output_solr.write(String.valueOf(count).getBytes());
                output_solr.write(',');
                output_solr.write(key.getBytes());
                output_solr.write(',');
                output_solr.write(v.getBytes());
                output_solr.write(System.getProperty("line.separator").getBytes());
                count++;
            }

            c1s();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                    output_solr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void c1s() {
        prop = new Properties();
        Properties temprop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("C:\\c1\\c1comehere\\c1s.txt");
            // load a properties file
            temprop.load(input);


            for (Map.Entry<Object, Object> e : temprop.entrySet()) {
                String key = ((String) e.getKey()).replace("%20", " ");
                String v = (String) e.getValue();
                prop.put(key, v);
            }
            System.out.println("Done Propertiesy loading");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    // takeC1toMe
    public String takeC1toMe(String str) {
        str = str.trim();
        return prop.getProperty(str);
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
        } catch (Exception e) {
        }
    }

    public C1comehere() {

    }


    private void showFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.setTitle("c1comeherec1");
        frame.setFont(font);
        JLabel label = new JLabel("c1, com ehere , c1, come to me here.....myself MYSELF Hi meeeee....");
        label.setFont(font);
        frame.add(label);
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

        textArea = new JTextArea(10, 36);
        textArea.setLineWrap(true);
        textArea.setFont(font);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if (e.getModifiers() == KeyEvent.CTRL_MASK && e.getKeyChar() == KeyEvent.VK_ENTER) {
                    e.consume();
                    Beep.sound(2000, 150);
                    try {
                        String buttonSelected ="";
                        for (Enumeration<AbstractButton> buttons = untoggle.bg.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();

                            if (button.isSelected()) {
                                buttonSelected=button.getText();
                            }
                        }

                        boolean deleteCommand = buttonSelected.contains("delete");
                        boolean deleteCommand2 = buttonSelected.contains("deldiary");
                        boolean isThoughtRecorderCommand = buttonSelected.equalsIgnoreCase("rec");
                        boolean isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("fgt");
                        boolean isHow2ForegertCommand_u = textArea.getText().contains(" ufgt ");
                        boolean isload = buttonSelected.contains("laod");
                        boolean codja = buttonSelected.contains("codeja");
                        boolean saerchdiary = buttonSelected.contains("saerchdiary");
                        boolean isShowCommand = buttonSelected.equalsIgnoreCase("sho");// shw
                        Search search = null;





                        String searchTrs="";
                        if (searchEngines.containsKey(buttonSelected)) {
                            String text = textArea.getText().trim();

                            if (!text.isEmpty()) {
                                Scanner in = new Scanner(text);
                                while (in.hasNext()) {
                                    String line = in.nextLine();
                                    if (line.length()>4) {
                                        search = searchEngines.get(line.substring(0,3));
                                        searchTrs=line.substring(4);
                                    } else {
                                    }
                                }
                            }

                        }

                        if (deleteCommand) {
                            prop.remove(textArea.getText());
                            textArea.setText("");
                        } else if (codja && textArea.getText().trim().isEmpty()) {
                            findthebestexample f = new findthebestexample(textArea);
                            f.returnshowsearchquetsry();
                        } else if (codja && !textArea.getText().trim().isEmpty()) {
                            findthebestexample f = new findthebestexample(textArea);
                            f.gogolesearchgsearch();
                        } else if (saerchdiary && !textArea.getText().trim().isEmpty()) {
                            how2Forgert.searchehabins(textArea.getText().trim());
                        } else if (isThoughtRecorderCommand) {
                            YouKnowWhat.insert(textArea.getText());
                            textArea.setText("");
                        } else if (isload) {
                            how2Forgert.load();
                            textArea.setText("");
                        } else if (deleteCommand2) {
                            how2Forgert.deltask();
                            textArea.setText("");
                        } else if (isHow2ForegertCommand_u) {
                            //init
                            how2Forgert.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (isHow2ForegertCommand) {
                            //init
                            how2Forgert.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (isShowCommand) {
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != search) {
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        } else {
                            insert();
                            textArea.setText("");
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        //Add Textarea in to middle panel
        controlPanel.add(scroll);

        //init
        c1s();

        if (null == how2Forgert) {
            how2Forgert = new How2Forgert(c1comehere, textArea, frame);
        }
        how2Forgert.c1comehere = c1comehere;
        how2Forgert.textArea = textArea;
        how2Forgert.frame = frame;
        how2Forgert.init();
    }

    static {
        searchEngines.put("sg ", new Search("Google", "sg ", "http://www.google.com/search?q=%s", "+"));
        searchEngines.put("sd ", new Search("Dictionary", "sd ", "http://www.dictionary.com/browse/%s?s=t", "%20"));
        searchEngines.put("su ", new Search("UrbanDictionary", "su ", "http://www.urbandictionary.com/define.php?term=%s", "%20"));
        searchEngines.put("st ", new Search("Treasure", "st ", "http://www.thesaurus.com/browse/%s?s=t", "%20"));
        searchEngines.put("sy ", new Search("Youtube", "sy ", "https://www.youtube.com/results?search_query=%s", "+"));
        searchEngines.put("sm ", new Search("Gmail", "sm ", "https://mail.google.com/mail/u/0/#search/%s", "+"));
        searchEngines.put("si ", new Search("Image", "si ", "https://www.google.com/search?site=&tbm=isch&source=hp&biw=1920&bih=965&q=%s", "+"));
        searchEngines.put("sl ", new Search("I'm Feeling Lucky", "sl ", "http://www.google.com/search?btnI=I%27m+Feeling+Lucky&ie=UTF-8&oe=UTF-8&q=%s", "+"));
        searchEngines.put("sb ", new Search("Baidu", "sb ", "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%s", "%20"));
    }

    public static void logDictionary(String search, String word, String uri) throws IOException, ParseException {

        String PATH = String.format("c:/c1/c1comehere/" + search + "/");
        File directory = new File(String.valueOf(PATH));
        if (!directory.exists()) {
            directory.mkdir();
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date todayWithZeroTime = formatter.parse(formatter.format(today));

        RandomAccessFile r = new RandomAccessFile(new File("c:/c1/c1comehere/" + search + "/" + formatter.format(today) + ".txt"), "rw");
        RandomAccessFile rtemp = new RandomAccessFile(new File("c:/c1/c1comehere/" + search + "/" + formatter.format(today) + ".txt" + "~"), "rw");
        long fileSize = r.length();
        FileChannel sourceChannel = r.getChannel();
        FileChannel targetChannel = rtemp.getChannel();
        sourceChannel.transferTo(0, (fileSize - 0), targetChannel);
        sourceChannel.truncate(0);
        r.seek(0);
        r.writeBytes(System.getProperty("line.separator"));
        r.writeBytes(new Date().toString());
        r.writeBytes(System.getProperty("line.separator"));
        r.writeBytes(search + ": " + word);
        r.writeBytes(System.getProperty("line.separator"));
        r.writeBytes(uri);
        r.writeBytes(System.getProperty("line.separator"));
        long newOffset = r.getFilePointer();
        targetChannel.position(0L);
        sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - 0));
        sourceChannel.close();
        targetChannel.close();
        System.out.println("Done");
    }

    public void insert() throws IOException, ParseException {

        String textUpcase = new StringBuilder(textArea.getText()).toString();
        String text = textArea.getText();
        String path = "";
        String key = "";

        boolean isHttpCommand = textUpcase.contains("http://") || textUpcase.contains("https://");
        boolean isShortcutButExe = text.contains("=") && !text.contains(".exe");
        boolean isExeShortcut = text.contains(".exe") && text.contains("=");
        if (isHttpCommand) {
            c1come2melater(textUpcase.split("=")[0], textUpcase.substring(textUpcase.indexOf("=") + 1));
        } else if (isShortcutButExe) {
            c1come2melater(text.split("=")[0], text.split("=")[1]);
        } else if (isExeShortcut) {
            key = text.substring(text.lastIndexOf("\\") + 1, text.indexOf("."));
            c1come2melater(text.split("=")[0], text.split("=")[1]);
        } else {
            if (text.contains(".exe") && !text.contains("=")) {
                key = text.substring(text.lastIndexOf("\\") + 1, text.indexOf("."));
                c1come2melater(key, text);
            } else {
                if (text.contains("c:")) {
                    if (text.contains(".") && (text.substring(text.indexOf(".") + 1).equalsIgnoreCase("exe") || text.substring(text.indexOf(".") + 1).equalsIgnoreCase("jar"))) {
                        key = text.substring(text.lastIndexOf("\\") + 1, text.indexOf("."));
                    } else {
                        key = text.substring(text.lastIndexOf("\\") + 1);
                    }
                    c1come2melater(key.toLowerCase(), text);
                } else {

                    if (!prop.containsKey(text.trim()) && !text.contains(".")) {
                        for (Object e : prop.keySet()) {
                            String tem = (String) e;
                            if (tem.startsWith(text)) {
                                path = (String) prop.get(tem);
                            }
                        }
                    } else {
                        path = (String) prop.get(text.trim().replace(".", ""));
                    }

                    if (path.contains("http://") || path.contains("https://")) {
                        try {
                            Desktop.getDesktop().browse(new URL(path).toURI());
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    } else if ((text.contains("sd")&&text.startsWith("sd")) || (text.contains("shutdown")&&text.startsWith("shutdown"))) {
                        Runtime.getRuntime().exec("shutdown.exe -s -t 0");

                    } else {
                        Desktop.getDesktop().open(new File(path));
                    }
                }
            }
        }
    }
}
