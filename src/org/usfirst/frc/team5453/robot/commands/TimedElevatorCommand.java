package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class TimedElevatorCommand extends Command{
	double speed=0;
	long stopTimestamp;
	long timeToExecute=10000;

	public TimedElevatorCommand(double s,long t){
		requires(Robot.elevatorSys);
		speed=s;
		timeToExecute=t;
	}
	
	protected void initialize(){
		System.out.println("TimedElevatorCommand("+speed+","+timeToExecute+") is initialized.");
		stopTimestamp=System.currentTimeMillis()+timeToExecute;
	}

	protected void execute(){
		Robot.elevatorSys.set(-speed);
	}

	protected boolean isFinished(){
		return stopTimestamp<=System.currentTimeMillis();
	}

	protected void end(){
		Robot.elevatorSys.reset();
		System.out.println("TimedElevatorCommand("+speed+","+timeToExecute+") is ended.");
	}

	protected void interrupted(){
		System.out.println("TimedElevatorCommand("+speed+","+timeToExecute+") is interrupted.");
		end();
	}
}
