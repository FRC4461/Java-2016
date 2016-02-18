package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;

/**
 * @author ramen 4461
 * @version 1.0 - Test for github Push
 */

public class Robot extends IterativeRobot {
		
// Variables
	boolean autoBreak = true; // This determines when to break in the autonomous code (see autonomousPeriodic)	
    boolean done = false;
    double currentPosition;
	
//	Motor's
	CANTalon talon1 = new CANTalon(1);
	CANTalon talon2 = new CANTalon(2);
	CANTalon talon3 = new CANTalon(3);
	CANTalon talon4 = new CANTalon(4);
		
	 
//	Encoder
	Encoder encoder = new Encoder(7,8);
	
	FeedbackDevice encoderFeedback;
	
//	Joysticks
	Joystick leftJoystick = new Joystick(0);
	Joystick rightJoystick = new Joystick(1);
	
//Left Buttons
	JoystickButton lbutton1 = new JoystickButton(leftJoystick, 1);
	JoystickButton lbutton2 = new JoystickButton(leftJoystick, 2);
	JoystickButton lbutton3 = new JoystickButton(leftJoystick, 3);
	JoystickButton lbutton4 = new JoystickButton(leftJoystick, 4);
	JoystickButton lbutton5 = new JoystickButton(leftJoystick, 5);
	JoystickButton lbutton6 = new JoystickButton(leftJoystick, 6);
	JoystickButton lbutton7 = new JoystickButton(leftJoystick, 7);
	JoystickButton lbutton8 = new JoystickButton(leftJoystick, 8);
	JoystickButton lbutton9 = new JoystickButton(leftJoystick, 9);
	
//Right Buttons
	JoystickButton rbutton1 = new JoystickButton(rightJoystick, 1);
	JoystickButton rbutton2 = new JoystickButton(rightJoystick, 2);
	JoystickButton rbutton3 = new JoystickButton(rightJoystick, 3);
	JoystickButton rbutton4 = new JoystickButton(rightJoystick, 4);
	JoystickButton rbutton5 = new JoystickButton(rightJoystick, 5);
	JoystickButton rbutton6 = new JoystickButton(rightJoystick, 6);
	JoystickButton rbutton7 = new JoystickButton(rightJoystick, 7);
	JoystickButton rbutton8 = new JoystickButton(rightJoystick, 8);
	JoystickButton rbutton9 = new JoystickButton(rightJoystick, 9);
	
//	RobotDrive
	RobotDrive chassis = new RobotDrive(talon1, talon2, talon3, talon4);

/*
 * 1 = Back Left
 * 2 = Front Left
 * 3 = Back Right
 * 4 = Front right
 */

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
		talon4.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon4.changeControlMode(TalonControlMode.Position);
		talon4.enableControl();
		talon4.setPID(0.1, .005, 0);
		talon4.setPosition(0);
	}
    public void teleopPeriodic() { // This is teleop	   
 	   chassis.tankDrive(-leftJoystick.getY(), -rightJoystick.getY());
 	   
 	   if(rbutton4.get()) {
 		   talon4.setPosition(50);
 		   printPos(talon4);
 		   resetTalon(talon4);
 	   }
 	   if(rbutton3.get()) {
 		   talon4.setPosition(25);
 		   printPos(talon4);
 		   resetTalon(talon4);
 	   }
    }
    
    public void resetTalon(CANTalon talon) {
    	talon.setPosition(0);
    	currentPosition = talon.getPosition();
    }
    
    public void printPos(CANTalon talon) {
    	System.out.println(talon.getPosition());
    }
}