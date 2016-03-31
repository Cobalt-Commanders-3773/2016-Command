package org.usfirst.frc.team3773.robot.commands.autonomous;

import org.usfirst.frc.team3773.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EngageShooterWheels extends Command {

    public EngageShooterWheels() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	//setTimeout(delay);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.shooterOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() { //Should not stop the shooter wheels so that they will be up to speed later
        Robot.shooter.stopShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.shooter.stopShooer();
    }
}
