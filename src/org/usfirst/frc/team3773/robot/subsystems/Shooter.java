package org.usfirst.frc.team3773.robot.subsystems;

import javax.swing.text.StyleContext.SmallAttributeSet;

import org.usfirst.frc.team3773.robot.Robot;
import org.usfirst.frc.team3773.robot.RobotMap;
import org.usfirst.frc.team3773.robot.commands.autonomous.AutoShoot;

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
	private SpeedController shooterIn;

    public Shooter(){
    	shooterOut1 = new Talon(RobotMap.shooterOut1Channel);
    	shooterOut2 = new Talon(RobotMap.shooterOut2Channel);
    	shooterIn = new Talon(RobotMap.shooterInChannel); 
    }
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
	
	public void shooterIn(){
		shooterOut1.set(1.0);
    	shooterOut2.set(-1.0);
	}
	
	public void shooterOut(){
		shooterOut1.set(-1.0);
    	shooterOut2.set(1.0);
	}
	
	public void stopShooter(){
		shooterOut1.set(0.0);
		shooterOut2.set(0.0);
	}
	
	public void ballIn(){
		shooterIn.set(1.0);
	}
	
	public void ballOut(){
		shooterIn.set(-1.0);
	}
	
	public void stopIntake(){
		shooterIn.set(0.0);
	}
	
	public void log(){
		SmartDashboard.putData(Robot.shooter);
	}
    
    
}

