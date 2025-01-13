// Copyright 2024 kpoag
// Assignment 4 Due: 10.24.24
#ifndef HEIGHTRANGE_H_
#define HEIGHTRANGE_H_

#include <string>
#include <iostream>
#include "height.h"
using std::string;
using std::ostream;

class HeightRange {
 public:
    HeightRange(const Height& smallest = Height(0, "feet"),
    const Height& largest = Height(0, "feet"));
    Height GetShortest() const { return smallest;}  // get shortest height
    Height GetTallest() const { return largest;}  // Get tallest height
    // Check height is in range
    bool InRange(const Height& h, bool inclusive = true);
    Height Width() const;
    void SetShortest(const Height& h);  // set shortest height
    void SetTallest(const Height& h);  //  set tallest height
    //  Height Width(); // Calc difference of tallest and shortest
 private:
  Height smallest;  //  smallest height
  Height largest;  // largest height
};
#endif
