package org.usfirst.frc.team3773.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DelayDriveAuto extends CommandGroup {
    
    public  DelayDriveAuto(double delayTime, double time, double speed) {
    	addSequential(new WaitCommand(delayTime));
    	addSequential(new DriveForward(time, speed));
    }
}
