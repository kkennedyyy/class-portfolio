// Copyright 2024 kpoag
#include"PixelShape.h"
#include"Rectangle.h"
#include<iostream>
using std::cout;
using std::endl;

namespace CSCE240_Program6 {
// Constructor check lengths
Rectangle::Rectangle(int length, int width, char pixel)
                    : PixelShape("rectangle", pixel),
                    length_(length), width_(width) {
  if (length < 1)
    SetLength(2);
  if (width < 1)
    SetWidth(1);
}
// Setter/Mutator for length
void Rectangle::SetLength(int length) {
  if (length>= 1)
    length_ = length;
}
// Setter/Mutator for width
void Rectangle::SetWidth(int width) {
  if (width >=1)
    width_ = width;
}
// Multiplies length and width values, left unchanged if less than 1
Rectangle& Rectangle::operator*= (double right) {
  int length = length_ * right;
  int width = width_ * right;
  if (1 <= length && width >= 1) {
    length_ = length;
    width_ = width;
  }
  return *this;
}
// uses for loop to print the rectangle
void Rectangle::Print(bool filled) const {
  cout << GetName() << endl;
  for (int i = 1; i <= length_; i++) {
    for (int j = 1; j <= width_; j++) {
      if (filled || i == length_ || j == width_ || i== 1 || j== 1)
        cout << GetPixel() << ' ';
      else
        cout << " ";
    }
    cout << endl;
  }
}
// destructor
Rectangle::~Rectangle() {}
}  // namespace CSCE240_Program6
