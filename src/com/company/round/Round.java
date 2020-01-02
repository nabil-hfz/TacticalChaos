package com.company.round;

import com.company.champion.Champion;
import com.company.game.Game;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;

import java.util.List;

public abstract class Round {
    private StoreFilter mStoreFilter;
    private int newField;
   // private StoreFilter mTemporalFilter = new TemporalStoreFilter();
    private List<Champion> listOfChampion;
    Game.RoundManger mRoundManger;

    public Round() {
        mRoundManger = RoundMangerSingleton.getRoundMangerInstance();
    }


}
