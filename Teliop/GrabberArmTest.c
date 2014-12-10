#pragma config(Sensor, S1, , sensorI2CCustom)
#include "../Libraries/Servos.h"
#include "../Libraries/Motors.h"


task main()
{
		Servos_SetPosition(S1, 2, 1, 110);
		wait1Msec(5000);
		Servos_SetPosition(S1, 2, 1, 219);

		int counter = nPgmTime;

	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 1, 20);
		writeDebugStreamLine("%i", nMotorEncoder[LeftDrive]);
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 1, -20);
		writeDebugStreamLine("%i", nMotorEncoder[LeftDrive]);
		wait1Msec(50);
	}
	motor[LeftDrive] = 0;

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 2, 20);
		writeDebugStreamLine("%i", nMotorEncoder[RightDrive]);
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 2, -20);
		writeDebugStreamLine("%i", nMotorEncoder[RightDrive]);
		wait1Msec(50);
	}

	motor[RightDrive] = 0;

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		motor[CenterDrive] = 20;
		writeDebugStreamLine("%i", nMotorEncoder[CenterDrive]);
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		motor[CenterDrive] = -20;
		writeDebugStreamLine("%i", nMotorEncoder[CenterDrive]);
		wait1Msec(50);
	}

	motor[RightDrive] = 0;

	counter = nPgmTime;
	while((nPgmTime - counter) < 500){
		motor[Scissor] = 10;
		writeDebugStreamLine("%i", nMotorEncoder[Scissor]);
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 500){
		motor[Scissor] = -10;
		writeDebugStreamLine("%i", nMotorEncoder[Scissor]);
		wait1Msec(50);
	}

	motor[RightDrive] = 0;
