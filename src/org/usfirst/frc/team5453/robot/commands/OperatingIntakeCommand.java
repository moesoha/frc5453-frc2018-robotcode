package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class OperatingIntakeCommand extends Command{
	double speed=0;
	boolean setInverted=false;

	public OperatingIntakeCommand(double s){
		requires(Robot.intakeSys);
		speed=s;
	}

	public OperatingIntakeCommand(double s,boolean setOneInverted){
		requires(Robot.elevatorSys);
		speed=s;
		setInverted=setOneInverted;
	}
	
	protected void initialize(){
		System.out.println("OperatingIntakeCommand("+speed+(setInverted?",inverted":"")+") is initialized.");
	}

	protected void execute(){
		Robot.intakeSys.set(speed,setInverted?(1*speed):(-1*speed));
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		Robot.intakeSys.reset();
		System.out.println("OperatingIntakeCommand("+speed+(setInverted?",inverted":"")+") is ended.");
	}

	protected void interrupted(){
		System.out.println("OperatingIntakeCommand("+speed+(setInverted?",inverted":"")+") is interrupted.");
		end();
	}
}
