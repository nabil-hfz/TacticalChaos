package com.company.champion;

import com.company.arena.Square;
import com.company.champion.typeofchampion.OChampionAttributes;
import com.company.damage.IDamageCalculator;
import com.company.move.Move;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Champion {

    public int hash;
    private int mType;
    private Integer mLevel = 1;
    private Integer mNumber;
    private List<Move> mMoves;
    private Square mCurrentSquare;
     private IDamageCalculator mCurrentDamageCalculators;
    private boolean[] mActiveClasses;
    @SerializedName("ChampionAttributes")
    private OChampionAttributes oChampionAttributes;
    public int playerId;

    public Champion() {
        mMoves = new ArrayList<>();
        mCurrentSquare = new Square(-1, -1);
        mActiveClasses = new boolean[3];
        for (boolean a : mActiveClasses) {
            a = false;
        }
        oChampionAttributes = new OChampionAttributes();
    }

    @Override
    public int hashCode() {
        return hash;
    }


    public void AcceptDamage() {
    }

    public void GetIntendedDamage() {

    }

    public Integer getChampionLevel() {
        return mLevel;
    }

    public void setChampionLevel(Integer mLever) {
        this.mLevel = mLever;
    }

    public OChampionAttributes getChampionAttributes() {
        return oChampionAttributes;
    }

    public void setChampionAttributes(OChampionAttributes oChampionAttributes) {
        this.oChampionAttributes = oChampionAttributes;
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public Integer getNumber() {
        return mNumber;
    }

    public void setNumber(Integer mNumber) {
        this.mNumber = mNumber;
    }

    public List<Move> getMoves() {
        return mMoves;
    }

    public void setMoves(List<Move> mMoves) {
        this.mMoves = mMoves;
    }

    public Square getCurrentSquare() {
        return mCurrentSquare;
    }

    public void setCurrentSquare(Square mCurrentSquare) {
        this.mCurrentSquare = mCurrentSquare;
    }

    public IDamageCalculator getCurrentDamageCalculators() {
        return mCurrentDamageCalculators;
    }

    public void setCurrentDamageCalculators(IDamageCalculator iDamageCalculator) {

        this.mCurrentDamageCalculators = iDamageCalculator;
        this.mCurrentDamageCalculators.CalculateIntendedDamage();
    }

    public boolean[] getActiveClasses() {
        return mActiveClasses;
    }

    public void setActiveClasses(boolean[] mActiveClasses) {
        this.mActiveClasses = mActiveClasses;
    }

    @Override
    public String toString() {
        return String.format("\t%s \t%s  \t%s  \t%s \t %s \t %s \t %s \t %s\t %s\t %s\t %s  \t %s\t %s\t %s \t %s \t %s \t %s",

                this.getChampionAttributes().getChampionName(),
                this.getChampionAttributes().getClass1(),
                this.getChampionAttributes().getClass2(),
                this.getChampionAttributes().getClass3(),
                this.getChampionAttributes().getGoldCost(),
                this.getChampionAttributes().getHealth(),
                this.getChampionAttributes().getArmor(),
                this.getChampionAttributes().getMagicResist(),
                this.getChampionAttributes().getVisionRange(),
                this.getChampionAttributes().getAttackRange(),
                this.getChampionAttributes().getMovementSpeed(),
                this.getChampionAttributes().getCriticalStrikeChance(),
                this.getChampionAttributes().getCriticalStrikeDamage(),
                this.getChampionAttributes().getAttackDamage(),
                this.getChampionAttributes().getManaStart(),
                this.getChampionAttributes().getManaCost(),
                this.getChampionAttributes().getAbility(),
                String.valueOf(this.getChampionLevel()),
                String.valueOf(this.getPlayerId()));
    }


    public String toInitials() {
        return String.format("%s%d",
                this.getChampionAttributes().getChampionName().substring(0, 2),
                this.getChampionLevel());
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


}
