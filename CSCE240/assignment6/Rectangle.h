// Copyright 2024 kpoag
#ifndef _RECTANGLE_H_
#define _RECTANGLE_H_
#include"PixelShape.h"

namespace CSCE240_Program6 {

class Rectangle : public PixelShape {
 public:
// Constrcutor
  explicit Rectangle(int length = 2, int width = 1, char pixel = '*');
// Mutator func
  void SetLength(int length);
  void SetWidth(int width);
// Accessor/Getter func
  int GetLength() const { return length_; }
  int GetWidth() const { return width_; }
// virtual print func
  void Print(bool filled = true) const override;
// virtual operator overload func
  Rectangle& operator *= (double right) override;
// virtual deconstructor
  virtual ~Rectangle();
 private:
  int length_;
  int width_;
};
}  // namespace CSCE240_Program6
#endif
