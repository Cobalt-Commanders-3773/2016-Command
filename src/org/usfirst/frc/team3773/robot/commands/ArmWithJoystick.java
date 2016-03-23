package org.usfirst.frc.team3773.robot.commands;

import org.usfirst.frc.team3773.robot.Robot;
import org.usfirst.frc.team3773.robot.OI;
import org.usfirst.frc.team3773.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmWithJoystick extends Command {

    public ArmWithJoystick() { //Check the constructor of DriveForward for comparison
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.arm.moveArm(Robot.oi.getXboxController().getRawAxis(1), 1.00);
    	Robot.arm.moveArm(Robot.oi.getXboxLeftJoystickYAxis(), 1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { //Change this?
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.arm.moveArm(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
