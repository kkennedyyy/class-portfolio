// Copyright 2024 kpoag
#include"./program2functions.h"
#include <iostream>
using std::cout;
using std::endl;

// Divides the year by 400,100 and 4 and checks
// the remainder to see if leap year
bool LeapYear(int year) {
  if (year % 400 == 0) {
    return true;
  } else if (year % 100 == 0) {
    return false;
  } else if (year % 4 == 0) {
    return true;
  } else {
    return false;
  }
}

// returns the last day of the month by checking
// if the year is a leap year and the integer
int LastDayOfMonth(int month, int year) {
  if ( month != 2 ) {
    year = 0;
  }
  if (month == 1 || month == 3 || month == 5 || month == 7 ||
    month == 8 || month == 10 || month == 12) {
    return 31;
  } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
  } else if (month == 2 && year > 0) {
    if (LeapYear(year)) {
      return 29;
    } else {
      return 28;
    }
  } else {
    return 0;
  }
}

// returns true or false if the month, day, and year is valid
bool ValidDate(int month, int day, int year) {
  if  (month >= 1 && month <= 12 && year > 0) {
    int lastDay = LastDayOfMonth(month, year);
    if (day >= 1 && day <= lastDay) {
      return true;
    }
  }
  cout << month <<"/"<< day << "/"<< year << " is not a valid date" << endl;
  return false;
}

// calculates the next date by adding to the day and resetting the values if
// the next day is a new year
void NextDate(int &month, int &day, int &year) {
  if (ValidDate(month, day, year)) {
    day++;
    if (day > LastDayOfMonth(month, year)) {
      day = 1;
      month++;
      if (month > 12) {
        month = 1;
        year++;
      }
    }
  }
}
// calculates the previous date by subtracting from the day
// and resetting the values if the prev day is last year
void PreviousDate(int &month, int &day, int &year) {
  if (ValidDate(month, day, year)) {
    day--;
    if (day < 1) {
      month--;
      if (month < 1) {
        month = 12;
        year--;
      }
      day =  LastDayOfMonth(month, year);
    }
  }
}



