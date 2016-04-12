package org.usfirst.frc.team3773.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortAuto extends CommandGroup {
    
    public  PortAuto() {
    	addSequential(new DriveForward(2, .5));
    	//addParallel(new DriveForward(2, .5));
    	//addSequential(new MoveArm(1, -.3));
    	//addParallel(new MoveArm(1, .3));
    	//addSequential(new DriveForward(2, .5));
    }
}
