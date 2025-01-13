// Copyright 2024 kpoag
#ifndef _RIGHTISOSCELES_H_
#define _RIGHTISOSCELES_H_
#include"PixelShape.h"
#include<iostream>
#include<string>
using std::string;

namespace CSCE240_Program6 {

class RightIsosceles : public PixelShape {
 public:
// Constructor
  explicit RightIsosceles(int length = 2, char pixel = '*');
// Mutator
  void SetLeg(int length);
// Getter
  int GetLeg() const { return length_;}
// virtual print func
  void Print(bool filled = true) const override;
// virtual deconstructor
  virtual ~RightIsosceles();
// virtual operator override
  RightIsosceles& operator *= (double right) override;
 private:
  int length_;
};
}  // namespace CSCE240_Program6

#endif
