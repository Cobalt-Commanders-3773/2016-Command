package org.usfirst.frc.team3773.robot.subsystems;

import org.usfirst.frc.team3773.robot.Robot;
import org.usfirst.frc.team3773.robot.RobotMap;
import org.usfirst.frc.team3773.robot.commands.ArmWithJoystick;
import org.usfirst.frc.team3773.robot.commands.ArmWithJoystickSlow;
import org.usfirst.frc.team3773.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem{
	
	private SpeedController armTalon1, armTalon2;
	private DigitalInput armLimit;
	
	/**
	 * 
	 */
	public Arm(){
		super();
		armTalon1 = new Talon(RobotMap.armChannel1);
		armTalon2 = new Talon(RobotMap.armChannel2);
		armLimit = new DigitalInput(RobotMap.armLimitChannel);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ArmWithJoystick());
		//setDefaultCommand(new ArmWithJoystickSlow());
	}

	public void moveArm(double armSpeed){
		armTalon1.set(armSpeed);
		armTalon2.set(armSpeed);
	}
	
	public void stop(){
		armTalon1.set(0.0);
		armTalon2.set(0.0);
	}
	
	public boolean getArmLimit(){
		return armLimit.get();
	}
	
	public void log(){
		SmartDashboard.putData(Robot.arm);
		SmartDashboard.putBoolean("Arm Limit", armLimit.get());
	}
}
