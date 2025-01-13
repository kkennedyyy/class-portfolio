// Copyright 2024 kpoag
#ifndef _PIXELSHAPE_H_
#define _PIXELSHAPE_H_

#include<iostream>
#include<string>
using std::ostream;
using std::string;

namespace CSCE240_Program6 {

class PixelShape {
// Public data members
 public:
// Explicit constructor
  explicit PixelShape(string name = "?", char pixel = '*');
// Setter functions
  void SetPixel(char pixel);
  void SetName(string name);
// Getter functions
  string GetName() const { return name_; }
  char GetPixel() const {return pixel_char_; }
// Virtual funcs
  virtual void Print(bool paint = true) const;
  virtual PixelShape& operator *= (double right) = 0;
  virtual ~PixelShape() {}
// Private data members
 private:
  string name_;
  char pixel_char_;
};
}  // namespace CSCE240_Program6
#endif
