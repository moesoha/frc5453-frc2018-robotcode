package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class TurnWithGyroCommand extends Command{
	double dstAngle=0;
	double speedRate=0.6;
	double angleT;

	boolean timeLimitation=false;
	long maxExecutionTime=5000;
	long stopTimestamp;
	
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

	public TurnWithGyroCommand(double angle,double spdRate,long timeLimit){
		requires(Robot.drivingSys);
		dstAngle=angle;
		speedRate=spdRate;
		timeLimitation=true;
		maxExecutionTime=timeLimit;
	}

	protected void initialize(){
		System.out.println("TurnWithGyroCommand("+dstAngle+") is initialized.");
		stopTimestamp=System.currentTimeMillis()+maxExecutionTime;
		Robot.gyroSys.reset();
		angleT=Robot.gyroSys.getHeading();
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
		return (false/*Here is Gyro judging*/)||((stopTimestamp<=System.currentTimeMillis())&&(timeLimitation));
	}

	protected void end(){
		Robot.drivingSys.resetMotors();
		System.out.println("TurnWithGyroCommand("+dstAngle+") is ended.");
	}

	protected void interrupted(){
		System.out.println("TurnWithGyroCommand("+dstAngle+") is interrupted.");
		end();
	}
}
