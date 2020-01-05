package com.company.move;

import com.company.arena.Arena;
import com.company.champion.Champion;
import com.company.players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveFactory extends Move {

    public void getMoves() {

    }

    @Override
    public void performMove() {

    }

    /*
   System.out.println("Welcome to phase 2, please choose your plan: ");

   System.out.println("1- Sell champions.");
   System.out.println("2- Buy champions.");
   System.out.println("3- Move a specific champion.");
   System.out.println("4- Attack a champion.");
   System.out.println("5- Use ability for specific champion.");
   System.out.println("6- Place champion.");
   System.out.println("7- Swap between tow champions -one from the Arena , the other one from the Bench-. ");
   System.out.println("Your choice is: ");
    */
    public void createAbilityMove(Champion champion, Arena arena, Player p1, ArrayList<Player> players) {

        switch (champion.getPlayerId()) {
            case (1): {
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;
            }
            case (2): {

                int x;
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;
            }
            case (3): {
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;
            }
            case (4): {
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;
            }


            case (5): {
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;
            }


            case (6): {
                Scanner Sx = new Scanner(System.in);
                Scanner Sy = new Scanner(System.in);
                int x;
                int y;
                System.out.print("select x :");
                x = Sx.nextInt();
                System.out.print("select y : ");
                y = Sy.nextInt();
                PlaceMove move = new PlaceMove();
                move.placeMove(x, y, champion, arena, players, p1);
                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;


            }

            case (7): {

                System.out.println("Ability of " + champion.getChampionAttributes().getChampionName() + "must be activate ");
                break;


            }

            default: {
//                throw new IllegalStateException("Unexpected value: " + champion.championId);
                break;
            }
        }
    }


}
