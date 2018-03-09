package org.usfirst.frc.team5453.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5453.robot.subsystems.*;

public class Robot extends TimedRobot{
	public static final DrivingSubsystem drivingSys=new DrivingSubsystem();
	public static final GyroAHRSSubsystem gyroSys=new GyroAHRSSubsystem();
	public static final PowerSubsystem powerSys=new PowerSubsystem();
	public static final ElevatorSubsystem elevatorSys=new ElevatorSubsystem();
	public static final IntakeSubsystem intakeSys=new IntakeSubsystem();
	public static final IntakeServoSubsystem intakeServoSys=new IntakeServoSubsystem();
	public static final ClimbSubsystem climbSys=new ClimbSubsystem();
	
	public static OI oi;

	public boolean colorLoaded=false;
	public String colorLocationString;
	public boolean[] colorLocation;

	public static boolean fuckingTesting000=false;
	
	SendableChooser<Command> chooser=new SendableChooser<>();
	Command autonomousCommand;

	@Override
	public void robotInit(){
		System.out.println("Hello, FRC season 2018!");
		System.out.println("Red Comet RobotCode 2018");
		oi=new OI();
		powerSys.initTable();
		
		chooser.addDefault("Go straight (Encoder)",new org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand(110,0.7,0.8));
		chooser.addObject("LEFT (Time) She-Pi",new org.usfirst.frc.team5453.robot.commands.autonomous.ShePiPushTrigger(true));
		chooser.addObject("RIGHT (Time) She-Pi",new org.usfirst.frc.team5453.robot.commands.autonomous.ShePiPushTrigger(false));
		chooser.addObject("Go straight (Time)",new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.6,5000));
		chooser.addObject("<- at LEFT",new org.usfirst.frc.team5453.robot.commands.autonomous.LeftAsInitial());
		chooser.addObject("at RIGHT ->",new org.usfirst.frc.team5453.robot.commands.autonomous.RightAsInitial());
		chooser.addObject("at | CENTER",new org.usfirst.frc.team5453.robot.commands.autonomous.CenterAsInitial());
		chooser.addObject("Still !",new org.usfirst.frc.team5453.robot.commands.autonomous.Still());
		SmartDashboard.putData("Auto mode",chooser);
		gyroSys.reset();

		CameraServer.getInstance().startAutomaticCapture("Camera 0",0);
		CameraServer.getInstance().startAutomaticCapture("Camera 1",1);
	}

	@Override
	public void robotPeriodic(){
		SmartDashboard.putNumber("Testing/Yaw",gyroSys.getYaw());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit(){
		if(drivingSys.isMotorBinded){
			drivingSys.resetMotors();
		}
		if(climbSys.isMotorBinded){
			climbSys.reset();
		}
		if(elevatorSys.isMotorBinded){
			elevatorSys.reset();
		}
		if(intakeSys.isMotorBinded){
			intakeSys.reset();
		}
	}

	@Override
	public void disabledPeriodic(){
		// System.out.println(Robot.gyroSys.getHeading());
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit(){
		// intakeServoSys.setFullRight();
		// intakeServoSys.setFullLeft();
		// intakeServoSys.setFullRight();
		// intakeServoSys.setFullLeft();
		// intakeServoSys.setFullRight();
		// intakeServoSys.setFullLeft();
		intakeServoSys.setFullRight();

		colorLoaded=true;
		colorLocationString=DriverStation.getInstance().getGameSpecificMessage();
		if(colorLocationString.length()>0){
			System.out.println("  Color1: "+colorLocationString.charAt(0));
			System.out.println("  Color2: "+colorLocationString.charAt(1));
			System.out.println("  Color3: "+colorLocationString.charAt(2));
		}else{
			colorLocationString=null;
		}
		
		autonomousCommand=chooser.getSelected();

		if(autonomousCommand!=null){
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit(){
		if(autonomousCommand!=null){
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic(){}
}
