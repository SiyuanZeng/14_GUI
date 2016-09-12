package zeng.siyuan.onceaday;

import zeng.siyuan.C1comehere.C1comehere;
import zeng.siyuan.mappingmanager.peoplequesiton;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

//Created by Real
public class How2Forgert implements Serializable {
    public transient C1comehere c1comehere;
    public transient JTextArea textArea;
    public transient static ArrayList<person_question> ebbinghauses;
    public transient ArrayList<Task> tasks = new ArrayList<Task>();
    public transient Task currentTask = new Task();
    public transient Display d;
    public transient Thread reloadandDisplayThread;
    public transient JFrame frame;
    public peoplequesiton m = new peoplequesiton();;
    public boolean isSearch;
    public int count=1;
    private ArrayList<person_question> searchebbinghauses;
    private ArrayList<Task> searchtasks;
    private Task currentTaskSearch;
    private String keywords;

    public void load(){
        Scanner in = null;

        if (null != textArea && !("".equalsIgnoreCase(textArea.getText()))) {

            in = new Scanner(textArea.getText());
                while (in.hasNext()) {
                    String line = in.nextLine();
                    if (line.contains("?") && line.endsWith("?")) {
                        person_question e = new person_question(line,"Person_Quesiton", getdatelastday());
                        m.store(e);
                    } else {
                    }
                }
            }
        }

    public How2Forgert(C1comehere c1comehere, JTextArea textArea, JFrame frame) {
        this.c1comehere = c1comehere;
        this.textArea = textArea;
        this.frame = frame;
    }

