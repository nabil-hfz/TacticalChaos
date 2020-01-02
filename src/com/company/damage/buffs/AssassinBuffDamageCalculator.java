package com.company.damage.buffs;

import com.company.champion.Champion;
import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;

public class AssassinBuffDamageCalculator extends DamageCalculatorDecorator {


    protected AssassinBuffDamageCalculator(
            IDamageCalculator iDamageCalculator) {
        super(iDamageCalculator);
     }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        return super.CalculateIntendedDamage();
    }
}
