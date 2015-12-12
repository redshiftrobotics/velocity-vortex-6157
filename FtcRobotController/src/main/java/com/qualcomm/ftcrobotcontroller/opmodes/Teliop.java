
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
public class Teliop extends OpMode {


	//constructor
	public Teliop() {

		telemetry.addData("Status:","Teliop about to start");
	}

	private String startDate;
	private ElapsedTime runtime = new ElapsedTime();

	//Controllers
	private DcMotorController mydcmotorcontroller;

	private ServoController Robot_servo_Controller;
	private DcMotorController myarmcontroller;
	//Motors
	private DcMotor my_dcmotor_left;
	private DcMotor my_dcmotor_right;
	private DcMotor dcmotor_arm;

	//Servos
	private Servo arm_servo;
	private Servo robot_front_left;
	private Servo robot_front_right;
	private Servo front_arm_rotation;


	public double front_right_servo_position = 0;
	public double front_left_servo_position = 0;

	/*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
	@Override
	public void init() {
		startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		runtime.reset();

		mydcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		myarmcontroller = hardwareMap.dcMotorController.get("arm_controller");
		Robot_servo_Controller = hardwareMap.servoController.get("servo_controller");
//		dcmotor_arm = hardwareMap.dcMotor.get("arm_motor");
		my_dcmotor_left = hardwareMap.dcMotor.get("left_drive");
		my_dcmotor_right = hardwareMap.dcMotor.get("right_drive");
		robot_front_left = hardwareMap.servo.get("frontleftservo");
		robot_front_right = hardwareMap.servo.get("frontrightservo");
		//front_arm_rotation = hardwareMap.servo.get("frontarmservo");


	}

	/*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
	@Override
	public void loop() {

		telemetry.addData("1 Start", "Teleop started at " + startDate);
		telemetry.addData("2 Status", "running for " + runtime.toString());
		my_dcmotor_left.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
		my_dcmotor_right.setPower(Range.clip((gamepad1.right_stick_y), -1, 1));
//		dcmotor_arm.setPower(Range.clip((gamepad2.right_stick_y), -1, 1));
		//front_arm_rotation.setPosition(Range.clip((gamepad2.right_stick_y), 0.0, 1.0));
		robot_front_right.setPosition(Range.clip((gamepad2.right_stick_x), 0.0, 1.0));
		robot_front_left.setPosition(Range.clip((gamepad2.left_stick_x), 1.0, 0.0));


	/*if (gamepad1.right_bumper){
				telemetry.addData("2", "GamePad.Right_bumper active");
				robot_front_right.setPosition(1.0);
		}
		else    {
			telemetry.addData("2", "GamePad.Right_bumper deactive");
			robot_front_right.setPosition(0.0);
		}
		if (gamepad1.left_bumper){
			telemetry.addData("2", "GamePad.Left_bumper active");
			robot_front_left.setPosition(1.0);
		}
		else {
			telemetry.addData("2", "GamePad.Left_bumper deactive");
			robot_front_left.setPosition(0.0);
			}*/

		/*if (gamepad1.right_bumper && front_right_servo_position < 1.0) {
			robot_front_right.setPosition(front_right_servo_position);
			front_right_servo_position += 0.01;
		}
		if (gamepad1.left_bumper && front_left_servo_position < 1.0) {
			robot_front_left.setPosition(front_left_servo_position);
			front_left_servo_position += 0.01;

		}*/


	}
}
