package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class GyroXRS450Subsystem extends Subsystem{
	ADXRS450_Gyro xrs450=new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	public GyroXRS450Subsystem(){
		System.out.println("Init gyro subsystem.");
	}
	
	public void initDefaultCommand(){
		
	}
	
	public double getHeading(){
		return xrs450.getAngle();
	}
	
	public void doCalibrate(){
		xrs450.calibrate();
	}
	
	public void reset(){
		xrs450.reset();
	}
}
