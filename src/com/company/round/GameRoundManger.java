package com.company.round;

import com.company.champion.Champion;
import com.company.game.Game;
import com.company.game.Game.RoundManger;
import com.company.utilities.Constants;
import com.company.utilities.Utility;

import java.lang.ref.WeakReference;
import java.util.List;

public class GameRoundManger extends RoundManger {

    GameRoundManger(WeakReference<Game> mGameReference){
        super(mGameReference);

    }

    @Override
    public void RunTurn() {

        /*
        // هون من الغيم لح نستدعي في اول 9 جولات
        Utility.getNewPlayer(i + Constants.PRIMARY);
        List<Champion> temp = mInGameStore
                .makeListOfChampionsForPlayer(Utility.getNewPlayer(i + Constants.PRIMARY));
        Utility.printAllAvailableChampion(temp);
        i++;*/
    }
    // بعد ال9 جولات نستعي مرة planning مرة excution
}
