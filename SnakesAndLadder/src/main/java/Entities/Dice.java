package Entities;

public class Dice {

    int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    // function rollDice, which will take number of dice and return random dice score
    public int rollDice(){
        int min = noOfDice;
        int max = noOfDice*6;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
}
