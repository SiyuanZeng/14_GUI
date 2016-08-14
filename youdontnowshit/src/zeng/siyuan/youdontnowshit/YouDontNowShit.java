package zeng.siyuan.youdontnowshit;

import java.io.*;

//Created by Real
public class YouDontNowShit implements Serializable{
    private static final long serialVersionUID = 1L;

    private static Frame e;

    public static void main(String[] args) {
        deserialize();
        if (null == e){
            e = new Frame();
        }
        e.showFrame();
    }


    public static void deserialize(){
        try
        {
            FileInputStream fileIn = new FileInputStream("c:/c1/youdontnowshit/v1/youdontnowshit.ser");
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
