// Copyright 2024 kpoag
// Source file to test the functions in program2functions.cc
#include<iostream>
using std::cout;
using std::cin;
using std::endl;
#include"./program2functions.h"

int main() {
  cout << "Enter two dates" << endl;
  int day1, month1, year1;
  int day2, month2, year2;
  char slash1, slash2;

  cin >> month1 >> slash1 >> day1 >> slash2 >> year1
  >> month2 >> slash1 >> day2 >> slash2 >> year2;
  // make sure input is valid before calculating days between
  if ( ValidDate(month1, day1, year1) && ValidDate(month2, day2, year2) ) {
    int daysBetween = 0;
    // t = temporary
    int tMonth = month1, tDay = day1, tYear = year1;
    // checks which day is earlier
    bool dateIsEarlier = (year1 < year2) || (year1 == year2 && month1 < month2)
    || (year1 == year2 && month1 == month2 && day1 < day2);
    if ( dateIsEarlier ) {
    // reiterates and counts days betweens until the dates match
      while ( tYear != year2 || tMonth != month2 || tDay != day2 ) {
        NextDate(tMonth, tDay, tYear);
        daysBetween++;
      }
    } else {
    // counts days between by subtracting if date isn't earlier
        while ( tYear != year2 || tMonth != month2 || tDay != day2 ) {
          PreviousDate(tMonth, tDay, tYear);
          daysBetween--;
        }
     }
     // use if-else statement to display output depending if daysBetween
     // is neg. or pos.
    if ( daysBetween > 0 ) {
      cout << month1 << "/" << day1 << "/" << year1 << " is " << daysBetween <<
        " days before " << month2 << "/" << day2 << "/" << year2 << endl;
    } else if ( daysBetween < 0 ) {
      cout << month1 << "/" << day1 << "/" << year1 << " is " << -daysBetween <<
        " days after " << month2 << "/" << day2 << "/" << year2 << endl;
    } else {
     cout << month1 << "/" << day1 << "/" << year1 << " is 0 days before "
        << month2 << "/" << day2 << "/" << year2 << endl;
    }
  }
  return 0;
}
