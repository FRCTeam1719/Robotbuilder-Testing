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

import org.usfirst.frc1719.TEST.Robot;
//import org.usfirst.frc1719.TEST.autonomous.CommandOption;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc1719.TEST.Robot;

/**
 *
 */
public class  AutonomousCommand extends Command {

    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    // please can we just put this in the constructor
    // NO
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//sets current autonomouscommand to command chosen from  smartdashboard radio button
    	((Robot.EnumAutoCMD) Robot.autoCMDChooser.getSelected()).cmd.doCMD();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//ends chosen command
        return ((Robot.EnumAutoCMD) Robot.autoCMDChooser.getSelected()).cmd.done();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
