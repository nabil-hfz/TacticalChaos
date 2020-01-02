package com.company.store;


import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.players.Player;

import java.util.ArrayList;
import java.util.List;

public class InGameStore {

    private StoreFilter mStoreFilter;
    private List<Champion> mCurrentChampion = new ArrayList<>();
    private Champions mChampions;

    public InGameStore(StoreFilter mStoreFilter, Champions champions) {
        this.mStoreFilter = mStoreFilter;
        this.mChampions = champions;
    }

    public InGameStore(StoreFilter storeFilter) {
        mStoreFilter = storeFilter;
    }

    public Champions getChampions() {
        return mChampions;
    }

    public void setInstanceOfInGameStoreToStoreFilter() {
        this.mStoreFilter.setInGameStore(this);
    }

    public List<Champion> makeListOfChampionsForPlayer(Player player) {
        if (mStoreFilter instanceof TemporalStoreFilter) {
            return mStoreFilter.getChampionsList(player);
        } else
            return null;
    }

    public void setChosenChampionFromPlayer(int type){
        mChampions.getNumberOfChampionsCopy()[type]--;
    }

 }
