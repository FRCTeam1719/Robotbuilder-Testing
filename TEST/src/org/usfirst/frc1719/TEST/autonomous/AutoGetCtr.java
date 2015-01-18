package org.usfirst.frc1719.TEST.autonomous;

import java.util.Date;

import org.usfirst.frc1719.TEST.Robot;
import org.usfirst.frc1719.TEST.commands.TurnToCamera;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Autonomous code for grabbing the containers from the step. 
 * @author duncan
 *
 */
public class AutoGetCtr implements ICommandOption {

	// Ranges are in mV. lower voltage = higher distance.
	private static final double RANGE = 150.0D;
	private static final double RANGE_2 = 250.0D;
	private static final double SCAN_SPEED = 0.5D;
	private static final double FORWARD_SPD = 1.0D;
	private static final double FORWARD_ANGLE = 0.0D;
	private static final long MOVE_TIME_MILLIS = 500L;
	private static final int STAGES = 8;
	private boolean cm_mv_dir = false;
	private int stage = 0;
	private TurnToCamera tt_cam = new TurnToCamera();
	private Date time;
	
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
				if(getDistance() > RANGE) stage++;
				else {
					Robot.drive.moveMechanum(FORWARD_ANGLE, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 3:
				if(getDistance() < RANGE_2) stage++;
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
				if(getDistance() > RANGE) stage++;
				else {
					Robot.drive.moveMechanum(-Math.PI / 2, FORWARD_SPD, FORWARD_ANGLE);
					break;
				}
			case 6:
				if(Robot.fr.getRetracted()) {
					stage++;
					time = new Date();
				} else {
					Robot.drive.moveMechanum(Math.PI, FORWARD_SPD, FORWARD_ANGLE);
					Robot.fr.getExtMotor().set(Relay.Value.kReverse);
					break;
				}
			case 7:
				if((new Date()).getTime() > (time.getTime() + MOVE_TIME_MILLIS)) stage++;
				else {
					if(getDistance() < RANGE_2) stage++;
					else {
						Robot.drive.moveMechanum(Math.PI / 2, FORWARD_SPD, FORWARD_ANGLE);
						break;
					}
				}
		}
	}

	@Override
	public boolean done() {
		return false;
	}
	
	private double getDistance() {
		return SmartDashboard.getNumber("Distance in front (cm)"); // change for distance sensor when ready
	}

}
