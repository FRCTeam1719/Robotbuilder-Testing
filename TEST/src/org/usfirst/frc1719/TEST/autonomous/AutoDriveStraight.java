package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;

public class AutoDriveStraight implements CommandOption {

	private static final double SPEED = 1.0D;
	private static final double ANGLE = 0.0D;
	
	@Override
	public void doCMD() {
		Robot.drive.moveArcade(SPEED, ANGLE);

	}

	@Override
	public boolean done() {
		return false;
	}

}
