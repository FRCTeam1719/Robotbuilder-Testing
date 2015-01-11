package org.usfirst.frc1719.TEST.commands;

import org.usfirst.frc1719.TEST.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetCameraPosition extends Command {
	private boolean isDone = false;
	final double xPosition;
	final double yPosition;
	
	public SetCameraPosition(double xPos, double yPos) {
		
		xPosition = xPos;
		yPosition = yPos;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
	
		Robot.cameraMount.setXServo(xPosition);
		Robot.cameraMount.setYServo(yPosition);
		isDone = true;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isDone;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
