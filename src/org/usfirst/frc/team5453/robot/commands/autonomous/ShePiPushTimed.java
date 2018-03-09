package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiPushTimed extends CommandGroup{
	// SWITCH only
	public ShePiPushTimed(boolean isPush){
		addSequential(new TimedElevatorCommand(0.5,2000));
		addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.6,3000));
		if(isPush){
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant*-1,false),1000);
		}
	}
}
