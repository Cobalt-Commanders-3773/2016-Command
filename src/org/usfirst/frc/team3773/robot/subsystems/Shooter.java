package org.usfirst.frc.team3773.robot.subsystems;

import org.usfirst.frc.team3773.robot.Robot;
import org.usfirst.frc.team3773.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Split into two subsysems?
 * the shooter and the buffer bar?
 */
public class Shooter extends Subsystem {
   
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController shooterOut1;
	private SpeedController shooterOut2;

    public Shooter(){
    	super();
    	shooterOut1 = new Talon(RobotMap.shooterOut1Channel);
    	shooterOut2 = new Talon(RobotMap.shooterOut2Channel);
    }
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		//setDefaultCommand(new ShooterWheelsOut());
    }
	
	public void shooterIn(double sens){
		shooterOut1.set(1.0);
    	shooterOut2.set(-1.0);
	}
	
	public void shooterOut(double sens){
		shooterOut1.set(-1.0);
    	shooterOut2.set(1.0);
	}
	
	public void stopShooter(){
		shooterOut1.set(0.0);
		shooterOut2.set(0.0);
	}

	
	public void log(){
		SmartDashboard.putData(Robot.shooter);
	}   
}