package org.usfirst.frc1719.TEST.commands;

import org.usfirst.frc1719.TEST.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractSpringStringThing extends Command {
	//magic numbers, represent the expected state of the limit switches
	final boolean NOT_ACTIVATED = true;
	final boolean ACTIVATED = false;
	//makes the program terminable
	boolean done = false;
    public RetractSpringStringThing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.springStringThing);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if limit switch at extreme triggers, keep the robot from breaking itself by retracting further
    	if(Robot.sensors.getLimitSwitchSpringStringThing(2).get()==!ACTIVATED){
    		System.out.println("OFF");
    		Robot.springStringThing.off();
    	}
    	else {
    		Robot.springStringThing.retract();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
