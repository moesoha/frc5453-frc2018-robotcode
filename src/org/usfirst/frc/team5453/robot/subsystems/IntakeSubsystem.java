package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team5453.robot.RobotMap;

public class IntakeSubsystem extends Subsystem{
	private VictorSP[] motor;
	
	public void initDefaultCommand(){
		bindMotors();
	}

	public IntakeSubsystem(){
		System.out.println("Init intake subsystem.");
	}
	
	public void bindMotors(){
		motor=new VictorSP[]{
			new VictorSP(RobotMap.pwmMotorIntake[0]),
			new VictorSP(RobotMap.pwmMotorIntake[1])
		};
		motor[0].setSafetyEnabled(false);
		motor[1].setSafetyEnabled(false);
	}

	public void reset(){
		motor[0].stopMotor();
		motor[1].stopMotor();
	}
	
	public void set(double v1,double v2){
		motor[0].setSpeed(v1);
		motor[1].setSpeed(v2);
	}
}
