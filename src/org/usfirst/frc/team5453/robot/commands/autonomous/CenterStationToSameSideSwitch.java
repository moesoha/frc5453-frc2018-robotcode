package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.TurnWithGyroCommand;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
import org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand;

public class CenterStationToSameSideSwitch extends CommandGroup{
	/* 
		Alliance is RED
		
		      [R] Scale [B]


			  [R] Switch [B]
		       |-----
		            |
		======Driver Station======
	*/
	public CenterStationToSameSideSwitch(boolean targetSwitchAtLeft){
		addSequential(new TimedElevatorCommand(RobotMap.operatingElevatorSpeedLeverRate*0.7,700));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant,false));

		addSequential(new GoWithEncoderCommand(FieldSize.robotLength/2,0.5));
		addSequential(new TurnWithGyroCommand((targetSwitchAtLeft?-1:1)*88));
		addSequential(new GoWithEncoderCommand(FieldSize.scaleWidth/2-10,0.7));
		addSequential(new TurnWithGyroCommand((targetSwitchAtLeft?1:-1)*92));
		addSequential(new GoWithEncoderCommand(FieldSize.fromStationToSwitchLength-FieldSize.fieldLength/2-FieldSize.robotLength-6,0.5));
		addSequential(new TimedGoStraightCommand(0.5,300));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant*-1,false));
	}
}
