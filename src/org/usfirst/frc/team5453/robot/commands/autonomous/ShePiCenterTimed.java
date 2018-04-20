package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiCenterTimed extends CommandGroup{
	// auto select left or right
	public ShePiCenterTimed(){
		char colorLocationFirst=DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if(colorLocationFirst=='L'){
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new TimedElevatorCommand(0.5,3000));
			addParallel(new TimedElevatorCommand(0.2,5000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.61,-0.48,2550));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.7,0.45,1300));
			addParallel(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.4,3800));
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedAutoConstant*-1,false),1000);
		}else if(colorLocationFirst=='R'){
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new TimedElevatorCommand(0.5,3000));
			addParallel(new TimedElevatorCommand(0.2,5000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.62,0.38,2400));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.7,-0.62,1300));
			addParallel(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.4,3800));
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedAutoConstant*-1,false),1000);
		}
	}
}
