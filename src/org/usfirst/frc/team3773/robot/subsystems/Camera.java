package org.usfirst.frc.team3773.robot.subsystems;

import org.usfirst.frc.team3773.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	int session;
	Image frame;
	int session2;
	Image frame2;
	int currSession;
	CameraServer server;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Camera(){
    	super();
        this.frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        this.session = NIVision.IMAQdxOpenCamera(RobotMap.frontCamera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session);
        
        this.session2 = NIVision.IMAQdxOpenCamera(RobotMap.rearCamera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session2);
        this.currSession = this.session;
        NIVision.IMAQdxConfigureGrab(this.currSession);
    }
    
    public void startVision(){
        NIVision.IMAQdxGrab(this.currSession, this.frame, 1);
        CameraServer.getInstance().setImage(this.frame);
    }
    
    public void setCamera1(){
    	NIVision.IMAQdxStopAcquisition(this.currSession);
 		this.currSession = this.session;
        NIVision.IMAQdxConfigureGrab(this.currSession);
    }
    
    public void setCamera2(){
    	NIVision.IMAQdxStopAcquisition(this.currSession);
 		this.currSession = this.session2;
 		NIVision.IMAQdxConfigureGrab(this.currSession);
    }
}

