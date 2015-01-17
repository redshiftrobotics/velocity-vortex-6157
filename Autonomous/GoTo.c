float x = 0.0;
float y = 9.0;
float angle = 0.0;

float gotoPos(float xnew, float ynew)
{
	float a = xnew - x;
	float b = ynew - y;
	float c = sqrt((a * a) + (b * b));
	float idk = b/c;
	float AngleNew = asin(idk);
	writeDebugStreamLine("Radians: %f", AngleNew);
	AngleNew = AngleNew * 180 / PI;
	return AngleNew;
}

task main() {
	int anglething = gotoPos(10.0,1.0);
	while(anglething < 0)
	{
		anglething = anglething + 360;
	}
	while(anglething >= 360)
	{
		anglething = anglething - 360;
	}
	writeDebugStreamLine("Degrees: %f", anglething);
}
