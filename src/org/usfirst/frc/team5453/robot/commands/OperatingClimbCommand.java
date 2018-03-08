package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class OperatingClimbCommand extends Command{
	double speed=0;

	public OperatingClimbCommand(double s){
		requires(Robot.climbSys);
		speed=s;
	}
	
	protected void initialize(){
		System.out.println("OperatingClimbCommand("+speed+") is initialized.");
	}

	protected void execute(){
		if(Robot.oi.readButton(RobotMap.joystickClimbLock,"operate")){
			Robot.climbSys.set(speed);
		}
		// speed=Robot.oi.readAxis(RobotMap.joystickClimbLever,"operate");
		// if(speed>=0.2){
		// 	Robot.climbSys.set(speed);
		// }else{
		// 	Robot.climbSys.set(0);
		// }
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end(){
		Robot.climbSys.reset();
		System.out.println("OperatingClimbCommand("+speed+") is ended.");
	}

	protected void interrupted(){
		System.out.println("OperatingClimbCommand("+speed+") is interrupted.");
		end();
	}
}
