
package com.company.damage;

import com.company.champion.Champion;
import com.company.damage.buffs.*;
import com.company.damage.types.BasicAttackDamageCalculator;
import com.company.damage.types.BasicAttackDodgeDamageCalculator;
import com.company.damage.types.ManaBurnerDamageCalculator;
import com.company.round.PlanningRound;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.company.champion.typeofchampion.ChampionClass.Void;
import static com.company.champion.typeofchampion.ChampionClass.*;

public class DamageCalculatorFactory {

    IDamageCalculator mDamageCalculator;

    public void CalculateClasses(List<Champion> currentChampions) {
        makeCalculateClasses(currentChampions);
    }

    private void makeCalculateClasses(List<Champion> currentChampions) {
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        String sClass1, sClass2, sClass3 = null;
        boolean bClass1, bClass2, bClass3;
        for (int i = 0; i < currentChampions.size(); ++i) {
            Champion champion = currentChampions.get(i);
            sClass1 = champion.getChampionAttributes().getClass1();
            sClass2 = champion.getChampionAttributes().getClass2();
            temp.put(champion.getChampionAttributes().getClass1(), 1);
            temp.put(champion.getChampionAttributes().getClass2(), 1);
            boolean tempBooleanForClass3 = !champion.getChampionAttributes().getClass3().equalsIgnoreCase("-");
            if (tempBooleanForClass3) {
                temp.put(champion.getChampionAttributes().getClass3(), 1);
                sClass3 = champion.getChampionAttributes().getClass3();
            }
            for (int j = 1 + i; j < currentChampions.size(); j++) {
                if (i == j) continue;
                Champion champion1 = currentChampions.get(j);
                if (champion.getChampionAttributes().getClass1().equalsIgnoreCase(
                        champion1.getChampionAttributes().getClass1())) {

                    temp.put(champion.getChampionAttributes().getClass1(), temp.get(champion.getChampionAttributes().getClass1()) + 1);
                }
                if (champion.getChampionAttributes().getClass2().equalsIgnoreCase(
                        champion1.getChampionAttributes().getClass2())) {
                    temp.put(champion.getChampionAttributes().getClass2(), temp.get(champion.getChampionAttributes().getClass2()) + 1);
                }
                if (tempBooleanForClass3)
                    if (champion.getChampionAttributes().getClass3().equalsIgnoreCase(champion1.getChampionAttributes().getClass3())) {
                        temp.put(champion.getChampionAttributes().getClass3(), temp.get(champion.getChampionAttributes().getClass3()) + 1);
                    }
            }
            bClass1 = temp.get(champion.getChampionAttributes().getClass1()) > 1;
            bClass2 = temp.get(champion.getChampionAttributes().getClass2()) > 1;
            //   bClass3 = temp.get(champion.getChampionAttributes().getClass3()) > 1;
            // bClass3 = bClass3 && tempBooleanForClass3;

            if (bClass1 || bClass2 /*|| bClass3*/) {
                makeAppropriateChangesToChampionsList(
                        temp,
                        currentChampions
                );
            }
            temp.clear();
        }
    }

    private void makeAppropriateChangesToChampionsList(
            LinkedHashMap<String, Integer> temp,
            List<Champion> currentChampions
    ) {

        Iterator<Map.Entry<String, Integer>> it = temp.entrySet().iterator();
        int i = 1;
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            System.err.println("Key is : " + pair.getKey());
            System.err.println("value  is : " + pair.getValue());
            makeAppropriateChangesToChampionsList(pair, currentChampions, i);
            i++;
            //      System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    private void makeAppropriateChangesToChampionsList(
            Map.Entry<String, Integer> pair,
            List<Champion> currentChampions,
            int type
    ) {
        switch (type) {
            case 1:
                if (pair.getValue() >= 1)
                    for (int i = 0; i < currentChampions.size(); ++i) {
                        System.out.println("******** getClass1 : " + pair.getKey());
                        System.out.println("******** getClass1 : " + currentChampions.get(i).getChampionAttributes().getClass1());
                        if (pair.getKey().equalsIgnoreCase(currentChampions.get(i).getChampionAttributes().getClass1())) {
                            makeBuffChangesToChampionsList(pair.getKey(), pair.getValue(), currentChampions, i);
                        }
                    }
                break;
            case 2:
                if (pair.getValue() >= 1)
                    for (int i = 0; i < currentChampions.size(); ++i) {
                        System.out.println("******** getClass2 : " + pair.getKey());
                        System.out.println("******** getClass2 : " + currentChampions.get(i).getChampionAttributes().getClass2());
                        if (pair.getKey().equalsIgnoreCase(currentChampions.get(i).getChampionAttributes().getClass2())) {
                            makeBuffChangesToChampionsList(pair.getKey(), pair.getValue(), currentChampions, i);
                        }
                    }
                break;
            case 3:
                if (pair.getValue() >= 1)
                    for (int i = 0; i < currentChampions.size(); ++i) {
                        if (pair.getKey().equalsIgnoreCase(currentChampions.get(i).getChampionAttributes().getClass3())) {
                            makeBuffChangesToChampionsList(pair.getKey(), pair.getValue(), currentChampions, i);
                        }
                    }
                break;
        }

    }

