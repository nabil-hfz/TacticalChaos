package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;

public class DragonBuffDamageCalculator extends DamageCalculatorDecorator {

    private int mNumberOfCurrentChampions = 0;

    public DragonBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        if (mNumberOfCurrentChampions > 1)
            championAttributes.setStopAbilityDamageForDragons(true);
        else
            championAttributes.setStopAbilityDamageForDragons(false);
        return championAttributes;
    }

}
