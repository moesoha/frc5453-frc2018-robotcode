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
			System.out.println("  Auto. Selected: side to same-side switch");
			new SideStationToSameSideSwitchA(true).start();
		}else if(colorLocationString.charAt(1)==here){
			System.out.println("  Auto. Selected: side to same-side scale");
			new SideStationToSameSideScale(true).start();
		}else{
			System.out.println("  Auto. Selected: side to another-side scale");
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
