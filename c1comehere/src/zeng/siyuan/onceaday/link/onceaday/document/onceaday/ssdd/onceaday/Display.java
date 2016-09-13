package zeng.siyuan.onceaday.link.onceaday.document.onceaday.ssdd.onceaday;


/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Display implements Runnable {
    private volatile boolean running = true;
    private How2Forgert f =null;


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public How2Forgert getF() {
        return f;
    }

    public void setF(How2Forgert f) {
        this.f = f;
    }

    public Display(How2Forgert f){
        this.f = f;
    }


    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (f.tasks.size()==0){
                    running = false;
                }
                f.reloadandDiskplaypopup();
            } catch (Exception e) {
                running = false;
            }
        }

    }
}
