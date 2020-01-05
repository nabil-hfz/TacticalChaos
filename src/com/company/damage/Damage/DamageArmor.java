package com.company.damage.Damage;

import com.company.champion.Champion;

public class DamageArmor extends DamageDecorator {
    public DamageArmor(IDamage damage) {
        super(damage);
    }


    // func deal with damage to champion's health with Armor
    public void Damaged(Champion champion, float much) {
        float AttackAfterShilding = Integer.parseInt(champion.getChampionAttributes().getArmor()) * much;
        this.damage.Damaged(champion, much - AttackAfterShilding);

    }
}
