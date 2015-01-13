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

//import org.usfirst.frc1719.TEST.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Sensors extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput limitSwitch = RobotMap.sensorsLimitSwitch;
    Encoder quadratureEncoder1 = RobotMap.sensorsQuadratureEncoder1;
    Encoder quadratureEncoder2 = RobotMap.sensorsQuadratureEncoder2;
    AnalogInput irSensor = RobotMap.sensorsIRSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public double getEncoderRate(int index){
    	double encoderValue = (1.0D / 0.0D);
    	
    	if(index == 1){
    		encoderValue = quadratureEncoder1.getRate();
    	}else if(index == 2){
    		encoderValue = quadratureEncoder2.getRate();
    		
    	}
    	
    	return encoderValue;
    }
    
    public int getIRSensorValue()
    {
    	return irSensor.getValue();
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public DigitalInput getLimitSwitch() {
    	return limitSwitch;
    }
}

