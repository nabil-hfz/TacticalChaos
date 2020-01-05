package com.company.game;


import com.company.arena.Arena;
import com.company.arena.SquaresState;
import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.move.ExecuteMove;
import com.company.players.Player;
import com.company.round.PlanningRound;
import com.company.round.Round;
import com.company.round.RoundMangerSingleton;
import com.company.store.InGameStore;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;
import com.company.utilities.Constants;
import com.company.utilities.Utility;

import java.lang.ref.WeakReference;
import java.util.*;

public class Game {

    private int mNumberOfPlayer;
    private Champions mChampions;
    private RoundManger mRoundManger;

    private StoreFilter mStoreFilter;
    private InGameStore mInGameStore;
    private final Game reference = this;
    private ArrayList<Player> mCurrentPlayer;
    private Round mPlanningRound = new PlanningRound();
    private int NumPlanningRound = 9;
    public static Arena arena;

    public Game() {

        setUpAllNeededClasses();

        setUpAllPlayers();

        setUpChampionsForEachPlayerInPlanningRound();

        Utility.printAllChampionOnArena(mCurrentPlayer);

        arena.printAllChampionsInTheArena();


        setPlanningForEachPlayer();
    }


    private void setUpAllNeededClasses() {

        arena = new Arena();

        mInGameStore = new InGameStore(mStoreFilter = new TemporalStoreFilter(), Utility.getChampions());

        mInGameStore.setInstanceOfInGameStoreToStoreFilter();

        RoundMangerSingleton.setReferenceOfGame(new WeakReference<>(this));

        mRoundManger = RoundMangerSingleton.getRoundMangerInstance();
    }

    private void setUpAllPlayers() {
        mNumberOfPlayer = Utility.getNumber(
                Constants.HINT_NUMBER_OF_PLAYERS,
                Constants.HINT_RANGE_OF_NUMBER_PLAYERS,
                Constants.START_PLAYER_NUMBER,
                Constants.END_PLAYER_NUMBER
        );
    }

    private void setUpChampionsForEachPlayerInPlanningRound() {
        mCurrentPlayer = new ArrayList<>(mNumberOfPlayer);
        for (int i = 0; i < mNumberOfPlayer; ++i) {
            Player player = Utility.getNewPlayer(i);

            for (int j = 0; j < Constants.NUMBER_OF_CHAMPION_FOR_EACH_PLAYER; ++j) {

                List<Champion> temp = mInGameStore.makeListOfChampionsForPlayer(player);

                HashMap<Integer, Champion> integerChampionHashMap = Utility
                        .printAllAvailableChampionChosenChampionFromPlayer(temp, true);

                Map.Entry<Integer, Champion> it = integerChampionHashMap.entrySet().iterator().next();

                it.getValue().setPlayerId(i);
                it.getValue().getCurrentSquare().setState(SquaresState.Occupied);
                it.getValue().setPlayerId(i);

                mInGameStore.setChosenChampionFromPlayer(it.getKey());

                player.setOneChampion(it.getValue());
                player.setNumberOfGoldCoin(Constants.GOLD_FOR_PLAYER_EACH_ROUND);
                arena.addChampion(it.getValue());
                player.PropagateMove();
                integerChampionHashMap.clear();
            }
            mCurrentPlayer.add(player);

        }
    }


    private List<Champion> getAllChampionsPlayer() {
        List<Champion> temp = new ArrayList<>();
        for (Player player : getCurrentPlayerOut()) {
            temp.addAll(player.getCurrentChampions());
        }
        return temp;
    }

    public List<Player> getCurrentPlayerOut() {
        return mCurrentPlayer;
    }

    private void setPlanningForEachPlayer() {
        ArrayList<ArrayList<String>> plansOfTheRound = new ArrayList<ArrayList<String>>();
        ArrayList<String> planForEachPlayer;

        //   System.err.println("hello ppppppppppppppppppppppppppppppppp ");
        for (Player player : mCurrentPlayer) {
            planForEachPlayer = new ArrayList<String>();
            System.err.println("the player name is : " + player.getFirstName());
            for (Champion champion : player.getCurrentChampions()) {
                String s = "";
                int i = 0;
                if (Utility.askForCompleteMission(champion.getChampionAttributes().getChampionName()))
                    while (i < 3) {
                        i++;
                        int choice = Utility.printPlanningListPhase2MovesList();
                        String moveAsString = "";

                        //    System.err.println("hello ppppppppppppppppppppppppppppppppp iii " + i);

                        switch (choice) {
                            case 1:
                                System.err.println("you don't deserve it.");
                                break;

                            case (2): {

                                moveAsString = moveAsString + "W";
//                                int championToMove1;
//                                championToMove1 = Utility.printAllAvailableChampionToMove(new ArrayList<>());
//                                System.out.println(championToMove1);

                                s = champion.getChampionAttributes().getChampionName().substring(0, 3);

                                System.out.println("Walking move must be running right now");
                                Scanner d = new Scanner(System.in);
                                String id;
                                System.out.println("where did you want to move ? ");
                                System.out.println(" 1-move up \n 2-move down \n 3-move left \n 4-move right");
                                System.out.print("your choice :");
                                id = d.next();

                                moveAsString = s + moveAsString + id;
                                System.out.println("move as string issssssssssss : " + moveAsString);
                                break;
                            }

                        }
                        if (!Utility.askForCompleteMission(champion.getChampionAttributes().getChampionName()))
                            break;
                        planForEachPlayer.add(s);


                    }
                System.err.println("-----------------------------------------------------------------------");
                System.err.println();
                System.err.println();
                System.err.println();
            }
            plansOfTheRound.add(planForEachPlayer);

        }

        arena.printAllChampionsInTheArena();

        //********************************************************executing phase*******************************************************************\\
        ArrayList<Player> tempPlayers = new ArrayList<Player>();


        Player p = takeTurns(this.mCurrentPlayer, tempPlayers);

        System.out.println("player to execute move" + p);
        for (int j = 1; j <= this.mCurrentPlayer.size(); j++) {


            ExecuteMove executeMove = new ExecuteMove();
            executeMove.executeMove(plansOfTheRound.get(j - 1).get(j),
                    arena,
                    this.mCurrentPlayer.get(j - 1),
                    this.mCurrentPlayer,
                    1);


        }


//********************************************************end of executing phase*******************************************************************\\

    }


    private Player takeTurns(ArrayList<Player> p, ArrayList<Player> tempPlayers) {

        System.out.println("all players" + p);
        System.out.println("temp players" + tempPlayers);

        Player pl = getRandomPlayer(p);

        if (tempPlayers.contains(pl)) {
            System.out.println("contains");
            takeTurns(p, tempPlayers);

        } else {
            System.out.println("all players in else" + p);
            System.out.println("temp players in else" + tempPlayers);

            System.err.println("player to add" + pl);


            tempPlayers.add(pl);
        }


        return pl;

    }

    public Player getRandomPlayer(ArrayList<Player> items) {
        this.IndexToDelete = new Random().nextInt(items.size());
        Player p = items.get(this.IndexToDelete);
        return p;
    }

    private int IndexToDelete = 0;

    public static abstract class RoundManger {

        private int CounterForNumberOfRound;
        private List<Round> IList;
        protected WeakReference<Game> mGameReference;

        protected RoundManger(WeakReference<Game> gameReference) {
            CounterForNumberOfRound = 0;
            this.mGameReference = gameReference;
        }

        public abstract void RunTurn();

        public void PropagateMove(Champion champion) {
        }
    }
}
