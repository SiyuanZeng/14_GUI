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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Example Swing GUI.
 * <p>
 * Inspired by <a href="http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm">
 * http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm</a>
 *
 * @author Greg Chabala
 * @since Sep 29, 2010
 */
public class Gui implements Serializable {
    private JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea;
    private JFrame frame;
    private static Gui gui;
    private static Font font = new Font("Serif", Font.PLAIN, 20);
    private Map<String, String> pathMap = new HashMap<String, String>();


    public static void main(String[] args) {
        configureLookAndFeel();
        gui = new Gui();
        gui.showFrame();
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

    public Gui() {

    }


    private void showFrame() {
        configureLookAndFeel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.setTitle("c1comeherec1");
        frame.setFont(font);
        JLabel label = new JLabel("c1, com ehere , c1, come to me here.....");
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
        frame.add(controlPanel);

        textArea = new JTextArea(10, 36);
        textArea.setLineWrap(true);
        textArea.setFont(font);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    Tone.sound(2000, 150);
                    try {
                        boolean deleteCommand = textArea.getText().contains("delete") && textArea.getText().contains("=");
                        boolean searchCommand = textArea.getText().startsWith("sg");
                        boolean searchEmailCommand = textArea.getText().startsWith("sm");
                        boolean dictionaryReferenceCommand = textArea.getText().startsWith("sdr");
                        boolean dictioanryReferenceTreasureCommand = textArea.getText().startsWith("str");
                        boolean urbanDictionaryCommand = textArea.getText().startsWith("sud");
                        boolean youtubeCommand = textArea.getText().startsWith("sytb");

                        try {
                            if (deleteCommand) {
                                pathMap.remove(textArea.getText().split("=")[1]);
                            } else if (searchCommand) {
                                Desktop.getDesktop().browse(new URL("http://www.google.com/search?q=" + textArea.getText().replaceFirst("sg", "").replace(' ', '+')).toURI());
                                logDictionary("Google", textArea.getText().replaceFirst("sg", ""), new URL("http://www.google.com/search?q=" + textArea.getText().replaceFirst("sg", "").replace(' ', '+')).toString());
                            } else if (dictionaryReferenceCommand) {
                                Desktop.getDesktop().browse(new URL("http://www.dictionary.com/browse/" + textArea.getText().replaceFirst("sdr", "").replace(" ", "%20") + "?s=t").toURI());
                                logDictionary("DicionaryReference", textArea.getText().replaceFirst("sdr", ""), new URL("http://www.dictionary.com/browse/" + textArea.getText().replaceFirst("sdr", "").replace(" ", "%20") + "?s=t").toString());
                            } else if (urbanDictionaryCommand) {
                                Desktop.getDesktop().browse(new URL("http://www.urbandictionary.com/define.php?term=" + textArea.getText().replaceFirst("sud", "").replace(" ", "%20")).toURI());
                                logDictionary("Urban", textArea.getText().replaceFirst("sud", ""), new URL("http://www.urbandictionary.com/define.php?term=" + textArea.getText().replaceFirst("sud", "").replace(" ", "%20")).toString());
                            } else if (dictioanryReferenceTreasureCommand) {
                                Desktop.getDesktop().browse(new URL("http://www.thesaurus.com/browse/" + textArea.getText().replaceFirst("str", "").replace(" ", "%20") + "?s=t").toURI());
                                logDictionary("Treasure", textArea.getText().replaceFirst("str", ""), new URL("http://www.thesaurus.com/browse/" + textArea.getText().replaceFirst("str", "").replace(" ", "%20") + "?s=t").toString());
                            } else if (youtubeCommand) {
                                Desktop.getDesktop().browse(new URL("https://www.youtube.com/results?search_query=" + textArea.getText().replaceFirst("sytb", "").replace(' ', '+')).toURI());
                                logDictionary("Youtube", textArea.getText().replaceFirst("sytb", ""), new URL("https://www.youtube.com/results?search_query=" + textArea.getText().replaceFirst("sytb", "").replace(' ', '+')).toString());
                            } else if (searchEmailCommand) {
                                Desktop.getDesktop().browse(new URL("https://mail.google.com/mail/u/0/#search/" + textArea.getText().replaceFirst("sm ", "").replace(' ', '+')).toURI());
                                logDictionary("gMail", textArea.getText().replaceFirst("sm ", ""), new URL("https://mail.google.com/mail/u/0/#search/" + textArea.getText().replaceFirst("sm ", "").replace(' ', '+')).toString());
                            } else {
                                insert();
                            }
                        } catch (URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                        writeToText();
                        serialize();
                        textArea.setText("");
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

        JScrollPane scrollPane = new JScrollPane(textArea);

        controlPanel.add(scrollPane);

        deserialize();

        frame.setVisible(true);
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

        RandomAccessFile r = new RandomAccessFile(new File("c:/c1/c1comehere/" + search + "/"+ formatter.format(today) + ".txt"), "rw");
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
        r.writeBytes(search + ": "+word);
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
        String text = textArea.getText().toLowerCase();
        String path = "";
        String key = "";

        if (textUpcase.contains("http://") || textUpcase.contains("https://")) {
            pathMap.put(textUpcase.split("=")[0], textUpcase.substring(textUpcase.indexOf("=") + 1));
            pathMap.put("ABC", "ABC");
        } else if (text.contains("=")) {
            pathMap.put(text.split("=")[0], text.split("=")[1]);
        } else if (text.contains("c:")) {
            if (text.contains(".") && (text.substring(text.indexOf(".") + 1).equalsIgnoreCase("exe") || text.substring(text.indexOf(".") + 1).equalsIgnoreCase("jar"))) {
                key = text.substring(text.lastIndexOf("\\") + 1, text.indexOf("."));
            } else {
                key = text.substring(text.lastIndexOf("\\") + 1);
            }
            pathMap.put(key.toLowerCase(), text);
        } else {

            if (!pathMap.containsKey(text) && !text.contains(".")) {
                for (Map.Entry<String, String> e : pathMap.entrySet()) {

                    if (e.getKey().startsWith(text)) {
                        path = e.getValue();
                    }
                }
            } else {
                path = pathMap.get(text.replace(".", ""));
            }

            if (path.contains("http://") || path.contains("https://")) {
                try {
                    Desktop.getDesktop().browse(new URL(path).toURI());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                Desktop.getDesktop().open(new File(path));
            }
        }

    }

    public void serialize() {
        try {
            String PATH = String.format("c:/c1/c1comehere/");
            File directory = new File(String.valueOf(PATH));
            if (!directory.exists()) {
                directory.mkdir();
            }
            FileOutputStream fileOut =
                    new FileOutputStream(String.format("c:/c1/c1comehere/c1comehere.ser"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pathMap);
            out.close();
            fileOut.close();
            System.out.printf(String.format("c:/c1/c1comehere/c1comehere.ser"));


        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream(String.format("c:/c1/c1comehere/c1comehere.ser"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pathMap = (HashMap<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
            pathMap = new HashMap<String, String>();
            f.printStackTrace();
            return;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("c1comehere class not found");
            pathMap = new HashMap<String, String>();
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized c1comehere...");
    }

    private void writeToText() throws IOException {
        FileWriter writer = new FileWriter(String.format("c:/c1/c1comehere/c1comehere.txt"));
        for (Map.Entry<String, String> e : pathMap.entrySet()) {
            writer.write(e.getKey() + "=" + e.getValue());
            writer.write(System.getProperty("line.separator"));
        }
        writer.close();
    }
}
