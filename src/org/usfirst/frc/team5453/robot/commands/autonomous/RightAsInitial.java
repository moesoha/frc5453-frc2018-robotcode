package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class RightAsInitial extends Command{
	char here='R';
	
	public RightAsInitial(){}

	protected void initialize(){
		System.out.println("Auto. Command: INITIAL_LOCATION_RIGHT");
	}

	protected void execute(){
		String colorLocationString=DriverStation.getInstance().getGameSpecificMessage();
		if(colorLocationString.charAt(0)==here){
			new SideStationToSameSideSwitchA(true).start();
		}else if(colorLocationString.charAt(1)==here){
			new SideStationToSameSideScale(true).start();
		}else{
			new SideStationToAnotherSideScale(true).start();
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
