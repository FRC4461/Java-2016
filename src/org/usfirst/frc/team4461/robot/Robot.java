package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * @author Team 4461
 * @version 2.2
 * 
 */

public class Robot extends IterativeRobot {
	// Variables
	boolean autoBreak = true; // This determines when to break in the autonomous code (see autonomousPeriodic)
	boolean encTest = true; // Just for testing our encoder
	
    // CANTalons
    CANTalon talon1 = new CANTalon(1);
    CANTalon talon2 = new CANTalon(2);
    CANTalon talon3 = new CANTalon(3);
    CANTalon talon4 = new CANTalon(4);
    
    // Joysticks
    Joystick leftJoystick = new Joystick(0);
    Joystick rightJoystick = new Joystick(1);
    
    // Left Joystick Buttons
    JoystickButton lButton1 = new JoystickButton(leftJoystick, 1);
    JoystickButton lButton2 = new JoystickButton(leftJoystick, 2);
    JoystickButton lButton3 = new JoystickButton(leftJoystick, 3);
    JoystickButton lButton4 = new JoystickButton(leftJoystick, 4);
    JoystickButton lButton5 = new JoystickButton(leftJoystick, 5);
    JoystickButton lButton6 = new JoystickButton(leftJoystick, 6);
    JoystickButton lButton7 = new JoystickButton(leftJoystick, 7);
    JoystickButton lButton8 = new JoystickButton(leftJoystick, 8);
    JoystickButton lButton9 = new JoystickButton(leftJoystick, 9);
    
    // Right Joystick Buttons
    JoystickButton rButton1 = new JoystickButton(rightJoystick, 1);
    JoystickButton rButton2 = new JoystickButton(rightJoystick, 2);
    JoystickButton rButton3 = new JoystickButton(rightJoystick, 3);
    JoystickButton rButton4 = new JoystickButton(rightJoystick, 4);
    JoystickButton rButton5 = new JoystickButton(rightJoystick, 5);
    JoystickButton rButton6 = new JoystickButton(rightJoystick, 6);
    JoystickButton rButton7 = new JoystickButton(rightJoystick, 7);
    JoystickButton rButton8 = new JoystickButton(rightJoystick, 8);
    JoystickButton rButton9 = new JoystickButton(rightJoystick, 9);
    
    // Robot Drive
    RobotDrive chassis = new RobotDrive(talon1, talon2, talon3, talon4);
    
    public void robotInit() {
    	
    }
    
    public void autonomousInit() {
    	autoBreak = true; // Resets the autonomous break
    	chassis.setSafetyEnabled(false); // Allows us to do autonomous
    }
    
    public void autonomousPeriodic() {
    	while(autoBreak) { // Put auto code above the "autoBreak = false;" line.
    		
    		autoBreak = false;
    	}
    }
    
    public void teleopInit() {
    	// Initializes our planetary encoder hooked up to our CANTalon
    	encTest = true;
    	talon1.changeControlMode(TalonControlMode.Position);
    	talon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	talon1.setPID(.0001, 0, 0);
    	talon1.configEncoderCodesPerRev(1440);
    	talon1.enableControl();
    	//Only use on CANTalon's above 4
    	//CANTalon 1-4 are used for Tank Drive
    	//Currently set to CANTalon 1 for testing
    }
    
    public void teleopPeriodic() {
    	talon1.enableControl();
    	chassis.tankDrive(-leftJoystick.getY(), -rightJoystick.getY()); // Really basic drive for testing.
    	
    	if(lButton1.get() && encTest) {
    		printPos(talon1);
    		printEncPos(talon1);
    		talon1.set(1440);
    		printPos(talon1);
    		printEncPos(talon1);
    		encTest = false;
    	}
    }
    
    public void printPos(CANTalon talon) {
    	System.out.println("Pos: " + talon.getPosition());
    }
    
    public void printEncPos(CANTalon talon) {
    	System.out.println("Enc Pos: " + talon.getEncPosition());
    }
    
}
