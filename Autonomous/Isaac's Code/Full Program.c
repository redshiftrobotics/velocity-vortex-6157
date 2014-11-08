#pragma config(Sensor, S1, IROne, sensorI2CCustom)
#pragma config(Sensor, S2, IRTwo, sensorI2CCustom)
#pragma config(Sensor, S3, Motor, sensorI2CCustom)

#include "IR.c"
#include "Motors.h"

const int Threashold = 10;
const int PositionOneThreashold = 25;
const int PositionTwoThreashold = 100;

void SetPower(int Left, int Right)
{
	Motors_SetSpeed(S3, 1, 2, -Right);
	Motors_SetSpeed(S3, 1, 1, Left);
}

void MoveForwardDistance(int Distance)
{
	int Target = Motors_GetPosition(S3, 1, 1) - Distance;

	SetPower(20, 20);

	while(Motors_GetPosition(S3, 1, 1) > Target)
	{
	}

	SetPower(0, 0);
}

void MoveRight()
{
	Motors_SetSpeed(S3, 1, 2, -15);
	Motors_SetSpeed(S3, 1, 1, 5);
}

void MoveLeft()
{
	Motors_SetSpeed(S3, 1, 2, -5);
	Motors_SetSpeed(S3, 1, 1, 15);
}

void MoveStraight()
{
	Motors_SetSpeed(S3, 1, 2, -10);
	Motors_SetSpeed(S3, 1, 1, 10);
}

void Stop()
{
	Motors_SetSpeed(S3, 1, 2, 0);
	Motors_SetSpeed(S3, 1, 1, 0);
}

int Distance()
{
	//updates IR
	IR_Update();

	if(IR_LeftValue.C > Threashold && IR_LeftValue.D > Threashold && IR_RightValue.B > Threashold && IR_RightValue.C > Threashold)
	{
		writeDebugStreamLine("Medium");
		return 2;
	}
	else if(IR_LeftValue.C > Threashold && IR_RightValue.C > Threashold && IR_LeftValue.D < Threashold && IR_RightValue.B < Threashold)
	{
		writeDebugStreamLine("Long");
		return 3;
	}
	else if(IR_LeftValue.D > Threashold && IR_RightValue.B > Threashold && IR_LeftValue.C < Threashold && IR_RightValue.C < Threashold)
	{
		writeDebugStreamLine("Short");
		return 1;
	}
	else
	{
		return -1;
	}
}

void FollowLine()
{
	while(true)
	{
		int DistanceMeasure = Distance();
		//updates IR
		IR_Update();

		//stop the program if the distance is 1
		if(DistanceMeasure == 1)
		{
			break;
		}
		else if(IR_LeftValue.C > Threashold && IR_LeftValue.D > Threashold)
		{
			//move straight
			writeDebugStreamLine("Straight");
			if(DistanceMeasure == 3)
			{
				MoveRight();
			}
			else
			{
				MoveStraight();
			}
		}
		else if(IR_LeftValue.C > Threashold)
		{
			//go left
			writeDebugStreamLine("Left");
			MoveLeft();
		}
		else if(IR_LeftValue.D > Threashold)
		{
			//go right
			writeDebugStreamLine("Right");
			MoveRight();
		}
	}
}


int CheckPosition()
{
	IR_Update();

	if((IR_RightValue.D < (.25) * IR_RightValue.C || IR_RightValue.D < (.25) * IR_RightValue.B) && IR_RightValue.C < IR_LeftValue.C * (.6))
	{
		return 2;
	}
	else if(IR_LeftValue.C * (.6) < IR_RightValue.C && IR_RightValue.C * (.6) < IR_LeftValue.C)
	{
		return 3;
	}
	else
	{
		return 1;
	}
}


int CheckConfiguration()
{
	//update the sensor values
	IR_Update();

	//write the raw data to the debug stream
	writeDebugStreamLine("Amplitude: %i", IR_LeftValue.C + IR_RightValue.C);

	if(IR_LeftValue.C + IR_RightValue.C < PositionOneThreashold)
	{
		//position 1
		return 1;
	}
	else if(IR_LeftValue.C + IR_RightValue.C >= PositionOneThreashold && IR_LeftValue.C + IR_RightValue.C < PositionTwoThreashold)
	{
		//position 2
		return 2;
	}
	else if(IR_LeftValue.C + IR_RightValue.C >= PositionTwoThreashold)
	{
		//position 3
		return 3;
	}

	//not possible to get here:  just to make the compiler happy
	return -1;
}
