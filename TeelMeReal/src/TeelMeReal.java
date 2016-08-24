import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Example Swing GUI.
 * <p>
 * Inspired by <a href="http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm">
 * http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm</a>
 *
 * @author Greg Chabala
 * @since Sep 29, 2010
 */
public class TeelMeReal {

    private static int count = 1;
    private static JFrame lastFrame = null;
    private JPanel controlPanel;
    private static JTextArea textArea;
    private static JFrame frame;
    private static Font font = new Font("Serif", Font.PLAIN, 20);

    public static void main(String[] args) {
        new TeelMeReal();
    }

    public TeelMeReal() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {
        frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Teel me... Real, what did you just learn?");
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

        textArea = new JTextArea(10, 40);
        textArea.setFont(font);

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
            }
        });

        textArea.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            };
            public void focusLost(FocusEvent e) {
                try {
                    insert();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(textArea);

        controlPanel.add(scrollPane);
        frame.setVisible(true);
    }

   public void insert() throws IOException, ParseException {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            Date todayWithZeroTime = formatter.parse(formatter.format(today));

            RandomAccessFile r = new RandomAccessFile(new File("c:\\TeelMeReal\\" + formatter.format(today) + ".txt"), "rw");
            RandomAccessFile rtemp = new RandomAccessFile(new File("c:\\TeelMeReal\\" + formatter.format(today) + ".txt" + "~"), "rw");
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
                                   textArea.setText("Real, tell me, what did you just learnt?");
                                   textArea.setFont(font);
                               }
                           },
                    // starting now
                    new Date(),
                    // 15 minutes
                    900000
            );
        }
}
