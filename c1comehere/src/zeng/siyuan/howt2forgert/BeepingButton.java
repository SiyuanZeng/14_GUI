package zeng.siyuan.howt2forgert;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SiyuanZeng's on 8/11/2016.
 */
public class BeepingButton extends JButton {
    BeepingButton(final String text) {
        super(text);
        setPreferredSize(new Dimension(140, 60));
    }
}
