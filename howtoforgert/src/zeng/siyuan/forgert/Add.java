package zeng.siyuan.forgert;

import javax.swing.*;

/**
 * Created by SiyuanZeng's on 8/9/2016.
 */
public class Add implements Runnable {
    private Frame f =null;

    public Add( Frame f ){
        this.f = f;
        System.out.println("Creating Add " );
    }
    public void run() {
        SwingUtilities.invokeLater(f::showFrame);
    }
}
