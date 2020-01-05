package com.company.Items;


import com.company.champion.Champion;

public class UniverseCore extends Item {
    public String name = "UniverseCore";
    public float x = (float) 0.2;
    public String Class = "elementalist";

    @Override
    public void equip(Champion champion) {
        float y = Float.parseFloat(champion.getChampionAttributes().getMagicResist()) * x;
        champion.getChampionAttributes().setMagicResist(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getMagicResist()) + y));

    }

    @Override
    public void unquip(Champion champion) {

        float y = Float.parseFloat(champion.getChampionAttributes().getMagicResist()) * x;
        champion.getChampionAttributes().setMagicResist(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getMagicResist()) - y));

    }
}
