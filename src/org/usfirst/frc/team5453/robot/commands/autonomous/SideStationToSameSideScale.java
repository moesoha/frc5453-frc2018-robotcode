package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.TurnWithGyroCommand;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
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
		addSequential(new TimedElevatorCommand(RobotMap.operatingElevatorSpeedSlowConstant,1800));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant,false));

		addSequential(new GoWithEncoderCommand(FieldSize.fromStationToScaleLength-FieldSize.robotLength/2-7,0.8));
		addSequential(new TurnWithGyroCommand((scaleAtLeft?-1:1)*80),0.6);
		addSequential(new TimedGoStraightCommand(0.6,500));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant*-1,false));
	}
}
