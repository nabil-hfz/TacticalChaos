package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;

public class BrawlerBuffDamageCalculator extends DamageCalculatorDecorator {

    private int mNumberOfCurrentChampions = 0;

    public BrawlerBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        championAttributes.setHealth(getAppropriateExtraHealth(championAttributes) + "");
        return championAttributes;
    }

    private int getAppropriateExtraHealth(ChampionAttributes championAttributes) {
        int ExtraHealth;

        switch (mNumberOfCurrentChampions) {
            case 1:
                ExtraHealth = 0;
                break;
            case 2:
            case 3:
                ExtraHealth = 250;
                break;
            case 4:
            case 5:
                ExtraHealth = 500;
                break;
            default:
                ExtraHealth = 1000;
        }


        return ExtraHealth;
    }
}

