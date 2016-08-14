package zeng.siyuan.youdontnowshit;

import java.io.Serializable;

/**
 * Created by SiyuanZeng's on 8/8/2016.
 */
public class Shit implements Serializable {
    String question;
    String answer;

    public Shit(String question) {
        this.question = question;
        this.answer ="";
    }

    public Shit(String question, String answer) {
        this.question = question;
        this.answer = answer;

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
