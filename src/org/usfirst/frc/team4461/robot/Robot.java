package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

/**
 * @author ramen 4461
 * @version 1.0
 */

/*
 * 5 = Grab Thing Backwards
 * 6 = Grab Thing Forward
 */

public class Robot extends IterativeRobot {
//    Talon, Victor, CANTalon Motors
    Talon motor1 = new Talon(1);
    Talon motor2 = new Talon(2);
    Talon motor3 = new Talon(3);
    Talon motor4 = new Talon(4);
    Victor motor5 = new Victor(5);
    Victor motor6 = new Victor(6);
    Encoder pEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    CANTalon canMotor = new CANTalon(1);

    
//    Joysticks
    Joystick leftJoystick = new Joystick(0);
    Joystick rightJoystick = new Joystick(1);
    
// cantalon
    
    
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
    
//    RobotDrive
    RobotDrive chassis = new RobotDrive(motor1, motor2, motor3, motor4);
    
/*
 * 1 = Back Left
 * 2 = Front Left
 * 3 = Back Right
 * 4 = Front right
 */
        
//    Tank Move
    public void teleopPeriodic() { // This is teleop
        chassis.tankDrive(-leftJoystick.getY(), -rightJoystick.getY());

// Can Talon
       if(lbutton7.get()) {
           canMotor.set(0.5);
       } //If
       else{
           canMotor.set(0);
       } //Else
        
//    Button Move
        if(lbutton2.get()) {
            motor5.set(0.75);
            motor6.set(0.75);
        } //If
        
        else if(lbutton3.get()) {
            motor5.set(-.5);
            motor6.set(-.5);
        } //Else if`
        
        else {
            motor5.set(0.0);
            motor6.set(0.0);
        } //Else
        
    } //Teleop Period
    
} //Class