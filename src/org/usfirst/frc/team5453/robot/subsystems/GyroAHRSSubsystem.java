package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class GyroAHRSSubsystem extends Subsystem{
	AHRS ahrs;
	double angle;
	boolean isReady=false;

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
		return ahrs.getCompassHeading();
	}
	
	public AHRS.BoardYawAxis getYaw(){
		return ahrs.getBoardYawAxis();
	}
	
	public void reset(){
		ahrs.reset();
	}
}
