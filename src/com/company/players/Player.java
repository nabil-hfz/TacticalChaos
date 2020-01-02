package com.company.players;


import com.company.champion.Champion;
import com.company.damage.DamageCalculatorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Nabil 11 / 28
 */

public class Player {

    // Base info
    private int mId;
    private String mFirstName;
    private String mLastName;
    private int mNumberOfGoldCoin = 12;

    // Second info
    private int mNumberOfRoundsStillAlive;
    private boolean isAllChampionsDead;
    private ArrayList<Champion> mCurrentChampions = new ArrayList<Champion>();
    private DamageCalculatorFactory mDamageCalculatorFactory;
    private List<Champion> mCurrentChampionsInBench = new ArrayList<>();
    private List<Champion> mBench = new ArrayList<>();
    private int PlayerIndex;


    public Player(String mFirstName, String mLastName, int mId, DamageCalculatorFactory damageCalculatorFactory) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mId = mId;
        this.mDamageCalculatorFactory = damageCalculatorFactory;
    }

    public Player(String firas, String shaal, int mId, int i) {

    }

    public void PropagateMove() {
         mDamageCalculatorFactory.CalculateClasses(mCurrentChampions);
    }

    public void setOneChampion(Champion champion) {

        mCurrentChampions.add(champion);
    }

    public List<Champion> getBench() {
        return mBench;
    }

    public void setBench(List<Champion> mBench) {
        this.mBench = mBench;
    }

    public void setBench(Champion champion) {
        this.mBench.add(champion);
    }

    public int getNumberOfGoldCoin() {
        return mNumberOfGoldCoin;
    }

    public void setNumberOfGoldCoin(int mNumberOfGoldCoin) {
        this.mNumberOfGoldCoin += mNumberOfGoldCoin;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getNumberOfRoundsStillAlive() {
        return mNumberOfRoundsStillAlive;
    }

    public void setNumberOfRoundsStillAlive(int mNumberOfRoundsStillAlive) {
        this.mNumberOfRoundsStillAlive = mNumberOfRoundsStillAlive;
    }

    public boolean isAllChampionsDead() {
        return isAllChampionsDead;
    }

    public void setAllChampionsDead(boolean allChampionsDead) {
        isAllChampionsDead = allChampionsDead;
    }

    public List<Champion> getCurrentChampions() {
        return mCurrentChampions;
    }

    public void setCurrentChampions(ArrayList<Champion> mCurrentChampions) {
        this.mCurrentChampions = mCurrentChampions;
    }

    public DamageCalculatorFactory getDamageCalculatorFactory() {
        return mDamageCalculatorFactory;
    }

    public void setDamageCalculatorFactory(DamageCalculatorFactory mDamageCalculatorFactory) {
        this.mDamageCalculatorFactory = mDamageCalculatorFactory;
    }

    public List<Champion> getCurrentChampionsInBench() {
        return mCurrentChampionsInBench;
    }

    public void setCurrentChampionsInBench(List<Champion> mCurrentChampionsInBench) {
        this.mCurrentChampionsInBench = mCurrentChampionsInBench;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
