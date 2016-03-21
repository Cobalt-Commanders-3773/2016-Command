package org.usfirst.frc.team3773.robot.subsystems;

import org.usfirst.frc.team3773.robot.RobotMap;
import org.usfirst.frc.team3773.robot.commands.ArmWithJoystick;
import org.usfirst.frc.team3773.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Arm {
	
	private SpeedController armTalon1, armTalon2;
	private double sensitivity = 0, time = 0;
	
	public Arm(){
		super();
		armTalon1 = new Talon(RobotMap.armChannel1);
		armTalon2 = new Talon(RobotMap.armChannel2);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ArmWithJoystick());
	}
	
	public void moveArm(double armSpeed, double sensitivity){
		armTalon1.set(armSpeed*sensitivity);
		armTalon2.set(armSpeed*sensitivity);
	}
	
	public void raiseArm(double armSpeed, double time){
		armTalon1.set(armSpeed);
		armTalon2.set(armSpeed);
	}
	
	public void lowerArm(double armSpeed, double time){
		armTalon1.set(-armSpeed);
		armTalon2.set(-armSpeed);
	}
	
	public void stop(){
		armTalon1.set(0.0);
		armTalon2.set(0.0);
	}
}