package com.company.damage.Damage;

import com.company.champion.Champion;

public class DamageAbility extends DamageDecorator {
    public DamageAbility(IDamage damage) {
        super(damage);
    }

    //func deal with champion's health with MagicR  (Damage from enemy champion's ability)
    public void Damaged(Champion champion, float much) {
        float AttackAftershilding = much * Integer.parseInt(champion.getChampionAttributes().getMagicResist());
        this.damage.Damaged(champion, much - AttackAftershilding);
    }
}
