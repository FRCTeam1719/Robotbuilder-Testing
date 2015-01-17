// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1719.TEST.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1719.TEST.Robot;

/**
 *
 */
//sets solenoid to false
public class  CMDSolenoid1Off extends Command {

    public CMDSolenoid1Off() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.pneumatics);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//sets solenoid to false
    	Robot.pneumatics.getSolenoid1().set(false);
    }

    // Make this return true when this Command no longer needs to run execute()
    //currently not terminable (other functions called sooner interrupt/override this one), memory issues?
    protected boolean isFinished() {
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