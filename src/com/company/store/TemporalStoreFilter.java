package com.company.store;

import com.company.champion.Champion;
import com.company.champion.typeofchampion.OChampionAttributes;
import com.company.players.Player;
import com.company.round.PlanningRound;
import com.company.utilities.Constants;
import com.company.utilities.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Nabil 11 / 28
 */
public class TemporalStoreFilter extends StoreFilter {
    private Random mRandom;

    public TemporalStoreFilter() {
        this.mRandom = new Random();
    }

    @Override
    public Player getCurrentPlayer() {
        return mCurrentPlayer;
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        mCurrentPlayer = currentPlayer;
    }


    @Override
    public InGameStore getInGameStore() {
        return mInGameStore;
    }

    @Override
    public void setInGameStore(InGameStore inGameStore) {
        mInGameStore = inGameStore;
    }

    @Override
    public PlanningRound getPlanning() {
        return mPlanning;
    }

    @Override
    public void setPlanning(PlanningRound planning) {
        mPlanning = planning;
    }

    @Override
    public List<Champion> getChampionsList(Player player) {
        List<Champion> temp = player.getCurrentChampions();
        List<Champion> temp2 = new ArrayList<>();

        if (temp.size() == 0) {
            if (getNumberOfChampionsCopy(0))
                temp2.add(getChampionFromExisting(0));
            if (getNumberOfChampionsCopy(40))
                temp2.add(getChampionFromExisting(40));
            for (int i = 0; i < 3; ++i)
                temp2.add(getChampion(getRandomNumber()));
        } else {
            int n = 0;
            for (int i = 0; i < Math.min(2, temp.size()); ++i) {
                if (getNumberOfChampionsCopy(temp.get(i).getNumber())) {
                    temp2.add(getChampionFromExisting(temp.get(i).getNumber()));
                    n++;

                }
            }
            for (int i = 0; i < 5 - n; ++i)
                temp2.add(getChampion(getRandomNumber()));
        }

        return temp2;
    }

    private Champion getChampion(int type) {
        Champion champion = new Champion();
        boolean isThereIs = getNumberOfChampionsCopy(type);
        if (!isThereIs)
            getChampion(getRandomNumber());
        else {

            OChampionAttributes championAttributes =
                    Utility.makeCopyOfChampionAttributes(mInGameStore.getChampions().getChampions().get(type).getChampionAttributes());
            champion.setNumber(mInGameStore.getChampions().getChampions().get(type).getNumber());
            champion.setChampionAttributes(championAttributes);

        }

        return champion;
    }

    private Champion getChampionFromExisting(int type) {

        return mInGameStore.getChampions().getAppropriateChampion(type);


    }


    private int getRandomNumber() {
        return (int) ((mRandom.nextLong() % 48 + Constants.PRIMARY) % 48);
    }

    private boolean getNumberOfChampionsCopy(int type) {
        return mInGameStore.getChampions().getNumberOfChampionsCopy()[type] > 0;
    }

}

