package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiPushRtAngleSwitchTimed extends CommandGroup{
	// Same-side SWITCH or SCALE only
	public ShePiPushRtAngleSwitchTimed(boolean isLeft){
		char colorLocationSecond=DriverStation.getInstance().getGameSpecificMessage().charAt(1);
		if(colorLocationSecond==(isLeft?'L':'R')){
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new TimedElevatorCommand(0.5,3000));
			addParallel(new TimedElevatorCommand(0.2,2000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.7,(isLeft?-1:-1.07)*0.22,1800));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.5,(isLeft?1:-1.1)*0.5,2000));
			addParallel(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.4,3000));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedAutoConstant*-1,false),1000);
		}else{
			addSequential(new ShePiPushTimed(isLeft));
		}
	}
}
