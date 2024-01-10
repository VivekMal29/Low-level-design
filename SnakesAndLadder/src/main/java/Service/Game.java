package Service;

import Entities.Board;
import Entities.Dice;
import Entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

    int boardSize;
    int numSnakes;
    int numLadder;
    int numPlayers;
    int noOfDice;
    Board board;
    public List<Player> players = new ArrayList<>();
    Dice dice;


    public Game(int boardSize, int numSnakes, int numLadder, int numPlayers, int noOfDice) {
        this.boardSize = boardSize;
        this.numSnakes = numSnakes;
        this.numLadder = numLadder;
        this.numPlayers = numPlayers;
        this.noOfDice = noOfDice;
    }

    public void initializeDice(){
        dice = new Dice(noOfDice);
    }

    public void initializeBoard(){
        board = new Board(boardSize,numSnakes,numLadder);
        board.jumpSetter();
    }

    public void initializePlayers(){
        for(int id=1;id<=numPlayers;id++){
            String name = "Player" + id;
            Player player = new Player(id,name,0);
            players.add(player);
            System.out.println("Player is " + player.name);
        }
    }

    boolean isGameOver = false;
    public int winnerId;
    public void play(){
        int curPlayerId = 1;
        Map<Integer, Integer> resetterMap = board.positionResetters;
        while (!isGameOver){
            Player player = players.get(curPlayerId-1);
            int prevPosition = player.curPosition;
            int diceScore = dice.rollDice();
            String str = player.name + " rolled dice to score " + diceScore;
            int nextPosition = player.curPosition + diceScore;

            if(resetterMap.containsKey(nextPosition)){
                player.curPosition = resetterMap.get(nextPosition);
                if(nextPosition > resetterMap.get(nextPosition)){
                    //snake
                    str += " to get bitten by snake ";
                }
                else{
                    //ladder
                    str += " to get ride in ladder ";
                }
            }
            else if(nextPosition < boardSize){
                player.curPosition = nextPosition;
            }else if(nextPosition == boardSize){
                isGameOver = true;
                winnerId = curPlayerId;
                player.curPosition = nextPosition;
            }
            str += " to move from " + prevPosition + " position to " + player.curPosition + " position.";
            player.stepsTaken.add(str);
            curPlayerId++;
            if(curPlayerId>numPlayers){
                curPlayerId = 1;
            }

        }

    }
}
