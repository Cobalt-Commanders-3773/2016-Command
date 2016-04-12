package org.usfirst.frc.team3773.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoFire extends CommandGroup {
    
    public  AutoFire() {
    	addSequential(new DriveForward(2, -.85));
    	addSequential(new AutoShoot(1));
    	addParallel(new AutoIntake(1));
    	addSequential(new AutoShoot(1));
    	
    }
}
