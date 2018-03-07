package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class TimedGoStraightCommand extends Command{
	double speed=0.5;

	long stopTimestamp;
	long timeToExecute=10000;

	public TimedGoStraightCommand(double v,long time){
		timeToExecute=time;
		speed=v;
	}

	protected void initialize(){
		System.out.println("TimedGoStraightCommand("+speed+","+timeToExecute+") is initialized.");
		stopTimestamp=System.currentTimeMillis()+timeToExecute;
	}

	protected void execute(){
		Robot.drivingSys.arcadeDrive(speed,0,RobotMap.drivingSquaredInput);
	}

	protected boolean isFinished(){
		return stopTimestamp<=System.currentTimeMillis();
	}

	protected void end(){
		Robot.drivingSys.resetMotors();
		System.out.println("TimedGoStraightCommand("+speed+","+timeToExecute+") is ended.");
	}

	protected void interrupted(){
		System.out.println("TimedGoStraightCommand("+speed+","+timeToExecute+") is interrupted.");
		end();
	}
}
