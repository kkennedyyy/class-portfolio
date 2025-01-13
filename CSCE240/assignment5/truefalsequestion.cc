// Copyright 2024 kpoag
// Implementation for TrueFalseQuestion class
#include"truefalsequestion.h"
#include <string>
using std::string;

using namespace csce240_program5;
// Constructs a TrueFalseQuestion object
TrueFalseQuestion::TrueFalseQuestion(const string &question, bool answer)
    : Question(question), answer_to_question(answer) {}
// Destructor
TrueFalseQuestion::~TrueFalseQuestion() {}
// Getter, returns answer
bool TrueFalseQuestion::getAnswer() const {
  return answer_to_question;
}
// Setter
void TrueFalseQuestion::setAnswer(bool answer) {
  answer_to_question = answer;
}
// Prints question and answer
void TrueFalseQuestion::Print(bool displayAnswer) const {
  Question::Print();
  if (displayAnswer) {
    std::cout << "Correct Answer: " << (answer_to_question ? "true" : "false")
               << std::endl;
  }
}
