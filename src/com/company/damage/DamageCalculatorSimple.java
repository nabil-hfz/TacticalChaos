package com.company.damage;

import com.company.champion.Champion;
import com.company.champion.typeofchampion.ChampionAttributes;

public class DamageCalculatorSimple implements IDamageCalculator {

    private ChampionAttributes mChampionAttributes;

    public DamageCalculatorSimple(ChampionAttributes championAttributes) {
        this.mChampionAttributes = championAttributes;
     //   System.out.println("constructor DamageCalculatorSimple() " + this.mChampionAttributes.getAbility());

    }

    public void makeNull(){
        this.mChampionAttributes = null;
    }

    private ChampionAttributes getChampionAttributes() {
        return this.mChampionAttributes;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
    //    System.out.println("method DamageCalculatorSimple" + this.mChampionAttributes.getAbility());
        return getChampionAttributes();
    }
}
