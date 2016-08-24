package com.capgeminisdm.todolist.fest.fixture;

import org.fest.swing.core.KeyPressInfo;
import org.fest.swing.core.MouseButton;
import org.fest.swing.core.MouseClickInfo;
import org.fest.swing.core.Robot;
import org.fest.swing.fixture.CommonComponentFixture;
import org.fest.swing.fixture.ComponentFixture;
import org.fest.swing.fixture.FocusableComponentFixture;
import org.fest.swing.fixture.KeyboardInputSimulationFixture;
import org.fest.swing.fixture.MouseInputSimulationFixture;
import org.fest.swing.fixture.StateVerificationFixture;
import org.fest.swing.timing.Timeout;
import org.jdesktop.swingx.JXDatePicker;

import com.capgeminisdm.todolist.fest.driver.JXDatePickerDriver;

/**
 * @author <a href="mailto:dominik.dary@capgemini-sdm.com">Dominik Dary</a>
 * 
 */
public class JXDatePickerFixture extends ComponentFixture<JXDatePicker> {

	public JXDatePickerFixture(Robot robot, Class<? extends JXDatePicker> type) {
		super(robot, type);
		driver = new JXDatePickerDriver(robot);
	}

	public JXDatePickerFixture(Robot robot, JXDatePicker target) {
		super(robot, target);
		driver = new JXDatePickerDriver(robot);
	}

	public JXDatePickerFixture(Robot robot, String name,
			Class<? extends JXDatePicker> type) {
		super(robot, name, type);
		driver = new JXDatePickerDriver(robot);
	}

	private JXDatePickerDriver driver;

	/**
	 * Enter the given text.
	 * 
	 * @param text
	 *            the text to enter
	 * @return this
	 */
	public JXDatePickerFixture enterText(String text) {
		driver.enterText(target, text);
		return this;
	}
}
