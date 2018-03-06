package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class TurnWithGyroCommand extends Command{
	double dstAngle=0;
	double speedRate=0.6;

	
	// Here `angle`, positive is clockwise, negative is anticlockwise.
	public TurnWithGyroCommand(double angle){
		requires(Robot.drivingSys);
		dstAngle=angle;
	}

	public TurnWithGyroCommand(double angle,double spdRate){
		requires(Robot.drivingSys);
		dstAngle=angle;
		speedRate=spdRate;
	}
	
	protected void initialize(){
		System.out.println("TurnWithGyroCommand("+dstAngle+") is initialized.");
	}

	protected void execute(){
		Robot.drivingSys.tankDrive((dstAngle>=0?-1:1)*speedRate,(dstAngle>=0?-1:1)*speedRate,false);
	}

	protected boolean isFinished(){
		// NOTICE
		// Here is not finished yet.
		// How to get yaw angle?
		// Refer to GyroAHRSSubsystem
		// is BoardYawAxis correct?
		return true;
	}

	protected void end(){
		System.out.println("TurnWithGyroCommand("+dstAngle+") is ended.");
		Robot.drivingSys.resetMotors();
	}

	protected void interrupted(){
		System.out.println("TurnWithGyroCommand("+dstAngle+") is interrupted.");
		Robot.drivingSys.resetMotors();
	}
}
