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
	final int LEFT_X = 0;
	final int LEFT_Y = 1;
	final int RIGHT_X = 4;
	final int RIGHT_Y = 5;
	
	final int MOTOR_1_CORRECT_SPEED = 1;
	final int MOTOR_2_CORRECT_SPEED = 1;
	final boolean TANK_DRIVE=false;
	final boolean ARCADE_DRIVE=true;
	
	
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
    	(new CheckSwitch()).start();
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
    	
    	//Print Statements
        //System.out.println("Infrared Value: " + Robot.sensors.getIRSensorValue()); 
    	//System.out.println("Encoder1 Rate: " + Robot.sensors.getEncoderRate(1) + "Encoder2 Rate: " + Robot.sensors.getEncoderRate(2));
    	
    	double encoder1Accuracy;
    	double encoder2Accuracy;
    	double encoder1Rate = Robot.sensors.getEncoderRate(1);
    	double encoder2Rate = Robot.sensors.getEncoderRate(2);
    	System.out.println("Encoder1 Rate: " + encoder1Rate + "Encoder2 Rate: " + encoder2Rate);
    	
    	
    	encoder1Accuracy = encoder1Rate / MOTOR_1_CORRECT_SPEED * 100;
    	encoder2Accuracy = encoder2Rate / MOTOR_2_CORRECT_SPEED * 100;
    	
    	System.out.println("Encoder1 Accuracy: " + encoder1Accuracy + " Encoder2 Accuracy: " + encoder2Accuracy);

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
