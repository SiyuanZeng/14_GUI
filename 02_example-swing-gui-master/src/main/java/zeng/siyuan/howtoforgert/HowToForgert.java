package zeng.siyuan.howtoforgert;

import java.io.*;
//Created by Real
public class HowToForgert implements Serializable{
    private static final long serialVersionUID = 1L;

    private static Frame e;

    private static Display d;
    private static Add add;

    private static Thread threadD;
    private static Thread threadadd;

    public static void main(String[] args) {
        deserialize();
        if (null == e){
            e = new Frame();
        }


        d = new Display(e);
        threadD = new Thread(d);
        threadD.start();
        e.setD(d);
        e.setThreadD(threadD);

        add = new Add(e);
        add.run();
    }



    public static void deserialize(){
        try
        {
            FileInputStream fileIn = new FileInputStream("c:/HowToForgert/howtoforgert.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Frame) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f){
            System.out.println("File not found");
            e = new Frame();
            f.printStackTrace();
            return;
        } catch(IOException i)
        {
            i.printStackTrace();
            return;
        } catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            e = new Frame();
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
    }
}
