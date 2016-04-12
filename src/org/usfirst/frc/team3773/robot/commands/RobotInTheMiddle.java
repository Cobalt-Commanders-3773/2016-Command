package org.usfirst.frc.team3773.robot.commands;

import java.util.Random;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RobotInTheMiddle extends CommandGroup {
    
    private Random randGen;
    private int time;
    
    public  RobotInTheMiddle() {
        //Robot spins in a circle for a random amount of time and then shoots the ball
        randGen = new Random();
        this.time = randGen.nextInt(10);
        addSequential(new SpinRobot(this.time, .5));
        addSequential(new AutoFire());
    }
}
