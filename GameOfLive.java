package gol;

import framework.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameBoard extends State {

    private static final int CELL_SIZE = 30;
    private static boolean[][] Lives = new boolean[26][13];
    private static int speed = 1;

    public GameBoard(int boardSize) {

        Random rand = new Random();

        for (int x = 0; x < 26; x++){
            for (int k = 0; k < 13; k++){
                Lives[x][k] = rand.nextBoolean();
            }
        }

    }

    private void checkLife(){

        for (int x = 0; x < 26; x++){
            for (int k = 0; k < 13; k++){
                int nearby = countForCellLifeNearby(x, k);
                changeLife(x, k, nearby);
            }
        }
    }

    private void changeLife(int x, int k, int numberOfLivingCells){
        if (numberOfLivingCells < 2){markDead(x, k);}
        if (numberOfLivingCells > 3){markDead(x, k);}
        if ((numberOfLivingCells == 3 || numberOfLivingCells == 2) && Lives[x][k]){markAlive(x, k);}
        if (numberOfLivingCells == 3 && !Lives[x][k]){markAlive(x, k);}
    }
    private void markDead(int x, int k){
        Lives[x][k] = false;
    }

    private void markAlive(int x, int k){
        Lives[x][k] = true;
    }

    private int checkCornersAndEdges(int x, int k){
        int numberOfLivingNeighbors = 0;

        if(x == 0){
            if(k == 0) {
                if (Lives[x + 1][k + 1]){numberOfLivingNeighbors++;}
                if (Lives[x + 1][k]){numberOfLivingNeighbors++;}
                if (Lives[x][k + 1]){numberOfLivingNeighbors++;}
            }
            else if (k == 12){
                if(Lives[x + 1][k - 1]){numberOfLivingNeighbors++;}
                if(Lives[x + 1][k]){numberOfLivingNeighbors++;}
                if(Lives[x][k - 1]){numberOfLivingNeighbors++;}
            }
            else{
                if(Lives[x + 1][k + 1]){numberOfLivingNeighbors++;}
                if(Lives[x + 1][k]){numberOfLivingNeighbors++;}
                if(Lives[x][k + 1]){numberOfLivingNeighbors++;}
                if(Lives[x][k - 1]){numberOfLivingNeighbors++;}
                if(Lives[x + 1][k - 1]){numberOfLivingNeighbors++;}
            }
        }
        else if(x == 25){
            if(k == 12){
                if (Lives[x - 1][k - 1]){numberOfLivingNeighbors++;}
                if (Lives[x - 1][k]){numberOfLivingNeighbors++;}
                if (Lives[x][k - 1]){numberOfLivingNeighbors++;}
            }
            else if(k == 0){
                if(Lives[x - 1][k + 1]){numberOfLivingNeighbors++;}
                if(Lives[x - 1][k]){numberOfLivingNeighbors++;}
                if(Lives[x][k + 1]){numberOfLivingNeighbors++;}
            }
            else{
                if(Lives[x - 1][k + 1]){numberOfLivingNeighbors++;}
                if(Lives[x - 1][k]){numberOfLivingNeighbors++;}
                if(Lives[x][k + 1]){numberOfLivingNeighbors++;}
                if(Lives[x][k - 1]){numberOfLivingNeighbors++;}
                if(Lives[x - 1][k - 1]){numberOfLivingNeighbors++;}
            }
        }
        else if(k == 0){
            if(Lives[x + 1][k + 1]){numberOfLivingNeighbors++;}
            if(Lives[x + 1][k]){numberOfLivingNeighbors++;}
            if(Lives[x - 1][k + 1]){numberOfLivingNeighbors++;}
            if(Lives[x - 1][k]){numberOfLivingNeighbors++;}
            if(Lives[x][k + 1]){numberOfLivingNeighbors++;}
        }
        else if(k == 12){
            if(Lives[x + 1][k - 1]){numberOfLivingNeighbors++;}
            if(Lives[x + 1][k]){numberOfLivingNeighbors++;}
            if(Lives[x][k - 1]){numberOfLivingNeighbors++;}
            if(Lives[x - 1][k - 1]){numberOfLivingNeighbors++;}
            if(Lives[x - 1][k]){numberOfLivingNeighbors++;}
        }

        return numberOfLivingNeighbors;
    }

    private int countForCellLifeNearby(int x, int y){

        int count = 0;

        if (x == 0 || y == 0 || x == 25 || y == 12) {count = checkCornersAndEdges(x, y);}
        else {
            for (int h = x - 1; h <= x + 1; h++){
                for (int k = y - 1; k <= y + 1; k++){
                    if(Lives[h][k]){count++;}
                }
            }
        }
        return count;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        try {Thread.sleep(speed);}
        catch(InterruptedException ex){Thread.currentThread().interrupt();}
        checkLife();
        for (int x = 0; x < 26; x++){
            for (int k = 0; k < 13; k++){
                if (Lives[x][k]) g.fillRect(8 + x*30, 4 + k*30, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {
        String slow = Character.toString(e.getKeyChar());

        if (slow.equals("0")) speed = 1;
        else if (slow.equals("1")) speed = 10;
        else if (slow.equals("2")) speed = 100;
        else if (slow.equals("3")) speed = 1000;
        else return;
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
