package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc.team5453.robot.RobotMap;

public class IntakeServoSubsystem extends Subsystem{
	private Servo servo;
	public boolean isBinded=false;
	
	public void initDefaultCommand(){
		bindServo();
	}

	public IntakeServoSubsystem(){
		System.out.println("Init intake.servo subsystem.");
	}
	
	public void bindServo(){
		servo=new Servo(RobotMap.pwmServoIntake);
		isBinded=true;
	}

	public void setAngle(double degree){
		servo.setAngle(degree);
	}

	public void set(double value){
		if(value>1.0){
			huajiTest();
			return;
		}
		servo.set(value);
		//servo.setDisabled();
	}

	public double getAngle(){
		return servo.getAngle();
	}

	public double get(){
		return servo.get();
	}

	public void disable(){
		servo.setDisabled();
	}
	
	public void setFullLeft(){
		servo.set(0.0);
		//servo.setDisabled();
	}
	
	public void setFullRight(){
		servo.set(1.0);
		// servo.set(0.7); //use 0.7 instead of 1.0
		//servo.setDisabled();
	}

	public void huajiTest(){
		// setFullRight();
		// setFullLeft();
		// setFullRight();
		// setFullLeft();
		// setFullRight();
		// setFullLeft();
		setFullRight();
	}
}
