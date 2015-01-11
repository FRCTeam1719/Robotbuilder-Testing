package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;

public class AutoSpinACW implements CommandOption {

	private static final double LEFT = -1.0D;
	private static final double RIGHT = 1.0D;
	
	@Override
	public void doCMD() {
		//Robot.drive.moveTank(LEFT, RIGHT);
		System.out.println("Spinning Anticlockwise");
	}

	@Override
	public boolean done() {
		return false;
	}

}
