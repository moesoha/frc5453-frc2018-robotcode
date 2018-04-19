package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class ShePiPushRtAngleSwitchTrigger extends Command{
	boolean isLeft=true;
	public ShePiPushRtAngleSwitchTrigger(boolean isLeftLocation){
		isLeft=isLeftLocation;
	}

	protected void initialize(){
		System.out.println("Auto. Command: SHEPI_PUSH_RTANGLE");
	}

	protected void execute(){
		System.out.println("  She-Pi RtAngle Start!");
		new ShePiPushRtAngleSwitchTimed(isLeft).start();
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
