package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a K9 robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left motor"
 * Motor channel:  Right drive motor:        "right motor"
 * Motor channel:  Motor to shoot particles: "shooter"
 * Servo channel:  Servo to raise particle shooter: "lifter"
 * Servo channel:  Servo to hit beacon: "beacon"
 *
 */
public class Hardware6157bot
{
    /* Public OpMode members. */
    public DcMotor  leftMotor      = null;
    public DcMotor  rightMotor     = null;
    public Servo    lifter         = null;
    public Servo    beacon         = null;
    public DcMotor  leftShooter    = null;
    public DcMotor  rightShooter   = null;

    public final static double lifter_HOME = 0.2;
    public final static double beacon_HOME = 0.2;
    public final static double lifter_MIN_RANGE  = 0.20;
    public final static double lifter_MAX_RANGE  = 0.90;
    public final static double beacon_MIN_RANGE  = 0.20;
    public final static double beacon_MAX_RANGE  = 0.7;

    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware6157bot() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor    = hwMap.dcMotor.get("left motor");
        rightMotor   = hwMap.dcMotor.get("right motor");
        leftShooter  = hwMap.dcMotor.get("left shooter");
        rightShooter = hwMap.dcMotor.get("right shooter");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        leftShooter.setPower(0);
        rightShooter.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.
        lifter = hwMap.servo.get("lifter");
        beacon = hwMap.servo.get("beacon");
        lifter.setPosition(lifter_HOME);
        beacon.setPosition(beacon_HOME);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs)  throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
