package org.usfirst.frc1719.TEST.subsystems;

import org.usfirst.frc1719.TEST.Robot;
import org.usfirst.frc1719.TEST.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FishingRod extends Subsystem {
    
    Relay extensionMotor = RobotMap.frExtensionMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean getExtended() {
    	return Robot.sensors.getLimitSwitch().get();
    }
    
    public boolean getRetracted() {
    	return Robot.sensors.getLimitSwitch2().get();
    }
    
    public Relay getExtMotor() {
    	return extensionMotor;
    }
}

