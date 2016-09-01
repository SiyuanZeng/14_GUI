package zeng.siyuan.howt2forgert;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Task implements Comparator<Task>, Serializable {
    Date date;

    public boolean isDone = false;// 20 munites
    public UUID Javauuid;
    public Task() {}

    public Ebbinghaus relatecebbinhause;


    public Task(Date date, UUID javauid) {
        this.date = date;
        this.Javauuid =  javauid;
    }


    @Override
    public int compare(Task o1, Task o2) {
        if(o1.getDate().after(o2.getDate())){
            System.out.println("Date1 is after Date2");
            return 1;
        }

        if(o1.getDate().before(o2.getDate())){
            System.out.println("Date1 is before Date2");
            return -1;
        }

        if(o1.getDate().equals(o2.getDate())){
            System.out.println("Date1 is equal Date2");
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

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}
