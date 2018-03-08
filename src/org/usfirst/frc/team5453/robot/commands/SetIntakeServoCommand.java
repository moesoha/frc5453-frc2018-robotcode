package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class SetIntakeServoCommand extends Command{
	double servoValue=0;

	public SetIntakeServoCommand(double s){
		requires(Robot.intakeServoSys);
		servoValue=s;
	}
	
	protected void initialize(){
		System.out.println("SetIntakeServoCommand("+servoValue+") is initialized.");
	}

	protected void execute(){
		Robot.intakeServoSys.set(servoValue);
	}

	protected boolean isFinished(){
		return true;
	}

	protected void end(){
		System.out.println("SetIntakeServoCommand("+servoValue+") is ended.");
	}

	protected void interrupted(){
		System.out.println("SetIntakeServoCommand("+servoValue+") is interrupted.");
		end();
	}
}
