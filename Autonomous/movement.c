#include "../Libraries/Motors.h"
#include "../Libraries/Servos.h"


float multiplier = 1.0; //This variable can account for different gear ratios between robots.



/*			FORWARD			*/


void forwardOLD(float rotations)
{
	int StartPosition1 = Motors_GetPosition(S1, 1, 1);
	int StartPosition2 = Motors_GetPosition(S1, 1, 2);
//Motors_GetPosition(S1, 1, 1) < StartPosition1 + rotations * 1440 * multiplier)&&
	while(Motors_GetPosition(S1, 1, 1) < StartPosition1 + rotations * 1440 * multiplier && Motors_GetPosition(S1, 1, 2) < StartPosition2 + rotations * 1440 * multiplier)
	{
		Motors_SetSpeed(S1, 1, 1, 100);
		Motors_SetSpeed(S1, 1, 2, -100);
	}

		Motors_SetSpeed(S1, 1, 1, 0);
		Motors_SetSpeed(S1, 1, 2, 0);
}

void forward(float time)
{

	//numbers to try: 65, 55, 50
	motor[motorA]=50;
	motor[motorB]=-100;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}

void backward(float time)
{
	//numbers to try: 65, 55,50

	motor[motorA]=-50;
	motor[motorB]=100;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}

void ultraSleep(int sleepTime)
{

	motor[motorA]=0;
	motor[motorB]=0;
	if(SensorValue(sonarRight) < 20)
	{
		return;
	}
	else
	{
		motor[motorA]=50;
		motor[motorB]=-100;
		wait1Msec(100);
	}
}

void forwardSlow(float time)
{
	motor[motorA]=32.5;
	motor[motorB]=-50;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}

void forwardSuperSlow(float time)
{
	motor[motorA]=16;
	motor[motorB]=-25;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}


/*			RIGHT			*/

void turnROld(float time)
{
	motor[motorA]=65;
	motor[motorB]=100;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}


/*			LEFT			*/

void turnLOld(float time)
{
	motor[motorA]=-65;
	motor[motorB]=-100;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}


void turnLSlow(float time)
{
	motor[motorA]=-32.5;
	motor[motorB]=-50;
	Sleep(time*500*multiplier);
	motor[motorA]=0;
	motor[motorB]=0;

}

void turnR(float rotations)
{
	nMotorEncoder[motorB] = 0;
	while(nMotorEncoder[motorB] > -1440*rotations)
	{
		motor[motorB] = -100;
	}
	motor[motorB] = 0;
}

void turnL(float rotations)
{
	nMotorEncoder[motorA] = 0;
	while(nMotorEncoder[motorA] < 1440*rotations)
	{
		motor[motorA] = 100;
	}
	motor[motorA] = 0;
}


void grabberDown(){
	servo[servo1] = 207;

}
void grabberUp(){
	servo[servo1] = 95;

}
