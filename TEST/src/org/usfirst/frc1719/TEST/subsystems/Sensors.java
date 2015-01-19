// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1719.TEST.subsystems;

import org.usfirst.frc1719.TEST.RobotMap;


import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import org.usfirst.frc1719.TEST.commands.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Sensors extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput limitSwitchSpringStringThingExtended = RobotMap.sensorsLimitSwitchSpringStringThingExtended;
    DigitalInput limitSwitchSpringStringThingRetracted = RobotMap.sensorsLimitSwitchSpringStringThingRetracted;
    Gyro gyro = RobotMap.sensorsGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput limitSwitch2 = RobotMap.sensorsLimitSwitch2;
    BuiltInAccelerometer acc = new BuiltInAccelerometer();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Gyro getGyro() {
    	//returns attached gyro so it can be accessed
    	return gyro;
    }


	public DigitalInput getLimitSwitchSpringStringThing(int index){
		//extended vs retracted
		if(index == 1) return limitSwitchSpringStringThingExtended;
		if(index == 2) return limitSwitchSpringStringThingRetracted;
		//default to prevent errors
		return null;
	}
	
	public double correctEncoderValue(double badRPM) {
		return badRPM * 1.4;
	}

	/**
	 * 
	 * @return distance to object directly in front in meters
	 */
	public double getDistanceInFront() {
		return 2.0D; // !!! Replace with distance sensor code !!!
	}
	
	/**
	 * returns the current acceleration in meters per second squared.
	 */
	public double getAcc() {
		double x = acc.getX();
		double y = acc.getY();
		return 9.8 * Math.sqrt(x * x + y * y);
	}
}

