package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiPushUpgradeTimed extends CommandGroup{
	// Same-side SWITCH or SCALE only
	public ShePiPushUpgradeTimed(boolean isLeft){
		char colorLocationSecond=DriverStation.getInstance().getGameSpecificMessage().charAt(1);
		if(colorLocationSecond==(isLeft?'L':'R')){
			addSequential(new org.usfirst.frc.team5453.robot.commands.SleepCommand(500));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.9,(isLeft?-1:-1.07)*0.32,1500));
			addSequential(new TimedElevatorCommand(0.6,4000));
			addParallel(new TimedElevatorCommand(0.2,15000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.6,(isLeft?1:-0.93)*0.37,1700));
			// addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.5,(isLeft?-1:-1.1)*0.36,2600));
			// addParallel(new TimedElevatorCommand(0.2,15000));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedAutoConstant*-1,false),1500);
			addParallel(new TimedElevatorCommand(0.2,2000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(-0.4,3800));
		}else{
			addSequential(new ShePiPushRtAngleSwitchTimed(isLeft));
		}
	}
}
