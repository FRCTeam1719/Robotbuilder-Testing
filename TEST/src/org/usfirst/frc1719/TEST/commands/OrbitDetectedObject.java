package org.usfirst.frc1719.TEST.commands;

import java.util.Date;

import org.usfirst.frc1719.TEST.Robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OrbitDetectedObject extends Command {

	private int stage = 0;
	private double rng = 0.0D;
	private double s = 0.0D;
	private double v = 0.0D;
	private double theta = 0.0D;
	private double target = 0.0D;
	private Date last = null;
	private TurnToCamera tt_cam = new TurnToCamera();
	private boolean done = false;
	private static final double NIL = 0.0D;
	private static final double TOLERANCE = 15.0D;
	private static final double SPD = 0.5D;
	
    public OrbitDetectedObject() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(stage) {
    		case 0:
    			if(!Robot.oi.xButton.get()) {
    				done = true;
    				tt_cam = new TurnToCamera();
    				return;
    			} else if(tt_cam.done()) {
    				stage++;
    			} else {
    				tt_cam.exec();
    				break;
    			}
    		case 1:
    			rng = Robot.sensors.getDistanceInFront();
    			stage++;
    		case 2:
    			if(!Robot.oi.xButton.get()) {
    				Robot.sensors.getGyro().reset();
    				theta = Math.atan(s / rng);
    				target = Math.sqrt(s * s + rng * rng) - rng;
    				stage++;
    			} else {
    				double dt;
    				Date now = new Date();
    				try {
    					dt = (now.getTime() - last.getTime()) * 0.001D;
    				} catch (NullPointerException npe) {
    					dt = NIL;
    				}
    				double a = Robot.sensors.getAcc();
    				double dv = a * dt;
    				v += dv;
    				double ds = v * dt;
    				s += ds;
    				last = now;
    				Robot.drive.moveMechanum(1.0D, Math.PI / 2.0D, NIL);
    				break;
    			}
    		case 3:
    			double curr = Robot.sensors.getGyro().getAngle();
    	    	//Checks if rotation is complete to within tolerance
    	    	if (Math.abs(theta - curr) < TOLERANCE) {
    	    		last = null;
    	    		s = 0;
    	    		v = 0;
    	    		stage++;
    	    	} else {
        	    	double dir = (theta < curr) ? -SPD : SPD;
        	    	Robot.drive.moveMechanum(NIL, NIL, dir);
        	    	break;
    	    	}
    		case 4:
    			if(s > target) {
    				done = true;
    			} else {
    				double dt;
    				Date now = new Date();
    				try {
    					dt = (now.getTime() - last.getTime()) * 0.001D;
    				} catch (NullPointerException npe) {
    					dt = NIL;
    				}
    				double a = Robot.sensors.getAcc();
    				double dv = a * dt;
    				v += dv;
    				double ds = v * dt;
    				s += ds;
    				last = now;
    				Robot.drive.moveMechanum(1.0D, NIL, NIL);
    				break;
    			}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(done) {
    		done = false;
    		stage = 0;
    		rng = NIL;
    		s = NIL;
    		v = NIL;
    		theta = NIL;
    		target = NIL;
    		last = null;
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
