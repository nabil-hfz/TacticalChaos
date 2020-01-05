package com.company.Items;


import com.company.champion.Champion;

public class KnightArmor extends Item {
    public String name = "KnightArmor";
    public float x = (float) 0.15;
    public String Class = "Knight" ;
    @Override
    public void equip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getArmor()) * x;
        champion.getChampionAttributes().setArmor(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getArmor()) + y));

    }

    @Override
    public void unquip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getArmor()) * x;
        champion.getChampionAttributes().setArmor(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getArmor()) - y));
    }
}
