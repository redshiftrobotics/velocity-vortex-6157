package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.ftcrobotcontroller.opmodes.adamsopmode;
/**
 * Created by adam on 11/14/15.
 */
 public class Robot {

	public Robot(){}
	//declare base class object, to use motors and such
	adamsopmode baseop = new adamsopmode();

	public void forward (float rotations) {
		int startPos = baseop.my_dcmotor_left.getCurrentPosition();
		while(baseop.my_dcmotor_left.getCurrentPosition() - startPos < rotations*1400) {
			//go forward
			baseop.my_dcmotor_left.setPower(1);
			baseop.my_dcmotor_right.setPower(1);
		}

	}

	public void turn (){}

}
