#pragma config(Sensor, S2,     IROne,          sensorI2CCustom)
#pragma config(Sensor, S3,     IRTwo,          sensorI2CCustom)
#pragma config(Sensor, S1, , sensorI2CCustom)

#include "JoystickDriver.c"
#include "movement.c"

// example.c

/*
	(C) Copyright 2014 Matthew Kelsey, Duncan McKee, Jesse Walling and Duncan Clark
	This file is part of the FTC team 6157 application code.

	FTC team 6157 application code is free software: you c	an
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


//float multiplier = 2.0; //This variable can account for different gear ratios between robots.
//17 for 1.0 forward on test bot

task main()
{
	//waitForStart();
	Servos_SetPosition(S1, 2, 2, 50);
	grabberUp();
	forward(6.0);
	//forward(4.5);
	/*turnL(0.4);
	forward(3.8);
	grabberDown();
	wait1Msec(100);
	turnR(1.6);
	forward(1.9);
	turnR(0.7);
	forward(5.9);
	turnL(0.6);
	forward(0.7);
	turnL(0.6);
	forward(0.4);
	turnL(0.3);
	forward(1.1);
*/

}