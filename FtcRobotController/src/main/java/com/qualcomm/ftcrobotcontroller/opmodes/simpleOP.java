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
public class simpleOP extends OpMode {

	private String startDate;
	private ElapsedTime runtime = new ElapsedTime();
public simpleOP(){}

	private DcMotorController dc_motor_controller;
	private DcMotor dc_motor_left;
	private DcMotor dc_motor_right;

	@Override
	public void init() {
		dc_motor_controller = hardwareMap.dcMotorController.get("drive_controller");
		dc_motor_left = hardwareMap.dcMotor.get("left_drive");
		dc_motor_right = hardwareMap.dcMotor.get("right_drive");

	}

	/*
         * Code to run when the op mode is first enabled goes here
         * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
         */
	@Override
	public void init_loop() {
		startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		runtime.reset();
		telemetry.addData("Null Op Init Loop", runtime.toString());


	}

	/*
       * This method will be called repeatedly in a loop
       * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
       */
	@Override
	public void loop() {
		telemetry.addData("1 Start", "NullOp started at " + startDate);
		telemetry.addData("2 Status", "running for " + runtime.toString());

		dc_motor_right.setPower(Range.clip((-gamepad1.right_stick_y), -1, 1));
		dc_motor_left.setPower(Range.clip((gamepad1.left_stick_y),-1, 1));

	}
}
