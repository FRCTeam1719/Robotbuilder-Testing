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
import org.usfirst.frc1719.TEST.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drive extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftRear = RobotMap.driveLeftRear;
    SpeedController rightRear = RobotMap.driveRightRear;
    SpeedController leftFront = RobotMap.driveLeftFront;
    SpeedController rightFront = RobotMap.driveRightFront;
    RobotDrive robotDrive = RobotMap.driveRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * Moves the mechanum drive in a given way.
     * 
     * @param magnitude a double on the interval [-1.0,1.0]. Defines the speed at which the robot should move.
     * @param direction the radian measure of angle between the direction of the strafe and the 'forward' of the robot.
     * @param rotation a double on the interval [-1.0,1.0]. Defines the speed at which the robot should turn in place.
     */
    public void moveMechanum(double magnitude, double direction, double rotation) {
    	robotDrive.mecanumDrive_Polar(magnitude, direction * 180 / Math.PI, rotation);
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new UseDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

