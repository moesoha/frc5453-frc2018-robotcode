package org.usfirst.frc.team5453.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class SleepCommand extends Command{
	long ms,stopTimestamp;
	public SleepCommand(long t){
		ms=t;
	}

	protected void initialize(){
		stopTimestamp=System.currentTimeMillis()+ms;
	}

	protected void execute(){}

	protected boolean isFinished(){
		return stopTimestamp<=System.currentTimeMillis();
	}

	protected void end(){}

	protected void interrupted(){
		end();
	}
}
