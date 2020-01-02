package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;

public class BladeMasterBuffDamageCalculator extends DamageCalculatorDecorator {

    private int mNumberOfCurrentChampions = 0;

    public BladeMasterBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {

        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        championAttributes.setBladeMasterNumber(mNumberOfCurrentChampions);
        int attackDamage;
        switch (championAttributes.getBladeMasterNumber()) {
            case 0:
            case 1:
            case 2:
                attackDamage = Integer.parseInt(championAttributes.getAttackDamage());
                championAttributes.setAttackDamage((attackDamage) + "");
                break;
            case 3:
            case 4:
            case 5:
                attackDamage = Integer.parseInt(championAttributes.getAttackDamage());
                System.out.println("attack damage ***************************** " + (attackDamage * 2) );
                championAttributes.setAttackDamage((attackDamage * 2) + "");
                System.out.println("attack damage ------------------- " + championAttributes.getAttackDamage() );

                break;
            case 6:
            case 7:
            case 8:
                attackDamage = Integer.parseInt(championAttributes.getAttackDamage());
                championAttributes.setAttackDamage((attackDamage * 3) + "");
                break;
            case 9:
            default:
                attackDamage = Integer.parseInt(championAttributes.getAttackDamage());
                championAttributes.setAttackDamage((attackDamage * 4) + "");
                break;
        }
        System.out.println("attack damage ////////////////// " + championAttributes.getAttackDamage() );

        return championAttributes;
    }

}
