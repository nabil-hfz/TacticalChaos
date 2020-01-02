package com.company.damage.buffs;

import com.company.champion.Champion;
import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.round.PlanningRound;

import javax.naming.NameNotFoundException;

public class ImperialBuffDamageCalculator extends DamageCalculatorDecorator {

    private int mNumberOfCurrentChampions = 0;

    public ImperialBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        if(mNumberOfCurrentChampions > 1){
            championAttributes.setDoubleAttackWithImperial(true);
        }else if (mNumberOfCurrentChampions < 2){
            championAttributes.setDoubleAttackWithImperial(false);
        }
        return championAttributes;
    }
}
