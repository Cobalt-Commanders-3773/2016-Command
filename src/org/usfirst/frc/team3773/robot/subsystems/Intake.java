package org.usfirst.frc.team3773.robot.subsystems;

import org.usfirst.frc.team3773.robot.Robot;
import org.usfirst.frc.team3773.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController shooterIn;
	
	public Intake(){
		super();
    	shooterIn = new Talon(RobotMap.shooterInChannel); 
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void ballIn(double sens){
		shooterIn.set(1.0*sens);
	}
	
	public void ballOut(double sens){
		shooterIn.set((-1.0)*sens);
	}
	
	public void stopIntake(){
		shooterIn.set(0.0);
	}
	
	public void log(){
		SmartDashboard.putData(Robot.intake);
	}
}

