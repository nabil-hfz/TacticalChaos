package com.company.arena;


import com.company.champion.Champion;
import com.company.players.Player;

import java.util.ArrayList;

public class Square {

    private Integer x;
    private Integer y;

    SquaresState state;
    ArrayList<Player> playersIn = new ArrayList<Player>();
    ArrayList<Champion> championsIn = new ArrayList<Champion>();

    public ArrayList<Player> getPlayersIn() {
        return playersIn;
    }

    public void setPlayersIn(Player p) {
        this.playersIn.add(p);
    }


    public SquaresState getState() {
        return state;
    }

    public void setState(SquaresState state) {
        this.state = state;
    }

    public ArrayList<Champion> getChampionsIn() {
        return championsIn;
    }

    public void setChampionsIn(Champion c) {
        this.championsIn.add(c);
    }



    public Square(Integer x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
