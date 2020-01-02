package com.company.store;


import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.players.Player;
import com.company.round.PlanningRound;

import java.util.List;

/**
 * Nabil 11 / 28
 */

public abstract class StoreFilter {

    protected InGameStore mInGameStore;
    protected PlanningRound mPlanning;
    protected StoreFilter mStoreFilter;

    //Edited here
    protected Player mCurrentPlayer;


    protected StoreFilter() {
    }

    protected StoreFilter(StoreFilter storeFilter) {
        this.mStoreFilter = storeFilter;
    }

    public abstract Player getCurrentPlayer();

    public abstract void setCurrentPlayer(Player mCurrentPlayer);

    public abstract InGameStore getInGameStore();

    public abstract void setInGameStore(InGameStore mInGameStore);

    public abstract PlanningRound getPlanning();

    public abstract void setPlanning(PlanningRound mPlanning);

    public abstract List<Champion> getChampionsList(Player player);

}
