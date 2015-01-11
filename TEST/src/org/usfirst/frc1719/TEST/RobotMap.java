// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1719.TEST;
    

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveLeft;
    public static SpeedController driveRight;
    public static RobotDrive driveRobotDrive;
    public static Compressor pneumaticsCompressor;
    public static Solenoid pneumaticsSolenoid1;
    public static Relay motorMotorRelay;
    public static DigitalInput sensorsLimitSwitch;
    public static Encoder sensorsQuadratureEncoder1;
    public static Encoder sensorsQuadratureEncoder2;
    public static Servo cameraMountYServo;
    public static Servo cameraMountXServo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveLeft = new Talon(0);
        LiveWindow.addActuator("Drive", "Left", (Talon) driveLeft);
        
        driveRight = new Talon(1);
        LiveWindow.addActuator("Drive", "Right", (Talon) driveRight);
        
        driveRobotDrive = new RobotDrive(driveLeft, driveRight);
        
        driveRobotDrive.setSafetyEnabled(true);
        driveRobotDrive.setExpiration(0.1);
        driveRobotDrive.setSensitivity(0.5);
        driveRobotDrive.setMaxOutput(1.0);
        

        pneumaticsCompressor = new Compressor(0);
        
        
        pneumaticsSolenoid1 = new Solenoid(0, 0);
        LiveWindow.addActuator("Pneumatics", "Solenoid1", pneumaticsSolenoid1);
        
        motorMotorRelay = new Relay(0);
        LiveWindow.addActuator("Motor", "MotorRelay", motorMotorRelay);
        
        sensorsLimitSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Sensors", "LimitSwitch", sensorsLimitSwitch);
        
        sensorsQuadratureEncoder1 = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Sensors", "Quadrature Encoder 1", sensorsQuadratureEncoder1);
        sensorsQuadratureEncoder1.setDistancePerPulse(1.0);
        sensorsQuadratureEncoder1.setPIDSourceParameter(PIDSourceParameter.kRate);
        sensorsQuadratureEncoder2 = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("Sensors", "Quadrature Encoder 2", sensorsQuadratureEncoder2);
        sensorsQuadratureEncoder2.setDistancePerPulse(1.0);
        sensorsQuadratureEncoder2.setPIDSourceParameter(PIDSourceParameter.kRate);
        cameraMountYServo = new Servo(2);
        LiveWindow.addActuator("CameraMount", "YServo", cameraMountYServo);
        
        cameraMountXServo = new Servo(3);
        LiveWindow.addActuator("CameraMount", "XServo", cameraMountXServo);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    }
}
