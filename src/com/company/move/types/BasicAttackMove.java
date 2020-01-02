package com.company.move.types;


import com.company.champion.Champion;
import com.company.move.Move;

public abstract class BasicAttackMove extends Move {


        private Champion ch;
        private Champion opponentCh;


    public BasicAttackMove(Champion opponentCh){
            this.opponentCh = opponentCh;
        }

        @Override
        public void performMove() {
            int health,attackDamage;
            if (isVisual(opponentCh)){
                health = Integer.parseInt(opponentCh.getChampionAttributes().getHealth());
                attackDamage = Integer.parseInt(ch.getChampionAttributes().getAttackDamage());

                health-= attackDamage;
                opponentCh.getChampionAttributes().setHealth(String.valueOf(health));

            }
        }

        private boolean isVisual(Champion opponentCh) {
            int xSquare = ch.getCurrentSquare().getX();
            int ySquare = ch.getCurrentSquare().getY();
            int visionR = Integer.parseInt(ch.getChampionAttributes().getVisionRange());
            int oppXSquare = opponentCh.getCurrentSquare().getX();
            int oppYSquare = opponentCh.getCurrentSquare().getY();
            for (int i = xSquare;i<xSquare+visionR;i++){
                if (i == oppXSquare)
                    return true;
            }
            for (int i = xSquare;i<xSquare-visionR;i++){
                if (i == oppXSquare)
                    return true;
            }
            for (int i = ySquare;i<ySquare+visionR;i++){
                if (i == oppYSquare)
                    return true;
            }
            for (int i = xSquare;i<xSquare-visionR;i++){
                if (i == oppXSquare)
                    return true;
            }
            return false;
        }
}
