package org.usfirst.frc1719.TEST.subsystems;

import org.usfirst.frc1719.TEST.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SpringStringThing extends Subsystem{
	//Relay springStringThingRelay = RobotMap.springStringThingMotor;
	Solenoid solenoid1 = RobotMap.springStringThingSolenoid;

	public void extend() {
		RobotMap.springStringThingMotor.set(Relay.Value.kForward);
	}

	public void retract() {
		RobotMap.springStringThingMotor.set(Relay.Value.kReverse);
	}

	public void off() {
		RobotMap.springStringThingMotor.set(Relay.Value.kOff);
    }
    public Solenoid getSolenoid() {
    	return solenoid1;
    }
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
