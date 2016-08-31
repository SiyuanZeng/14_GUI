package zeng.siyuan.howt2forgert;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import zeng.siyuan.C1comehere.C1comehere;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

//Created by Real
public class How2Forgert implements Serializable {
    public transient C1comehere c1comehere;
    public transient JTextArea textArea;
    public transient static final long serialVersionUID = 1L;
    public transient static ArrayList<Ebbinghaus> ebbinghauses;
    public transient ArrayList<Task> tasks = new ArrayList<Task>();
    public transient Task currentTask = new Task();
    public transient Display d;
    public transient Thread threadD;
    public transient JFrame frame;

    public How2Forgert(C1comehere c1comehere, JTextArea textArea, JFrame frame) {
        this.c1comehere = c1comehere;
        this.textArea = textArea;
        this.frame = frame;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private void displayTask() {
        try {
            for (Task t : tasks) {
                if (!t.isDone() && t.getDate().after(new Date())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(t.getDate());
                    long diff = calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
                    if (diff > 0) {
                        System.out.println("Before sleep");
                        Thread.sleep(diff);
                        System.out.println("After sleep");
                        frame.repaint();
                        frame.toFront();
                        textArea.setText(t.getQuestion());
                        currentTask = t;
                        currentTask.setIsDone(true);
                    } else {
                        System.out.println("Before sleep.....");
                        System.out.println("After sleep.....");
                        frame.repaint();
                        frame.toFront();
                        textArea.setText(t.getQuestion());
                        currentTask = t;
                        currentTask.setIsDone(true);
                        Thread.sleep(10000);
                    }
                } else if (!t.isDone() && t.getDate().before(new Date())) {
                    t.setIsDone(true);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyCustomExclusionStrategy implements ExclusionStrategy {

        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {
            return (f.getDeclaringClass() == Ebbinghaus.class && f.getName().equals("changes"));
        }

    }

    public static void serialize() {
        Gson gson = new Gson();
        try {
            String str = gson.toJson(ebbinghauses);
            System.out.println(gson.toJson(ebbinghauses));

            FileWriter writer = new FileWriter("C:\\c1\\c1comehere\\ebbinghauses.txt");
            writer.write(str);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        final Type REVIEW_TYPE = new TypeToken<List<Ebbinghaus>>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader("C:\\c1\\c1comehere\\ebbinghauses.txt"));
            ebbinghauses = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
            System.out.println("Hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addWord(String word, String answer) {
        ebbinghauses = null != ebbinghauses ? ebbinghauses : new ArrayList<Ebbinghaus>();
        Ebbinghaus ebbinghaus = new Ebbinghaus(word, answer);
        ebbinghauses.add(ebbinghaus);
        textArea.setText("");
    }

    public void loadTask() {
        ebbinghauses = null != ebbinghauses ? ebbinghauses : new ArrayList<Ebbinghaus>();
        tasks = new ArrayList<Task>();
        for (Ebbinghaus e : ebbinghauses) {
            ArrayList<Task> t = e.tasks;
            for (Task task : t) {
                tasks.add(task);
            }
        }
        Collections.sort(tasks, new Task());
    }

    public void popup() {
        loadTask();
        displayTask();
    }

    public void inster(String word, String answer) throws IOException {
        addWord(word, answer);
        restartPopThread();
    }

    private void restartPopThread() {
        if (null != threadD || threadD.isAlive()) {
            threadD.interrupt();
        }
        d = new Display(this);
        threadD = new Thread(d);
        threadD.start();
    }


    public void init() {
        deserialize();
        loadTask();
        d = new Display(this);
        threadD = new Thread(d);
        threadD.start();
    }


}

