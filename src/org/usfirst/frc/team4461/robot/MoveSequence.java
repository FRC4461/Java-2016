package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class MoveSequence {
	public enum RoutineOne {
		Start,
		MoveForward1,
		TurnLeft1,
		MoveForward2,
		TurnLeft2,
		End,
		Print,
		}

	private RoutineOne state;
	private boolean done; 
	
	public static void main(String[] arg){
		System.out.println("moo");
		MoveSequence ms = new MoveSequence();
		ms.init();
		while(ms.state != RoutineOne.Print){
			ms.move();
		}
	}
	
	void init(){
		state = RoutineOne.Start;
		done = false;
	}
	
	private void talonInit(CANTalon talon) {
	    talon.changeControlMode(TalonControlMode.Position);
	    talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	    talon.setPID(.0001, 0, 0);
	    talon.configEncoderCodesPerRev(Robot.QUAD_TICKS); //___ for 90 degrees
	    talon.enableControl();
	    talon.setPosition(0);
		System.out.println("move1");
	}
	
	void move(){
		switch(state){
		case Start:
			startFunction();
			if (done) state = RoutineOne.MoveForward1;
			break;
		case MoveForward1:
			move1Function();
			if (done) state = RoutineOne.TurnLeft1;
			break;
		case TurnLeft1:
			turn1Function();
			if (done) state = RoutineOne.MoveForward2;
			break;
		case MoveForward2:
			move2Function();
			if (done) state = RoutineOne.TurnLeft2;
			break;
		case TurnLeft2:
			turn2Function();
			if (done) state = RoutineOne.End;
		case End:
			endFunction();
			if (done) state = RoutineOne.Print;
		case Print:
			printFunction();
		}
	}
	
	 void startFunction(){
		talonInit(Robot.talon1);
		talonInit(Robot.talon2);
		talonInit(Robot.talon3);
		talonInit(Robot.talon4);
		System.out.println("start");
		done = true;
	}
	 void move1Function(){
		Robot.talon1.set(1440);
		Robot.talon2.set(1440);
		Robot.talon3.set(1440);
		Robot.talon4.set(1440);
		done = true;
	}
	 void turn1Function(){
		System.out.println("turn1");
		done = true;
	}
	 void move2Function(){
		System.out.println("move2");
		done = true;
	}
	 void turn2Function(){
		System.out.println("turn2");
		done = true;
	}
	 void endFunction(){
		System.out.println("end");
		done = true;
	}
	 void printFunction(){
		System.out.println("print");
		done = true;
	}
}

