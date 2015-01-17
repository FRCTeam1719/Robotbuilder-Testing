package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;

public class AutoSpinACW implements CommandOption {

	private static final double NIL = 0.0D;
	private static final double TURN = 1.0D;
	
	@Override
	public void doCMD() {
		Robot.drive.moveMechanum(NIL, NIL, TURN);
	}

	@Override
	public boolean done() {
		return false;
	}

}
