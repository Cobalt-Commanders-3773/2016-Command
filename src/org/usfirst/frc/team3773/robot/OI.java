
package org.usfirst.frc.team3773.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3773.robot.commands.*;
import org.usfirst.frc.team3773.robot.commands.autonomous.AutoShoot;
import org.usfirst.frc.team3773.robot.commands.autonomous.DriveForward;
import org.usfirst.frc.team3773.robot.commands.autonomous.EngageShooterWheels;
import org.usfirst.frc.team3773.robot.commands.autonomous.FireBall;
import org.usfirst.frc.team3773.robot.commands.autonomous.StopShooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //Inputs as private or not?
	private Joystick leftJoystick = new Joystick(RobotMap.leftJoystickChannel);
    private Joystick rightJoystick = new Joystick(RobotMap.rightJoystickChannel);
    private Joystick xboxController = new Joystick(RobotMap.xboxChannel);
    //Not sure if it is correct to put diff axis here and then use an accessor to pull them for commands
    private double driveStickY = rightJoystick.getY();
    private double driveStickX = rightJoystick.getX();
    private boolean driveTrigger = rightJoystick.getRawButton(1);
    private Button driveStick2 = new JoystickButton(rightJoystick, 2); //Button 2 on the driveJoystick
    private Button driveStick3 = new JoystickButton(rightJoystick, 3);
    private double sens = (-rightJoystick.getZ() + 1) / 2.0; //Sets the sensitivity of the drive joystick
    //Xbox controller
    private Button xboxA = new JoystickButton(xboxController, 1); //A button
    private Button xboxB = new JoystickButton(xboxController, 2); //B button
    private Button xboxX = new JoystickButton(xboxController, 3); //X button
    private Button xboxY = new JoystickButton(xboxController, 4); //Y button
    private Button xboxRB = new JoystickButton(xboxController, 6); //Right Bumper
    private Button xboxLB = new JoystickButton(xboxController, 5); //Left Bumper
    private double xboxLX = xboxController.getRawAxis(0); //Left joystick x-axis?
    private double xboxLY = xboxController.getRawAxis(1); //Left joystick y-axis
    private double xboxRX = xboxController.getRawAxis(4); //Right joystick x-axis
    private double xboxRY = xboxController.getRawAxis(5); //Right joystick y-axis
    private Button xboxStart = new JoystickButton(xboxController, 9); //Start button
    private double xboxLT = xboxController.getRawAxis(2); //Left trigger //check axis number
    private double xboxRT = xboxController.getRawAxis(3); //Right trigger //check axis number
        
    public OI() {
    	// Put Some buttons on the SmartDashboard
        SmartDashboard.putData("Auto Shoot", new AutoShoot());
        SmartDashboard.putData("BallIn", new BallIn());
        SmartDashboard.putData("BallOut", new BallOut());
        SmartDashboard.putData("ShooterWheels", new ShooterWheels());
        SmartDashboard.putData("ShooterWheelsReverse", new ShooterWheelsReverse());
        //SmartDashboard.putData("SwapCamera", new SwapCamera());
        //AutoButtons
        SmartDashboard.putData("AutoShoot", new AutoShoot()); 
        //Maybe change to running the commands in parallel instead if this does not work
        SmartDashboard.putData("DriveForward", new DriveForward(2.0, -.65));
        SmartDashboard.putData("EngageShooterWheels", new EngageShooterWheels(2));
        SmartDashboard.putData("FireBall", new FireBall(2));
        SmartDashboard.putData("StopShooter", new StopShooter());

        // Connect the buttons to commands
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
        //Remove?
    public boolean getDriveTrigger(){
        return driveTrigger;
    }
    
    public Joystick getXboxController() {
    	return xboxController;
    }
    //Create deadzone?
    //Remove?
    public double getXboxLeftJoystickYAxis(){
    	if(Math.abs(xboxLY) <= .25)
        	xboxLY = 0.0;
    	return xboxLY;
    }
    
    public double deadZone(double xboxAxis){
    	if(Math.abs(xboxAxis) <= .25)
			xboxAxis = 0.0;
    	return xboxAxis;

    }
}

