package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TeleOp Mode
 * <p>
 *Enables control of the robot via the gamepad
 */
public class autonomous extends adamsopmode {

	class Robot{

		public Robot(){}


	}
	private String startDate;
	private ElapsedTime runtime = new ElapsedTime();

	public void init() {
		super.init();
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
		setDrivePower(1.0,1.0);
	}
}
