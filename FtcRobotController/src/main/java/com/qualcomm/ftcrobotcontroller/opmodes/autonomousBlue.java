/* Copyright (c) 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
//import com.qualcomm.ftcrobotcontroller.opmodes.Robot;
import com.qualcomm.ftcrobotcontroller.opmodes.adamsopmode;
import com.qualcomm.ftcrobotcontroller.Event;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * This class simply contains the procedures for autonomous mode. For actual method definitions, see com/qualcomm/ftcrobotcontroller/opmodes/Robot.java.
 */

public class autonomousBlue extends LinearOpMode {

	//change this based on encoder values for one full turn. To find this value, run viewEncoderPosition on robot until it has turned as close to 360 degrees as possible, then view /sdcard/Downloads/output.txt
	private int fullturnvalue = 3278;
	public double pos;
	public adamsopmode op;
	private DcMotorController dcmotorcontroller;
	private DcMotorController armcontroller;
	private ServoController servoController;
	private DcMotorController wheelcontroller;
	private DcMotor dcmotorLeft;
	private DcMotor dcmotorRight;
	private DcMotor dcmotorArmLift;
	private DcMotor dcmotorArmPull;
	private DcMotor dcmotorWheelLift;
	private DcMotor dcmotorWheelWheel;
	public autonomousBlue() {
		//create a new adamsopmode object in order to access base motors
	}

	@Override public void runOpMode() throws InterruptedException {

		dcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		 armcontroller = hardwareMap.dcMotorController.get("arm_controller");
		servoController  = hardwareMap.servoController.get("servo_controller");
		wheelcontroller = hardwareMap.dcMotorController.get("wheel_controller");

		dcmotorLeft = hardwareMap.dcMotor.get("left_drive");
		dcmotorRight = hardwareMap.dcMotor.get("right_drive");
		dcmotorArmLift = hardwareMap.dcMotor.get("arm_lift");
		dcmotorArmPull = hardwareMap.dcMotor.get("arm_pull");
		dcmotorWheelLift = hardwareMap.dcMotor.get("wheel_lift");
		dcmotorWheelWheel = hardwareMap.dcMotor.get("wheel_wheel");
		waitForStart();
		//procedures for autonomous - note: as full turn encoder values aren't accurate, degree measures aren't accurate either.
		// Therefore, view the degree argument of the turn function as simply a factor, not an actual degree. We can fix this later.
		forward(0.9, dcmotorLeft.getCurrentPosition());
		turn(70, dcmotorLeft.getCurrentPosition(), "RIGHT");
		forward(5.7, dcmotorLeft.getCurrentPosition());
		turn(90, dcmotorLeft.getCurrentPosition(), "RIGHT");
		forward(1.2, dcmotorLeft.getCurrentPosition());


		//end procedures for autonomous


	}


	public void forward (double rotations, double startPos) {

		while(Math.abs(dcmotorLeft.getCurrentPosition()) - startPos <= rotations*1400) {

			dcmotorLeft.setPower(1.0);
			dcmotorRight.setPower(-1.0);
			telemetry.addData("Position ", "is: " + Math.abs(op.my_dcmotor_left.getCurrentPosition()));

		}
		stop(dcmotorLeft, dcmotorRight);
	}



	public void turn(float degrees, int startPos, String direction){
		float encoderval = fullturnvalue*(degrees/360);

		if (direction.equals("LEFT")) {

			while(Math.abs(op.my_dcmotor_left.getCurrentPosition()) - startPos <= encoderval) {
				dcmotorLeft.setPower(-1);
				dcmotorRight.setPower(-1);
				telemetry.addData("Position ","is: "+Math.abs(dcmotorLeft.getCurrentPosition()));

			}

		}

		else {
			while(Math.abs(dcmotorLeft.getCurrentPosition()) - startPos <= encoderval) {
				dcmotorLeft.setPower(-1);
				dcmotorRight.setPower(1);

			}
		}

		stop(dcmotorLeft,dcmotorRight);

	}
	private void  stop(DcMotor dc1, DcMotor dc2) {
		dc1.setPower(0);
		dc2.setPower(0);
	}
}

