
package org.usfirst.frc.team3773.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.awt.font.ShapeGraphicAttribute;

import org.usfirst.frc.team3773.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //Create all of the joystick axis and buttons
	private Joystick leftJoystick = new Joystick(RobotMap.leftJoystickChannel);
    private Joystick rightJoystick = new Joystick(RobotMap.rightJoystickChannel);
    private Joystick xboxController = new Joystick(RobotMap.xboxChannel);
    //private double driveStickY = rightJoystick.getY();
    //private double driveStickX = rightJoystick.getX();
    private Button driveTrigger = new JoystickButton(rightJoystick, 1);
    private Button driveStick2 = new JoystickButton(rightJoystick, 2); //Button 2 on the driveJoystick
    private Button driveStick3 = new JoystickButton(rightJoystick, 3);
    //private double sens = (-rightJoystick.getZ() + 1) / 2.0; //Sets the sensitivity of the drive joystick
    //Xbox controller
    private Button xboxA = new JoystickButton(xboxController, 1); //A button
    private Button xboxB = new JoystickButton(xboxController, 2); //B button
    private Button xboxX = new JoystickButton(xboxController, 3); //X button
    private Button xboxY = new JoystickButton(xboxController, 4); //Y button
    private Button xboxRB = new JoystickButton(xboxController, 6); //Right Bumper
    private Button xboxLB = new JoystickButton(xboxController, 5); //Left Bumper
    //private double xboxLX = xboxController.getRawAxis(0); //Left joystick x-axis?
    private double xboxLY = xboxController.getRawAxis(1); //Left joystick y-axis
    //private double xboxRX = xboxController.getRawAxis(4); //Right joystick x-axis
    private double xboxRY = xboxController.getRawAxis(5); //Right joystick y-axis
    //private Button xboxStart = new JoystickButton(xboxController, 8); //Start button (does not work)
    //private double xboxLT = xboxController.getRawAxis(2); //Left trigger //check axis number
    //private double xboxRT = xboxController.getRawAxis(3); //Right trigger //check axis number
        
    public OI() {
    	// Put Some buttons on the SmartDashboard
        //SmartDashboard.putData("String", new Command()); 

        // Connect the buttons to commands
    	xboxX.whileActive(new BallIntake());
        xboxY.whileActive(new BallOut());
        xboxA.whileActive(new SlowBallIn());
        xboxB.whileActive(new SlowBallOut());
        xboxLB.whileActive(new ShooterOut());
        xboxRB.whileActive(new ShooterIn());
        driveTrigger.whileActive(new DriveFlip());
        driveStick3.whenPressed(new StartCamera1());
        driveStick2.whenPressed(new StartCamera2());
    }

    /**
     * Accesses the left joystick
     * 
     * @return Left joystick
     */
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }
    
    /**
     * Accesses the right joystick
     * 
     * @return Right joystick
     */
    public Joystick getRightJoystick() {
    	return rightJoystick;
    }
    
    /**
     * Accesses the xbox controller
     * 
     * @return xbox controller
     */
    public Joystick getXboxController() {
    	return xboxController;
    }
    
    /**
     * Creates a deadzone of .25 and gets the y-axis
     * of the left joystick on the xbox controller
     *     
     * @return xbox left y-axis
     */
    public double getXboxLeftJoystickYAxis(){
    	if(Math.abs(this.getXboxController().getRawAxis(1)) <= .25)
        	xboxLY = 0.0;
    	else
    		xboxLY = this.getXboxController().getRawAxis(1);
    	return xboxLY;
    }
    
    /**
     * Creates a deadzone of .25 and gets the y-axis
     * of the right joystick on the xbox controller
     * 
     * @return
     */
    public double getXboxRightJoystickYAxis(){
    	if(Math.abs(this.getXboxController().getRawAxis(5)) <= .25)
        	xboxRY = 0.0;
    	else
    		xboxRY = this.getXboxController().getRawAxis(5);
    	return xboxRY;
    }

}