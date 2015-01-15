#include "../Libraries/Motors.h"
#include "../Libraries/Servos.h"


float multiplier = 1.0; //This variable can account for different gear ratios between robots.



/*			FORWARD			*/


void forward(float rotations)
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

/*			RIGHT			*/

void turnR(float time)
{
	Motors_SetSpeed(S1, 1, 1, 100);
	Motors_SetSpeed(S1, 1, 2, 100);
	Sleep(time*500*multiplier);
	Motors_SetSpeed(S1, 1, 1, 0);
	Motors_SetSpeed(S1, 1, 2, 0);

}

/*			LEFT			*/

void turnL(float time)
{
	Motors_SetSpeed(S1, 1, 1, -100);
	Motors_SetSpeed(S1, 1, 2, -100);
	Sleep(time*500*multiplier);
	Motors_SetSpeed(S1, 1, 1, 0);
	Motors_SetSpeed(S1, 1, 2, 0);

}
/*			BACKWARD			*/

void backward(float rotations)
{
	int StartPosition1 = Motors_GetPosition(S1, 1, 1);
	int StartPosition2 = Motors_GetPosition(S1, 1, 2);

	while(Motors_GetPosition(S1, 1, 1) > StartPosition1 - rotations * 1440 * multiplier && Motors_GetPosition(S1, 1, 2) > StartPosition2 - rotations * 1440 * multiplier)
	{
		Motors_SetSpeed(S1, 1, 1, -100);
		Motors_SetSpeed(S1, 1, 2, 100);
	}

		Motors_SetSpeed(S1, 1, 1, 0);
		Motors_SetSpeed(S1, 1, 2, 0);
}

/* GRABBER */
void grabberUp()
{
	Servos_SetPosition(S1, 2, 1, 95);
}

void grabberDown()
{
	Servos_SetPosition(S1, 2, 1, 207);
}
