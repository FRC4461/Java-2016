package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;

/**	
 * 
 * @author Team 4461
 * @version 3.0
 * 
 */

public class Robot extends IterativeRobot {
	
	// Variables
	boolean autoBreak = true; // This determines when to break in the autonomous code (see autonomousPeriodic)
	//
	double AngleA = ctalon1.getPosition();
	double AngleB = ctalon2.getPosition();
	boolean Lock = true; 
	final static int QUAD_TICKS = 1024;
	
    // CANTalons
    static CANTalon ctalon1 = new CANTalon(1);	//TANKDRIVE RIGHT MOTOR
    static CANTalon ctalon2 = new CANTalon(2);	//TANKDRIVE RIGHT MOTOR
    static CANTalon ctalon3 = new CANTalon(3);	//TANKDRIVE LEFT MOTOR
    static CANTalon ctalon4 = new CANTalon(4);	//TANKDRIVE LEFT MOTOR
    static CANTalon ctalon5 = new CANTalon(5);	//Right wheel
    static CANTalon ctalon6 = new CANTalon(6);	//top
    
//    //Talons
    static Talon talon1 = new Talon(9);	//Left Shooter

    // Robot Drive
    RobotDrive chassis = new RobotDrive(ctalon1, ctalon2, ctalon3, ctalon4);
    
    //Solenoid
    Solenoid SD = new Solenoid(1);

    // Joysticks
    Joystick leftJoystick = new Joystick(0);
    Joystick rightJoystick = new Joystick(1);
    Joystick xBox = new Joystick(2);
    
    // Xbox Controller Buttons
    JoystickButton xButton1 = new JoystickButton(xBox, 1);// A
    JoystickButton xButton2 = new JoystickButton(xBox, 2);// B
    JoystickButton xButton3 = new JoystickButton(xBox, 3);// X
    JoystickButton xButton4 = new JoystickButton(xBox, 4);// Y
    JoystickButton xButton5 = new JoystickButton(xBox, 5);// LB
    JoystickButton xButton6 = new JoystickButton(xBox, 6);// RB
    JoystickButton xButton7 = new JoystickButton(xBox, 7);// Back Button
    JoystickButton xButton8 = new JoystickButton(xBox, 8);// Menu
    JoystickButton xButton9 = new JoystickButton(xBox, 9);// LTrig pressed
    JoystickButton xButton10 = new JoystickButton(xBox, 10);// RTrig pressed
    
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
    
//    public void autonomousInit() {
//    	mover = new MoveSequence();
//    	mover.init();
//    	autoBreak = true; // Resets the autonomous break
//    	chassis.setSafetyEnabled(true); // Allows us to do autonomous
//    }//End autonomousInit
    
//    public void autonomousPeriodic() {
//    	while(autoBreak) { // Put auto code above the "autoBreak = false;" line.
//    		mover.move();
//    		autoBreak = false;
//    	}//End While
//    }//End autonomousPeriodic

    public void teleopPeriodic() {
    	chassis.tankDrive(leftJoystick.getY()*.9, rightJoystick.getY()*.9); // Really basic drive for testing

    	if(xButton1.get()){//Ball Retrive
    		ctalon5.set(.75);
    		talon1.set(.75);
    	}//End if
    	else if(xButton2.get()){//Half Power Shoot
    		ctalon5.set(-.5);
    		talon1.set(-.5);
    	}
    	else if(xButton3.get()){//Full Power Shoot
    		ctalon5.set(-.8);
    		talon1.set(-.8); 
    	}
    	else{
    		ctalon5.set(0);
    		talon1.set(0);
    	}
    	if(xButton1.get()){
    		ctalon6.set(-.75);
    	}
    	else if(xButton4.get()){
    		ctalon6.set(.5);
    	}
    	else{
    		ctalon6.set(0);
    	}
    }//End teleopPeriodic

    public void testPeriodic() {
    	ctalon1.set(.1);
    	ctalon2.set(.1);
    	ctalon3.set(.1);
    	ctalon4.set(.1);
    }//End testPeriodic
    
}//End Class Robot