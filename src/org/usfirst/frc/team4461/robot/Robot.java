package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CameraServer;

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
	
	MoveSequence mover;
	
	final static int QUAD_TICKS = 4096;
	//0.23724365234375 4096 set 10
	// 0.7001736111111111 1440 set 10
	
    // CANTalons
    static CANTalon talon1 = new CANTalon(1);
    static CANTalon talon2 = new CANTalon(2);
    static CANTalon talon3 = new CANTalon(3);
    static CANTalon talon4 = new CANTalon(4);
    
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
    
    //Pneumatics
    Solenoid solOne = new Solenoid(1, 2);
    Solenoid solTwo = new Solenoid(3, 4);
    
    Compressor comp = new Compressor(1);
    
    public void robotInit() {
    	
    }
    
    public void autonomousInit() {
    	mover = new MoveSequence();
    	
    	mover.init();
    	autoBreak = true; // Resets the autonomous break
    	chassis.setSafetyEnabled(true); // Allows us to do autonomous
    }
    
    public void autonomousPeriodic() {
    	while(autoBreak) { // Put auto code above the "autoBreak = false;" line.
    		mover.move();
    		autoBreak = false;
    	}
    }
    
    public void teleopInit() {
    	// Initializes our planetary encoder hooked up to our CANTalon
    	encTest = true;
    	talon1.changeControlMode(TalonControlMode.Position);
    	talon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	talon1.setPID(.001, 0, 0);
    	talon1.configEncoderCodesPerRev(QUAD_TICKS); //___ for 90 degrees
    	talon1.enableControl();
		talon1.setPosition(0);
    	System.out.println("comcom");
//		talon1.set(0);
    	//Only use on motor's above 4
    	//Motors 1-4 are used for Tank Drive
    	// Currently set to motor 1 for testing
    }
    
    public void teleopPeriodic() {
    	printPos(talon1);
    	talon1.enableControl();
//    	chassis.tankDrive(-leftJoystick.getY(), -rightJoystick.getY()); // Really basic drive for testing.
    		printPos(talon1);
    		talon1.set(1);
    		printPos(talon1);
    		
    	//Pneumatics
    	if (lButton1.get()){
    		comp.enabled();
    		comp.start();
    	}
    	else{
    	}
    		
		if (rButton1.get()) {
			solOne.set(true);
		} else {
			solOne.set(false);
		}
		if (rButton2.get()) {
			solTwo.set(true);
		} else {
			solTwo.set(false);
			
		}
    }
    
    public void printPos(CANTalon talon) {
    	System.out.println("Pos: " + talon.getPosition());
    }
    
    public void printEncPos(CANTalon talon) {
    	System.out.println("Enc Pos: " + talon.getEncPosition());
    }
    
}