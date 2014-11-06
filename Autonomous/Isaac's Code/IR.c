#include "hitechnic-irseeker-v2.h"

#warn "Unless you are a member of 2856, do not use this library! It does not use generalized functions."
#warn "A 2856 member should come integrate this library into their team-specific repository."

typedef struct
{
  int A;
  int B;
  int C;
  int D;
  int E;
} Values;

Values IR_LeftValue;
Values IR_RightValue;

void IR_Update()
{
	HTIRS2readAllACStrength(IROne, IR_LeftValue.A, IR_LeftValue.B, IR_LeftValue.C, IR_LeftValue.D, IR_LeftValue.E);
	HTIRS2readAllACStrength(IRTwo, IR_RightValue.A, IR_RightValue.B, IR_RightValue.C, IR_RightValue.D, IR_RightValue.E);
}
