package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Zephyr Gilmore on 9/23/2017.
 */
@TeleOp(name = "Zephyr", group = "TeleOp")
public class ZephyrsTeleopTest extends LinearOpMode {
    private DcMotor Motor1 = null;
    private DcMotor Motor2 = null;
    @Override
    public void runOpMode(){
        Motor1 = hardwareMap.dcMotor.get("Motor1");
        Motor2 = hardwareMap.dcMotor.get("Motor2");
       while(opModeIsActive()) {
           Motor1.setPower(gamepad1.left_stick_y);
           Motor2.setPower(gamepad1.right_stick_y);
       }
    }

}
