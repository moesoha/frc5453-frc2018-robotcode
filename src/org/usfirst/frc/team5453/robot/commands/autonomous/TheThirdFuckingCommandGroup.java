package org.usfirst.frc.team5453.robot.commands.autonomous;

import org.usfirst.frc.team5453.robot.FieldSize;
import org.usfirst.frc.team5453.robot.commands.GoWithEncoderCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TheThirdFuckingCommandGroup extends CommandGroup{
	public TheThirdFuckingCommandGroup(boolean scaleAtLeft){
		addParallel(new TheFuckingCommandGroup());
		addParallel(new GoWithEncoderCommand(FieldSize.fromStationToScaleLength-FieldSize.robotLength/2-7,0.7,0.85+(scaleAtLeft?0.5:-0.5)));
	}
}
