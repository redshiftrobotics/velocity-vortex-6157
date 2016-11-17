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

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;

/*
 *
 * This is an example LinearOpMode that shows how to use
 * a legacy (NXT-compatible) Light Sensor.
 * It assumes that the light sensor is configured with a name of "light sensor".
 *
 * You can use the X button on gamepad1 to turn Toggle the LED on and off.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name = "Drive", group = "Sensor")

public class Drive extends LinearOpMode {

  Hardware6157bot robot = new Hardware6157bot();
  DcMotor dcmotor1;
  DcMotor dcmotor2;
//  LightSensor lightSensor;  // Hardware Device Object
  DcMotor Shoot1;
  DcMotor Shoot2;
  private boolean shoot = false;
  private boolean lastshoot = false;
  private boolean moton = false;
  private boolean lastbutton = false;
  private boolean direction = false;
  private boolean lastbutton2 = false;

  @Override
  public void runOpMode() throws InterruptedException {

    robot.init(hardwareMap);

    // bLedOn represents the state of the LED.
    boolean bLedOn = true;

    // get a reference to our Light Sensor object.
  //  lightSensor = hardwareMap.lightSensor.get("light sensor");
    dcmotor1 = hardwareMap.dcMotor.get("ball_grab");
    dcmotor2 = hardwareMap.dcMotor.get("ball_grab2");
      Shoot1 = hardwareMap.dcMotor.get("Shoot1");
      Shoot2 = hardwareMap.dcMotor.get("Shoot2");
    double mot1float = dcmotor1.getPower(); // get mod1power

    // Set the LED state in the beginning.
//    lightSensor.enableLed(bLedOn);

    // wait for the start button to be pressed.
    waitForStart();
    // while the op mode is active, loop and read the light levels.
    // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
    while (opModeIsActive()) {

  //    double lightSensorValue = lightSensor.getLightDetected();
      if (gamepad2.left_bumper){
        dcmotor1.setPower(0.25);
        dcmotor2.setPower(0);
      } else {
        if (gamepad2.right_bumper != lastbutton && gamepad2.right_bumper) {
          moton = !moton;
        }
        lastbutton = gamepad2.right_bumper;
        if (moton) {

          dcmotor1.setPower(-0.25);
          dcmotor2.setPower(0.25);
        } else {
          dcmotor1.setPower(0);
          dcmotor2.setPower(0);
        }
      }
      if (gamepad1.right_bumper != lastbutton2 && gamepad1.right_bumper){
        direction = !direction;

      }
      lastbutton2 = gamepad1.right_bumper;
      if (direction){
        telemetry.addLine("Collector Is Front");
        if (gamepad1.right_trigger < 0.1) {
          if (gamepad1.left_trigger < 0.1) {
            robot.leftMotor.setPower(-gamepad1.left_stick_y);
            robot.rightMotor.setPower(-gamepad1.right_stick_y);
          } else {
            robot.leftMotor.setPower(-gamepad1.left_stick_y*0.5);
            robot.rightMotor.setPower(-gamepad1.right_stick_y*0.5);
          }
        } //else {
          // send the info back to driver station using telemetry function.
    /*      if (lightSensorValue > 0.27) {
            // turn left
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0.2);

          } else {
            //turn right
            robot.leftMotor.setPower(0.2);
            robot.rightMotor.setPower(0);

          }
        } */
      } else { // direc invert else
telemetry.addLine("Shooter Is Front");
        if (gamepad1.right_trigger < 0.1) {
          if (gamepad1.left_trigger < 0.1) {
            robot.leftMotor.setPower(gamepad1.right_stick_y);
            robot.rightMotor.setPower(gamepad1.left_stick_y);
          } else {
            robot.leftMotor.setPower(gamepad1.right_stick_y*0.5);
            robot.rightMotor.setPower(gamepad1.right_stick_y*0.5);
          }
        }/* else {
          // send the info back to driver station using telemetry function.
          if (lightSensorValue > 0.27) {
            // turn left
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0.2);

          } else {
            //turn right
            robot.leftMotor.setPower(0.2);
            robot.rightMotor.setPower(0);

          }
        }*/
      }
      
      Shoot1.setPower(-gamepad2.left_stick_y*.3);
      Shoot2.setPower(gamepad2.left_stick_y*.3);
/*        double shootpower = Shoot1.getPower();


      if (gamepad1.b != lastshoot && gamepad1.b){
        shoot = !shoot;
      }
      lastshoot = gamepad1.b;
      if (shoot) {
        if (shootpower < 1) {
          Shoot1.setPower(shootpower + 0.001);
          Shoot2.setPower(-shootpower - 0.001);
        }
      } else {
        if (shootpower > 0) {
          Shoot1.setPower(shootpower - 0.001);
          Shoot2.setPower(-shootpower + 0.001);
        } else {
          Shoot2.setPower(0);
          Shoot1.setPower(0);
        }
      }

*/

      telemetry.addData("Shoot Power", Shoot2.getPower());
      //telemetry.addData("Front", direction);
      //telemetry.addData("Light", lightSensorValue);
      telemetry.addData("Collecter", mot1float);
      telemetry.update();
      idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
    }
  }
}
