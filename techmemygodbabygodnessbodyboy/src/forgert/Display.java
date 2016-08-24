package forgert;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Display implements Runnable {
    private volatile boolean running = true;
    private Frame f =null;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Frame getF() {
        return f;
    }

    public void setF(Frame f) {
        this.f = f;
    }

    public Display(Frame f){
        this.f = f;
    }


    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (f.getTasks().size()==0){
                    running = false;
                }
                f.popup();
            } catch (Exception e) {
                running = false;
            }
        }

    }
}
