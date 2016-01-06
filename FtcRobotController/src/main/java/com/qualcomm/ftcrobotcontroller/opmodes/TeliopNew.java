
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
public class TeliopNew extends OpMode {


	//constructor
	public TeliopNew() {

		telemetry.addData("Status:","Teliop about to start");
	}

	private String startDate;
	private ElapsedTime runtime = new ElapsedTime();

	//Controllers
	private DcMotorController dcmotorcontroller;
	private ServoController servoController;
	private DcMotorController armcontroller;
	private DcMotorController wheelcontroller;
	//Motors
	private DcMotor dcmotorLeft;
	private DcMotor dcmotorRight;
	private DcMotor dcmotorArmLift;
	private DcMotor dcmotorArmPull;
	private DcMotor dcmotorWheelWheel;
	private DcMotor dcmotorWheelLift;

	//Servos
//	private Servo arm_servo;
//	private Servo robot_front_left;
//	private Servo robot_front_right;
//	private Servo front_arm_rotation;


//	public double front_right_servo_position = 0;
//	public double front_left_servo_position = 0;

	/*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
	@Override
	public void init() {
		startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		runtime.reset();

		dcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		armcontroller = hardwareMap.dcMotorController.get("arm_controller");
		servoController = hardwareMap.servoController.get("servo_controller");
		wheelcontroller = hardwareMap.dcMotorController.get("wheel_controller");

		dcmotorLeft = hardwareMap.dcMotor.get("left_drive");
		dcmotorRight = hardwareMap.dcMotor.get("right_drive");
		dcmotorArmLift = hardwareMap.dcMotor.get("arm_lift");
		dcmotorArmPull = hardwareMap.dcMotor.get("arm_pull");
		dcmotorWheelLift = hardwareMap.dcMotor.get("wheel_lift");
		dcmotorWheelWheel = hardwareMap.dcMotor.get("wheel_wheel");


//		robot_front_left = hardwareMap.servo.get("frontleftservo");
//		robot_front_right = hardwareMap.servo.get("frontrightservo");
//		//front_arm_rotation = hardwareMap.servo.get("frontarmservo");


	}

	/*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
	@Override
	public void loop() {

		telemetry.addData("1 Start", "Teleop started at " + startDate);
		telemetry.addData("2 Status", "running for " + runtime.toString());
		dcmotorLeft.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
		dcmotorRight.setPower(Range.clip((gamepad1.right_stick_y), -1, 1));
		dcmotorArmLift.setPower(Range.clip((gamepad2.left_stick_y), -1, 1));
		dcmotorArmPull.setPower(Range.clip((gamepad2.left_stick_x), -1, 1));
		dcmotorWheelLift.setPower(Range.clip((gamepad2.right_stick_y), -1, 1));
		dcmotorWheelWheel.setPower(Range.clip((gamepad2.right_stick_x), -1, 1));


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
