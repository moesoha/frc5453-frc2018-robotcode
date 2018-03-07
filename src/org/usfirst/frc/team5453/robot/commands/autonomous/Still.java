package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class Still extends Command{
	public Still(){}

	protected void initialize(){
		System.out.println("Auto. Command: STILL");
	}

	protected void execute(){}

	protected boolean isFinished(){
		return true;
	}

	protected void end(){
		System.out.println("AutonomousCommand is ended.");
	}

	protected void interrupted(){
		System.out.println("AutonomousCommand is interrupted.");
		end();
	}
}
