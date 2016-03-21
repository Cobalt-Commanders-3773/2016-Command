package org.usfirst.frc.team3773.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3773.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3773.robot.RobotMap;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController leftDrive, rightDrive;
	private RobotDrive drive;
	private AnalogInput rangefinder;
	private AnalogInput infraRed; 
	private double valueToInches = 102.4; //Factor to convert sensor values to a distance in inches


	public DriveTrain() {
		super();
		leftDrive = new Talon(RobotMap.leftDriveChannel);
		rightDrive = new Talon(RobotMap.rightDriveChannel);
		drive = new RobotDrive(leftDrive, rightDrive);
		rangefinder = new AnalogInput(RobotMap.ultrasonicChannel);
		infraRed = new AnalogInput(RobotMap.infraRedChannel);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
        double currentDistance = (rangefinder.getAverageVoltage())*(valueToInches); //sensor returns a value from 0-4095 that is scaled to inches
        SmartDashboard.putNumber("Distance Graph ", currentDistance);
        SmartDashboard.putNumber("Distance", currentDistance);
        SmartDashboard.putNumber("IRED", infraRed.getAverageVoltage());

	}

	public void drive(double left, double right) {
		drive.arcadeDrive(left, -right);
	}

	public void drive(Joystick joy) {
		drive.arcadeDrive(joy.getY(), -joy.getX());
	}
	
	public void driveFlip(Joystick joy){
		drive.arcadeDrive(-joy.getY(), -joy.getX());
	}
	
	public void driveFlip(double left, double right){
		drive.arcadeDrive(-left, -right);
	}
	
	public void stop(){
		drive.arcadeDrive(0.0, 0.0);
	}

	/**
	 * @return The distance to the obstacle detected by the rangefinder.
	 */
	public double getDistanceToObstacle() { //Not needed?
		// Really meters in simulation since it's a rangefinder...
		return rangefinder.getAverageVoltage();
	}
}
