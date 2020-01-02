package com.company.move.types;

import com.company.arena.Arena;
import com.company.arena.Square;
import com.company.champion.Champion;
import com.company.game.Game;
import com.company.move.Move;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;

public class WalkMove extends Move {
    private Champion ch1;
    private Square nSquare;
    private Arena gArena;
    private String mChoice;
    private int movementSpeed;

    public WalkMove(String mChoice) {
        this.mChoice = mChoice;
    }

    @Override
    public void performMove() {
        nSquare = ch1.getCurrentSquare();
        movementSpeed = Integer.parseInt(ch1.getChampionAttributes().getMovementSpeed());

        if (Objects.equals(mChoice, "up"))
            nSquare.setY(nSquare.getY() + movementSpeed/*Movment speed for y */);
        if (Objects.equals(mChoice, "down"))
            nSquare.setY(nSquare.getY() - movementSpeed /*Movment speed for y */);
        if (Objects.equals(mChoice, "right"))
            nSquare.setY(nSquare.getX() + movementSpeed/*Movment speed for x */);
        if (Objects.equals(mChoice, "left"))
            nSquare.setY(nSquare.getX() - movementSpeed/*Movment speed for x */);

        if (isLegal(nSquare))
            ch1.setCurrentSquare(nSquare); //the new square of champion
        else{
            System.err.println("Your move out of array boundaries");
        }
    }

    private boolean isLegal(Square nSquare) {
        return nSquare.getX() <= Game.arena.getArenaSize() && nSquare.getY() <= Game.arena.getArenaSize();
    }
}
