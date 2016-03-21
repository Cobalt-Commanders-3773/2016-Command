package org.usfirst.frc.team3773.robot.subsystems;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3773.robot.RobotMap;

import com.ni.vision.NIVision;

//AxisCamera axis = new AxisCamera("10.37.73.11"); //IP of the axis camera
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	int session;
	Image frame;
	int session2;
	Image frame2;
	int currSession;
	CameraServer server;

    public Camera(){
        //Create the camera(s) and assign the name(s)
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera(RobotMap.frontCamera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        ////////////////////session2 = NIVision.IMAQdxOpenCamera(RobotMap.rearCamera,
        //NIVision.IMAQdxConfigureGrab(session2);
        //////////////////currSession = session;
        /////////////////NIVision.IMAQdxConfigureGrab(currSession);
        /////////////////NIVision.IMAQdxConfigureGrab(currSession);
    }
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		//setDefaultCommand(new SwapCamera());
    }
}

