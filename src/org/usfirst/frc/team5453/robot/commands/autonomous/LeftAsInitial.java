package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team5453.robot.Robot;

public class LeftAsInitial extends Command{
	char here='L';
	
	public LeftAsInitial(){}

	protected void initialize(){
		System.out.println("Auto. Command: INITIAL_LOCATION_LEFT");
	}
	
	private void doNearestSwitch(){
		
	}
	
	private void doNearestAnotherSideSwitch(){
		new SideStationToSameSideSwitchA(false).start();
	}

	private void doScale(){
		
	}
	
	private void doAnotherSideScale(){
		
	}

	protected void execute(){
		String colorLocationString=DriverStation.getInstance().getGameSpecificMessage();
		if(colorLocationString.charAt(0)==here){
			doNearestSwitch();
		}else if(colorLocationString.charAt(1)==here){
			doScale();
		}else{
			doNearestAnotherSideSwitch();
			doAnotherSideScale();
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
