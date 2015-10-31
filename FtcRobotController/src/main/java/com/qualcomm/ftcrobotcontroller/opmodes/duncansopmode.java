
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
public class duncansopmode extends OpMode {


    //constructor
public duncansopmode(){


}
    private String startDate;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorController mydcmotorcontroller;

    private DcMotor my_dcmotor_left;
    private DcMotor my_dcmotor_right;
    private DcMotor arm_lift;
    private Servo arm_rotation;
    /*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
    @Override
    public void init() {
        startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        runtime.reset();

        mydcmotorcontroller = hardwareMap.dcMotorController.get("drive_controller");

        my_dcmotor_left= hardwareMap.dcMotor.get ("left_drive");
        my_dcmotor_right = hardwareMap.dcMotor.get ("right_drive");
        arm_lift = hardwareMap.dcMotor.get ("Arm_lift");

        arm_rotation = hardwareMap.servo.get("servo_1");
    }
    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
        telemetry.addData("1 Start", "DuncanOp started at " + startDate);
        telemetry.addData("2 Status", "running for " + runtime.toString());

        my_dcmotor_left.setPower(Range.clip((gamepad1.left_stick_y), -1, 1));
        my_dcmotor_right.setPower(Range.clip ((gamepad1.right_stick_y), -1, 1));
        arm_lift.setPower(Range.clip ((gamepad2.right_stick_y), -1, 1));
        arm_rotation.setPosition(Range.clip ((gamepad2.right_stick_x), -1, 1));
    }
}
