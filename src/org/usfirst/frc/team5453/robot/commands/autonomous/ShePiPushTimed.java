package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiPushTimed extends CommandGroup{
	// SWITCH only
	public ShePiPushTimed(boolean isLeft){
		char colorLocationFirst=DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		if(colorLocationFirst==(isLeft?'L':'R')){
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new TimedElevatorCommand(0.5,3000));
			addParallel(new TimedElevatorCommand(0.2,4000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.6,3000));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedAutoConstant*-1,false),1000);
		}else{
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.6,5000));
		}
		// addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(-0.6,1000));
		// addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.8,(colorLocationFirst=='L'?1:-1)*0.67,5000));
	}
}
