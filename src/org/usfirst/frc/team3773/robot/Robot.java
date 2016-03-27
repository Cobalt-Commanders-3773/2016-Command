
package org.usfirst.frc.team3773.robot;

import org.usfirst.frc.team3773.robot.commands.autonomous.DriveForward;
import org.usfirst.frc.team3773.robot.subsystems.Arm;
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

	public static OI oi;
	public static DriveTrain drivetrain;
	public static Shooter shooter;
	public static Arm arm;

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

    public void robotInit() {
		oi = new OI();
		drivetrain = new DriveTrain();
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
        log();
        
    }

    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

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

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
    	arm.log();
    	shooter.log();
        SmartDashboard.putData(Scheduler.getInstance());
    }
}
