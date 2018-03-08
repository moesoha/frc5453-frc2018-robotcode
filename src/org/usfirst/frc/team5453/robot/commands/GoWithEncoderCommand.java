package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class GoWithEncoderCommand extends Command{
	double distance=0;
	double speedRate=0.6;

	boolean timeLimitation=false;
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

	public GoWithEncoderCommand(double dst,double spdRate,long timeLimit){
		requires(Robot.drivingSys);
		distance=dst;
		speedRate=spdRate;
		timeLimitation=true;
		maxExecutionTime=timeLimit;
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
		double[] distances=Robot.drivingSys.encoderGetDistance();
		double distanceAvg=(distances[0]+distances[1])/2;
		distanceAvg=distances[1]; // Left Encoder is dead.
		// System.out.println((distance>=distanceAvg)+" "+(stopTimestamp<=System.currentTimeMillis())+" "+(timeLimitation));
		return (distance<=distanceAvg)||((stopTimestamp<=System.currentTimeMillis())&&(timeLimitation));
	}

	protected void end(){
		Robot.drivingSys.resetMotors();
		System.out.println("GoWithEncoderCommand("+distance+") is ended.");
	}

	protected void interrupted(){
		System.out.println("GoWithEncoderCommand("+distance+") is interrupted.");
		end();
	}
}
