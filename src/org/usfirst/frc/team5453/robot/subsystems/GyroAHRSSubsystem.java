package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class GyroAHRSSubsystem extends Subsystem{
	AHRS ahrs;
	double angle;
	boolean isReady=false;
	double fuckingHeading,lastHeading=0;
	double awesomeYaw=0;

	public GyroAHRSSubsystem(){
		System.out.println("Init gyro (naiveX-MXP) subsystem.");
		ahrs=new AHRS(SPI.Port.kMXP);
		ahrs.reset();
		angle=ahrs.getAngle();
		System.out.println("  naiveX Version: "+ahrs.getFirmwareVersion());
		isReady=true;
	}
	
	public void initDefaultCommand(){}

	public double getHeading(){
		lastHeading=ahrs.getFusedHeading();
		return lastHeading;
	}
	
	public double getYaw(){
		double currentHeading=getHeading();
		double lastDelta=currentHeading-lastHeading;
		if(lastDelta<-200){
			awesomeYaw+=360+currentHeading-lastHeading;
		}else if(lastDelta>200){
			awesomeYaw-=360+currentHeading-lastHeading;
		}else{
			awesomeYaw+=lastDelta;
		}
		return awesomeYaw;
	}
	
	public void reset(){
		ahrs.reset();
		fuckingHeading=getHeading();
	}
}
