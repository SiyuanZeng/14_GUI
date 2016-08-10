package org.chabala.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionUI extends JFrame{
	JTextField txtNumber1;
	JTextField txtNumber2;
	JTextField txtSum;
	JButton bttnAdd;
	JButton bttnClear;
	Calculator calc;
	
	public AdditionUI(Calculator c){
		calc = c;
		setLayout(new GridLayout(4, 4));
		setSize(250,150);
		add(new JLabel("First Number: "));
 		add(txtNumber1  = new JTextField(10));
 		
 		add(new JLabel("Second Number: "));
 		add(txtNumber2  = new JTextField(10));
 		
 		add(new JLabel("Sum: "));
 		add(txtSum  = new JTextField(10));
 		txtSum.setEnabled(false);
 		
 		ActionListener l = new AdditionListener();
 		bttnAdd = new JButton("Add");
 		bttnAdd.addActionListener(l);
 		add(bttnAdd);
 		
 		bttnClear = new JButton("Clear");
 		bttnClear.addActionListener(l);
 		add(bttnClear);
	}
	
	private class AdditionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bttnAdd){
				addNumbers();
			}else if(e.getSource()== bttnClear){
				clearFields();
			}
		}
		
		private void addNumbers(){
			try{
				calc.setOperand1(Double.parseDouble(txtNumber1.getText()));
				calc.setOperand2(Double.parseDouble(txtNumber2.getText()));
				calc.add();
				txtSum.setText(String.valueOf(calc.getResult()));
			}catch(Exception ex){
				JOptionPane.showMessageDialog(AdditionUI.this, "Error occured computing sum");
				ex.printStackTrace();
			}
		}
		
		private void clearFields(){
			txtNumber1.setText("");
			txtNumber2.setText("");
			txtSum.setText("");
		}
	}
	
	public static void main(String args[]){
		Calculator calc = new Calculator();
		JFrame app = new AdditionUI(calc);
		app.setTitle("Sum Application");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}

