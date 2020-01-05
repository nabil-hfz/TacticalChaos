package com.company.Items;


import com.company.champion.Champion;

public class AngryCloak extends Item {
    public String name = "AngryCloak";
    float x = (float) 0.1;
    public String Class = "yordle";


    @Override
    public void equip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getCriticalStrikeDamage()) * x;
        champion.getChampionAttributes().setCriticalStrikeDamage(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getCriticalStrikeDamage()) + y));
    }

    @Override
    public void unquip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getCriticalStrikeDamage()) * x;
        champion.getChampionAttributes().setCriticalStrikeDamage(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getCriticalStrikeDamage()) - y));
    }
}
