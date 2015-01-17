package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;

public class AutoCurveRight implements CommandOption {

	private static final double FORWARD_SPD = 1.0D;
	private static final double FORWARD_ANGLE = 0.0D;
	private static final double CURVE_AMT = 0.25D;
	
	@Override
	public void doCMD() {
		Robot.drive.moveMechanum(FORWARD_SPD, FORWARD_ANGLE, CURVE_AMT);
	}

	@Override
	public boolean done() {
		return false;
	}

}
