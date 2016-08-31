package zeng.siyuan.youknowwhat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YouKnowWhat {
    public static void insert(String string) throws IOException, ParseException {
        String PATH = String.format("c:/c1/c1comehere/diary");
        File directory = new File(String.valueOf(PATH));
        if (!directory.exists()) {
            directory.mkdir();
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date todayWithZeroTime = formatter.parse(formatter.format(today));

        RandomAccessFile r = new RandomAccessFile(new File("c:/c1/c1comehere/diary/" + formatter.format(today) + ".txt"), "rw");
        RandomAccessFile rtemp = new RandomAccessFile(new File("c:/c1/c1comehere/diary/" + formatter.format(today) + ".txt" + "~"), "rw");
        long fileSize = r.length();
        FileChannel sourceChannel = r.getChannel();
        FileChannel targetChannel = rtemp.getChannel();
        sourceChannel.transferTo(0, (fileSize - 0), targetChannel);
        sourceChannel.truncate(0);
        r.seek(0);
        r.writeBytes(System.getProperty("line.separator"));
        r.writeBytes(new Date().toString());
        r.writeBytes(System.getProperty("line.separator"));
        r.writeBytes(string);
        r.writeBytes(System.getProperty("line.separator"));
        long newOffset = r.getFilePointer();
        targetChannel.position(0L);
        sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - 0));
        sourceChannel.close();
        targetChannel.close();
        System.out.println("Done");
    }
}
