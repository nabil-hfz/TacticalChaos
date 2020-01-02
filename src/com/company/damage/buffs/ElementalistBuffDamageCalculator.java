package com.company.damage.buffs;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.round.PlanningRound;

public class ElementalistBuffDamageCalculator extends DamageCalculatorDecorator {
    PlanningRound mPlanningRound;
    private int mNumberOfCurrentChampions = 0;

    public ElementalistBuffDamageCalculator(
            int numberOfCurrentChampions,
            IDamageCalculator iDamageCalculator) {

        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = super.CalculateIntendedDamage();
        if (mNumberOfCurrentChampions <= 1) {
            championAttributes.setElementalist(mNumberOfCurrentChampions);
            championAttributes.setTenthPlaceFromElementalistBuff(false);
        } else if (mNumberOfCurrentChampions < 4) {
            championAttributes.setElementalist(mNumberOfCurrentChampions);
            championAttributes.setTenthPlaceFromElementalistBuff(false);
        } else {
            championAttributes.setElementalist(mNumberOfCurrentChampions);
            championAttributes.setTenthPlaceFromElementalistBuff(true);
        }
        return championAttributes;
    }
}
