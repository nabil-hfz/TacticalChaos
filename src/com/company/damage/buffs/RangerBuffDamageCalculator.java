package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;

public class RangerBuffDamageCalculator extends DamageCalculatorDecorator {


    private int mNumberOfCurrentChampions = 0;

    public RangerBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        if (mNumberOfCurrentChampions < 3) {
            if (championAttributes.isRangerDoubleAttackRanger()) {
                championAttributes.setAttackRange((Integer.parseInt(championAttributes.getAttackRange()) / 2) + "");
            }
            championAttributes.setRangerDoubleAttackRanger(false);
            System.err.println(championAttributes.getAttackRange());

        } else {
            if (!championAttributes.isRangerDoubleAttackRanger()) {
                championAttributes.setAttackRange((Integer.parseInt(championAttributes.getAttackRange()) * 2) + "");
            }
            System.err.println(championAttributes.getAttackRange());
            championAttributes.setRangerDoubleAttackRanger(true);

        }
        return championAttributes;
    }
}
