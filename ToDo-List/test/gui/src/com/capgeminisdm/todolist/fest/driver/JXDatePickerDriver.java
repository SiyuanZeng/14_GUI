/**
 * 
 */
package com.capgeminisdm.todolist.fest.driver;

import org.fest.swing.core.Robot;
import org.fest.swing.driver.ComponentDriver;
import org.fest.swing.driver.JTextComponentDriver;
import org.jdesktop.swingx.JXDatePicker;

/**
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 *
 */
public class JXDatePickerDriver extends ComponentDriver {

	   private final JTextComponentDriver textComponentDriver;

	   public JXDatePickerDriver(Robot robot) {
	      super(robot);
	      this.textComponentDriver = new JTextComponentDriver(robot);
	   }

	   /**
	    * Enter the given text.
	    * 
	    * @param datePicker
	    *           the jxDatePicker
	    * @param text
	    *           the entered text
	    */
	   public void enterText(JXDatePicker datePicker, String text) {
	      textComponentDriver.enterText(datePicker.getEditor(), text);
	   }
}
