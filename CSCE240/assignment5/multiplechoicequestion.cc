// Copyright 2024 kpoag

#include "multiplechoicequestion.h"
#include<string>
using std::string;

using namespace csce240_program5;
// Constructs an object and initializes question class with question
// text, sets number of choices, and assigns answer choices and correctness
MultipleChoiceQuestion::MultipleChoiceQuestion(const string &question,
          int nChoices, string *choices, bool *correct)
     : Question(question),
     num_choices(nChoices),
     _choices(nullptr),
     _correct(nullptr) {
    SetAnswerChoices(nChoices, choices, correct);
    }
// Copy constructor
MultipleChoiceQuestion::MultipleChoiceQuestion(
      const MultipleChoiceQuestion &diff)
      : Question(diff.GetQuestion()),
      num_choices(diff.num_choices),
      _choices(nullptr),
      _correct(nullptr) {
    SetAnswerChoices(num_choices, diff._choices, diff._correct);
}
// Assignment operator
MultipleChoiceQuestion &MultipleChoiceQuestion::operator=(
  const MultipleChoiceQuestion &diff) {
     if (this != &diff) {
       Question::SetQuestion(diff.GetQuestion());
       SetAnswerChoices(diff.num_choices, diff._choices, diff._correct);
       }
       return *this;
}
// Destructor
MultipleChoiceQuestion::~MultipleChoiceQuestion() {
  delete[] _choices;
  delete[] _correct;
}
// Getter and Setters
int MultipleChoiceQuestion::GetNumberOfChoices() const {
  return num_choices;
}
void MultipleChoiceQuestion::SetNumberOfChoices(int nChoices) {
  num_choices = nChoices;
}
void MultipleChoiceQuestion::SetAnswerChoices(int nChoices,
                                              string *choices, bool *correct) {
  delete[] _choices;
  delete[] _correct;
  num_choices = nChoices;
  _choices = new string[nChoices];
  _correct = new bool[nChoices];
  for (int i = 0; i < nChoices; ++i) {
    if (choices) {
      _choices[i] = choices[i];
    } else {
      _choices[i] = "";
    }
    if (correct) {
      _correct[i] = correct[i];
    } else {
      _correct[i] = true;
    }
  }
}
// Prints question and answer choices
void MultipleChoiceQuestion::Print(bool displayAnswer) const {
  Question::Print();
  std::cout << "Answer Choices:" << std::endl;
  if (_choices && _correct) {
    for (int i = 0; i < num_choices; ++i) {
      std::cout << _choices[i];
      if (displayAnswer) {
        std::cout << (_correct[i] ? " - correct" : " - incorrect");
      }
      std::cout << std::endl;
    }
  }
}
