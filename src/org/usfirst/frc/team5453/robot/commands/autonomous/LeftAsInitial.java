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
		if(colorLocationString.charAt(0)==here){
			new SideStationToSameSideSwitchA(false).start();
		}else if(colorLocationString.charAt(1)==here){
			new SideStationToSameSideScale(false).start();
		}else{
			
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
