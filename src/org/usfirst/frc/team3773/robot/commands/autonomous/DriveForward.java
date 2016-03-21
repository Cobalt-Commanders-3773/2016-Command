package org.usfirst.frc.team3773.robot.commands.autonomous;

import org.usfirst.frc.team3773.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command drives the robot over a given distance with simple proportional
 * control This command will drive a given distance limiting to a maximum speed.
 */
public class DriveForward extends Command {
	private double driveForwardSpeed;
	private double driveTime;

	public DriveForward(double time, double speed) {
		requires(Robot.drivetrain);
		driveTime = time;
		driveForwardSpeed = speed;
	}

	protected void initialize() {
		setTimeout(driveTime);
	}

	protected void execute() {
		Robot.drivetrain.drive(driveForwardSpeed, 0.0);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
		end();
	}
}