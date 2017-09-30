package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jaxon Gordon on 9/23/2017.
 */
@TeleOp(name = "JaxonEarlyChassisDriveTrain", group = "TeleOp")

public class JaxonEarlyChassisPrototype extends LinearOpMode {
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
@Override
    public void runOpMode() {
        // replace with the name of your motors in the config file.
        motor1 = hardwareMap.dcMotor.get("LeftMotor");
        motor2 = hardwareMap.dcMotor.get("RightMotor");

        while (true) {
            motor1.setPower(gamepad1.left_stick_y * -1);
            motor2.setPower(gamepad1.right_stick_y);
        }
    }
}
