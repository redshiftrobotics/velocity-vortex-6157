#pragma config(Sensor, S1, , sensorI2CCustom)
#include "../Libraries/Servos.h"
#include "../Libraries/Motors.h"


task main()
{
		Servos_SetPosition(S1, 2, 1, 110);
		wait1Msec(2000);
		Servos_SetPosition(S1, 2, 1, 219);
		wait1Msec(2000);

		int counter = nPgmTime;

	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 1, 20);
	//	writeDebugStreamLine("%i", nMotorEncoder[LeftDrive]);  Change encoder values!
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 1, -20);
		//writeDebugStreamLine("%i", nMotorEncoder[LeftDrive]);  Change encoder values!
		wait1Msec(50);
	}
	Motors_SetSpeed(S1, 1, 1, 0);
	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 2, 20);
		//writeDebugStreamLine("%i", nMotorEncoder[RightDrive]);  Change encoder values!
		wait1Msec(50);
	}

	counter = nPgmTime;
	while((nPgmTime - counter) < 2000){
		Motors_SetSpeed(S1, 1, 2, -20);
		//writeDebugStreamLine("%i", nMotorEncoder[RightDrive]); Change encoder values!
		wait1Msec(50);
	}

	Motors_SetSpeed(S1, 1, 2, 0);

}