    private void makeBuffChangesToChampionsList(
            String GroupName,
            int numberOfCurrentChampionGroup,
            List<Champion> currentChampion,
            int position
    ) {

        IDamageCalculator damageCalculatorSimple = null;
        damageCalculatorSimple = new
                //        DamageCalculatorSimple(Utility.makeCopyOfChampionAttributes(currentChampion.get(position).getChampionAttributes()));
                DamageCalculatorSimple(currentChampion.get(position).getChampionAttributes());

        if (GroupName.equalsIgnoreCase(Demon.toString())) {
            damageCalculatorSimple = DemonBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Dragon.toString())) {
            damageCalculatorSimple = DragonBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Glacial.toString())) {


        } else if (GroupName.equalsIgnoreCase(Imperial.toString())) {
            damageCalculatorSimple = ImperialBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Noble.toString())) {


        } else if (GroupName.equalsIgnoreCase(Ninja.toString())) {


        } else if (GroupName.equalsIgnoreCase(Pirate.toString())) {


        } else if (GroupName.equalsIgnoreCase(Wild.toString())) {


        } else if (GroupName.equalsIgnoreCase(Void.toString())) {


        } else if (GroupName.equalsIgnoreCase(Yordle.toString())) {


        } else if (GroupName.equalsIgnoreCase(Assassin.toString())) {


        } else if (GroupName.equalsIgnoreCase(BladeMaster.toString())) {
            damageCalculatorSimple = BladeMasterBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Brawler.toString())) {
            damageCalculatorSimple = BrawlerBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Elementalist.toString())) {
            damageCalculatorSimple = ElementalistBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Gunslinger.toString())) {


        } else if (GroupName.equalsIgnoreCase(Knight.toString())) {


        } else if (GroupName.equalsIgnoreCase(Ranger.toString())) {
            damageCalculatorSimple = RangerBuff(numberOfCurrentChampionGroup, damageCalculatorSimple);

        } else if (GroupName.equalsIgnoreCase(Shapeshifter.toString())) {


        } else if (GroupName.equalsIgnoreCase(Sorcerer.toString())) {


        }
        damageCalculatorSimple.CalculateIntendedDamage();
        //    currentChampion.get(position).setCurrentDamageCalculators(damageCalculatorSimple);
        // currentChampion.get(position).setChampionAttributes((OChampionAttributes) damageCalculatorSimple.CalculateIntendedDamage());
        ;
        damageCalculatorSimple = null;
    }

    private IDamageCalculator DemonBuff(int numberOfCurrentChampionGroup,
                                        IDamageCalculator damageCalculatorSimple) {

        return new DemonBuffDamageCalculator(damageCalculatorSimple, numberOfCurrentChampionGroup);

    }

    private IDamageCalculator DragonBuff(int numberOfCurrentChampionGroup,
                                         IDamageCalculator damageCalculatorSimple) {
        return new DragonBuffDamageCalculator(numberOfCurrentChampionGroup, damageCalculatorSimple);
    }

    private void GlacialBuff(int numberOfCurrentChampionGroup,
                             Champion currentChampion) {

    }

    private IDamageCalculator ImperialBuff(int numberOfCurrentChampionGroup,
                                           IDamageCalculator damageCalculatorSimple) {

        return new ImperialBuffDamageCalculator(numberOfCurrentChampionGroup, damageCalculatorSimple);
    }

    private void NobleBuff(int numberOfCurrentChampionGroup,
                           Champion currentChampion) {

    }

    private void NinjaBuff(int numberOfCurrentChampionGroup,
                           Champion currentChampion) {

    }

    private void PirateBuff(int numberOfCurrentChampionGroup,
                            Champion currentChampion) {

    }

    private void WildBuff(int numberOfCurrentChampionGroup,
                          Champion currentChampion) {

    }

    private void VoidBuff(int numberOfCurrentChampionGroup,
                          Champion currentChampion) {

    }

    private void YordleBuff(int numberOfCurrentChampionGroup,
                            Champion currentChampion) {

    }

    private void AssassinBuff(int numberOfCurrentChampionGroup,
                              Champion currentChampion) {

    }

    private IDamageCalculator BladeMasterBuff(int numberOfCurrentChampionGroup,
                                              IDamageCalculator damageCalculatorSimple) {
        return new BladeMasterBuffDamageCalculator(numberOfCurrentChampionGroup, damageCalculatorSimple);
    }

    private IDamageCalculator BrawlerBuff(int numberOfCurrentChampionGroup,
                                          IDamageCalculator damageCalculatorSimple) {
        return new BrawlerBuffDamageCalculator(numberOfCurrentChampionGroup, damageCalculatorSimple);
    }

    private IDamageCalculator ElementalistBuff(int numberOfCurrentChampionGroup,
                                               IDamageCalculator damageCalculatorSimple) {
        return new ElementalistBuffDamageCalculator(numberOfCurrentChampionGroup,
                damageCalculatorSimple);
    }

    private void GunslingerBuff(int numberOfCurrentChampionGroup,
                                Champion currentChampion) {

    }

    private void KnightBuff(int numberOfCurrentChampionGroup,
                            Champion currentChampion) {

    }

    private IDamageCalculator RangerBuff(int numberOfCurrentChampionGroup,
                                         IDamageCalculator damageCalculatorSimple) {
        return new RangerBuffDamageCalculator(numberOfCurrentChampionGroup, damageCalculatorSimple);
    }

    private void ShapeshifterBuff(int numberOfCurrentChampionGroup,
                                  Champion currentChampion) {

    }

    private void SorcererBuff(int numberOfCurrentChampionGroup,
                              Champion currentChampion) {

    }

    // case 1 : BasicAttackDamageCalculator
    // case 2 : BasicAttackDodgeDamageCalculator
    // case 3 : ManaBurnerDamageCalculator

    public static IDamageCalculator newInstance(int type, IDamageCalculator iDamageCalculator, PlanningRound
            planning) {
        switch (type) {
            case 1:
                return new BasicAttackDamageCalculator(iDamageCalculator);
            case 2:
                return new BasicAttackDodgeDamageCalculator(iDamageCalculator);
            case 3:
                return new ManaBurnerDamageCalculator(iDamageCalculator, 3);
            default:
                return null;

        }
    }
}
