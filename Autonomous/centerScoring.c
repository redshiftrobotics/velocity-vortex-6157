#pragma config(Hubs,  S1, HTMotor,  HTServo,  none,     none)
#pragma config(Sensor, S1,     ,               sensorI2CMuxController)
#pragma config(Sensor, S2,     IROne,          sensorI2CCustom)
#pragma config(Sensor, S3,     IRTwo,          sensorI2CCustom)
#pragma config(Motor,  mtr_S1_C1_1,     motorA,        tmotorTetrix, openLoop)
#pragma config(Motor,  mtr_S1_C1_2,     motorB,        tmotorTetrix, openLoop)
#pragma config(Servo,  srvo_S1_C2_1,    servo1,               tServoStandard)
#pragma config(Servo,  srvo_S1_C2_2,    servo2,               tServoStandard)
#pragma config(Servo,  srvo_S1_C2_3,    servo3,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_4,    servo4,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_5,    servo5,               tServoNone)
#pragma config(Servo,  srvo_S1_C2_6,    servo6,               tServoNone)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

/////////////
//TURN TEST//
/////////////


#include "JoystickDriver.c"
#include "movement.c"

// example.c

//float multiplier = 2.0; //This variable can account for different gear ratios between robots.
//17 for 1.0 forward on test bot
float mult = 0.58;

task main()
{
	int centerPos = 0;

	if(centerPos == 1)
	{
		turnR(2.0);
		forward(2.0);
		turnL(2.0);
		forward(4.0);
		turnL(2.0);
		forward(3.0);
		backward(1.0);
	}else if(centerPos == 2)
	{
		turnR(1.5);
		forward(2.0);
		turnL(2.0);
		forward(3.0);
		backward(1.0);
	}else if(centerPos == 3)
	{
		forward(5.0);
		backward(1.0);

	}

}
