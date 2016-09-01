package zeng.siyuan.howt2forgert;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by SiyuanZeng's on 8/8/2016.
 */
public class Ebbinghaus implements Serializable {
    String question;
    String answer;

    Date date;
    String word;

    ArrayList<Task> tasks = new ArrayList<Task>();

    //        20 minutes
    public Task first;// 20 munites
    //        1 hour
    public Task second; // 1 hour
    //        9 hours
    public Task third;
    //        1 day
    public Task fourth;
    //        2 sdays
    public Task fifth;
    //        6 days
    public Task sixth;
    //        31 days
    public Task seventh;

    public UUID javauid;

    public Ebbinghaus() {

    }

    public void setUUID() {
        if (null == javauid) {
            this.javauid = java.util.UUID.randomUUID();
            first.Javauuid = javauid;
            second.Javauuid = javauid;
            third.Javauuid = javauid;
            fourth.Javauuid = javauid;
            fifth.Javauuid = javauid;
            sixth.Javauuid = javauid;
            seventh.Javauuid = javauid;
        }
    }

    public Ebbinghaus(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.javauid = java.util.UUID.randomUUID();


        StringBuilder stringBuilder = new StringBuilder();
        this.date = new Date();

        Calendar c = Calendar.getInstance();

        c.set(2013, Calendar.MARCH, 10, 1, 58);

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

        if (timeOfDay >= 0 && timeOfDay < 12) {
            stringBuilder.append(" am");
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(question);
        } else if (timeOfDay >= 12 && timeOfDay < 24) {
            stringBuilder.append(" pm");
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(question);
        }


        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

        long curTimeInMs = date.getTime();
        first = new Task(new Date(curTimeInMs + (20 * ONE_MINUTE_IN_MILLIS)), javauid);
        second = new Task(new Date(curTimeInMs + (60 * ONE_MINUTE_IN_MILLIS)), javauid);
        third = new Task(new Date(curTimeInMs + (540 * ONE_MINUTE_IN_MILLIS)), javauid);
        fourth = new Task(new Date(curTimeInMs + (24 * 60 * ONE_MINUTE_IN_MILLIS)), javauid);
        fifth = new Task(new Date(curTimeInMs + (2 * 24 * 60 * ONE_MINUTE_IN_MILLIS)), javauid);
        sixth = new Task(new Date(curTimeInMs + (6 * 24 * 60 * ONE_MINUTE_IN_MILLIS)), javauid);
        seventh = new Task(new Date(curTimeInMs + (31 * 24 * 60 * ONE_MINUTE_IN_MILLIS)), javauid);

        tasks.add(first);
        tasks.add(second);
        tasks.add(third);
        tasks.add(fourth);
        tasks.add(fifth);
        tasks.add(sixth);
        tasks.add(seventh);

        this.word = question;
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getFirst() {
        return first;
    }

    public void setFirst(Task first) {
        this.first = first;
    }

    public Task getSecond() {
        return second;
    }

    public void setSecond(Task second) {
        this.second = second;
    }

    public Task getThird() {
        return third;
    }

    public void setThird(Task third) {
        this.third = third;
    }

    public Task getFourth() {
        return fourth;
    }

    public void setFourth(Task fourth) {
        this.fourth = fourth;
    }

    public Task getFifth() {
        return fifth;
    }

    public void setFifth(Task fifth) {
        this.fifth = fifth;
    }

    public Task getSixth() {
        return sixth;
    }

    public void setSixth(Task sixth) {
        this.sixth = sixth;
    }

    public Task getSeventh() {
        return seventh;
    }

    public void setSeventh(Task seventh) {
        this.seventh = seventh;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
