// Copyright kpoag 2024
// Header file containing prototypes for program3functions.cc
#ifndef _PROGRAM3FUNCTIONS_H_
#define _PROGRAM3FUNCTIONS_H_

#include <iostream>

using std::cout;
using std::endl;
using std::cin;


const int columns = 10;
int CountAboveAv(const double array[][columns], int kRow);
void SortByCol(double doubarray[][columns], int kRow, int sort, bool ascending);
void SortByRow(double doubarray[][columns], int kRow, int sort, bool ascending);
double MedianInCol(const double doubarray[][columns], int kRow, int col);
int ModeInCol(const double doubarray[][columns], int kRow,
  int col, double modes[2]);

#endif  //  _HOME_KPOAG_ASSIGNMENT3_PROGRAM3FUNCTIONS_H_
