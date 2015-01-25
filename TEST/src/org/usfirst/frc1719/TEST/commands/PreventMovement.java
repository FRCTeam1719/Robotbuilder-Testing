package org.usfirst.frc1719.TEST.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PreventMovement extends Command {
	
	//Magic Numbers: is the tote stack in the front or back?
	private static final boolean FRONT = true;
	private static final boolean BACK = false;
	//Allows this command to affect UseDrive
	UseDrive useDrive = new UseDrive();
	
    public PreventMovement() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	useDrive.setPreventMovement(false);
    	if(true){
    		useDrive.setPreventMovement(true);
    		useDrive.setDirectionPrevention(FRONT);
    	}
    	else if(true){
    		useDrive.setPreventMovement(true);
    		useDrive.setDirectionPrevention(BACK);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
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
