package com.company.damage.types;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.move.Move;
import com.company.round.PlanningRound;

public class BasicAttackDamageCalculator extends DamageCalculatorDecorator {

    PlanningRound mPlanning;
    ChampionAttributes championAttributes;

    public BasicAttackDamageCalculator(IDamageCalculator iDamageCalculator) {
        super(iDamageCalculator);

    }


    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        championAttributes = super.CalculateIntendedDamage();
        return championAttributes;
    }

    public void makeAttack(Move move) {

    }
}
