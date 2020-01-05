package com.company.damage.Damage;

import com.company.champion.Champion;

public class DamageAttack implements IDamage {

    @Override
    //func deal with Damage to champion's health without any shild
    public void Damaged(Champion champion, float Attack) {

        champion.getChampionAttributes().setHealth(String.valueOf(
                Integer.parseInt(champion.getChampionAttributes().getHealth()) - Attack));


    }
}
