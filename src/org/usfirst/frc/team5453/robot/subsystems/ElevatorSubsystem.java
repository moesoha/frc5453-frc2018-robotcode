package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team5453.robot.RobotMap;

public class ElevatorSubsystem extends Subsystem{
	private VictorSP[] motor;
	
	public void initDefaultCommand(){
		bindMotors();
	}

	public ElevatorSubsystem(){
		System.out.println("Init elevator subsystem.");
	}
	
	public void bindMotors(){
		motor=new VictorSP[]{
			new VictorSP(RobotMap.pwmMotorElevator[0]),
			new VictorSP(RobotMap.pwmMotorElevator[1])
		};
		motor[0].setSafetyEnabled(false);
		motor[1].setSafetyEnabled(false);
		
		motor[1].setInverted(true);
	}

	public void reset(){
		motor[0].stopMotor();
		motor[1].stopMotor();
	}
	
	public void set(double v){
		motor[0].setSpeed(v);
		motor[1].setSpeed(v);
	}
}
