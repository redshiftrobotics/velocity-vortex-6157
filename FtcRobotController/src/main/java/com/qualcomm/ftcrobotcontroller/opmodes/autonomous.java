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

/**
 * This class simply contains the procedures for autonomous mode. For actual method definitions, see com/qualcomm/ftcrobotcontroller/opmodes/Robot.java.
 */

public class autonomous extends LinearOpMode {

	//change this based on encoder values for one full turn. To find this value, run viewEncoderPosition on robot until it has turned as close to 360 degrees as possible, then view /sdcard/Downloads/output.txt
	private int fullturnvalue = 3278;
	public adamsopmode op;
	public autonomous() {
		//create a new adamsopmode object in order to access base motors
		this.op = new adamsopmode();
	}

	@Override public void runOpMode() throws InterruptedException {

		op.mydcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		op.my_dcmotor_left = hardwareMap.dcMotor.get("left_drive");
		op.my_dcmotor_right = hardwareMap.dcMotor.get("right_drive");
		int startPos = Math.abs(op.my_dcmotor_left.getCurrentPosition());
		waitForStart();
		//procedures for autonomous
		forward(0.9, startPos);
		sleep(3000);
		turn(65, op.my_dcmotor_left.getCurrentPosition(), "LEFT");
		sleep(5000);
		forward(3.3, op.my_dcmotor_left.getCurrentPosition());
		sleep(3000);
		turn(90,startPos,"LEFT");
		//end procedures for autonomous


	}


	public void forward (double rotations, double startPos) {

		while(Math.abs(op.my_dcmotor_left.getCurrentPosition()) - startPos <= rotations*1400) {

			op.my_dcmotor_left.setPower(-0.5);
			op.my_dcmotor_right.setPower(-0.5);
			telemetry.addData("Position ", "is: " + Math.abs(op.my_dcmotor_left.getCurrentPosition()));


		}
		stop(op.my_dcmotor_left, op.my_dcmotor_right);
	}



	public void turn(float degrees, int startPos, String direction){
		float encoderval = fullturnvalue*(degrees/360);
		double power;

		if (direction.equals("RIGHT")) {

			while(Math.abs(op.my_dcmotor_left.getCurrentPosition()) - startPos <= encoderval) {
				op.my_dcmotor_left.setPower(1);
				op.my_dcmotor_right.setPower(-1);
				telemetry.addData("Position ","is: "+Math.abs(op.my_dcmotor_left.getCurrentPosition()));

			}

		}

		else {
			while(Math.abs(op.my_dcmotor_left.getCurrentPosition()) - startPos <= encoderval) {
				op.my_dcmotor_left.setPower(-1);
				op.my_dcmotor_right.setPower(1);

			}
		}

		stop(op.my_dcmotor_left,op.my_dcmotor_right);

	}

	private void  stop(DcMotor dc1, DcMotor dc2) {
		dc1.setPower(0);
		dc2.setPower(0);
	}

}

