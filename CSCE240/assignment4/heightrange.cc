// Copyright 2024 kpoag

#include "heightrange.h"
#include <cmath>
#include <string>
#include <iostream>
#include "height.h"
using std::ostream;
using std::string;

HeightRange::HeightRange(const Height& h1, const Height& h2) {
     Height convertedH1 = h1;
    convertedH1.ConvertUnits(h2.GetUnits());  // Convert h1 to h2's units

    if (convertedH1.GetValue() < h2.GetValue()) {
        smallest = h1;
        largest = h2;
    } else {
        smallest = h2;
        largest = h1;
    }
    }
//  Creates copy of h, converts it, and checks if its the shortest
void HeightRange::SetShortest(const Height& h) {
    Height convertedHeight = h;
    convertedHeight.ConvertUnits(largest.GetUnits());
    if (convertedHeight.GetValue() <= largest.GetValue()) {
        smallest = h;
    }
}
//  Creates copy of h, converts it, and checks if its the tallest
void HeightRange::SetTallest(const Height& h) {
    Height convertedHeight = h;
    convertedHeight.ConvertUnits(smallest.GetUnits());
    if (convertedHeight.GetValue() >= smallest.GetValue()) {
        largest = h;
    }
}
//  checks if height is in range
bool HeightRange::InRange(const Height& h, bool inclusive) {
    Height convertedHeight = h;
    if (h.GetUnits() != smallest.GetUnits()) {
        convertedHeight.ConvertUnits(smallest.GetUnits());
    }
    double smallestValue = smallest.GetValue();
    double largestValue = largest.GetValue();
    double testValue = convertedHeight.GetValue();

    if (inclusive) {
        return (testValue >= smallestValue && testValue <= largestValue);
    } else {
        return (testValue > smallestValue && testValue < largestValue);
    }
}
//  calculates width by returning difference between largest and smallest height
Height HeightRange::Width() const {
    Height convertedLargest = largest;
    if (largest.GetUnits() != smallest.GetUnits()) {
        convertedLargest.ConvertUnits(smallest.GetUnits());
    }
    double widthValue = convertedLargest.GetValue() - smallest.GetValue();
    if (widthValue < 0) {
        widthValue = -widthValue;
    }
    return Height(widthValue, smallest.GetUnits());
}
