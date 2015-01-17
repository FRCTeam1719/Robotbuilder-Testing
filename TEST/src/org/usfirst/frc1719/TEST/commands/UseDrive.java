// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1719.TEST.commands;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc1719.TEST.Robot;

/**
 *
 */
public class  UseDrive extends Command {
	private static final int LEFT_X = 0;
	private static final int LEFT_Y = 1;
	private static final int RIGHT_Y = 5;
	
	private static final boolean TANK_DRIVE=false;
	private static final boolean ARCADE_DRIVE=true;
	
	private int i = 0;
	
	
	boolean driveType;
    public UseDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveType = ARCADE_DRIVE; //(boolean) Robot.driveChooser.getSelected();
    	if(driveType==ARCADE_DRIVE){
    		Robot.drive.moveArcade(Robot.oi.getJoystick1().getRawAxis(LEFT_Y), Robot.oi.getJoystick1().getRawAxis(LEFT_X));
    		}
    	if(driveType==TANK_DRIVE){
    		Robot.drive.moveTank(Robot.oi.getJoystick1().getRawAxis(LEFT_Y), Robot.oi.getJoystick1().getRawAxis(RIGHT_Y));
    		}
    	

        //System.out.println("Infrared Value: " + Robot.sensors.getIRSensorValue()); 
    	System.out.println("Encoder1 RPM: " + Robot.sensors.getEncoderRPM(1) + "  Infrared Value: " + Robot.sensors.getIRSensorValue());
    	System.out.println("Encoder1 Count Per second: " + Robot.sensors.getEncoderCountPerSecond(1));
    	System.out.println("Encoder1 RPM based off of count: " + Robot.sensors.getEncoderCountPerSecond(1) / 6);
    	System.out.println(Robot.sensors.getIRSensorValue());
    	
    	if (i++ % 0x40 == 0) System.out.println("Gyro angle: " + Robot.sensors.getGyro().getAngle());
    	if (i % 0x1000 == 0) {
    		System.out.println("Resetting gyro...");
    		Robot.sensors.getGyro().reset();
    		System.out.println("Done.");
    	}


    }
    
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
