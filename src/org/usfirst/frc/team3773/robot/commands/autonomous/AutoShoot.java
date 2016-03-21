package org.usfirst.frc.team3773.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShoot extends CommandGroup {

    public AutoShoot() {
    	addSequential(new EngageShooterWheels(1));
    	addSequential(new FireBall(2));
    	addSequential(new StopShooter());
        
    }
}