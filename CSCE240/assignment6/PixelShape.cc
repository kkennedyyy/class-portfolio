// Copyright 2024 kpoag
#include "PixelShape.h"
#include<iostream>
#include<string>
using std::cout;
using std::endl;

namespace CSCE240_Program6 {
// Constructor default arguments to check length
PixelShape::PixelShape(string name, char pixel) :
                       name_(name), pixel_char_(pixel) {
  if (name.length() < 1)
    SetName("?");
  if (pixel < 33 || pixel > 126)
    SetPixel('*');
}
// Sets pixel if meets the char requirements
void PixelShape::SetPixel(char pixel) {
  if (pixel >= 33 && pixel <= 126)
    pixel_char_ = pixel;
}
// Set name if it meets requirements
void PixelShape::SetName(string name) {
  if ( name.length() >= 1)
    name_ = name;
}
// Virtual print function
void PixelShape::Print(bool paint) const {
  cout << "Pixel Shape Name " << name_ << endl;
}
}  // namespace CSCE240_Program6
