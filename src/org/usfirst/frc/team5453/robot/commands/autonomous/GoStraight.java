package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;
import org.usfirst.frc.team5453.robot.RobotMap;

public class GoStraight extends Command {
	long stopTimestamp;
	long timeToExecute=10000;
	
	public GoStraight(){}
	
	public GoStraight(long time){
		timeToExecute=time;
	}

	protected void initialize(){
		System.out.println("Auto. Command: GO_STRAIGHT");
		stopTimestamp=System.currentTimeMillis()+timeToExecute;
	}

	protected void execute(){
		Robot.drivingSys.arcadeDrive(0.44,0,RobotMap.drivingSquaredInput);
	}

	protected boolean isFinished(){
		return stopTimestamp<System.currentTimeMillis();
	}

	protected void end(){
		System.out.println("AutonomousCommand is ended.");
		Robot.drivingSys.resetMotors();
	}

	protected void interrupted(){
		System.out.println("AutonomousCommand is interrupted.");
		Robot.drivingSys.resetMotors();
	}
}
