package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.TurnWithGyroCommand;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand;

public class SideStationToSameSideSwitchA extends CommandGroup{
	/* PLAN A
		Alliance is RED, switchAtLeft==false 
		
		      [R] Scale [B]


		  ----[R] Switch [B]
		  |
		======Driver Station======
	*/
	public SideStationToSameSideSwitchA(boolean switchAtLeft){
		addParallel(new TheSecondFuckingCommandGroup());
		addSequential(new GoWithEncoderCommand(FieldSize.fromStationToSwitchLength-FieldSize.robotLength/2-7,0.7,0.8));
		addSequential(new TurnWithGyroCommand((switchAtLeft?-1:1)*90));
		addSequential(new TimedGoStraightCommand(0.2,1000));
		addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedConstant*-1,false));
	}
}
