#pragma config(Sensor, S4, sonarSensor, sensorSONAR);
//motor[motorA] = 100;
//motor[motorB] = 100;
int MotorSpeed = 0; // value of motor speed (0-100)

	if(SensorValue(sonarSensor) < 20) {
		MotorSpeed = 0;
	}
	else {
		return;
	}
