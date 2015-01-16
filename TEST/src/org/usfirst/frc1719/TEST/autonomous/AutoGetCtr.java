package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;
import org.usfirst.frc1719.TEST.commands.CMDTurnToCamera;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoGetCtr implements CommandOption {

	private static final double RANGE = 2.0D;
	private static final double RANGE_2 = 3.0D;
	private static final double SCAN_SPEED = 0.5D;
	private static final double FORWARD_SPD = 1.0D;
	private static final double FORWARD_ANGLE = 0.0D;
	private static final int STAGES = 7;
	private boolean cm_mv_dir = false;
	private int stage = 0;
	private CMDTurnToCamera tt_cam = new CMDTurnToCamera();
	
	@Override
	public void doCMD() {
		switch (stage % STAGES) {
			case 0:
				if(SmartDashboard.getBoolean("Target Acquired - Container")) stage++;
				else {
					if (Math.abs(Robot.cameraMount.getXPos()) == 1) cm_mv_dir = !cm_mv_dir;
					Robot.cameraMount.setXServoPan(cm_mv_dir ? SCAN_SPEED : -SCAN_SPEED);
					break;
				}
			case 1:
				if(tt_cam.isFinished()) stage++;
				else {
					tt_cam.exec();
					break;
				}
			case 2:
				if(getIRDistance() < RANGE) stage++;
				else {
					Robot.drive.moveTank(FORWARD_SPD, FORWARD_SPD); // !!! Delete this when Mechanum is implemented !!!
					Robot.drive.moveMechanum(FORWARD_ANGLE, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 3:
				if(getIRDistance() > RANGE_2) stage++;
				else {
					Robot.drive.moveTank(FORWARD_SPD, -FORWARD_SPD); // !!! Delete this when Mechanum is implemented !!!
					Robot.drive.moveMechanum(Math.PI / 2, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 4:
				if(Robot.fr.getExtended()) stage++;
				else {
					Robot.pneumatics.getArmSolenoid().set(true);
					Robot.fr.getExtMotor().set(Relay.Value.kForward);
					break;
				}
			case 5:
				if(getIRDistance() < RANGE) stage++;
				else {
					Robot.drive.moveTank(-FORWARD_SPD, FORWARD_SPD); // !!! Delete this when Mechanum is implemented !!!
					Robot.drive.moveMechanum(-Math.PI / 2, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 6:
				if(Robot.fr.getRetracted()) stage++;
				else {
					Robot.drive.moveTank(-FORWARD_SPD, -FORWARD_SPD); // !!! Delete this when Mechanum is implemented !!!
					Robot.drive.moveMechanum(Math.PI, FORWARD_SPD, FORWARD_ANGLE);
					Robot.fr.getExtMotor().set(Relay.Value.kReverse);
					break;
				}
		}
	}

	@Override
	public boolean done() {
		return false;
	}
	
	private double getIRDistance() {
		// !!! Not implemented yet !!!
		return -1.0D;
	}

}
