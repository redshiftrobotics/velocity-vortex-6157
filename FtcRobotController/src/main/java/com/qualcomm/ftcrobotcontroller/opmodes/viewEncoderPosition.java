package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.adamsopmode;
import java.io.*;

/**
 * Created by adam on 11/28/15.
 */
public class viewEncoderPosition extends OpMode{
	private File file;
	private FileOutputStream fos;


	public viewEncoderPosition(){
		base = new adamsopmode();
		file = new File("/sdcard/Download/output.txt");

		try {
			fos = new FileOutputStream(file,false);

		}catch (java.io.FileNotFoundException ex){
			ex.printStackTrace();
		}

	}


	@Override public void init(){
		base.mydcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		base.my_dcmotor_right = hardwareMap.dcMotor.get("left_drive");
		base.my_dcmotor_left = hardwareMap.dcMotor.get("right_drive");
	}

	@Override public void loop(){
		base.my_dcmotor_left.setPower(0.3);
		base.my_dcmotor_right.setPower(0.3);
		pos = base.my_dcmotor_left.getCurrentPosition();
		telemetry.addData("Position: ", "is "+pos);
		temp = "Position: "+pos+" ";
		bytes = temp.getBytes();
		try {
			fos.write(bytes);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	private int pos;
	private String temp;
	private byte[] bytes;
	private adamsopmode base;


}
