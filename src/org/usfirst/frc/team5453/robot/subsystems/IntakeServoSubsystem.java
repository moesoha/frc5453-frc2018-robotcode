package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc.team5453.robot.RobotMap;

public class IntakeServoSubsystem extends Subsystem{
	private Servo servo;
	
	public void initDefaultCommand(){
		bindServo();
	}

	public IntakeServoSubsystem(){
		System.out.println("Init intake.servo subsystem.");
	}
	
	public void bindServo(){
		servo=new Servo(RobotMap.pwmServoIntake);
	}

	public void setAngle(double degree){
		servo.setAngle(degree);
	}

	public void set(double value){
		servo.set(value);
	}

	public double getAngle(){
		return servo.getAngle();
	}

	public double get(){
		return servo.get();
	}
	
	public void setFullLeft(){
		servo.set(0.0);
	}
	
	public void setFullRight(){
		servo.set(1.0);
	}
}
