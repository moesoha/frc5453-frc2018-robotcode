package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class ShePiCenterTrigger extends Command{
	public ShePiCenterTrigger(){
	}

	protected void initialize(){
		System.out.println("Auto. Command: SHEPI_PUSH_CENTER");
	}

	protected void execute(){
		System.out.println("  She-Pi Start!");
		new ShePiCenterTimed().start();
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
