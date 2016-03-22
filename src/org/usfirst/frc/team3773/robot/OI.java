
package org.usfirst.frc.team3773.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3773.robot.commands.*;
import org.usfirst.frc.team3773.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //Inputs as private or not?
    Joystick leftJoystick = new Joystick(RobotMap.leftJoystickChannel);
    Joystick rightJoystick = new Joystick(RobotMap.rightJoystickChannel);
    Joystick xboxController = new Joystick(RobotMap.xboxChannel);
    //Not sure if it is correct to put diff axis here and then use an accessor to pull them for commands
    //double driveStickY = rightJoystick.getY();
    //double driveStickX = rightJoystick.getX();
    //boolean driveTrigger = rightJoystick.getRawButton(1);
    JoystickButton driveStick2 = new JoystickButton(rightJoystick, 2); //Button 2 on the driveJoystick
    JoystickButton driveStick3 = new JoystickButton(rightJoystick, 3);
    //double sens = (-rightJoystick.getZ() + 1) / 2.0; //Sets the sensitivity of the drive joystick
    //Xbox controller
    JoystickButton xboxA = new JoystickButton(xboxController, 1); //A button
    JoystickButton xboxB = new JoystickButton(xboxController, 2); //B button
    JoystickButton xboxX = new JoystickButton(xboxController, 3); //X button
    JoystickButton xboxY = new JoystickButton(xboxController, 4); //Y button
    JoystickButton xboxRB = new JoystickButton(xboxController, 6); //Right Bumper
    JoystickButton xboxLB = new JoystickButton(xboxController, 5); //Left Bumper
    //double xboxLX = xboxController.getRawAxis(0); //Left joystick x-axis?
    //double xboxLY = xboxController.getRawAxis(1); //Left joystick y-axis
    //double xboxRX = xboxController.getRawAxis(4); //Right joystick x-axis
    //double xboxRY = xboxController.getRawAxis(5); //Right joystick y-axis
    JoystickButton xboxStart = new JoystickButton(xboxController, 9); //Start button
    //double xboxLT = xboxController.getRawAxis(2); //Left trigger //check axis number
    //double xboxRT = xboxController.getRawAxis(3); //Right trigger //check axis number
        
    public OI() {
    	// Put Some buttons on the SmartDashboard
        //SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0));    
        //SmartDashboard.putData("Deliver Soda", new Autonomous());
        SmartDasboard.putData("Auto Shoot", new AutoShoot());

        // Connect the buttons to commands
        //d_up.whenPressed(new SetElevatorSetpoint(0.2));
        //driveStick3.whenPressed(new SwapCamera());
        xboxX.whenActive(new BallIn());
        xboxY.whenActive(new BallOut());
        xboxLB.whenActive(new ShooterWheels());
        xboxRB.whenActive(new ShooterWheelsReverse());
    }
    
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }
    
    public Joystick getRightJoystick() {
    	return rightJoystick;
    }

    public Joystick getXboxController() {
    	return xboxController;
    }
    //Check
    /**
    public double getXboxLeftJoystickYAxis(){
    	if(Math.abs(xboxLY) <= .25)
        	xboxLY = 0.0;
    	return xboxLY;
    */	
    }
}

