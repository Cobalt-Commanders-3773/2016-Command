
package org.usfirst.frc.team3773.robot;

import org.usfirst.frc.team3773.robot.commands.autonomous.DriveForward;
import org.usfirst.frc.team3773.robot.subsystems.Arm;
import org.usfirst.frc.team3773.robot.subsystems.Camera;
import org.usfirst.frc.team3773.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3773.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Camera camera;
	public static Shooter shooter;
	public static Arm arm; //Check to see why Arm is invalid but DriveTrain is not

    Command autonomousCommand;    
    final String defaultAuto = "Default";
    final String portAuto = "Portcullis";
    final String chevalAuto = "Cheval de Frise";
    final String moatAuto = "Moat";
    final String rampAuto = "Ramparts";
    final String drawAuto = "Drawbridge";
    final String sallyAuto = "Sally Port";
    final String rockAuto = "Rock Wall";
    final String roughAuto = "Rough Terrain";
    final String minAuto = "Auto Line";
    final String testAuto = "Test Auto";
    String autoSelected;
    SendableChooser chooser; //Create the chooser for the dashboard

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		drivetrain = new DriveTrain();
		camera = new Camera();
		shooter = new Shooter();
		arm = new Arm();
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("Portcullis", portAuto);
        chooser.addObject("Cheval de Frise", chevalAuto);
        chooser.addObject("Moat", moatAuto);
        chooser.addObject("Ramparts", rampAuto);
        chooser.addObject("Drawbridge", drawAuto);
        chooser.addObject("Sally Port", sallyAuto);
        chooser.addObject("Rock Wall", rockAuto);
        chooser.addObject("Rough Terrain", roughAuto);
        chooser.addObject("Auto Line", minAuto);
        chooser.addObject("Test Auto", testAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        switch(autoSelected) {
    	case portAuto:
    		//Code to complete the Portcullis
    		
            break;
    	case chevalAuto:
    		//Code to complete the Cheval de Frise
    		
    		break;
    	case moatAuto:
    		//Code to complete the Moat
    		autonomousCommand = new DriveForward(2, -.65);
    		break;
    	case rampAuto:
    		//Code to complete the Ramparts
    		autonomousCommand = new DriveForward(2, -.85);
    		break;
    	case drawAuto:
    		//Code to complete the Drawbridge

    		break;
    	case sallyAuto:
    		//Code to complete the Sallyport
    		 
    		break;
    	case rockAuto:
    		//Code to complete the Rock Wall
    		autonomousCommand = new DriveForward(2.5, -.85);
    		break;
    	case roughAuto:
    		//Code to complete the Rough Terrain
    		autonomousCommand = new DriveForward(2.5, -.65);
    		break;
    	case minAuto:
    		//Code to drive over the auto line at the start of the match
    		autonomousCommand = new DriveForward(1, -.5); //(time in seconds, speed of motors)
    		break;
    	case testAuto: //FOR TESTING AUTO IDEAS
    		//Space to test Auto concepts
    		
    		break;
    	case defaultAuto:
    	default:
    		//The robot does nothing
            break;
    	}
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
    }
}
