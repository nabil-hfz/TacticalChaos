package com.company.arena;

import com.company.champion.Champion;
import com.company.players.Player;

import java.util.ArrayList;

public class Arena {
    public static Square[][] getSquare() {
        return Square;
    }

    public static void setSquare(Square[][] Square) {
        Arena.Square = Square;
    }

    static Square[][] Square;

    public void setArenaSize(int arenaSize) {
        this.arenaSize = arenaSize;
    }

    int arenaSize = 100;

    SquaresState State;


    public Arena() {
        Square = new Square[arenaSize][arenaSize];

        for (int i = 0; i < arenaSize; i++) {
            for (int j = 0; j < arenaSize; j++) {
                this.Square[i][j] = new Square(i, j);
                this.Square[i][j].setState(State.Free);

            }
        }
    }

    public void addChampion(Champion champion) {
        Square square = champion.getCurrentSquare();
        Square[square.getX()][square.getY()].setState(SquaresState.Occupied);
        Square[square.getX()][square.getY()].setChampionsIn(champion);
    }


    public void printAllChampionsInTheArena() {

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {

                if (Square[i][j].getState() == State.Free) {
                    System.out.print("| [#####] |");

                } else if (Square[i][j].getState() == State.Occupied) {
                  //  System.err.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRORRRRRRRRRRRRRRRR" + Square[i][j].getChampionsIn().size());
                    for (Champion c : Square[i][j].getChampionsIn()) {
                        System.err.print("| [" + c.toInitials() + "P" + c.getPlayerId() + "] |");
                    }


                } else {
                    System.err.print("Square[i][j]");


                }
            }
            System.out.println("");

        }

    }


    public void printArena(Player p) {


        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                if (Square[i][j].getState() == State.Free) {
                    System.out.print("| [#####] |");

                } else if (Square[i][j].getState() == State.Occupied) {

                    for (Champion c : Square[i][j].getChampionsIn()) {

                        if (c.playerId == p.getPlayerIndex()) {
                            System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() + "] |");


                        } else
                            System.out.print("| [#####] |");


                    }


                }

            }
            System.out.println("");

        }
    }


    public Square getSquare(int i, int j) {
        return this.Square[i][j];
    }

    public void setSquare(int i, int j) {
        this.Square[i][j].setX(i);

    }

    public int getArenaSize() {
        return this.arenaSize;
    }

    ArrayList<Champion> allChampionsOnArena = new ArrayList<Champion>();

    public ArrayList<Champion> getAllChampionsOnArena() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < Square[i][j].getChampionsIn().size(); k++)
                    allChampionsOnArena.addAll(Square[i][j].getChampionsIn());


            }


        }
        return allChampionsOnArena;
    }

}





