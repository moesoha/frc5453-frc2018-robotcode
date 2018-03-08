package org.usfirst.frc.team5453.robot;

public class RobotMap{
	/*
		  - Motor Definition
		  ========FRONT========
		  Left23        Right01
		  ========REAR=========
	*/
	/* PWM Definition */
	public static int pwmMotorLeft=0;
	public static int pwmMotorRight=1;
	public static int[] pwmMotorOnChassis={
		pwmMotorLeft,
		pwmMotorRight,
	};
	public static int[] pwmMotorElevator={2,3};
	public static int[] pwmMotorIntake={4,5};
	public static int[] pwmMotorClimb={6};
	public static int pwmServoIntake=7;

	/* DIO Definition */
	/* Encoder   0-Channel A, 1-Channel B*/
	public static int[] dioEncoderLeftChannel={0,1};
	public static int[] dioEncoderRightChannel={2,3};
	
	/* PDP Channels */
	public static int[] pdpMotorOnChassis={0,2,12,14};
	public static int[] pdpMotorElevator={5,6};
	public static int[] pdpMotorIntake={7,8};
	public static int pdpMotorClimb=9;
	
	/* Stall Current */
	public static double pdpMotorOnChassisCriticalCurrent=40;/* Unit: Amp */
	
	/* Driving Definition */
	public static boolean drivingSquaredInput=true;
	
	/* Constant Definition */
	public static double[] drivingSpeedConstant={0.8,-0.4,+0.2};
	public static double operatingElevatorSpeedFastConstant=0.8;
	public static double operatingElevatorSpeedSlowConstant=0.6;
	public static double operatingIntakeSpeedConstant=0.67;
	
	/* Joystick Port Definition */
	public static int joystickDriving=0;
	public static int joystickOperating=1;
	/* Joystick Axis Binding Definition */
	public static int joystickDrivingLeverL=1;
	public static int joystickDrivingLeverR=3;
	public static int[] joystickDrivingSpeedControl={0,7,5};
	public static int joystickClimbLever=1;
	/* Joystick Button Binding Definition */
	public static int joystickElevatorUpFast=6;
	public static int joystickElevatorUpSlow=5;
	public static int joystickElevatorDownFast=8;
	public static int joystickElevatorDownSlow=7;
	public static int joystickIntakeIn=2;
	public static int joystickIntakeOut=4;
	public static int joystickIntakeClockwise=3;
	public static int joystickIntakeAntiClockwise=1;
	public static int joystickIntakeServoSetFullLeft=9;
	public static int joystickIntakeServoSetFullRight=10;
	
	/* Encoder Parameter */
	public static double encoderPulsePerRevolution=1440;
	public static double encoderChassisDistancePerPulse=6*Math.PI/encoderPulsePerRevolution; // inch
}
