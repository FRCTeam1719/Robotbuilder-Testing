package org.usfirst.frc1719.TEST.commands;

import org.usfirst.frc1719.TEST.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCamera extends Command {

	private boolean done = false;
	private double[][] presets = new double[][] {{0.0D, 1.0D}, {0.5D, 1.0D}, {1.0D, 1.0D},
			{0.0D, 0.5D}, {0.5D, 0.5D}, {1.0D, 0.5D}, {0.0D, 0.0D}, {0.5D, 0.0D},
			{1.0D, 0.0D}};
	private int i = 0;
	
    public ToggleCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(++i >= presets.length) i = 0;
    	Robot.cameraMount.setXServoRaw(presets[i][0]);
    	Robot.cameraMount.setYServoRaw(presets[i][1]);
    	done = true;
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
