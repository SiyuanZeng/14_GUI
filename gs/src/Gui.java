import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Example Swing GUI.
 * <p>
 * Inspired by <a href="http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm">
 * http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm</a>
 *
 * @author Greg Chabala
 * @since Sep 29, 2010
 */
public class Gui {

    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea;
    private static JFrame frame;
    private static Font font = new Font("Serif", Font.PLAIN, 20);


    public static void main(String[] args) {
        new Gui();
    }

    public Gui() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {
        frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.setTitle("ThoughtRecorder");
        frame.setFont(font);
        JLabel label = new JLabel("Surreal, What are you thinking.....");
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
                        insert();
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
        frame.setVisible(true);
    }


    public static void insert() throws IOException, ParseException {

        String PATH = String.format("c:/c1/gs/");
        File directory = new File(String.valueOf(PATH));
        if (!directory.exists()) {
            directory.mkdir();
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date todayWithZeroTime = formatter.parse(formatter.format(today));

        RandomAccessFile r = new RandomAccessFile(new File("c:/c1/gs/" + formatter.format(today) + ".txt"), "rw");
        RandomAccessFile rtemp = new RandomAccessFile(new File("c:/c1/gs/" + formatter.format(today) + ".txt" + "~"), "rw");
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
        try {
            Desktop.getDesktop().browse(new URL("http://www.google.com/search?q=" + textArea.getText().replace(' ', '+')).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        r.writeBytes(System.getProperty("line.separator"));
        long newOffset = r.getFilePointer();
        targetChannel.position(0L);
        sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - 0));
        sourceChannel.close();
        targetChannel.close();
        System.out.println("Done");
        frame.dispose();
    }
}
