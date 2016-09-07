package zeng.siyuan.howt2forgert;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import zeng.siyuan.C1comehere.C1comehere;
import zeng.siyuan.mappingmanager.mappingmanager;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

//Created by Real
public class How2Forgert implements Serializable {
    public transient C1comehere c1comehere;
    public transient JTextArea textArea;
    public transient static Set<Ebbinghaus> ebbinghauses;
    public transient ArrayList<Task> tasks = new ArrayList<Task>();
    public transient Task currentTask = new Task();
    public transient Display d;
    public transient Thread reloadandDisplayThread;
    public transient JFrame frame;
    public mappingmanager m;

    public How2Forgert(C1comehere c1comehere, JTextArea textArea, JFrame frame) {
        this.c1comehere = c1comehere;
        this.textArea = textArea;
        this.frame = frame;
        m = new mappingmanager();
        ebbinghauses = m.get();
    }

    public void updatetask() {
        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date();

        Calendar c = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm");

        System.out.println(format.format(c.getTime()));

        c.add(Calendar.HOUR_OF_DAY, 1);

        System.out.println(format.format(c.getTime()));


        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            stringBuilder.append("Good Morning C1 world, ");
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            stringBuilder.append("Good Afternoon C1 world, ");
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            stringBuilder.append("Good Evening C1 world, ");
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            stringBuilder.append("Good Night C1 world, ");
        }

        stringBuilder.append(format.format(c.getTime()));

        for (Ebbinghaus e : ebbinghauses) {
            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                if (timeOfDay >= 0 && timeOfDay < 12) {
                    stringBuilder.append(" am");
                } else if (timeOfDay >= 12 && timeOfDay < 24) {
                    stringBuilder.append(" pm");
                }
                stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append(textArea.getText().replace(" ufgt ", ""));
                stringBuilder.append(System.getProperty("line.separator"));
                e.question = stringBuilder.toString();
                Ebbinghaus e1 = new Ebbinghaus(e.question, "");
                m.deleteTask(e.getJavauid());
                m.store(e1);
                System.out.println("updates");
                reloadTAskandrestartPopThread();
            }
        }
    }

    public void displayTask() {
        try {
            for (Task t : tasks) {
                if (!t.getIsDone() && t.getDate().after(new Date())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(t.getDate());
                    long diff = calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
                    if (diff > 0) {
                        Thread.sleep(diff);
                        while (!textArea.getText().trim().isEmpty()) {
                            Thread.sleep(10000);
                        }
                        frame.repaint();
                        frame.toFront();
                        currentTask = t;
                        String inntuitive = System.getProperty("line.separator");
                        inntuitive += (" ufgt ");
                        inntuitive += System.getProperty("line.separator");
                        for (Ebbinghaus e : ebbinghauses) {
                            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                                for (Task ct : e.getTasks()) {
                                    if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                        ct.setIsDone(true);
                                        inntuitive += e.question;
                                        m.deleteTask(e.getJavauid());
                                        m.store(e);
                                    }
                                }
                            }
                        }
                        inntuitive += System.getProperty("line.separator");
                        textArea.setText(inntuitive);
                    } else {
                        while (!textArea.getText().trim().isEmpty()) {
                            Thread.sleep(10000);
                        }
                        frame.repaint();
                        frame.toFront();
                        currentTask = t;
                        String inntuitive = System.getProperty("line.separator");
                        inntuitive += (" ufgt ");
                        inntuitive += System.getProperty("line.separator");
                        for (Ebbinghaus e : ebbinghauses) {
                            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                                for (Task ct : e.getTasks()) {
                                    if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                        ct.setIsDone(true);
                                        inntuitive += e.question;
                                        m.deleteTask(e.getJavauid());
                                        m.store(e);
                                    }
                                }
                            }
                        }
                        inntuitive += System.getProperty("line.separator");
                        textArea.setText(inntuitive);
                        Thread.sleep(10000);
                    }
                } else if (!t.getIsDone() && t.getDate().before(new Date())) {
                    while (!textArea.getText().trim().isEmpty()) {
                        Thread.sleep(10000);
                    }
                    frame.repaint();
                    frame.toFront();
                    currentTask = t;
                    String inntuitive = System.getProperty("line.separator");
                    inntuitive += (" ufgt ");
                    inntuitive += System.getProperty("line.separator");
                    for (Ebbinghaus e : ebbinghauses) {
                        if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                            for (Task ct : e.getTasks()) {
                                if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                    ct.setIsDone(true);
                                    inntuitive += e.question;
                                    m.deleteTask(e.getJavauid());
                                    m.store(e);
                                }
                            }
                        }
                    }
                    inntuitive += System.getProperty("line.separator");
                    textArea.setText(inntuitive);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deltask() {
        for (Ebbinghaus e : ebbinghauses) {
            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                m.deleteTask(e.getJavauid());
                System.out.println("delet the " + e.getQuestion());
                reloadTAskandrestartPopThread();
            }
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

            FileWriter writer = new FileWriter("C:\\c1\\c1comehere\\ebbinghauses.txt");
            writer.write(str);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addWord(String word, String answer) {
        Ebbinghaus ebbinghaus = new Ebbinghaus(word, answer);
        mappingmanager mappingmanager = new mappingmanager();
        mappingmanager.store(ebbinghaus);
        ebbinghauses.add(ebbinghaus);
        textArea.setText("");
    }

    public void loadTask() {
        ebbinghauses = m.get();
        tasks = new ArrayList<Task>();
        for (Ebbinghaus e : ebbinghauses) {
            Set<Task> t = e.tasks;
            for (Task task : t) {
                tasks.add(task);
            }
        }
        Collections.sort(tasks, new Task());
    }

    public void reloadandDiskplaypopup() {
        loadTask();
        displayTask();
    }

    public void inster(String word, String answer) throws IOException {
        addWord(word, answer);
        reloadTAskandrestartPopThread();
    }

    private void reloadTAskandrestartPopThread() {
        if (null != reloadandDisplayThread || reloadandDisplayThread.isAlive()) {
            reloadandDisplayThread.interrupt();
        }
        d = new Display(this);
        reloadandDisplayThread = new Thread(d);
        reloadandDisplayThread.start();
    }


    public void init() {
        d = new Display(this);
        reloadandDisplayThread = new Thread(d);
        reloadandDisplayThread.start();
    }
}

