package com.company.move.types;


import com.company.arena.Arena;
import com.company.arena.SquaresState;
import com.company.champion.Champion;
import com.company.damage.Damage.DirectDamageCalculator;
import com.company.move.Move;
import com.company.players.Player;
import com.company.utilities.Utility;

import java.util.ArrayList;

public class BasicAttackMove extends Move {


    private Champion ch;
    private Champion opponentCh;


    public BasicAttackMove(Champion opponentCh) {
        this.opponentCh = opponentCh;
    }

    @Override
    public void performMove() {
        int health, attackDamage;
        if (isVisual(opponentCh)) {
            health = Integer.parseInt(opponentCh.getChampionAttributes().getHealth());
            attackDamage = Integer.parseInt(ch.getChampionAttributes().getAttackDamage());

            health -= attackDamage;
            opponentCh.getChampionAttributes().setHealth(String.valueOf(health));

        }
    }

    private boolean isVisual(Champion opponentCh) {
        int xSquare = ch.getCurrentSquare().getX();
        int ySquare = ch.getCurrentSquare().getY();
        int visionR = Integer.parseInt(ch.getChampionAttributes().getVisionRange());
        int oppXSquare = opponentCh.getCurrentSquare().getX();
        int oppYSquare = opponentCh.getCurrentSquare().getY();
        for (int i = xSquare; i < xSquare + visionR; i++) {
            if (i == oppXSquare)
                return true;
        }
        for (int i = xSquare; i < xSquare - visionR; i++) {
            if (i == oppXSquare)
                return true;
        }
        for (int i = ySquare; i < ySquare + visionR; i++) {
            if (i == oppYSquare)
                return true;
        }
        for (int i = xSquare; i < xSquare - visionR; i++) {
            if (i == oppXSquare)
                return true;
        }
        return false;
    }

    public ArrayList<Champion> attackAccepted(Champion Attacker, Arena arena, Player p) {
        ArrayList<Champion> AttackableChampion = new ArrayList<Champion>();


        int stX = Attacker.getCurrentSquare().getX() - Integer.parseInt(Attacker.getChampionAttributes().getAttackRange());
        if (stX < 0) stX = 0;
        if (stX > 25) stX = 25;

        int stY = Attacker.getCurrentSquare().getY() - Integer.parseInt(Attacker.getChampionAttributes().getAttackRange());

        if (stY < 0) stY = 0;
        if (stY > 25) stY = 25;

        for (int i = stX; i < stX + Integer.parseInt(Attacker.getChampionAttributes().getAttackRange()) * 2; i++) {
            for (int j = stY; j < stY + Integer.parseInt(Attacker.getChampionAttributes().getAttackRange()) * 2; j++) {

                if (arena.getSquare(i, j).getState() == SquaresState.Free) {
                    continue;

                } else if (arena.getSquare(i, j).getState() == SquaresState.Occupied) {


                    for (Champion c : arena.getSquare(i, j).getChampionsIn()) {
                        if (c.playerId == p.getPlayerIndex()) {
                            continue;

                        }


                        AttackableChampion.add(c);
                    }
                }

            }
        }


        return AttackableChampion;
    }

    public boolean PerformMove(Champion Attacker, Champion Target) {
        if (Integer.parseInt(Target.getChampionAttributes().getHealth()) == 0) {
            System.out.println("this Champion is dead ");
            return false;
        } else {
            int c = Utility.getRandom(4, 1);
            if (c == 1 || c == 2 || c == 3) {
                DirectDamageCalculator.creatDamageCalculator(Target, 2,
                        Float.parseFloat(Attacker.getChampionAttributes().getAttackDamage()));
                Attacker.getChampionAttributes().setManaStart(String.valueOf(Attacker.getChampionAttributes().getManaStart() + 10));
            } else if (c == 4) {
                DirectDamageCalculator.creatDamageCalculator(Target,
                        2,
                        Float.parseFloat(Attacker.getChampionAttributes().getAttackDamage())
                                * Float.parseFloat(Attacker.getChampionAttributes().getCriticalStrikeDamage()));
                Attacker.getChampionAttributes().setManaStart(String.valueOf(Attacker.getChampionAttributes().getManaStart() + 10));

            }
            return true;

        }

    }


}
