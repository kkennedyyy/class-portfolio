// Copyright 2024 kpoag
// Implementation for ShortAnswerQuestion class
#include "shortanswerquestion.h"
#include <string>
using std::string;

using namespace csce240_program5;
// Constructs an Object
ShortAnswerQuestion::ShortAnswerQuestion(const string &question,
                                         const string &answer)
      : Question(question), correct_answer(answer) {}
// Destructor
ShortAnswerQuestion::~ShortAnswerQuestion() {}
// Getter
string ShortAnswerQuestion::getCorrectAnswer() const {
  return correct_answer;
}
// Setter
void ShortAnswerQuestion::setCorrectAnswer(const string &answer) {
  correct_answer = answer;
}
// Print function
void ShortAnswerQuestion::Print(bool displayAnswer) const {
  Question::Print();
  if (displayAnswer) {
    std::cout << "Correct Answer: " << correct_answer << std::endl;
  }
}
