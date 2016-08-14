package es.uvigo.esei.dojos.swing.todo;

import es.uvigo.esei.dojos.swing.todo.gui.MainWindow;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class TodoApp {
	private static final long serialVersionUID = 1L;

	private static MainWindow window;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {


		configureLookAndFeel();
		deserialize();
		if (null == window){
			window = new MainWindow();
		}
		setSerializeBeforeCloseWindow();
		window.setLocationRelativeTo( null );
		window.setVisible(true);
	}

	private static void configureLookAndFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("GTK+".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break; //preferred!
		        }
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		        }
		    }
		} catch (Exception e) {}
	}

	public static void deserialize(){
		try
		{
			FileInputStream fileIn = new FileInputStream("c:/c1/todosimple/v1/todosimple.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			window = (MainWindow) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException f){
			System.out.println("File not found");
			window = new MainWindow();
			f.printStackTrace();
			return;
		} catch(IOException i)
		{
			i.printStackTrace();
			return;
		} catch(ClassNotFoundException c)
		{
			System.out.println("MainWindow class not found");
			window = new MainWindow();
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized MainWindow...");
	}


	private static void setSerializeBeforeCloseWindow() {
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(window,
						"Are you sure to close this window?", "Really Closing?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					serialize();
					System.exit(0);

				}
			}
		});
	}


	public static void serialize(){
		try
		{
			FileOutputStream fileOut =
					new FileOutputStream("c:/c1/todosimple/v1/todosimple.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(window);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in c:/c1/todosimple/v1/todosimple.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
}
