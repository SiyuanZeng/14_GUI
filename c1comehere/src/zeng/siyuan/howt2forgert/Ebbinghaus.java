package zeng.siyuan.howt2forgert;

 import  com.datastax.driver.mapping.annotations.*;

 import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by SiyuanZeng's on 8/8/2016.
 */


@Table(keyspace = "keyspace1", name = "ebbinhance6",
        readConsistency = "QUORUM",
        writeConsistency = "QUORUM",
        caseSensitiveKeyspace = false,
        caseSensitiveTable = false)

public class Ebbinghaus implements Serializable{
    // column name does not match field name
//    @Column(name = "question")

//    @Field
@org.apache.solr.client.solrj.beans.Field
    @PartitionKey
    @Column(name = "id")
    public UUID javauid;
//    @Field
@org.apache.solr.client.solrj.beans.Field
    @Column(name = "question")
    String question;
//    @Field
@org.apache.solr.client.solrj.beans.Field
    @FrozenValue
    @Column(name = "tasks")
    Set<Task> tasks;

    //        20 minutes
    @Transient
    public Task first;// 20 munites
    //        1 hour
    @Transient
    public Task second; // 1 hour
    //        9 hours
    @Transient
    public Task third;
    //        1 day
    @Transient
    public Task fourth;
    //        2 sdays
    @Transient
    public Task fifth;
    //        6 days
    @Transient
    public Task sixth;
    //        31 days
    @Transient
    public Task seventh;


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
        this.javauid = java.util.UUID.randomUUID();

        tasks = new HashSet<Task>();

        StringBuilder stringBuilder = new StringBuilder();

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

        if (timeOfDay >= 0 && timeOfDay < 12) {
            stringBuilder.append(" am");
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(question);
        } else if (timeOfDay >= 12 && timeOfDay < 24) {
            stringBuilder.append(" pm");
            stringBuilder.append(System.getProperty("line.separator"));
            stringBuilder.append(question);
        }

        this.question = stringBuilder.toString();

        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

        long curTimeInMs = new Date().getTime();
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


    }


    public Ebbinghaus(String question, HashSet<Task> tasks, Task first, Task second, Task third, Task fourth, Task fifth, Task sixth, Task seventh, UUID javauid) {
        this.question = question;
        this.tasks = tasks;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.javauid = javauid;
    }


    public Ebbinghaus(String question, UUID javauid, HashSet<Task> tasks, Task first, Task second, Task third, Task fourth, Task fifth, Task sixth, Task seventh) {
        this.question = question;
        this.javauid = javauid;
        this.tasks = tasks;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public UUID getJavauid() {
        return javauid;
    }

    public void setJavauid(UUID javauid) {
        this.javauid = javauid;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
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
}
