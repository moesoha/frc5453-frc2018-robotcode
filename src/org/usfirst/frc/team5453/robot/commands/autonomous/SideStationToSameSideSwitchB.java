package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.TurnWithGyroCommand;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
import org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand;

public class SideStationToSameSideSwitchB extends CommandGroup{
	/* PLAN B
		Alliance is RED, switchAtLeft==false 
		
		      [R] Scale [B]


		      [R] Switch [B]
		  -----|
		  |
		======Driver Station======
	*/
	public SideStationToSameSideSwitchB(boolean switchAtLeft){
		addSequential(new TimedElevatorCommand(RobotMap.operatingElevatorSpeedSlowConstant,1200));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant,false));

		addSequential(new TimedGoStraightCommand(0.56,666));
		addSequential(new TurnWithGyroCommand((switchAtLeft?-1:1)*76),0.6);
		addSequential(new GoWithEncoderCommand(FieldSize.fromLengthSideToSwitchLength-FieldSize.portalWidth+8,0.6));
		addSequential(new TurnWithGyroCommand((switchAtLeft?1:-1)*86),0.57);
		addSequential(new TimedGoStraightCommand(0.66,1000));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant*-1,false));
	}
}
