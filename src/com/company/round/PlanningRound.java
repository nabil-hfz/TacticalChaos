package com.company.round;

import com.company.champion.Champion;
import com.company.players.Player;
import com.company.store.InGameStore;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;
import com.company.utilities.Constants;
import com.company.utilities.Utility;

import java.util.ArrayList;
import java.util.List;


public class PlanningRound extends Round {
    private int newField;
    //Edited Here :)
    private InGameStore mInGameStore;
    private StoreFilter storeFilter; //here i can get to current player
    private TemporalStoreFilter temporalStore = new TemporalStoreFilter();
    List<Champion> temp;
    private int mNumberOfPlayer;
    private List<Player> mCurrentPlayer;


    public void GetTemporalList(){
        temp = new ArrayList<>();
     //   List<Champion> temp = temporalStore.getChampionsList(storeFilter.getCurrentPlayer()); //parameters :current player
        // you can here print the list for player to choose from using utility
        //return currentPlayer for the game
    }

   // @Override
    public void RunTurn() {
        // هون من الغيم لح نستدعي في اول 9 جولات
        Utility.getNewPlayer(i + Constants.PRIMARY);
        List<Champion> temp = mInGameStore
                .makeListOfChampionsForPlayer(Utility.getNewPlayer(i + Constants.PRIMARY));
      //  Utility.printAllAvailableChampionChosenChampionFromPlayer(temp);
        i++;
    }
    // بعد ال9 جولات نستعي مرة planning مرة excution
int i = 0;

}
