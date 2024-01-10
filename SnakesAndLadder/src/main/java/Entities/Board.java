package Entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {
    int boardSize;
    int numSnakes;
    int numLadder;

    public Board(int boardSize, int numSnakes, int numLadder) {
        this.boardSize = boardSize;
        this.numSnakes = numSnakes;
        this.numLadder = numLadder;
    }


    public Map<Integer, Integer> positionResetters = new HashMap<>();

    // A function which will take these 3 values and generate random positionResetters and return map of position resetters

    public Map<Integer, Integer> jumpSetter(){
        int min = 1;
        int max = boardSize-1;
        int range = max-min + 1;
        Set<Integer> jumpPositions = new HashSet<>();
        while (numLadder > 0 && numSnakes > 0){
            int position1;
            int position2;
            do{
                position1 = (int) (Math.random() * range) + min;
                position2 = (int) (Math.random() * range) + min;
            }while (jumpPositions.contains(position1) || jumpPositions.contains(position2));
            jumpPositions.add(position1);
            jumpPositions.add(position2);
            if(position1 < position2){
                //ladder
                numLadder--;
                System.out.println("Ladder from " + position1 + " to " + position2);
            }
            else{
                //snake
                numSnakes--;
                System.out.println("Snake from " + position1 + " to " + position2);
            }
            positionResetters.put(position1,position2);
        }

        return positionResetters;
    }
}
