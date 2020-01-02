package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.utilities.Utility;

public class DemonBuffDamageCalculator extends DamageCalculatorDecorator {

    int mNumberOfCurrentChampions = 0;

    public DemonBuffDamageCalculator(
            IDamageCalculator iDamageCalculator,
            int numberOfCurrentChampions) {
        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        championAttributes.setManaBurnCost(Utility.getAppropriateManaBurnerCost(mNumberOfCurrentChampions));
        return championAttributes;
    }

}
