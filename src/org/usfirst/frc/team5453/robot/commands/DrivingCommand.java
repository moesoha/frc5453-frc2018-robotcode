package org.usfirst.frc.team5453.robot.commands;

import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.RobotState;

public class DrivingCommand extends Command{
	public DrivingCommand(){
		requires(Robot.drivingSys);
	}
	
	protected void initialize(){
		System.out.println("DrivingCommand is initialized.");
	}

	protected void execute(){
		double speed;
		if(RobotState.isOperatorControl()){
			speed=RobotMap.drivingSpeedConstant[0];
			/*for(int i=1;i<RobotMap.joystickDrivingSpeedControl.length;i++){
				speed=(Robot.oi.readButton(RobotMap.joystickDrivingSpeedControl[i],"drive")) ? (speed+RobotMap.drivingSpeedConstant[i]) : speed;
			}*/	
			Robot.drivingSys.tankDrive(-1*(Robot.oi.readAxis(RobotMap.joystickDrivingLeverL,"drive")*speed),1*(Robot.oi.readAxis(RobotMap.joystickDrivingLeverR,"drive")*speed),RobotMap.drivingSquaredInput);
		}
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		System.out.println("DrivingCommand is ended.");
	}

	protected void interrupted(){
		System.out.println("DrivingCommand is interrupted.");
		end();
	}
}
