// Copyright 2024 kpoag
// Assignment 4 Due: 10.24.24
#ifndef HEIGHT_H_
#define HEIGHT_H_

#include<string>
using std::string;
#include<iostream>
using std::ostream;
// Height class to represent height val and unit
class Height {
  // Overloaded operator
  friend ostream& operator << (ostream& whereto, const Height& h);
 public:
  // Constructor: intializes Height
    explicit Height(double value = 0.0, string units = "feet");
    bool SetValue(double value);  // Sets height value
    double GetValue() const { return value_; }  // Gets current height
    bool SetUnits(const string& newUnit);  // Sets units of height
    string GetUnits() const { return units_; }  // Gets current unit
    void ConvertUnits(string unitWant);  // Converts to desired unit
 private:
    double value_;  // Holds numeric val of height
    string units_;  // Holds units of measurement for height
};
#endif
