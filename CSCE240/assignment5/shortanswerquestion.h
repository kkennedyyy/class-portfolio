// Copyright 2024 kpoag

#ifndef SHORTANSWERQUESTION_H
#define SHORTANSWERQUESTION_H

#include<iostream>
#include<string>
using std::string;
// Include base class header file
#include "question.h"

namespace csce240_program5 {

class ShortAnswerQuestion : public Question {
 public:
// Explicit constructor
  explicit ShortAnswerQuestion(const string &question = "?",
                               const string &answer = "");
// Destructor
  virtual ~ShortAnswerQuestion();
// Getter and Setter
  string getCorrectAnswer() const;
  void setCorrectAnswer(const string &answer);
// Print question and answer
  void Print(bool displayAnswer) const;
 private:
  string correct_answer;
};
}  // end namespace csce240_program5
#endif  // SHORTANSWERQUESTION_H
