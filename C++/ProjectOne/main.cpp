/*
  setup area

*/
#include <iostream>

int main() {
    int temp;
    std::string name;
    std::cout << "enter you name " << std::endl;
    std::cin >> name;
    std::cout << "enter you age " << std::endl;
    std::cin >> temp;
    std::cout << "you entered " << name << std::endl;

    std::cout << "you entered " << temp << std::endl;
    return 0;
}
