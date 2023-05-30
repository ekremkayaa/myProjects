#include <iostream>
#include <ctime>

char getUserChoice();
char getComputerChoice();
void showChoice(char choice);
void chooseWinner(char player, char computer);

int main(){
    char player;
    char computer;

    player = getUserChoice();
    std::cout << "Your choice ";
    showChoice(player);

    computer = getComputerChoice();
    std::cout << "Computer's choice ";
    showChoice(computer);

    chooseWinner(player, computer);
    
    return 0;
}

char getUserChoice(){
    char player;
    do{
    std::cout << "'r' for rock\n";
    std::cout << "'p' for paper\n";
    std::cout << "'s' for scissors\n";
    std::cin >> player;
    }while(player != 'r' && player != 'p' && player != 's');

    return player;

}

char getComputerChoice(){

    srand(time(0));
    int num = (rand() % 3) + 1;

    switch (num)
    {
    case 1: 
       return 's';
    case 2: 
        return 'p';
    case 3: 
        return 'r';
    }

    return 0;
}

void showChoice(char choice){
    switch (choice)
    {
    case 's': 
        std::cout << "scissors\n";
        break;
    case 'p': 
        std::cout << "paper\n";
        break;
    case 'r': 
        std::cout << "rock\n";
        break;
    
    default:
        break;
    }
}

void chooseWinner(char player, char computer){
    switch(player){
        case 'r':  if(computer == 'r') std::cout << "it's tie\n";
                   else if(computer == 'p') std::cout << "you lose\n";
                   else std::cout << "you win\n";
                   break;
        case 'p':  if(computer == 'p') std::cout << "it's tie\n";
                   else if(computer == 's') std::cout << "you lose\n";
                   else std::cout << "you win\n";
                   break;
        case 's':  if(computer == 's') std::cout << "it's tie\n";
                   else if(computer == 'r') std::cout << "you lose\n";
                   else std::cout << "you win\n";
                   break;
        default:
                    break;
    }


}