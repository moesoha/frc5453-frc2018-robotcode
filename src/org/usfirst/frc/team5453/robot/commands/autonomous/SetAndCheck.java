package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5453.robot.Robot;

public class SetAndCheck extends Command{
	String test="set";

	public SetAndCheck(String method){
		test=method;
	}
	
	protected void initialize(){
		if(test=="set"){
			Robot.fuckingTesting000=true;
		}
	}

	protected void execute(){}

	protected boolean isFinished(){
		return test=="set"?true:(Robot.fuckingTesting000);
	}

	protected void end(){}

	protected void interrupted(){}
}
