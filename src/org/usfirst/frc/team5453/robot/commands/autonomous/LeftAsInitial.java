package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class LeftAsInitial extends Command{
	char here='L';
	
	public LeftAsInitial(){}

	protected void initialize(){
		System.out.println("Auto. Command: INITIAL_LOCATION_LEFT");
	}

	protected void execute(){
		String colorLocationString=DriverStation.getInstance().getGameSpecificMessage();
		if(colorLocationString.charAt(1)==here){
			System.out.println("  Auto. Selected: side to same-side scale");
			new SideStationToSameSideScale(false).start();
		}else if(colorLocationString.charAt(0)==here){
			System.out.println("  Auto. Selected: side to same-side switch");
			// new SideStationToSameSideSwitchA(false).start();
			new org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand(110,0.7,0.8).start();
		}else{
			System.out.println("  Auto. Selected: side to another-side scale");
			new org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand(110,0.7,0.8).start();
		}
	}

	protected boolean isFinished(){
		return true;
	}

	protected void end(){
		// System.out.println("AutonomousCommand is ended.");
	}

	protected void interrupted(){
		// System.out.println("AutonomousCommand is interrupted.");
		end();
	}
}
