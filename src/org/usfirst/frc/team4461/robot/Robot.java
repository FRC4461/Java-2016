package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**	
 * 
 * @author Team 4461
 * @version 2.6
 * 
 */

public class Robot extends IterativeRobot {
	// Variables
	boolean autoBreak = true; // This determines when to break in the autonomous code (see autonomousPeriodic)
	boolean encTest = true; // Just for testing our encoder
	MoveSequence mover;
	final static int QUAD_TICKS = 1024;	//0.23724365234375 4096 set 10 | 0.7001736111111111 1440 set 10
	
    // CANTalons
    static CANTalon talon1 = new CANTalon(1);
    static CANTalon talon2 = new CANTalon(2);
    static CANTalon talon3 = new CANTalon(3);
    static CANTalon talon4 = new CANTalon(4);

    // Robot Drive
    RobotDrive chassis = new RobotDrive(talon1, talon2, talon3, talon4);

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
    JoystickButton lButton10 = new JoystickButton(leftJoystick, 10);
    JoystickButton lButton11 = new JoystickButton(leftJoystick, 11);
    
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
    JoystickButton rButton10 = new JoystickButton(rightJoystick, 10);
    JoystickButton rButton11 = new JoystickButton(rightJoystick, 11);
    
    public void robotInit() {
    	SmartDashboard.putNumber("P", .001);
    	SmartDashboard.putNumber("I", 0);
    	SmartDashboard.putNumber("D", 0);
    }//End roboInit
    
    public void autonomousInit() {
    	mover = new MoveSequence();
    	mover.init();
    	autoBreak = true; // Resets the autonomous break
    	chassis.setSafetyEnabled(true); // Allows us to do autonomous
    }//End autonomousInit
    
    public void autonomousPeriodic() {
    	while(autoBreak) { // Put auto code above the "autoBreak = false;" line.
    		mover.move();
    		autoBreak = false;
    	}//End While
    }//End autonomousPeriodic
    
    public void teleopInit() {
    }//End teleopInit
    
    public void teleopPeriodic() {
    	chassis.tankDrive(-leftJoystick.getY(), -rightJoystick.getY()); // Really basic drive for testing.
    }//End teleopPeriodic

    public void testInit() {
		 talon1.setPosition(0);
		 talon2.setPosition(0);
		 talon3.setPosition(0);
		 talon4.setPosition(0);
    }//End testInit

    public void testPeriodic() {
    	
    	if(lButton1.get()){
    		talon4.reset();
    		talon4.disable();
    	}
    	
    	if(rButton1.get()){
    		talon4.reset();
    		talon4.disable();
    	}
    		
    	
    	 boolean Pressed = lButton6.get();
    	
    	 boolean otherPressed = lButton5.get();
    	 
    	 if (otherPressed) {
    		double P = SmartDashboard.getNumber("P", .001);
    	 	double I = SmartDashboard.getNumber("I", 0);
    	 	double D = SmartDashboard.getNumber("D", 0);
    	 	QuadSet.talonLoad(P, I, D);
    	 }

		 SmartDashboard.putNumber("PosP", talon4.get());
    	 if(Pressed){
    		 talon1.set(3);
    		 talon2.set(3);
    		 talon3.set(3);
    		 talon4.set(1);
    	 }
    	 else{
    		 talon1.setPosition(0);
    		 talon2.setPosition(0);
    		 talon3.setPosition(0);
    		 //talon4.setPosition(0);
    		 talon1.set(0);
    		 talon2.set(0);
    		 talon3.set(0);
    		 //talon4.set(0);
    	 }
    
    }//End testPeriodic
    
}//End Class Robot