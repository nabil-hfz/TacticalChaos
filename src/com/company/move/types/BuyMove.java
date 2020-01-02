package com.company.move.types;


import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.game.Game;
import com.company.move.Move;
import com.company.players.Player;
import com.company.store.InGameStore;
import com.company.store.StoreFilter;

import java.util.List;

public class BuyMove extends Move {     //new class and new added

    private InGameStore mInGameStore;
    private Player mPlayer;
    private List<Champions>mChampionsList;
    private Champion mChampion;
    private StoreFilter mStoreFilter;
    int id;
    int mCostChampion;

    public BuyMove(int id){
        this.id=id;
        mInGameStore = new InGameStore(mStoreFilter);
        mPlayer = new Player("firas","shaal",4,450); // Example
    }
    @Override
    public void performMove() {

    if(mInGameStore.getChampions().getChampions().isEmpty()){  // if Store don`t have Any champion
        return;
    }
    else {
       // mChampion = new Champion();
        mInGameStore = new InGameStore(mStoreFilter);
        mChampion = mInGameStore.getChampions().getChampions().get(id);  // set champion in mChampion from store

        if(mPlayer.getNumberOfGoldCoin()>=(int) mInGameStore.getChampions().getChampions().get(id).getChampionAttributes().getGoldCost().length()){ // if player have Money to buy champion
            mCostChampion = (int)   mInGameStore.getChampions().getChampions().get(id).getChampionAttributes().getGoldCost().length();
            mPlayer.setNumberOfGoldCoin(mPlayer.getNumberOfGoldCoin() - mCostChampion);
            mPlayer.getCurrentChampions().add(id,mChampion);
            mInGameStore.getChampions().getChampions().remove(id);
        }
        else{
            System.out.println("player Don`t have mony");
        }

    }

    }
}
