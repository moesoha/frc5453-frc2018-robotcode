package org.usfirst.frc.team5453.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class PowerSubsystem extends Subsystem{
	PowerDistributionPanel pdp;
	boolean tableInited=false;
	
	public void initDefaultCommand(){}
	
	public PowerSubsystem(){
		System.out.println("Init power subsystem.");
		pdp=new PowerDistributionPanel();
	}
	
	public void initTable(){
		//if(!tableInited) {
		//	pdp.initSendable(sb);
		//}
	}
		
	public double getCurrent(int channel){
		return pdp.getCurrent(channel);
	}
	
	public double getTemperature(){
		return pdp.getTemperature();
	}
	
	public double getTotalCurrent(){
		return pdp.getTotalCurrent();
	}
	
	public double getTotalVoltage(){
		return pdp.getVoltage();
	}
}
