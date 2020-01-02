package com.company.round;


import com.company.game.Game;

import java.lang.ref.WeakReference;

public class RoundMangerSingleton {

    private static Game.RoundManger mRoundManger;

    private  static WeakReference<Game> mGameReference;

    private static Round mRound;

    public static void setReferenceOfGame(WeakReference<Game> gameReference){
        mGameReference = gameReference;
    }

    public static Game.RoundManger getRoundMangerInstance() {
        if (mRoundManger == null) {
            mRoundManger = new GameRoundManger(mGameReference);
        }
        return mRoundManger;
    }

}
