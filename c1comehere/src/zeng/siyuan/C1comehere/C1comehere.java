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
    public zeng.siyuan.onceaday.How2Forgert dhow2Forgert;
    public zeng.siyuan.onceaday.link.onceaday.How2Forgert dhow2Forgertl;
    public zeng.siyuan.onceaday.link.onceaday.document.onceaday.How2Forgert dhow2ForgDertl;
    public zeng.siyuan.onceaday.link.onceaday.document.onceaday.ssdd.onceaday.How2Forgert dhow2ForgDertls;
    public static C1comehere c1comehere;
    public static Font font = new Font("Serif", Font.PLAIN, 20);
    public static untoggle untoggle;
    public transient Properties prop;
    public transient static Map<String, Search> searchEngines = new HashMap<String, Search>();


    public static void main(String[] args) {
        configureLookAndFeel();
        c1comehere = new C1comehere();
        c1comehere.showFrame();
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
        controlPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setTitle("c1comeherec1");
        frame.setFont(font);
        JLabel label = new JLabel("c1, com ehere , c1, come to me here.....myself MYSELF Hi meeeee....");
        label.setFont(font);
        frame.pack();

        JFrame temp = new JFrame();
        temp.pack();
        Insets insets = temp.getInsets();
        temp = null;
        frame.setSize(new Dimension(insets.left + insets.right + 500,
                insets.top + insets.bottom + 500));
        frame.setResizable(true);


        if (lastFrame == null) {
            frame.setLocationByPlatform(true);
        } else {
            Point p = lastFrame.getLocation();
            p.translate(50, 50);
            frame.setLocation(p);
        }
        lastFrame = frame;


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
                        String buttonSelected = "";
                        for (Enumeration<AbstractButton> buttons = untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
                            AbstractButton button = buttons.nextElement();

                            if (button.isSelected()) {
                                buttonSelected = button.getText();
                            }
                        }

                        boolean deleteCommand = buttonSelected.startsWith("delete");
                        boolean deleteCommand2 = buttonSelected.startsWith("deldiary");
                        boolean isThoughtRecorderCommand = buttonSelected.startsWith("rec");
                        boolean isHow2ForegertCommand = buttonSelected.startsWith("fgt");
                        boolean isHow2ForegertCommand_u = textArea.getText().contains(" ufgt ");
                        boolean isload = buttonSelected.startsWith("laod");
                        boolean codja = buttonSelected.startsWith("codeja");
                        boolean saerchdiary = buttonSelected.startsWith("saerchdiary");
                        boolean isShowCommand = buttonSelected.startsWith("sho");// shw
                        Search search = null;


                        boolean DdeleteCommand_X = buttonSelected.startsWith("Ddelete");
                        boolean DdeleteCommand2 = buttonSelected.startsWith("Ddeldiary");
                        boolean DisThoughtRecorderCommand_x = buttonSelected.startsWith("Drec");
                        boolean DisHow2ForegertCommand = buttonSelected.startsWith("Dfgt");
                        boolean DisHow2ForegertCommand_u = textArea.getText().startsWith(" Dufgt ");
                        boolean Disload = buttonSelected.startsWith("startsWith");
                        boolean Dcodja_x = buttonSelected.startsWith("Dcodeja");
                        boolean Dsaerchdiary = buttonSelected.startsWith("Dsaerchdiary");
                        boolean DisShowCommand = buttonSelected.startsWith("Dsho");// shw
                        Search Dsearch = null;


                        boolean DldeleteCommand_X = buttonSelected.startsWith("LDdelete");
                        boolean DdleleteCommand2 = buttonSelected.startsWith("DdeldLiary");
                        boolean DislThoughtRecorderCommand_x = buttonSelected.equalsIgnoreCase("Drec");
                        boolean DisHlow2ForegertCommand = buttonSelected.equalsIgnoreCase("DLfgt");
                        boolean DisHolw2ForegertCommand_u = textArea.getText().startsWith("DufLgt");
                        boolean Disloald = buttonSelected.startsWith("DlaodL")&&(!buttonSelected.startsWith("DlaodLD"));
                        boolean Dcodja_lx = buttonSelected.startsWith("DcodeLja");
                        boolean Dsaerchdliary = buttonSelected.startsWith("DsaerLchdiary");
                        boolean DisShowColmmand = buttonSelected.equalsIgnoreCase("DshoL");// shw
                        Search Dsearclh = null;




                        boolean DldeleteCommandd_X = buttonSelected.startsWith("DLDdelete");
                        boolean DdleleteCoDmmand2 = buttonSelected.startsWith("DdeldLDiary");
                        boolean DislThoughtDRecorderCommand_x = buttonSelected.equalsIgnoreCase("Drec");
                        boolean DisHlow2ForeDgertCommand = buttonSelected.equalsIgnoreCase("DDLfgt");
                        boolean DisHolw2ForegDertCommand_u = textArea.getText().startsWith("DuDfLgt");
                        boolean DislDoald = buttonSelected.startsWith("DlaodLD");
                        boolean DcodjDa_lx = buttonSelected.startsWith("DcodeLDja");
                        boolean DsaercDhdliary = buttonSelected.startsWith("DsaerDLchdiary");
                        boolean DisShowDColmmand = buttonSelected.equalsIgnoreCase("DshoDL");// shw
                        Search DsearclhD = null;




                        boolean SDldeleteCommandd_X = buttonSelected.startsWith("DLDdSelete");
                        boolean SDdleleteCoDmmand2 = buttonSelected.startsWith("DdeldSLDiary");
                        boolean SDislThoughtDRecorderCommand_x = buttonSelected.equalsIgnoreCase("Drec");
                        boolean SDisHlow2ForeDgertCommand = buttonSelected.equalsIgnoreCase("DDLSfgt");
                        boolean SDisHolw2ForegDertCommand_u = textArea.getText().startsWith("DuSDfLgt");
                        boolean SDislDoald = buttonSelected.startsWith("DlaoSdLD");
                        boolean SDcodjDa_lx = buttonSelected.startsWith("DcodeLSDja");
                        boolean SDsaercDhdliary = buttonSelected.startsWith("DsaeSrDLchdiary");
                        boolean SDisShowDColmmand = buttonSelected.equalsIgnoreCase("DshSoDL");// shw
                        Search DSsearclhD = null;




                        String searchTrs = "";
                        if (searchEngines.containsKey(buttonSelected)) {
                            String text = textArea.getText().trim();

                            if (!text.isEmpty()) {
                                Scanner in = new Scanner(text);
                                while (in.hasNext()) {
                                    String line = in.nextLine();
                                    if (line.length() > 4) {
                                        search = searchEngines.get(line.substring(0, 3));
                                        searchTrs = line.substring(4);
                                    } else {
                                    }
                                }
                            }
                        }

                        if (deleteCommand) {
                            System.out.println("delete command");
                            prop.remove(textArea.getText());
                            textArea.setText("");
                        } else if (codja && textArea.getText().trim().isEmpty()) {
                            System.out.println("codja");
                            findthebestexample f = new findthebestexample(textArea);
                            f.returnshowsearchquetsry();
                        } else if (codja && !textArea.getText().trim().isEmpty()) {
                            System.out.println("codja");
                            findthebestexample f = new findthebestexample(textArea);
                            f.gogolesearchgsearch();
                        } else if (saerchdiary && !textArea.getText().trim().isEmpty()) {
                            System.out.println("saerchdiary ");
                            how2Forgert.searchehabins(textArea.getText().trim());
                        } else if (isThoughtRecorderCommand) {
                            System.out.println("isThoughtRecorderCommand");
                            YouKnowWhat.insert(textArea.getText());
                            textArea.setText("");
                        } else if (isload) {
                            System.out.println("isload");
                            how2Forgert.load();
                            textArea.setText("");
                        } else if (deleteCommand2) {
                            System.out.println("deleteCommand2");
                            how2Forgert.deltask();
                            textArea.setText("");
                        } else if (isHow2ForegertCommand_u) {
                            System.out.println("isHow2ForegertCommand_u");
                            //init
                            how2Forgert.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (isHow2ForegertCommand) {
                            System.out.println("isHow2ForegertCommand");
                            //init
                            how2Forgert.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (isShowCommand) {
                            System.out.println("isShowCommand");
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != search) {
                            System.out.println("search");
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        }



                        else if (Dsaerchdiary && !textArea.getText().trim().isEmpty()) {
                            System.out.println("Dsaerchdiary");
                            dhow2Forgert.searchehabins(textArea.getText().trim());
                        } else if (Disload) {
                            System.out.println("Disload");
                            dhow2Forgert.load();
                            textArea.setText("");
                        } else if (DdeleteCommand2) {
                            System.out.println("DdeleteCommand2");
                            dhow2Forgert.deltask();
                            textArea.setText("");
                        } else if (DisHow2ForegertCommand_u) {
                            System.out.println("DisHow2ForegertCommand_u");
                            dhow2Forgert.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisHow2ForegertCommand) {
                            System.out.println("DisHow2ForegertCommand");
                            dhow2Forgert.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisShowCommand) {
                            System.out.println("DisShowCommand");
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != Dsearch) {
                            System.out.println("Dsearch");
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        }





                        else if (Dsaerchdliary && !textArea.getText().trim().isEmpty()) {
                            System.out.println("Dsaerchdliary");
                            dhow2Forgertl.searchehabins(textArea.getText().trim());
                        } else if (Disloald ) {
                            System.out.println("Disloadl");
                            dhow2Forgertl.load();
                        } else if (DdleleteCommand2 ) {
                            System.out.println("DdeletleCommand2");
                            dhow2Forgertl.deltask();
                            textArea.setText("");
                        } else if (DisHolw2ForegertCommand_u) {
                            System.out.println("DisHolw2ForegertCommand_u");
                            dhow2Forgertl.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisHlow2ForegertCommand ) {
                            System.out.println("DisHlow2ForegertCommand");
                            dhow2Forgertl.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisShowColmmand) {
                            System.out.println("DislShowCommand");
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != Dsearclh) {
                            System.out.println("Dsearlch");
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        }






                        else if (DsaercDhdliary && !textArea.getText().trim().isEmpty()) {
                            System.out.println("Dsaerchdliary");
                            dhow2ForgDertl.searchehabins(textArea.getText().trim());
                        } else if (DislDoald ) {
                            System.out.println("Disloadl");
                            dhow2ForgDertl.load();
                        } else if (DdleleteCoDmmand2 ) {
                            System.out.println("DdeletleCommand2");
                            dhow2ForgDertl.deltask();
                            textArea.setText("");
                        } else if (DisHolw2ForegDertCommand_u ) {
                            System.out.println("DisHolw2ForegertCommand_u");
                            dhow2ForgDertl.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisHlow2ForeDgertCommand ) {
                            System.out.println("DisHlow2ForegertCommand");
                            dhow2ForgDertl.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (DisShowDColmmand) {
                            System.out.println("DislShowCommand");
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != DsearclhD ) {
                            System.out.println("Dsearlch");
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        }





                        else if (SDsaercDhdliary && !textArea.getText().trim().isEmpty()) {
                            System.out.println("Dsaerchdliary");
                            dhow2ForgDertls.searchehabins(textArea.getText().trim());
                        } else if (SDislDoald ) {
                            System.out.println("Disloadl");
                            dhow2ForgDertls.load();
                        } else if (SDdleleteCoDmmand2 ) {
                            System.out.println("DdeletleCommand2");
                            dhow2ForgDertls.deltask();
                            textArea.setText("");
                        } else if (SDisHolw2ForegDertCommand_u ) {
                            System.out.println("DisHolw2ForegertCommand_u");
                            dhow2ForgDertls.updatetask();
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (SDisHlow2ForeDgertCommand ) {
                            System.out.println("DisHlow2ForegertCommand");
                            dhow2ForgDertls.inster(textArea.getText(), "");
                            textArea.setText("");
                            How2Forgert.serialize();
                        } else if (SDisShowDColmmand) {
                            System.out.println("DislShowCommand");
                            textArea.setText(takeC1toMe(textArea.getText()));
                            frame.repaint();
                            frame.toFront();
                        } else if (null != DSsearclhD ) {
                            System.out.println("Dsearlch");
                            search.setURI(searchTrs);
                            Desktop.getDesktop().browse(search.getURI());
                            logDictionary(search.searchName, search.keywords, search.getURIString());
                            textArea.setText("");
                        }



                        else {
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


        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //Add Textarea in to middle panel


        untoggle = new untoggle(frame, controlPanel, textArea, label, scroll);


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextAreaExample(frame, textArea, controlPanel);
            }
        });

//        SwingUtilities.invokeLater(() -> new buttons());

        //init
        c1s();

        if (null == how2Forgert) {
            how2Forgert = new How2Forgert(c1comehere, textArea, frame);
        }
        how2Forgert.c1comehere = c1comehere;
        how2Forgert.textArea = textArea;
        how2Forgert.frame = frame;
        how2Forgert.init();


        if (null == dhow2Forgert) {
            dhow2Forgert = new zeng.siyuan.onceaday.How2Forgert(c1comehere, textArea, frame);
        }
        dhow2Forgert.c1comehere = c1comehere;
        dhow2Forgert.textArea = textArea;
        dhow2Forgert.frame = frame;
        dhow2Forgert.init();


        if (null == dhow2Forgertl) {
            dhow2Forgertl = new zeng.siyuan.onceaday.link.onceaday.How2Forgert(c1comehere, textArea, frame);
        }
        dhow2Forgertl.c1comehere = c1comehere;
        dhow2Forgertl.textArea = textArea;
        dhow2Forgertl.frame = frame;
        dhow2Forgertl.init();




        if (null == dhow2ForgDertl) {
            dhow2ForgDertl= new zeng.siyuan.onceaday.link.onceaday.document.onceaday.How2Forgert(c1comehere, textArea, frame);
        }
        dhow2ForgDertl.c1comehere = c1comehere;
        dhow2ForgDertl.textArea = textArea;
        dhow2ForgDertl.frame = frame;
        dhow2ForgDertl.init();






        if (null == dhow2ForgDertls) {
            dhow2ForgDertls= new zeng.siyuan.onceaday.link.onceaday.document.onceaday.ssdd.onceaday.How2Forgert(c1comehere, textArea, frame);
        }
        dhow2ForgDertls.c1comehere = c1comehere;
        dhow2ForgDertls.textArea = textArea;
        dhow2ForgDertls.frame = frame;
        dhow2ForgDertls.init();








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
                if (text.contains("c:") && !key.trim().isEmpty()) {
                    if (text.contains(".") && (text.substring(text.indexOf(".") + 1).equalsIgnoreCase("exe") || text.substring(text.indexOf(".") + 1).equalsIgnoreCase("jar"))) {
                        key = text.substring(text.lastIndexOf("\\") + 1, text.indexOf("."));
                    } else {
                        key = text.substring(text.lastIndexOf("\\") + 1);
                    }
                    c1come2melater(key.toLowerCase(), text);
                } else if (text.contains("c:") && key.trim().isEmpty()) {
                    Desktop.getDesktop().open(new File(text.trim()));
                } else {
                    if (!prop.containsKey(text.trim()) && !text.contains(".")) {
                        for (Object e : prop.keySet()) {
                            String tem = (String) e;
                            if (tem.startsWith(text)) {
                                path = (String) prop.get(tem);
                            }
                        }
                    } else {
                        path = (String) prop.get(text.trim().replace(".", "")) == null ? "" : (String) prop.get(text.trim().replace(".", ""));
                    }

                    if (null != path && !path.isEmpty() && path.contains("http://") || path.contains("https://")) {
                        try {
                            Desktop.getDesktop().browse(new URL(path).toURI());
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    } else if ((text.contains("sd") && text.startsWith("sd")) || (text.contains("shutdown") && text.startsWith("shutdown"))) {
                        Runtime.getRuntime().exec("shutdown.exe -s -t 0");
                        // what the fuck si the else mean?
                    } else if (null == path || path.trim().isEmpty()) {
                        Desktop.getDesktop().open(new File(text.trim()));
                    } else {
                        Desktop.getDesktop().open(new File(path));
                    }
                }
            }
        }
    }
}
