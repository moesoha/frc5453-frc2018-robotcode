package org.usfirst.frc.team5453.robot;

import org.usfirst.frc.team5453.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	// init Joysticks
	Joystick driving;
	Joystick operating;
	
	public OI(){
		driving=new Joystick(RobotMap.joystickDriving);
		operating=new Joystick(RobotMap.joystickOperating);
		
		/* Binding command and button event */
		new JoystickButton(operating,RobotMap.joystickIntakeIn).whileHeld(new OperatingIntakeCommand(RobotMap.operatingIntakeSpeedConstant,false));
		new JoystickButton(operating,RobotMap.joystickIntakeOut).whileHeld(new OperatingIntakeCommand(-1*RobotMap.operatingIntakeSpeedConstant,false));
		new JoystickButton(operating,RobotMap.joystickIntakeSlowIn).whileHeld(new OperatingIntakeCommand(RobotMap.operatingIntakeSpeedSlowConstant,false));
		new JoystickButton(operating,RobotMap.joystickIntakeSlowOut).whileHeld(new OperatingIntakeCommand(-1*RobotMap.operatingIntakeSpeedSlowConstant,false));
		// new JoystickButton(operating,RobotMap.joystickIntakeClockwise).whileHeld(new OperatingIntakeCommand(RobotMap.operatingIntakeSpeedConstant,true));
		// new JoystickButton(operating,RobotMap.joystickIntakeAntiClockwise).whileHeld(new OperatingIntakeCommand(-1*RobotMap.operatingIntakeSpeedConstant,true));
		new JoystickButton(operating,RobotMap.joystickClimb).whileHeld(new OperatingClimbCommand(RobotMap.operatingClimbSpeedConstant));
		new JoystickButton(operating,RobotMap.joystickIntakeServoSetFullLeft).whenPressed(new SetIntakeServoCommand(0.0));
		new JoystickButton(operating,RobotMap.joystickIntakeServoSetFullRight).whenPressed(new SetIntakeServoCommand(2.333));
	}
	
	public double readAxis(int port,String which){
		switch(which){
			case "drive":
				return driving.getRawAxis(port);
			case "operate":
				return operating.getRawAxis(port);
			default:
				System.out.println("no method for "+which);
				return 0.0;
		}
	}
	
	public boolean readButton(int port,String which){
		switch(which){
			case "drive":
				return driving.getRawButton(port);
			case "operate":
				return operating.getRawButton(port);
			default:
				System.out.println("no method for "+which);
				return false;
		}
	}
}
