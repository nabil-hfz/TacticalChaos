package com.company.move.types;

import com.company.arena.Arena;
import com.company.arena.Square;
import com.company.champion.Champion;
import com.company.game.Game;
import com.company.move.Move;
import com.company.move.PlaceMove;
import com.company.players.Player;

import java.util.ArrayList;
import java.util.Objects;

public class WalkMove extends Move {
    private Champion ch1;
    private Square nSquare;
    private Arena gArena;
    private String mChoice;
    private int movementSpeed;


    public boolean PerformMove(Champion champion, int id, Arena arena, Player p1, ArrayList<Player> players) {
        /*
        1-move up
        2-move down
        3-move left
        4move right
         */
        boolean done = false;
        System.out.println("the last cood " + champion.getCurrentSquare().getX() + " - " + champion.getCurrentSquare().getY());
        arena.getSquare(champion.getCurrentSquare().getX(), champion.getCurrentSquare().getY()).getChampionsIn().remove(champion);

        switch (id) {
            case (1): {
                done = MoveUp(champion, arena, p1, players);
                arena.printArena(p1);
                break;

            }
            case (2): {
                done = MoveDown(champion, arena, p1, players);
                arena.printArena(p1);

                break;
            }

            case (3): {
                done = MoveLeft(champion, arena, p1, players);
                arena.printArena(p1);

                break;
            }


            case (4): {
                done = MoveRight(champion, arena, p1, players);
                arena.printArena(p1);

                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + id);

        }


        return done;
    }

    public boolean MoveDown(Champion champion, Arena arena, Player p1, ArrayList<Player> players) {
        champion.getCurrentSquare().setX(champion.getCurrentSquare().getX() + (Integer.parseInt(champion.getChampionAttributes().getMovementSpeed()) - 3));


        if (champion.getCurrentSquare().getX() < 0)
            champion.getCurrentSquare().setX(0);


        if (champion.getCurrentSquare().getX() > 25) {
            champion.getCurrentSquare().setX(25);
        }


        PlaceMove move = new PlaceMove();
        move.placeMove(champion.getCurrentSquare().getX(), champion.getCurrentSquare().getY(), champion, arena, players, p1)
        ;
        return true;
    }


    public boolean MoveUp(Champion champion, Arena arena, Player p1, ArrayList<Player> players) {
        champion.getCurrentSquare().setX(champion.getCurrentSquare().getX()
                - (Integer.parseInt(champion.getChampionAttributes().getMovementSpeed()) - 3));
        if (champion.getCurrentSquare().getX() < 0)
            champion.getCurrentSquare().setX(0);


        if (champion.getCurrentSquare().getX() > 25) {
            champion.getCurrentSquare().setX(25);
            ;
        }

        PlaceMove move = new PlaceMove();
        move.placeMove(champion.getCurrentSquare().getX(), champion.getCurrentSquare().getY(), champion, arena, players, p1);
        return true;

    }

    public boolean MoveLeft(Champion champion, Arena arena, Player p1, ArrayList<Player> players) {
        champion.getCurrentSquare().setY(champion.getCurrentSquare().getY() - (Integer.parseInt(champion.getChampionAttributes().getMovementSpeed()) - 3));
        if (champion.getCurrentSquare().getY() < 0)
            champion.getCurrentSquare().setY(0);

        if (champion.getCurrentSquare().getY() > 25)
            champion.getCurrentSquare().setY(25);
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.getCurrentSquare().getX(), champion.getCurrentSquare().getY(), champion, arena, players, p1);
        return true;

    }


    public boolean MoveRight(Champion champion, Arena arena, Player p1, ArrayList<Player> players) {
        champion.getCurrentSquare().setY(champion.getCurrentSquare().getY() + (Integer.parseInt(champion.getChampionAttributes().getMovementSpeed()) - 3));
        if (champion.getCurrentSquare().getY() < 0)
            champion.getCurrentSquare().setY(0);

        if (champion.getCurrentSquare().getY() > 25)
            champion.getCurrentSquare().setY(25);
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.getCurrentSquare().getX(), champion.getCurrentSquare().getY(), champion, arena, players, p1);
        return true;


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
        else {
            System.err.println("Your move out of array boundaries");
        }
    }

    private boolean isLegal(Square nSquare) {
        return nSquare.getX() <= Game.arena.getArenaSize() && nSquare.getY() <= Game.arena.getArenaSize();
    }
}
