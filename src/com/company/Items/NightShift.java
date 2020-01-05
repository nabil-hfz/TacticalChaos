package com.company.Items;


import com.company.champion.Champion;

public class NightShift extends Item {
    public String name = "NightShift";
    public float x = (float) 0.2;
    public String Class = "assassin";


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
