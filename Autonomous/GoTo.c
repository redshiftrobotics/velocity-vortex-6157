float x = 0.0;
float y = 0.0;
float angle = 0.0;

float gotoPos(float xnew, float ynew)
{
	float a = xnew - x;
	float b = ynew - y;
	float c = sqrt((a * a) + (b * b));
	int AngleNew = asin(b/c);
	return AngleNew;
}
task main() {
	writeDebugStreamLine("Position: %i", gotoPos(10,0));
}
