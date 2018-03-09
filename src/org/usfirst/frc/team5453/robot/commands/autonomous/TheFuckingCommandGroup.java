package org.usfirst.frc.team5453.robot.commands.autonomous;

import org.usfirst.frc.team5453.robot.commands.TimedElevatorCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TheFuckingCommandGroup extends CommandGroup{
	public TheFuckingCommandGroup(){
		addSequential(new TimedElevatorCommand(0.5,5000));
		addSequential(new SetAndCheck("set"));
		addSequential(new TimedElevatorCommand(0.1,8000));
		addSequential(new TimedElevatorCommand(-0.1,500));
	}
}
