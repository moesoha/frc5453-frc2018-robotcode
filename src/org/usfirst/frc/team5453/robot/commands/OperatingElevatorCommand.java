package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class OperatingElevatorCommand extends Command{
	double speed=0;

	public OperatingElevatorCommand(double s){
		requires(Robot.elevatorSys);
		speed=s;
	}
	
	protected void initialize(){
		System.out.println("OperatingElevatorCommand("+speed+") is initialized.");
	}

	protected void execute(){
		Robot.elevatorSys.set(speed);
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		Robot.elevatorSys.reset();
		System.out.println("OperatingElevatorCommand("+speed+") is ended.");
	}

	protected void interrupted(){
		System.out.println("OperatingElevatorCommand("+speed+") is interrupted.");
		end();
	}
}
