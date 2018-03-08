package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
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
		addParallel(new TheFuckingCommandGroup());
		addSequential(new GoWithEncoderCommand(FieldSize.fromStationToScaleLength-FieldSize.robotLength/2-7,0.7,0.85+(scaleAtLeft?0.5:-0.5)));
		addSequential(new TimedGoStraightCommand(0.2,4000));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant*-1,false),1000);
		addSequential(new GoWithEncoderCommand(48,0.4));
	}
}
