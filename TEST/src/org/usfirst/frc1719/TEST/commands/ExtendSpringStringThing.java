package org.usfirst.frc1719.TEST.commands;

import org.usfirst.frc1719.TEST.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendSpringStringThing extends Command {
	//makes program terminable
	boolean done = false;
	//magic numbers, shows expected state of limit switches
	final boolean NOT_ACTIVATED = true;
	final boolean ACTIVATED = false;
    public ExtendSpringStringThing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.springStringThing);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if limit switch at extreme triggers, keep the robot from breaking itself by extending further
    	done = false;
    	if(Robot.sensors.getLimitSwitchSpringStringThing(1).get()==ACTIVATED){
    		Robot.springStringThing.off();
    		done = true;
    	}
    	else if(Robot.sensors.getLimitSwitchSpringStringThing(1).get()==NOT_ACTIVATED) Robot.springStringThing.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	done = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	done = true;
    }
}
