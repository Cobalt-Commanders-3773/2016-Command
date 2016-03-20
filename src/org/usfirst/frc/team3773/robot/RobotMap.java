package org.usfirst.frc.team3773.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //TALONS
	public static int leftDriveChannel = 0; //Channel for the left drive
	public static int rightDriveChannel = 1; //Channel for the right drive
    public static int shooterInChannel = 2; //Channel for the shooter intake
    public static int shooterOut1Channel = 3; //Channel for the bottom shooter bar
    public static int shooterOut2Channel = 4; //Channel for the top shooter bar
    public static int armChannel1 = 5; //Channel for the first talon for the arm
    public static int armChannel2 = 6; //Channel for the first talon for the arm
	
    //ANALOG INPUTS
    //public static int gyroChannel = 0; //Channel for the gyro
    public static int infraRedChannel = 0;
    public static int ultrasonicChannel = 1; //Channel for the range finder
    
    //DIGITAL INPUTS
    public static int armLimitChannel = 2; //Limit switch for the top of the arm
    
    //USB (port number on the dashboard)
    public static int leftJoystickChannel = 0; //Port number for the left joystick
	public static int rightJoystickChannel = 1; //Port number for the right joystick
	public static int xboxChannel = 2; //Port number for the xbox controller
	
	//CAMERAS
	public static String frontCamera = "cam1";
	public static String rearCamera = "cam2";
	
}
