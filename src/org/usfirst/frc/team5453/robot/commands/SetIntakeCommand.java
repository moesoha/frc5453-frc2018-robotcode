package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class SetIntakeCommand extends Command{
	double speed=0;
	boolean setInverted=false;

	public SetIntakeCommand(double s){
		requires(Robot.intakeSys);
		speed=s;
	}

	public SetIntakeCommand(double s,boolean setOneInverted){
		requires(Robot.elevatorSys);
		speed=s;
		setInverted=setOneInverted;
	}
	
	protected void initialize(){
		System.out.println("SetIntakeCommand("+speed+(setInverted?",inverted":"")+") is initialized.");
	}

	protected void execute(){
		Robot.intakeSys.set(speed,setInverted?(1*speed):(-1*speed));
	}

	protected boolean isFinished(){
		return true;
	}

	protected void end(){
		System.out.println("SetIntakeCommand("+speed+(setInverted?",inverted":"")+") is ended.");
	}

	protected void interrupted(){
		System.out.println("SetIntakeCommand("+speed+(setInverted?",inverted":"")+") is interrupted.");
	}
}
