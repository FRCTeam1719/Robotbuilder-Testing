package org.usfirst.frc1719.TEST.autonomous;

import org.usfirst.frc1719.TEST.Robot;
import org.usfirst.frc1719.TEST.commands.TurnToCamera;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoGetCtr implements ICommandOption {

	// Ranges are in mV. lower voltage = higher distance.
	private static final int RANGE = 500;
	private static final int RANGE_2 = 400;
	private static final double SCAN_SPEED = 0.5D;
	private static final double FORWARD_SPD = 1.0D;
	private static final double FORWARD_ANGLE = 0.0D;
	private static final int STAGES = 7;
	private boolean cm_mv_dir = false;
	private int stage = 0;
	private TurnToCamera tt_cam = new TurnToCamera();
	
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
				if(getIRDistance() > RANGE) stage++;
				else {
					Robot.drive.moveMechanum(FORWARD_ANGLE, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 3:
				if(getIRDistance() < RANGE_2) stage++;
				else {
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
				if(getIRDistance() > RANGE) stage++;
				else {
					Robot.drive.moveMechanum(-Math.PI / 2, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 6:
				if(Robot.fr.getRetracted()) stage++;
				else {
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
		return Robot.sensors.getIRSensorValue();
	}

}
