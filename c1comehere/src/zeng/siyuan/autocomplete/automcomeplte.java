package zeng.siyuan.autocomplete;

import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by SiyuanZeng's on 9/5/2016.
 */
public class automcomeplte {
    JFrame f=new JFrame();
    JTextField t1;

    automcomeplte () throws ClassNotFoundException, SQLException {

            f.setSize(500,500);
            f.setLocation(500,100);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            f.setVisible(true);


            t1=new JTextField();
            t1.setBounds(50,80,200,20);
            f.add(t1);


            TextAutoCompleter complete=new TextAutoCompleter(t1);
            complete.addItem("number");
            complete.addItem("number");

        }


        public static void main(String[] args) {
            try {
                automcomeplte a = new automcomeplte();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
