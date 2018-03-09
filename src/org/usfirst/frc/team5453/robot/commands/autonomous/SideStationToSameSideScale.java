package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.SleepCommand;
import org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand;

public class SideStationToSameSideScale extends CommandGroup{
	/*
		Alliance is RED, scaleAtLeft==false 
		
		  ----[R] Scale [B]
		  |
		  |
		  |   [B] Switch [R]
		  |
		======Driver Station======
	*/
	public SideStationToSameSideScale(boolean scaleAtLeft){
		addSequential(new SleepCommand(300));
		addSequential(new TheThirdFuckingCommandGroup(scaleAtLeft));
		addSequential(new SetAndCheck("check"));
		addSequential(new TimedGoStraightCommand(0.2,4000));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant*-1,false),1000);
		addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.6,5000));
	}
}
