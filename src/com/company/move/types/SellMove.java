package com.company.move.types;


import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.move.Move;
import com.company.players.Player;
import com.company.store.InGameStore;
import com.company.store.StoreFilter;

import java.util.List;

public class SellMove extends Move {   // new class and new added


    private InGameStore mInGameStore;
    private Player mPlayer;
    private List<Champion> mChampionsList;
    private Champion mChampion;
    private StoreFilter mStoreFilter;
    int id;
    int mCostChampion;


    public SellMove(int id){
        this.id = id;
        mInGameStore = new InGameStore(mStoreFilter);
        mPlayer = new Player("firas","shaal",4,500); // Example;
    }

    @Override
    public void performMove() {
        if(mPlayer.getCurrentChampions().isEmpty()){    // if Player have`nt ane champion
            System.out.println("the champion list is Empty");
        }
        else
        {
            if(mInGameStore.getChampions().getChampions().size()==5)
                System.out.println("The store is full");
            else
            {
                mChampion = mPlayer.getCurrentChampions().get(id);  // take champion from list champions player and set in mChampion
                mCostChampion = (int) mPlayer.getCurrentChampions().get(id).getChampionAttributes().getGoldCost().length(); // calculate cost of this champion
                mInGameStore.getChampions().getChampions().add(id,mChampion);  // add this champion is list champions store
                mPlayer.setNumberOfGoldCoin(mPlayer.getNumberOfGoldCoin() + mCostChampion);  // add champion money to players money
                mPlayer.getCurrentChampions().remove(id); // remove champion from list of player
            }
        }


    }
}
