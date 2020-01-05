package com.company.damage.Damage;

import com.company.champion.Champion;

public class DamageMana implements IDamage {
    @Override
    //func deal with any damage to Champion's Mana without any shild
    public void Damaged(Champion champion, float Mana) {
        champion.getChampionAttributes().setManaStart(String.valueOf(Float.parseFloat(champion.getChampionAttributes().getManaStart()) - Mana));
    }
}
