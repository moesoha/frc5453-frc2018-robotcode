package org.usfirst.frc.team5453.robot.commands.autonomous;

import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TheSecondFuckingCommandGroup extends CommandGroup{
	public TheSecondFuckingCommandGroup(){
		addSequential(new TimedElevatorCommand(0.4,3000));
		addSequential(new TimedElevatorCommand(0.2,8000));
	}
}
