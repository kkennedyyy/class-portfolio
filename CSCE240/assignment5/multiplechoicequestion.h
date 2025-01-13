// Copyright 2024 kpoag

#ifndef MULTIPLECHOICEQUESTION_H
#define MULTIPLECHOICEQUESTION_H

#include<string>
using std::string;
#include<iostream>
#include "question.h"

namespace csce240_program5 {

class MultipleChoiceQuestion : public Question{
 public:
// Constructs an object
  explicit MultipleChoiceQuestion(const string &question = "?",
    int nChoices = 0, string *choices = nullptr,
    bool *correct = nullptr);
// Copy constructor
  MultipleChoiceQuestion(const MultipleChoiceQuestion &diff);
// Assignsnment operator
  MultipleChoiceQuestion &operator=(const MultipleChoiceQuestion &diff);
// Destructor
  virtual ~MultipleChoiceQuestion();
// Getter and Setter's
  int GetNumberOfChoices() const;
  void SetNumberOfChoices(int nChoices);
  void SetAnswerChoices(int nChoices, string *choices, bool *correct);
// Print func
  void Print(bool displayAnswer) const;
 private:
    int num_choices;
    string *_choices;
    bool *_correct;
};
}  // end namespace csce240_program5
#endif
