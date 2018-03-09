package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class TimedArcadeGoCommand extends Command{
	double speedLeft=0;
	double speedRight=0;

	long stopTimestamp;
	long timeToExecute=10000;

	public TimedArcadeGoCommand(double lv,double rv,long time){
		timeToExecute=time;
		speedLeft=lv;
		speedRight=rv;
	}

	protected void initialize(){
		System.out.println("TimedArcadeGoCommand("+speedLeft+","+speedRight+","+timeToExecute+") is initialized.");
		stopTimestamp=System.currentTimeMillis()+timeToExecute;
	}

	protected void execute(){
		Robot.drivingSys.arcadeDrive(-speedLeft,speedRight,RobotMap.drivingSquaredInput);
	}

	protected boolean isFinished(){
		return stopTimestamp<=System.currentTimeMillis();
	}

	protected void end(){
		Robot.drivingSys.resetMotors();
		System.out.println("TimedArcadeGoCommand("+speedLeft+","+speedRight+","+timeToExecute+") is ended.");
	}

	protected void interrupted(){
		System.out.println("TimedArcadeGoCommand("+speedLeft+","+speedRight+","+timeToExecute+") is interrupted.");
		end();
	}
}
