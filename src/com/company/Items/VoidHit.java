package com.company.Items;


import com.company.champion.Champion;

public class VoidHit extends Item {
    public String name = "VoidHit";
    public float x = (float) 0.05;
    public String Class = "void";

    @Override
    public void equip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getHealth()) * x;
        champion.getChampionAttributes().setHealth(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getHealth()) + y));

    }

    @Override
    public void unquip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getHealth()) * x;
        champion.getChampionAttributes().setHealth(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getHealth()) - y));

    }
}
