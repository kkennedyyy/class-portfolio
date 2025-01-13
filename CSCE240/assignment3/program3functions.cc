// Copyright 2024 kpoag
#include"program3functions.h"
#include"checkArraysMatch.h"
#include<iostream>
#include<iomanip>
#include<cmath>

using std::cout;
using std::endl;
using std::cin;

int CountAboveAv(const double array[][columns], int kRow) {
  int allElements = kRow * 10;
  double average = 0.0;
  //  Loops through array and adds all the values
  for ( int i = 0; i < kRow; ++i ) {
    for ( int j = 0; j < columns; ++j ) {
       average += array[i][j];
    }
  }
  //  Divides the average by the number of elements in array
  double mean = average / allElements;
  int count = 0;
  //  Loops through away again and counts each element thats greater
  //  than the mean and returns the count
  for ( int i = 0; i < kRow; ++i ) {
    for ( int j = 0; j < columns; ++j ) {
       if (array[i][j] > mean) {
         count++;
       }
    }
  }
  return count;
}

void SortByCol(double doubarray[][columns], int kRow,
  int sort, bool ascending) {
  //  Embedded for loop to loop through each column
  for (int i = 0; i < kRow - 1; i++) {
    for (int j = 0; j < kRow - i -1; j++) {
    //  Sorts array by either ascending or descending order
      if ((ascending && doubarray[j][sort] > doubarray[j+1][sort]) ||
        (!ascending && doubarray[j][sort] < doubarray[j + 1][sort]))  {
          for ( int columns = 0; columns < 10; columns++ ) {
            double temp = doubarray[j][columns];
            doubarray[j][columns] = doubarray[j + 1][columns];
            doubarray[j + 1][columns] = temp;
          }
        }
      }
  }
}

void SortByRow(double doubarray[][columns], int kRow,
  int sort, bool ascending) {
  //  Embedded for loop to loop through each row
  for (int i = 0; i < columns - 1; i++) {
    for (int j = 0; j < columns - i -1; j++) {
      if ((ascending && doubarray[sort][j] > doubarray[sort][j + 1]) ||
       (!ascending && doubarray[sort][j] < doubarray[sort][j+1]))  {
          for (int row = 0; row < kRow; row++) {
            double temp = doubarray[row][j];
            doubarray[row][j] = doubarray[row][j + 1];
            doubarray[row][j + 1] = temp;
          }
        }
      }
  }
}

double MedianInCol(const double doubarray[][columns],
  int kRow, int col) {
  //  Create temp array to store a column
  double columnValues[kRow];
  for (int i = 0; i < kRow; i++) {
    columnValues[i] = doubarray[i][col];
  }
  double median;
  //  Uses bubble sort to sort column
  for (int i = 0; i < kRow - 1; i++) {
    for (int j = 0; j < kRow - i -1; j++) {
      if (columnValues[j] > columnValues[j + 1]) {
      //  Swap neighboring elements if order is incorrect
        double temp = columnValues[j];
        columnValues[j] = columnValues[j + 1];
        columnValues[j + 1] = temp;
      }
    }
  }
  //  Returns median if row is odd
  if (kRow % 2 == 1) {
     median = columnValues[kRow / 2];
     return median;
  } else {
  //  Retrieves middle two values average
     median = (columnValues[kRow / 2 - 1] + columnValues[kRow / 2]) / 2.0;
     return median;
  }
}

int ModeInCol(const double doubarray[][columns],
  int kRow, int col, double modes[2]) {
  double values[kRow];
  int count[kRow] = {0};
  int times = 0;

  //  For loop to check which element appears the most.
  for (int i = 0; i < kRow; i++) {
    bool exist = false;
    for (int j = 0; j < times; j++) {
      if (doubarray[i][col] == values[j]) {
        count[j]++;
        exist = true;
        break;
      }
    }
    if (!exist) {
      values[times] = doubarray[i][col];
      count[times] = 1;
      times++;
    }
  }
  int maxCount = 0;
  for (int i = 0; i < times; i++) {
    if (count[i] > maxCount) {
      maxCount = count[i];
    }
  }
  int modeCount = 0;
  //  Find numbers that occur the most (mode)
  for (int i = 0; i < times; i++) {
    if (count[i] == maxCount) {
      if (modeCount < 2) {
          modes[modeCount] = values[i];
          modeCount++;
      } else {
         modes[0] = modes[1] = -1.0;
         return 0;
        }
      }
    }
    if ( modeCount == 1 ) {
      modes[1] = -2.0;
    }
  return modeCount;
}
