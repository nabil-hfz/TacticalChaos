package com.company.damage.types;

 import com.company.champion.Champion;
 import com.company.champion.typeofchampion.ChampionAttributes;
 import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
 import com.company.round.PlanningRound;

public class BasicAttackDodgeDamageCalculator extends DamageCalculatorDecorator {

    private PlanningRound mPlanning;

    public BasicAttackDodgeDamageCalculator(IDamageCalculator iDamageCalculator) {
        super(iDamageCalculator);


    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        return super.CalculateIntendedDamage();
    }
//    @Override
//    public ChampionAttributes CalculateIntendedDamage(Champion champion) {
//        return champion.getChampionAttributes();
//    }
}
