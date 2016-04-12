
package org.usfirst.frc.team3773.robot;

import org.usfirst.frc.team3773.robot.commands.DelayDriveAuto;
import org.usfirst.frc.team3773.robot.commands.DriveForward;
import org.usfirst.frc.team3773.robot.commands.PortAuto;
import org.usfirst.frc.team3773.robot.commands.WaitCommand;
import org.usfirst.frc.team3773.robot.subsystems.Arm;
import org.usfirst.frc.team3773.robot.subsystems.Camera;
import org.usfirst.frc.team3773.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3773.robot.subsystems.Intake;
import org.usfirst.frc.team3773.robot.subsystems.Shooter;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Names the subsystems that will be used in commands later
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Shooter shooter;
	public static Arm arm;
	public static Intake intake;
	public static Camera camera;
    
    String autoSelected; //The string that will indicate what autonomous mode has been selected
    SendableChooser chooser; //Create the chooser for the dashboard
    Command autonomousCommand; //The command that will run during autonomous

    public void robotInit() {
    	//Construct the subsystems
    	drivetrain = new DriveTrain();
		shooter = new Shooter();
		arm = new Arm();
		intake = new Intake();
		camera = new Camera();
    	oi = new OI(); //Should be constructed after any subsystems that are called by it
    	
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new WaitCommand(0));
        chooser.addObject("Portcullis", new PortAuto());
        //chooser.addObject("Cheval de Frise", new );
        //chooser.addObject("Moat", new DriveForward(2, -.65));
        //chooser.addObject("Ramparts", new DriveForward(2, -.85));
        //chooser.addObject("Drawbridge", new );
        //chooser.addObject("Sally Port", new );
        //chooser.addObject("Rock Wall", new DriveForward(2, .5));
        //chooser.addObject("Rough Terrain", new DriveForward(2.5, -.65));\
        chooser.addObject("Drive Auto", new DelayDriveAuto(9, 2.75, -.85));
        chooser.addObject("Auto Line", new DriveForward(1, -.5));
        chooser.addObject("Test Auto", new DriveForward(1, -.5));
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
    	//Sets the command chosen by the dashboard to the command to run in autonomous
        autonomousCommand = (Command) chooser.getSelected();
    	//if a command has been choosen, run that command
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //log();
    }

    public void teleopInit() {
    	//If autonomous is still running, stop it when teleop starts
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
        //Calls the cameras
        Robot.camera.startVision();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
    	//arm.log();
    	//shooter.log();
    	//intake.log();
        //SmartDashboard.putData(Scheduler.getInstance());
    }
}
