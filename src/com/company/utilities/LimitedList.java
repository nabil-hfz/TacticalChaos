package com.company.utilities;

import com.company.champion.typeofchampion.ChampionAttributes;

import java.util.ArrayList;

public class LimitedList extends ArrayList {

    ChampionAttributes championAttributes;

    public LimitedList(ChampionAttributes championAttributes) {
        this.championAttributes = championAttributes;
    }

    @Override
    public boolean add(Object o) {
            return super.add(o);
    }
}
