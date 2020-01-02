package com.company.damage.buffs;

import com.company.champion.Champion;
import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.round.PlanningRound;

public class YordleBuffDamageCalculator extends DamageCalculatorDecorator {

    PlanningRound mPlanningRound;

    protected YordleBuffDamageCalculator(
            IDamageCalculator iDamageCalculator,
            PlanningRound planningRound) {
        super(iDamageCalculator);
        this.mPlanningRound = planningRound;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        return super.CalculateIntendedDamage();
    }
}
