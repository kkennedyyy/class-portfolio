// Copyright 2024 kpoag
// Header file containing prototypes of functions in program2functions.cc
#ifndef PROGRAM2FUNCTIONS_H_
#define PROGRAM2FUNCTIONS_H_

// function checks if the year is a leap year
bool LeapYear(int year);

// Returns last day of month
int LastDayOfMonth(int month, int year);

// return true or false if date is valid
bool ValidDate(int month, int day, int year);

// calculates the next date based on month, day, and year input
void NextDate(int &month, int &day, int &year);

// calculates previous date based on month, day, and year input
void PreviousDate(int &month, int &day, int &year);


#endif
