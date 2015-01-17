package org.usfirst.frc1719.TEST.commands;

import org.usfirst.frc1719.TEST.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDTurnToCamera extends Command {

	private boolean flag = true;
	private boolean done = false;
	private double target = 0;
	private static final double TOLERANCE = 15.0D;
	private static final double SPD = 0.5D;
	private static final double NIL = 0.0D;
	
    public CMDTurnToCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(flag) {
    		Robot.sensors.getGyro().reset();
    		target = (Robot.cameraMount.getXPos() * 180) - 90;
    		flag = false;
    	}
    	double curr = Robot.sensors.getGyro().getAngle();
    	if (Math.abs(target - curr) < TOLERANCE) {
    		System.out.println("Rotation Completed");
    		Robot.cameraMount.center();
    		done = true;
    		flag = true;
    		return;
    	}
    	System.out.println("Current Error: " + (target - curr));
    	double dir = ((target - curr) < 0) ? SPD : -SPD;
    	Robot.drive.moveMechanum(NIL, NIL, dir);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(done) {
    		done = false;
    		return true;
    	} else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
