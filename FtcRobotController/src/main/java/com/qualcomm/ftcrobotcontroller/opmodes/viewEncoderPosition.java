package com.qualcomm.ftcrobotcontroller.opmodes;

import android.os.Environment;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.adamsopmode;
import com.qualcomm.robotcore.hardware.DcMotorController;

import java.io.*;

/**
 * Created by adam on 11/28/15.
 */
public class viewEncoderPosition extends OpMode{
	private File file;
	private FileOutputStream fos;
	private DcMotorController dcmotorcontroller;
	private DcMotor dcmotorLeft;
	private DcMotor dcmotorRight;


	public viewEncoderPosition(){
		file = new File(Environment.getExternalStorageDirectory().getPath()+"/Download/output.txt");
		try {
			fos = new FileOutputStream(file,false);
		}catch (java.io.FileNotFoundException ex){
			ex.printStackTrace();
		}
	}
	@Override public void init(){
		dcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");
		dcmotorLeft = hardwareMap.dcMotor.get("left_drive");
		dcmotorRight = hardwareMap.dcMotor.get("right_drive");
	}
	@Override public void loop(){
		dcmotorLeft.setPower(1);
		dcmotorRight.setPower(-1);
		pos = dcmotorLeft.getCurrentPosition();
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

}
