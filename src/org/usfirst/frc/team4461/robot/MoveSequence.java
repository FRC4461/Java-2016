//package org.usfirst.frc.team4461.robot;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
//import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
//import edu.wpi.first.wpilibj.Timer;
//
//public class MoveSequence {
//	public enum RoutineOne {
//		Start,
//		MoveBackwards,
//		End,
//		Print,
//		}
//
//	private RoutineOne state;
//	private boolean done; 
//	
//	public static void main(String[] arg){
//		System.out.println("Running Routine 1");
//		MoveSequence ms = new MoveSequence();
//		ms.init();
//		while(ms.state != RoutineOne.Print){
//			ms.move();
//		}
//	}
//	
//	void init(){
//		state = RoutineOne.Start;
//		done = false;
//	}
//
//	//Setting Talon to PID
//	private void talonInit(CANTalon talon) {
//	    talon.changeControlMode(TalonControlMode.Position);
//	    talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//	    talon.setPID(.0001, 0, 0);
//	    talon.configEncoderCodesPerRev(Robot.QUAD_TICKS); //___ for 90 degrees
//	    talon.enableControl();
//	    talon.setPosition(0);
//		System.out.println("move1");
//	}
//	
//	//Moving from 1 to 2
//	void move(){
//		switch(state){
//		case Start:
//			startFunction();
//			if (done) state = RoutineOne.MoveBackwards;
//			break;
//		case MoveBackwards:
//			movebackwardsFunction();
//			if (done) state = RoutineOne.End;
//		case End:
//			endFunction();
//			if (done) state = RoutineOne.Print;
//		case Print:
//			printFunction();
//		}
//	}
//	
//	 void startFunction(){
////		talonInit(Robot.talon1);
////		talonInit(Robot.talon2);
////		talonInit(Robot.talon3);
////		talonInit(Robot.talon4);
//		System.out.println("start");
//		done = true;
//	}
//	 void movebackwardsFunction(){
//		Robot.talon1.set(-1024);
//		Robot.talon2.set(-1024);
//		Robot.talon3.set(-1024);
//		Robot.talon4.set(-1024);
//		Timer.delay(1);
//		System.out.println("movebackwards1");
//		done = true;
//	}
//	 void endFunction(){
//		System.out.println("end");
//		done = true;
//	}
//	 void printFunction(){
//		System.out.println("print");
//		done = true;
//	}
//}