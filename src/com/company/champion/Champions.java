package com.company.champion;

import com.company.champion.typeofchampion.OChampionAttributes;
import com.company.utilities.Utility;

import java.util.List;

public class Champions {

    List<Champion> Champions;
    int[] mNumberOfChampionsCopy = new int[50];


    public Champions() {
    }

    public int[] getNumberOfChampionsCopy() {
        return mNumberOfChampionsCopy;
    }

    public void setNumberOfChampionsCopy(int[] mNumberOfChampionsCopy) {
        this.mNumberOfChampionsCopy = mNumberOfChampionsCopy;
    }

    public void makeCopyNumber() {
        for (int i = 0; i < 48; ++i) {
            mNumberOfChampionsCopy[i] = 10;
            // System.err.println("hello nabil");
        }
    }

    public void setChampions(List<Champion> champions) {
        Champions = champions;
    }

    public List<Champion> getChampions() {
        return Champions;
    }


    public Champion getAppropriateChampion(Integer type) {
        Champion tempChampion = new Champion();
        for (Champion champion : Champions) {
            if (champion.getNumber().equals(type)) {

                 OChampionAttributes championAttributes =
                        Utility.makeCopyOfChampionAttributes(champion.getChampionAttributes());

                tempChampion.setChampionAttributes(championAttributes);
                tempChampion.setChampionLevel(1);
                tempChampion.setNumber(champion.getNumber());

                return tempChampion;
            }
        }
        return null;
    }
}