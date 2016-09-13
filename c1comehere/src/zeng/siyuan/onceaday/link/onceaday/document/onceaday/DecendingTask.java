package zeng.siyuan.onceaday.link.onceaday.document.onceaday;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
@UDT(keyspace = "keyspace1", name = "type4")
public class DecendingTask implements Comparator<DecendingTask>, Serializable {
//    @Field
    @Field(name="date")
    Date date;
    @Field(name="isdone")
    public boolean isDone = false;// 20 munites
    @Field(name="javauuid")
    public UUID Javauuid;




    public DecendingTask(Date date, UUID javauid) {
        this.date = date;
        this.Javauuid =  javauid;
    }


    @Override
    public int compare(DecendingTask o1, DecendingTask o2) {
        if(o1.getDate().after(o2.getDate())){
            return -1;
        }

        if(o1.getDate().before(o2.getDate())){
            return 1;
        }

        if(o1.getDate().equals(o2.getDate())){
            return 0;
        }
        return 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public UUID getJavauuid() {
        return Javauuid;
    }

    public void setJavauuid(UUID javauuid) {
        Javauuid = javauuid;
    }

    public DecendingTask(Date date, boolean isDone, UUID javauuid) {
        this.date = date;
        this.isDone = isDone;
        Javauuid = javauuid;
    }

    public DecendingTask() {}

    public DecendingTask(Date d) {
        this.date=d;
    }

    public DecendingTask(boolean isDone, UUID javauuid) {
        this.isDone = isDone;
        Javauuid = javauuid;
    }
}


