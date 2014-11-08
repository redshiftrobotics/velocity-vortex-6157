#pragma config(Hubs,  S1, HTMotor,  HTServo,  none,     none)
#pragma config(Motor,  mtr_S1_C1_1,     motorD,        tmotorTetrix, openLoop)
#pragma config(Motor,  mtr_S1_C1_2,     motorE,        tmotorTetrix, openLoop, reversed)
#pragma config(Servo,  srvo_S1_C2_1,    servo1,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_2,    servo2,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_3,    servo3,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_4,    servo4,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_5,    servo5,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_6,    servo6,               tServoNone)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

#include "JoystickDriver.c"

// example.c

/*

	(C) Copyright 2014 Duncan McKee and Jesse Walling.

	This file is part of the FTC team 6157 application code.

	FTC team 6157 application code is free software: you can
	redistribute it and/or modify it under the terms of the GNU
	General Public License as published by the Free Software
	Foundation, either version 2 of the License, or (at your
	option) any later version.

	FTC team 6157 application code is distributed in the hope that
	it will be useful, but WITHOUT ANY WARRANTY; without even the
	implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
	PURPOSE.  See the GNU General Public License for more details.

	You should have received a copy of the GNU General Public
	License along with FTC team 6157 application code. If not, see
	<http://www.gnu.org/licenses/>.

*/



void forward(int rotations)
{
	nMotorEncoder[motorD] = 0;          // reset the Motor Encoder of Motor B
	while(nMotorEncoder[motorD] < (rotations * 360))  // while the Motor Encoder of Motor B has not yet reached 360 counts:
	{
  	motor[motorD] = 100;                 // motor B is given a power level of 75
  	motor[motorE] = 100;                 // motor C is given a power level of 75
	}
	motor[motorD] = 0;                  // motor B is given a power level of 0 (stop)
	motor[motorE] = 0;                  // motor C is given a power level of 0 (stop)
}

void backward(int rotations)
{
	nMotorEncoder[motorD] = 0;          // reset the Motor Encoder of Motor B
	while(nMotorEncoder[motorD] < (rotations * -360))  // while the Motor Encoder of Motor B has not yet reached 360 counts:
	{
  	motor[motorD] = -100;                 // motor B is given a power level of 75
  	motor[motorE] = -100;                 // motor C is given a power level of 75
	}
	motor[motorD] = 0;                  // motor B is given a power level of 0 (stop)
	motor[motorE] = 0;                  // motor C is given a power level of 0 (stop)
}

void turnD(int rotations)
{
	nMotorEncoder[motorD] = 0;          // reset the Motor Encoder of Motor B
	while(nMotorEncoder[motorD] < (rotations * -360))  // while the Motor Encoder of Motor B has not yet reached 360 counts:
	{
  	motor[motorD] = -100;                 // motor B is given a power level of 75
  	motor[motorE] = 100;                 // motor C is given a power level of 75
	}
	motor[motorD] = 0;                  // motor B is given a power level of 0 (stop)
	motor[motorE] = 0;                  // motor C is given a power level of 0 (stop)
}

void turnE(int rotations)
{
	nMotorEncoder[motorD] = 0;          // reset the Motor Encoder of Motor B
	while(nMotorEncoder[motorD] < (rotations * 360))  // while the Motor Encoder of Motor B has not yet reached 360 counts:
	{
  	motor[motorD] = 100;                 // motor B is given a power level of 75
  	motor[motorE] = -100;                 // motor C is given a power level of 75
	}
	motor[motorD] = 0;                  // motor B is given a power level of 0 (stop)
	motor[motorE] = 0;                  // motor C is given a power level of 0 (stop)
}

task main()
{

	//waitForStart();
	string location = "ramp";
	//where it starts
	if(location == "ramp")
	{
		forward(20);
	}else if(location == "floor")
	{

	}
}