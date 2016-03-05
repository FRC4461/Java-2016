//package org.usfirst.frc.team4461.robot;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
//import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
//
//public class QuadSet {
//	static void talonInit(CANTalon talon, double P, double I, double D){
//	    talon.changeControlMode(TalonControlMode.Position);
//	    talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//	    talon.setPID(P, I, D);
//	    talon.configEncoderCodesPerRev(Robot.QUAD_TICKS); //___ for 90 degrees
//	    talon.enableControl();
//	    talon.setPosition(0);
//		System.out.println("move1");
//	}
//	
//	 static void talonLoad(double P, double I, double D){
//			talonInit(Robot.talon1, P, I, D);
//			talonInit(Robot.talon2, P, I, D);
//			talonInit(Robot.talon3, P, I, D);
//			talonInit(Robot.talon4, P, I, D);
//	 }
//	 
//	
//}
