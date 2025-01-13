// Copyright 2024 kpoag
// Implementation for functions in Height class
// Assignment 4 Due: 10.24.24
#include"height.h"
#include<iostream>
using std::ostream;
#include<string>
using std::string;
#include<cmath>

// Sets members to default values
Height::Height(double value, string units) : value_(value), units_(units) {
  if (!SetUnits(units)) {
    units_ = "feet";
  }
  if (!SetValue(value)) {
    value_ = 0;
  }
}
//  Setter for Value
bool Height::SetValue(double newValue) {
  if (newValue >= 0) {
    value_ = newValue;
    return true;
  }
  return false;
}
//  Setter for Units
bool Height::SetUnits(const string& newUnit) {
  if ((newUnit == "inches") || (newUnit == "feet") ||
  (newUnit == "meters") || (newUnit == "centimeters")) {
    units_ = newUnit;
    return true;
  }
  return false;
}
//  Converts value to desired unit
void Height::ConvertUnits(string unitWanted) {
  if (units_ == unitWanted) return;
  if (units_ == "inches") {
     if (unitWanted == "feet") {
       value_ /= 12.0;
     } else if (unitWanted == "meters") {
       value_ *= 0.0254;
     } else if (unitWanted == "centimeters") {
       value_ *= 2.54;
     }
  }
  if (units_ == "feet") {
     if (unitWanted == "inches") {
       value_ *= 12.0;
     } else if (unitWanted == "meters") {
       value_ *= 0.3048;
     } else if (unitWanted == "centimeters") {
       value_ *= 30.48;
     }
  }
  if (units_ == "meters") {
     if (unitWanted == "inches") {
       value_ *= 39.3701;
     } else if (unitWanted == "feet") {
       value_ *= 3.28084;
     } else if (unitWanted == "centimeters") {
       value_ *= 100;
     }
  }
  if (units_ == "centimeters") {
     if (unitWanted == "inches") {
       value_ *= 0.393701;
     } else if (unitWanted == "feet") {
       value_ *= 0.0328084;
     } else if (unitWanted == "meters") {
       value_ *= 0.01;
     }
  }
  units_ = unitWanted;
}
//  overload operator
ostream& operator << (ostream& whereto, const Height& h) {
  whereto << h.GetValue() << " " << h.GetUnits();
  return whereto;
}