    public void updatetask() {
        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date();

        Calendar c = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm");

        System.out.println(format.format(c.getTime()));

        c.add(Calendar.HOUR_OF_DAY, 1);

        System.out.println(format.format(c.getTime()));

        // found!
        String textinput = textArea.getText().replace(" Dufgt ", "");
        Scanner in = null;

        if (!textinput.isEmpty()) {
            StringBuilder stringBuilder1 = new StringBuilder();
            in = new Scanner(textinput);
            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.contains(" found!")) {
                } else {
                    stringBuilder.append(line);
                }
            }
            textinput=stringBuilder.toString();
        }


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

        for (person_question e : ebbinghauses) {
            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                if (timeOfDay >= 0 && timeOfDay < 12) {
                    stringBuilder.append(" am");
                } else if (timeOfDay >= 12 && timeOfDay < 24) {
                    stringBuilder.append(" pm");
                }
                stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append(textinput);
                stringBuilder.append(System.getProperty("line.separator"));

                e.text = stringBuilder.toString();

                m.store(e);
                System.out.println("updates");
                isSearch=false;
                break;
            }
        }
    }

    public void displayTask() {
        try {
            if(isSearch){
                displaysearchtasks();
            } else {
                for (Task t : tasks) {
                    if (!t.getIsDone() && t.getDate().after(new Date())) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(t.getDate());
                        long diff = calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
                        if (diff > 0) {
                            Thread.sleep(diff);


                            String buttonSelected = getString();
                            boolean isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");


                            while (!textArea.getText().trim().isEmpty() || !isHow2ForegertCommand) {
                                Thread.sleep(10000);
                                for (Enumeration<AbstractButton> buttons = c1comehere.untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
                                    AbstractButton button = buttons.nextElement();

                                    if (button.isSelected()) {
                                        buttonSelected = button.getText();
                                    }
                                }
                                isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");


                            }
                            frame.repaint();
                            frame.toFront();
                            currentTask = t;
                            String inntuitive = System.getProperty("line.separator");

                            inntuitive += (" Dufgt ");
                            inntuitive += System.getProperty("line.separator");
                            for (person_question e : ebbinghauses) {
                                if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                                    for (Task ct : e.getTasks()) {
                                        if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                            ct.setIsDone(true);
                                            inntuitive += e.text;
                                            m.store(e);
                                        }
                                    }
                                }
                            }
                            inntuitive += System.getProperty("line.separator");
                            textArea.setText(inntuitive);
                        } else {


                            String buttonSelected = getString();
                            boolean isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");


                            while (!textArea.getText().trim().isEmpty() || !isHow2ForegertCommand) {
                                Thread.sleep(10000);

                                for (Enumeration<AbstractButton> buttons = c1comehere.untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
                                    AbstractButton button = buttons.nextElement();

                                    if (button.isSelected()) {
                                        buttonSelected = button.getText();
                                    }
                                }
                                isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");

                            }
                            frame.repaint();
                            frame.toFront();
                            currentTask = t;
                            String inntuitive = System.getProperty("line.separator");
                            inntuitive += (" Dufgt ");
                            inntuitive += System.getProperty("line.separator");
                            for (person_question e : ebbinghauses) {
                                if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                                    for (Task ct : e.getTasks()) {
                                        if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                            ct.setIsDone(true);
                                            inntuitive += e.text;
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

                        String buttonSelected = getString();
                        boolean isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");


                        while (!textArea.getText().trim().isEmpty() || !isHow2ForegertCommand) {
                            Thread.sleep(10000);
                            for (Enumeration<AbstractButton> buttons = c1comehere.untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
                                AbstractButton button = buttons.nextElement();

                                if (button.isSelected()) {
                                    buttonSelected = button.getText();
                                }
                            }
                            isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("Dufgt") || buttonSelected.equalsIgnoreCase("Ddeldiary");

                        }
                        frame.repaint();
                        frame.toFront();
                        currentTask = t;
                        String inntuitive = System.getProperty("line.separator");
                        inntuitive += (" Dufgt ");
                        inntuitive += System.getProperty("line.separator");
                        for (person_question e : ebbinghauses) {
                            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                                for (Task ct : e.getTasks()) {
                                    if (ct.getDate().getTime() == currentTask.getDate().getTime()) {
                                        ct.setIsDone(true);
                                        inntuitive += e.text;
                                        m.store(e);
                                    }
                                }
                            }
                        }
                        inntuitive += System.getProperty("line.separator");
                        textArea.setText(inntuitive);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getString() {
        String buttonSelected = "";
        for (Enumeration<AbstractButton> buttons = c1comehere.untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                buttonSelected = button.getText();
            }
        }
        return buttonSelected;
    }

    private void displaysearchtasks() {

        for (Task t : searchtasks) {
            currentTaskSearch=t;

            for (person_question e : searchebbinghauses) {
                if (e.getJavauid().toString().equalsIgnoreCase(currentTaskSearch.getJavauuid().toString())) {
                    String inntuitive = "";
                    inntuitive += "\n";
                    inntuitive += " Dufgt ";
                    inntuitive += "\n";

                    inntuitive += (" found! " + count + "/" +searchtasks.size() + " " +keywords);
                    inntuitive +="\n";
                    inntuitive+=e.text;
                    textArea.setText(inntuitive);
                    while (!textArea.getText().trim().equalsIgnoreCase("")) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    count++;
                    isSearch=true;
                }
            }
        }
    }

    public void deltask() {
        for (person_question e : ebbinghauses) {
            if (e.getJavauid().toString().equalsIgnoreCase(currentTask.getJavauuid().toString())) {
                m.deleteTask(e.getJavauid());
                System.out.println("delet the " + e.text);
                if(isSearch==false)reloadTAskandrestartPopThread();
                isSearch=false;
            }
        }
    }


    public void addWord(String word, String answer) {
        person_question pq = new person_question(word, answer,getdatelastday());
        m.store(pq);
        ebbinghauses.add(pq);
        textArea.setText("");
    }

    public void loadTask() {
        ebbinghauses = (ArrayList<person_question>) m.getlatest();
        tasks = new ArrayList<Task>();
        for (person_question e : ebbinghauses) {
            if (e.text.replace("Dufgt", "").trim().isEmpty()){
                m.deleteTask(e.getJavauid());
            } else {
                Set<Task> t = e.tasks;
                for (Task task : t) {
                    tasks.add(task);
                }
            }
        }
        Collections.sort(tasks, new Task());
    }


    public Date getdatelastday() {
        ArrayList<person_question> ebbinghauses2 = (ArrayList<person_question>) m.getlatest();
        ArrayList<DecendingTask> taskstemp = new ArrayList<DecendingTask>();
        for (person_question e : ebbinghauses2) {
            if (e.text.replace("Dufgt", "").trim().isEmpty()){
                m.deleteTask(e.getJavauid());
            } else {
                DecendingTask d = new DecendingTask(e.getDate());
                taskstemp.add(d);
            }
        }
        Collections.sort(taskstemp, new DecendingTask());
        if(null != taskstemp && taskstemp.size()>0) {
            return taskstemp.get(0).getDate();
        }
        return new Date();
    }

    public void searchehabins(String a) {
        textArea.setText("");
        ebbinghauses = (ArrayList<person_question>) m.getlatest();
        searchtasks = new ArrayList<Task>();
        searchebbinghauses=new ArrayList<person_question>();

        keywords=a.trim();
        String[] sts=a.trim().split(" ");
        if(sts.length==0)return;
        for (person_question e : ebbinghauses) {
            boolean flag2=false;
            for (String s : sts){
                flag2 = e.text.contains(s);
                if(!flag2){
                    break;
                }
            }
            if(flag2) {
                for (Task ct : e.getTasks()) {
                    searchtasks.add(ct);
                    searchebbinghauses.add(e);
                    break;
                }
            }
        }
        count=1;
        isSearch = true;
        if (null != searchtasks ) {
            textArea.setText("");
            Collections.sort(searchtasks, new Task());
            reloadandDiskplaypopup(isSearch);
        }
    }
    public void reloadandDiskplaypopup(boolean is) {
        textArea.setText("");
        reloadTAskandrestartPopThread();
    }

    public void reloadandDiskplaypopup() {
        if(!isSearch){
            loadTask();
        }
        displayTask();
    }

    public void inster(String word, String answer) throws IOException {
        addWord(word, answer);
        isSearch=false;
    }

    private void reloadTAskandrestartPopThread() {
        textArea.setText("");
        if (null != reloadandDisplayThread || reloadandDisplayThread.isAlive()) {
            reloadandDisplayThread.interrupt();
        }
        d = new Display(this);
        reloadandDisplayThread = new Thread(d);
        reloadandDisplayThread.start();
    }


    public void init() {
        loadTask();
        d = new Display(this);
        reloadandDisplayThread = new Thread(d);
        reloadandDisplayThread.start();
    }
}

