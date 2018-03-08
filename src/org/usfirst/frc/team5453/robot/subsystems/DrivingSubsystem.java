package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team5453.robot.commands.*;
import org.usfirst.frc.team5453.robot.RobotMap;

@SuppressWarnings("deprecation")
public class DrivingSubsystem extends Subsystem{
	private VictorSP[] motor;
	private RobotDrive drive;
	private Encoder[] encoder;
	
	boolean tableInited=false;
	public boolean isMotorBinded=false;

	public DrivingSubsystem(){
		System.out.println("Init driving subsystem.");
	}
	
	public void bindMotors(){
		motor=new VictorSP[]{
			new VictorSP(RobotMap.pwmMotorLeft),
			new VictorSP(RobotMap.pwmMotorRight)
		};

		drive=new RobotDrive(motor[0],motor[1]);
		for(int i=0;i<motor.length;i++){
			motor[i].setSafetyEnabled(false);
		}
		drive.setSafetyEnabled(false);

		encoder=new Encoder[]{
			new Encoder(RobotMap.dioEncoderLeftChannel[0],RobotMap.dioEncoderLeftChannel[1]),
			new Encoder(RobotMap.dioEncoderRightChannel[0],RobotMap.dioEncoderRightChannel[1])
		};
		encoder[0].setReverseDirection(true);
		encoder[0].setDistancePerPulse(RobotMap.encoderChassisDistancePerPulse);
		encoder[1].setDistancePerPulse(RobotMap.encoderChassisDistancePerPulse);

		isMotorBinded=true;
	}
	
	public void initDefaultCommand(){
		setDefaultCommand(new DrivingCommand());
		bindMotors();
	}
	
	public void resetMotors(){
		for(int i=0;i<motor.length;i++){
			motor[i].stopMotor();
		}
		drive.stopMotor();
	}
	
	public void resetMotor(int serialNumber){
		motor[serialNumber].stopMotor();
	}

	public void drivingMotorsControlRaw(String where,double value){
		switch(where){
			case "left":
				motor[0].setSpeed(value);
				motor[1].setSpeed(value);
				break;
			case "right":
				motor[2].setSpeed(value);
				motor[3].setSpeed(value);
				break;
			case "turn":
				motor[0].setSpeed(-value);
				motor[1].setSpeed(-value);
				motor[2].setSpeed(value);
				motor[3].setSpeed(value);
				break;
			case "all":
				motor[0].setSpeed(value);
				motor[1].setSpeed(value);
				motor[2].setSpeed(value);
				motor[3].setSpeed(value);
				break;
			default:
				System.out.println("no method for "+where);
				break;
		}
	}

	public boolean[] encoderGetDirection(){
		return new boolean[]{
			encoder[0].getDirection(),
			encoder[1].getDirection()
		};
	}

	public double[] encoderGetDistance(){
		return new double[]{
			encoder[0].getDistance(),
			encoder[1].getDistance()
		};
	}

	public void encoderReset(){
		encoder[0].reset();
		encoder[1].reset();
	}
	
	public void arcadeDrive(double x,double y,boolean squared){
		drive.arcadeDrive(y,x,squared);
	}

	public void tankDrive(double l,double r,boolean squaredInputs){
		drive.tankDrive(l,r,squaredInputs);
	}
}

