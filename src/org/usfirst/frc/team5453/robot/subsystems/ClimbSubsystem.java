package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.OperatingClimbCommand;

public class ClimbSubsystem extends Subsystem{
	private VictorSP[] motor;
	
	public void initDefaultCommand(){
		setDefaultCommand(new OperatingClimbCommand());
		bindMotors();
	}

	public ClimbSubsystem(){
		System.out.println("Init climb subsystem.");
	}
	
	public void bindMotors(){
		motor=new VictorSP[]{
			new VictorSP(RobotMap.pwmMotorClimb[0])
		};
		motor[0].setSafetyEnabled(false);
	}

	public void reset(){
		motor[0].stopMotor();
	}
	
	public void set(double v){
		motor[0].setSpeed(v);
	}
}
