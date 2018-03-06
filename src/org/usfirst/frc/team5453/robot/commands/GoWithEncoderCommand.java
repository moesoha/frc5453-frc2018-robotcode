package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class GoWithEncoderCommand extends Command{
	double distance=0;
	double speedRate=0.6;

	long maxExecutionTime=5000;
	long stopTimestamp;
	
	// Here `angle`, positive is clockwise, negative is anticlockwise.
	public GoWithEncoderCommand(double dst){
		requires(Robot.drivingSys);
		distance=dst;
	}

	public GoWithEncoderCommand(double dst,double spdRate){
		requires(Robot.drivingSys);
		distance=dst;
		speedRate=spdRate;
	}
	
	protected void initialize(){
		System.out.println("GoWithEncoderCommand("+distance+") is initialized.");
		stopTimestamp=System.currentTimeMillis()+maxExecutionTime;
		Robot.drivingSys.encoderReset();
	}

	protected void execute(){
		Robot.drivingSys.tankDrive((distance>=0?-1:1)*speedRate,(distance>=0?1:-1)*speedRate,false);
	}

	protected boolean isFinished(){
		return (distance>=Robot.drivingSys.encoderGetDistance()[1])||(stopTimestamp<=System.currentTimeMillis());
	}

	protected void end(){
		System.out.println("GoWithEncoderCommand("+distance+") is ended.");
		Robot.drivingSys.resetMotors();
	}

	protected void interrupted(){
		System.out.println("GoWithEncoderCommand("+distance+") is interrupted.");
		Robot.drivingSys.resetMotors();
	}
}
