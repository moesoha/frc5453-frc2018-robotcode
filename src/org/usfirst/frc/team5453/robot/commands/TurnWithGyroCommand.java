package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class TurnWithGyroCommand extends Command{
	double dstAngle=0;
	double speedRate=0;
	double dltAngle;
	double angleT;
	boolean grdSpeed=false;

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
		dltAngle=Math.abs(dstAngle-angleT);
	}

	protected void execute(){
		if(speedRate==0){
			grdSpeed=true;
		}
		if(grdSpeed){
			if(dltAngle<20){
				speedRate=0.48;
			}else if(dltAngle<50){
				speedRate=0.5;
			}else if(dltAngle<90){
				speedRate=0.54;
			}else{
				speedRate=0.6;
			}
		}
		Robot.drivingSys.tankDrive((dstAngle>=0?-1:1)*speedRate,(dstAngle>=0?-1:1)*speedRate,false);
	}

	protected boolean isFinished(){
		dltAngle=Math.abs(dstAngle-Robot.gyroSys.getYaw());
		// NOTICE
		// Here is not finished yet.
		// How to get yaw angle?
		// Refer to GyroAHRSSubsystem
		// is BoardYawAxis correct?
		return (Math.abs(dltAngle)<=2)||((stopTimestamp<=System.currentTimeMillis())&&(timeLimitation));
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
