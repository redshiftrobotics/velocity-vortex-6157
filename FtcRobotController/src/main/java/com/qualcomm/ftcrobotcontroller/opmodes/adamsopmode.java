
package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

/**
 * TeleOp Mode
 * <p>
 *Enables control of the robot via the gamepad
 */


public class adamsopmode extends OpMode {


	//constructor
	public adamsopmode() {


	}

	protected String startDate;
	protected ElapsedTime runtime = new ElapsedTime();

	//Controllers
	protected DcMotorController mydcmotorcontroller;

	//protected ServoController Robot_servo_Controller;
	//protected DcMotorController myarmcontroller;
	//Motors
	protected DcMotor my_dcmotor_left;
	protected DcMotor my_dcmotor_right;
	// DcMotor dcmotor_arm;

	//Servos

	/*protected Servo robot_front_left;
	protected Servo robot_front_right;
	protected Servo front_arm_rotation;*/



	/*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
	@Override
	public void init() {
		startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		runtime.reset();

			mydcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		/*myarmcontroller = hardwareMap.dcMotorController.get("arm_controller");
		Robot_servo_Controller = hardwareMap.servoController.get("servo_controller");
		dcmotor_arm = hardwareMap.dcMotor.get("arm_motor"); */
		my_dcmotor_left = hardwareMap.dcMotor.get("left_drive");
		my_dcmotor_right = hardwareMap.dcMotor.get("right_drive");
		/*robot_front_left = hardwareMap.servo.get("frontleftservo");
		robot_front_right = hardwareMap.servo.get("frontrightservo");
       front_arm_rotation = hardwareMap.servo.get("frontarmservo"); */



	}

	/*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
	@Override
	public void loop() {

		my_dcmotor_left.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
		my_dcmotor_right.setPower(-Range.clip((gamepad1.right_stick_y), -1, 1));

	}
}
