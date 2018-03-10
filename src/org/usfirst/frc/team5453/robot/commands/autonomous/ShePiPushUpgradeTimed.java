package org.usfirst.frc.team5453.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5453.robot.RobotMap;
import org.usfirst.frc.team5453.robot.commands.SetIntakeCommand;
import org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand;
import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;

public class ShePiPushUpgradeTimed extends CommandGroup{
	// SWITCH only
	public ShePiPushUpgradeTimed(boolean isLeft){
		char colorLocationFirst=DriverStation.getInstance().getGameSpecificMessage().charAt(0);
		char colorLocationSecond=DriverStation.getInstance().getGameSpecificMessage().charAt(1);
		if(colorLocationSecond==(isLeft?'L':'R')){
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.7,(isLeft?-1:1)*0.18,4500));
			addSequential(new TimedElevatorCommand(0.5,4000));
			addParallel(new TimedElevatorCommand(0.2,15000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(0.5,3000));
			addParallel(new TimedElevatorCommand(0.2,15000));
			addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant*-1,false),1500);
			addParallel(new TimedElevatorCommand(0.2,2000));
			addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(-0.4,3000));
		}else{
			if(colorLocationFirst==(isLeft?'L':'R')){
				addSequential(new TimedElevatorCommand(0.5,4000));
				addParallel(new TimedElevatorCommand(0.2,15000));
				addSequential(new TimedArcadeGoCommand(0.6,0.3,3000));
				addSequential(new SetIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant*-1,false),1000);
			}
			// addSequential(new org.usfirst.frc.team5453.robot.commands.TimedGoStraightCommand(-0.6,1000));
			// addSequential(new org.usfirst.frc.team5453.robot.commands.TimedArcadeGoCommand(0.8,(colorLocationFirst=='L'?1:-1)*0.67,5000));
		}
	}
}
