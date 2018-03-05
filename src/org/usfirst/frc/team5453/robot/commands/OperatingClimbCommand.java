package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class OperatingClimbCommand extends Command{
	double speed=0;

	public OperatingClimbCommand(/*double s*/){
		requires(Robot.climbSys);
		//speed=s;
	}
	
	protected void initialize(){
		System.out.println("OperatingClimbCommand("+speed+") is initialized.");
	}

	protected void execute(){
		//Robot.climbSys.set(speed);
		Robot.climbSys.set(Robot.oi.readAxis(RobotMap.joystickClimbLever,"operate"));
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		System.out.println("OperatingClimbCommand("+speed+") is ended.");
		Robot.climbSys.reset();
	}

	protected void interrupted(){
		System.out.println("OperatingClimbCommand("+speed+") is interrupted.");
		Robot.climbSys.reset();
	}
}
