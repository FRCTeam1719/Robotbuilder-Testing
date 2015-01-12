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

import org.usfirst.frc1719.TEST.commands.AutonomousCommand;
import org.usfirst.frc1719.TEST.commands.BALBOBAGGINS;
import org.usfirst.frc1719.TEST.commands.CMDSolenoid1Off;
import org.usfirst.frc1719.TEST.commands.CMDSolenoid1On;
import org.usfirst.frc1719.TEST.commands.CMDToggleCamera;
import org.usfirst.frc1719.TEST.commands.CMDTurnToCamera;
import org.usfirst.frc1719.TEST.commands.CentreCamera;
import org.usfirst.frc1719.TEST.commands.CheckSwitch;
import org.usfirst.frc1719.TEST.commands.DriveServos;
//import org.usfirst.frc1719.TEST.commands.SetCameraPosition;
import org.usfirst.frc1719.TEST.commands.SpinMotor;
import org.usfirst.frc1719.TEST.commands.StopMotor;
import org.usfirst.frc1719.TEST.commands.UseDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton aButton;
    public JoystickButton aButtonReleaed;
    public JoystickButton xButtonPressed;
    public Joystick joystick1;
    public JoystickButton yButton;
    public JoystickButton rightBumper;
    public JoystickButton leftBumper;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick1 = new Joystick(0);
        
        xButtonPressed = new JoystickButton(joystick1, 3);
        xButtonPressed.whenPressed(new CentreCamera());
        aButtonReleaed = new JoystickButton(joystick1, 1);
        aButtonReleaed.whenReleased(new StopMotor());
        aButton = new JoystickButton(joystick1, 1);
        aButton.whenPressed(new SpinMotor());
        yButton = new JoystickButton(joystick1, 4);
        yButton.whenPressed(new CMDSolenoid1On());
        yButton.whenReleased(new CMDSolenoid1Off());
        
        rightBumper = new JoystickButton(joystick1, 6);
        rightBumper.whenPressed(new CMDToggleCamera());
        
        leftBumper = new JoystickButton(joystick1, 5);
        leftBumper.whenPressed(new CMDTurnToCamera());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("BALBOBAGGINS", new BALBOBAGGINS());

        SmartDashboard.putData("UseDrive", new UseDrive());

        SmartDashboard.putData("SpinMotor", new SpinMotor());

        SmartDashboard.putData("StopMotor", new StopMotor());

        SmartDashboard.putData("CheckSwitch", new CheckSwitch());

        SmartDashboard.putData("DriveServos", new DriveServos());

        SmartDashboard.putData("CentreCamera", new CentreCamera());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

