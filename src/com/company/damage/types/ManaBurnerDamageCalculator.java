package com.company.damage.types;

import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.damage.DamageCalculatorDecorator;
import com.company.damage.IDamageCalculator;
import com.company.utilities.Constants;

public class ManaBurnerDamageCalculator extends DamageCalculatorDecorator {

    private int mNumberOfCurrentChampions;

    public ManaBurnerDamageCalculator(IDamageCalculator iDamageCalculator, int numberOfCurrentChampions) {
        super(iDamageCalculator);
        this.mNumberOfCurrentChampions = numberOfCurrentChampions;
    }

    @Override
    public ChampionAttributes CalculateIntendedDamage() {
        ChampionAttributes championAttributes = makeAppropriateManaBurnCost(super.CalculateIntendedDamage());
        System.out.println("ManaBurnerDamageCalculator" + championAttributes.getAbility());
        System.out.println("CalculateIntendedDamage  : ManaBurnCost" + championAttributes.getManaBurnCost());
        return championAttributes;
    }

    private ChampionAttributes makeAppropriateManaBurnCost(ChampionAttributes championAttributes) {
        int mManaBurnCost = mNumberOfCurrentChampions < 4 ?
                Constants.MANA_BURNER_COST_20 : Constants.MANA_BURNER_COST_40;
        championAttributes.setManaBurnCost(mManaBurnCost);
        return championAttributes;
    }
}
