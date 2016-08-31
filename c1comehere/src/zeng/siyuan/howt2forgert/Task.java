package zeng.siyuan.howt2forgert;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Task implements Comparator<Task>, Serializable {
    Date date;
    String question;
    String answer;
    private boolean isDone = false;// 20 munites

    public Task() {}


    public Task(Date date, String question, String answer) {
        this.date = date;
        this.question = question;
        this.answer = answer;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
