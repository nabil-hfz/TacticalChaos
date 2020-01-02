package com.company.damage;


import com.company.champion.typeofchampion.ChampionAttributes;

public abstract class DamageCalculatorDecorator implements IDamageCalculator {

    protected IDamageCalculator mIDamageCalculator;

    protected DamageCalculatorDecorator(IDamageCalculator iDamageCalculator) {
        this.mIDamageCalculator = iDamageCalculator;
    }

    public ChampionAttributes CalculateIntendedDamage() {
        return this.mIDamageCalculator.CalculateIntendedDamage();
    }

}
