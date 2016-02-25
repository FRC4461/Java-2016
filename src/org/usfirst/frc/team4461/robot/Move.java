/**
 * 
 */
package org.usfirst.frc.team4461.robot;

/**
 * @author john
 *
 */
public class Move {
	public static final double WHEEL_CIRCUMFERENCE = .2; // meters for instance - I am making this number up
                                                         // make sure the wheel is in the same measure as the distance  
	public static final double TURN_CIRCUMFERENCE = 1.1;  // circle of movement better to explain if I draw it  
	
	private static final double P_WHEEL = .0001; // we really need to tune these
	private static final double I_WHEEL = 0;
	private static final double D_WHEEL = 0;
	private static final double THRESHOLD = .1;

	public static boolean move(double distance){
		Robot.talon1.enableControl(); // left wheel
		Robot.talon3.enableControl(); // right wheel
		Robot.talon1.setPID(P_WHEEL,I_WHEEL, D_WHEEL);
		Robot.talon1.setPID(P_WHEEL,I_WHEEL, D_WHEEL);
		Robot.talon1.set(distance/WHEEL_CIRCUMFERENCE);
		Robot.talon3.set(distance/WHEEL_CIRCUMFERENCE);
		return Robot.talon1.getError() < THRESHOLD && Robot.talon3.getError() < THRESHOLD;		
	}

	public static boolean turn(double angle){
		Robot.talon1.enableControl();
		Robot.talon3.enableControl();
		Robot.talon1.setPID(P_WHEEL,I_WHEEL, D_WHEEL);
		Robot.talon1.setPID(P_WHEEL,I_WHEEL, D_WHEEL);
		Robot.talon1.set((angle/360)/TURN_CIRCUMFERENCE); // left wheel forward
		Robot.talon3.set(-1 * (angle/360)/TURN_CIRCUMFERENCE); // right wheel back
		return Robot.talon1.getError() < THRESHOLD && Robot.talon3.getError() < THRESHOLD;		
	}
}