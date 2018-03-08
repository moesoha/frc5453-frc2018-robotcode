package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class OperatingElevatorCommand extends Command{
	double speed=0;

	public OperatingElevatorCommand(){
		requires(Robot.elevatorSys);
	}
	
	protected void initialize(){
		System.out.println("OperatingElevatorCommand is initialized.");
	}

	protected void execute(){
		speed=Robot.oi.readAxis(RobotMap.joystickElevatorLever,"operate");
		if(Math.abs(speed)>=0.02){
			Robot.elevatorSys.set(speed*RobotMap.operatingElevatorSpeedLeverRate);
		}else{
			Robot.elevatorSys.set(0);
		}
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		Robot.elevatorSys.reset();
		System.out.println("OperatingElevatorCommand is ended.");
	}

	protected void interrupted(){
		System.out.println("OperatingElevatorCommand is interrupted.");
		end();
	}
}
