// Copyright 2024 kpoag
#include"PixelShape.h"
#include"RightIsosceles.h"
#include<iostream>

using std::cout;
using std::endl;

namespace CSCE240_Program6 {
// constructor
RightIsosceles::RightIsosceles(int length, char pixel) :
                               PixelShape("right isosceles triangle", pixel),
                               length_(length) {
  if (length < 2)
    SetLeg(2);
}
// Set triangle leg
void RightIsosceles::SetLeg(int length) {
  if (length >=2 )
    length_ = length;
}
// print triangle
void RightIsosceles::Print(bool filled) const {
  cout << GetName() << endl;
  for (int i = 1; i <= length_; i++) {
    for (int j = 1; j <= i; j++) {
      if (filled || i == length_ || j == i || j== 1) {
        cout << GetPixel() << ' ';
      } else {
        cout << " ";
     }
    }
    cout << endl;
  }
}
// returns reference to left operand, but left unchanged if <2
RightIsosceles& RightIsosceles::operator *= (double right) {
  if ((length_ * right) >= 2)
    length_ = length_ * right;
  return *this;
}
// destructor
RightIsosceles::~RightIsosceles() {}
}  // namespace CSCE240_Program6
