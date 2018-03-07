package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.TurnWithGyroCommand;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
import org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand;

public class SideStationToAnotherSideScale extends CommandGroup{
	/*
		Alliance is RED, scaleAtLeft==false 
		
			  [B] Scale [R]
		  ---------------|
		  |
		  |   [B] Switch [R]
		  |
		======Driver Station======
	*/
	public SideStationToAnotherSideScale(boolean scaleAtLeft){
		addSequential(new TimedElevatorCommand(RobotMap.operatingElevatorSpeedSlowConstant,1800));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant,false));

		addSequential(new GoWithEncoderCommand(FieldSize.fromStationToScaleLength-FieldSize.scaleLength/2-FieldSize.robotLength/2-10,0.8));
		addSequential(new TurnWithGyroCommand((scaleAtLeft?-1:1)*88));
		addSequential(new GoWithEncoderCommand(FieldSize.scaleWidth-FieldSize.robotLength/4-10,0.7));
		addSequential(new TurnWithGyroCommand((scaleAtLeft?1:-1)*94));
		addSequential(new TimedGoStraightCommand(0.5,500));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant*-1,false));
	}
}
