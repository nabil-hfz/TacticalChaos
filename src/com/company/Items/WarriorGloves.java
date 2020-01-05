package com.company.Items;


import com.company.champion.Champion;

public class WarriorGloves extends Item {
    public String name = "WarriorGloves";
    public float x = (float) 0.1;
    public String Class = "blade master";

    @Override
    public void equip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) * x;
        champion.getChampionAttributes().setAttackDamage(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) + y));
    }

    @Override
    public void unquip(Champion champion) {

        float y = Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) * x;
        champion.getChampionAttributes().setAttackDamage(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) - y));
    }
}
