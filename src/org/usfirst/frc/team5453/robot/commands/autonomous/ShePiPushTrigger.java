package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class ShePiPushTrigger extends Command{
	boolean isLeft=true;
	public ShePiPushTrigger(boolean isLeftLocation){
		isLeft=isLeftLocation;
	}

	protected void initialize(){
		System.out.println("Auto. Command: SHEPI_PUSH");
	}

	protected void execute(){
		String colorLocationString=DriverStation.getInstance().getGameSpecificMessage();
		if(colorLocationString.charAt(0)==(isLeft?'L':'R')){
			System.out.println("  She-Pi Start!");
			new ShePiPushTimed(colorLocationString.charAt(0)==(isLeft?'L':'R')).start();
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
