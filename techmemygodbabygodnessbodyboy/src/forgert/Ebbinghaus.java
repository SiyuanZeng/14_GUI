package forgert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SiyuanZeng's on 8/8/2016.
 */
public class Ebbinghaus implements Serializable {

    Date date;
    String word ;
    ArrayList<Task> tasks = new ArrayList<Task>();

    //        20 minutes
    private Task first;// 20 munites
    //        1 hour
    private Task second; // 1 hour
    //        9 hours
    private Task third;
    //        1 day
    private Task fourth;
    //        2 sdays
    private Task fifth;
    //        6 days
    private Task sixth;
    //        31 days
    private Task seventh;


    public Ebbinghaus(String question, String answer) {
        this.date = new Date();
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

        long curTimeInMs = date.getTime();
        first = new Task(new Date(curTimeInMs + (20 * ONE_MINUTE_IN_MILLIS)), question, answer);
        second = new Task(new Date(curTimeInMs + (60 * ONE_MINUTE_IN_MILLIS)), question, answer );
        third = new Task(new Date(curTimeInMs + (540 * ONE_MINUTE_IN_MILLIS)), question, answer );
        fourth = new Task(new Date(curTimeInMs + (24*60 * ONE_MINUTE_IN_MILLIS)), question, answer );
        fifth = new Task(new Date(curTimeInMs + (2*24*60 * ONE_MINUTE_IN_MILLIS)), question, answer );
        sixth = new Task(new Date(curTimeInMs + (6*24*60 * ONE_MINUTE_IN_MILLIS)), question, answer );
        seventh = new Task(new Date(curTimeInMs + (31*24*60 * ONE_MINUTE_IN_MILLIS)), question, answer );
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
