//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

// Tankdrive.c

/*

(C) Copyright 2014 Samin Zach and Matthew Kelsey

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
#pragma config(Sensor, S1, , sensorI2CCustom)
#pragma config(Motor,  motorA,          spinner1,      tmotorNXT, PIDControl, encoder)
#pragma config(Motor,  motorB,          spinner2,      tmotorNXT, PIDControl, encoder)

#include "../Libraries/Motors.h"
#include "../Libraries/Servos.h"

#include "JoystickDriver.c"

int constrain(int x, int min, int max)
{
	if (x > max)
		return max;
	if (x < min)
		return min;
	return x;
}

int joymotor (int joy)
{
	int motor;
	if(joy > 7 || joy < -7)
	{
		motor = joy * 100 / 127;
	}
	else
	{
		return 0;
	}
	return constrain(motor,-100,100);
}


//toggle
bool toggle(int joybtn, bool toggleSwitch)
{
	bool btnup = true;

		if(joy1Btn(joybtn) == 1 && btnup == true)
			{
				//transition down
				toggleSwitch =! toggleSwitch;
				btnup = false;
				Sleep(100);
			}
			else if(joy1Btn(joybtn) == 0 && btnup == false)
			{
				//transition up
				btnup = true;
			}

			return toggleSwitch;



}




task main()
{
	int SpeedLeft = 0;
	int SpeedRight = 0;
	int SpeedArm = 0;
	int servoangle = 0;
	int servo2angle = 0;
	bool btnup = true;
	bool grabberToggle = true;
	bool sweeperToggle = true;
	bool dumperToggle = true;
	while(true)
	{


//driving

		getJoystickSettings(joystick);

		SpeedRight = joymotor(-joystick.joy1_y2);
		SpeedLeft = joymotor(joystick.joy1_y1);
//sweeper

		if(joy1Btn(7+1) == 1)
		{
			motor(motorA) = 100;
			motor(motorB) = 100;
		}

		if(joy1Btn(6+1) == 1)
		{
			motor(motorA) = -100;
			motor(motorB) = -100;
		}

//tubegrabber

		grabberToggle = toggle(1+1, grabberToggle);
		servoangle = grabberToggle ? 110 : 219;


//arm
		if(joy2Btn(6+1) == 1)
		{
			SpeedArm = joymotor(joystick.joy2_y1/2);

		}
		else
		{
			SpeedArm = joymotor(joystick.joy2_y1);
		}

//DUMPER

		//dumperToggle = toggle(2+1, dumperToggle);
		//servo2angle = dumperToggle ? 110 : 219;


//feed to motors/servos

	Servos_SetPosition(S1, 2, 1, servoangle);
	Servos_SetPosition(S1, 2, 1, servoangle);
	Motors_SetSpeed(S1, 1, 1, SpeedRight);
	Motors_SetSpeed(S1, 3, 1, SpeedArm);
	Motors_SetSpeed(S1, 1, 2, SpeedLeft);



	}

}
