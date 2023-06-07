#include <iostream>
#include <cmath>

int main(){
    int num;
    int guess;
    int tries;
    int close[10]{1,2,3,4,5,6,7,8,9,10};
    
    srand(time(NULL));
    num = (rand() % 100) + 1;

    do{ 
        jump:
        std::cout << "enter a guess between (1-100): ";
        std::cin >> guess;
        tries++;

        for(int i=0; i < 10; i++){
        if(abs((guess - num)) == close[i]){ 
        std::cout << "that was close \n";
        goto jump;}
        }
        if(guess > num) std::cout << "too high \n";
        else if(num > guess) std::cout << "too low \n";
        else std::cout << "Correct! " <<tries<<" of tries\n";
    
    }while(guess != num);

    return 0;
}