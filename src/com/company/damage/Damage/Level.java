package com.company.damage.Damage;


import com.company.champion.Champion;

public class Level {
    private static float fraction = 0.1f;

    // make champion level 2
    public static void Level2(Champion champion) {
        fraction = 0.1f;
        //amplifying  basic attack by 10%
        champion.getChampionAttributes().setAttackDamage(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) * fraction)))));
        //amplifying  armor by 20%
        champion.getChampionAttributes().setMagicResist(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getMagicResist()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getMagicResist()) * fraction)))));
        //amplifying magic resist by 20%

        champion.getChampionAttributes().setArmor(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getArmor()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getArmor()) * fraction)))));
    }

    public static void Level3(Champion champion) {
        fraction = 0.25f;
        //amplifying  basic attack by 10%
        champion.getChampionAttributes().setAttackDamage(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getAttackDamage()) * fraction)))));
        //amplifying  armor by 20%
        champion.getChampionAttributes().setMagicResist(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getMagicResist()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getMagicResist()) * fraction)))));
        //amplifying magic resist by 20%

        champion.getChampionAttributes().setArmor(
                String.valueOf((Float.parseFloat(champion.getChampionAttributes().getArmor()) +
                        ((Float.parseFloat(champion.getChampionAttributes().getArmor()) * fraction)))));

    }
    //when champion level up we need to remove the three level 1/2 champion before put one new level 2/3 champion
}
