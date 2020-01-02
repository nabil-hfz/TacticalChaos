package com.company.utilities;

import com.company.arena.Square;
import com.company.champion.Champion;
import com.company.champion.Champions;
import com.company.champion.typeofchampion.ChampionAttributes;
import com.company.champion.typeofchampion.OChampionAttributes;
import com.company.damage.DamageCalculatorFactory;
import com.company.players.Player;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Utility {

    private static Scanner scanner = new Scanner(System.in);
    private static Champions mChampions;

    public static Champions getChampions() {
        if (mChampions == null) {
            readChampionsFromJson();
        }
        return mChampions;
    }

    private static void readChampionsFromJson() {
        //First way to create a Json object for faster coding
        Gson gson = new Gson();
        FileReader json = null;
        try {
            json = new FileReader("D:\\Java\\TacticalChaos\\TacticalChaosV1\\Tactical Chaos\\Champions.json");
        } catch (FileNotFoundException e) {
            System.err.println(e.getCause());
            System.err.println("File not found, please try again. " + e.getMessage());
            System.exit(1);
        }
        try {
            mChampions = gson.fromJson(json, Champions.class);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        for (int i = 0; i < mChampions.getChampions().size(); ++i) {
            mChampions.getChampions().get(i).setNumber(i);
            //    mChampions.getChampions().get(i).setCurrentSquare(new Square(getRandomNumber(), getRandomNumber()));
        }
        mChampions.makeCopyNumber();
    }

    static Random mRandom = new Random();

    private static int getRandomNumber() {
        return (int) ((mRandom.nextLong() % 100 + Constants.PRIMARY) % 100);
    }

    public static int getNumber(String std, String error, int start, int end) {
        return getInteger(std, error, start, end);
    }

    public static Player getNewPlayer(int id) {
        printNewPlayer();
        return new Player(
                getString(Constants.HINT_FIRST_NAME),
                //getString(Constants.HINT_LAST_NAME),
                "",
                id,
                new DamageCalculatorFactory());
    }

    private static String getString(String str) {
        System.out.println("Please enter the " + str + "of player, you want to continue :");
        boolean isInt = false;
        String EnteredStr;
        do {
            EnteredStr = scanner.nextLine();
            if (EnteredStr != null && !EnteredStr.isEmpty())
                return EnteredStr;
        } while (true);
    }


    private static int getInteger(String str, String error, int start, int end) {
        int numOfPlayer = -1;
        System.out.println("Please enter the number of " + str + ", you want to continue :");
        do {
            String EnteredStr = scanner.nextLine();
            try {
                numOfPlayer = Integer.parseInt(EnteredStr);
                if (numOfPlayer < start || numOfPlayer > end) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("You have to enter a valid number " + error);
                System.out.println("Please try again : ");
            }
        } while (numOfPlayer < start || numOfPlayer > end);
        return numOfPlayer;
    }

    private static void printNewPlayer() {
        System.out.println("Please enter the following data which belongs to current player");

    }


    public static List<Integer> getChampionNumberRang() {
        List<Integer> temp = new ArrayList<>(48);
        for (int i = 1; i <= Constants.NUMBER_OF_ALL_TYPES_CHAMPION; ++i) {
            temp.add(i);
        }
        return temp;
    }

    public static HashMap<Integer, Champion> printAllAvailableChampionChosenChampionFromPlayer(List<Champion> tempList, boolean b) {
        System.out.println("\t\t\t\t" + "//////////////////////////////////////// \t\t\t\t The current list of champions " +
                "\t\t\t\t " +
                "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        int i = 1;
        for (Champion champion : tempList) {

            System.out.println("The champion number to choose if you want ==============> " + i);
            System.out.println("The Champion name is : " + champion.getChampionAttributes().getChampionName());
            System.out.println("The cost of this champion is : " + champion.getChampionAttributes().getGoldCost());


            System.out.println("The first Group that Champion belongs to is : " + champion.getChampionAttributes().getClass1());
            System.out.println("The second Group that Champion belongs to is : " + champion.getChampionAttributes().getClass2());

            if (!champion.getChampionAttributes().getClass3().equalsIgnoreCase("-")) {
                System.out.println("The third Group that Champion belongs to is : " + champion.getChampionAttributes().getClass3());
            }


            System.out.println("The champion health is : " + champion.getChampionAttributes().getHealth());
            System.out.println("The champion armor is : " + champion.getChampionAttributes().getArmor());


            System.out.println("The champion magic resist is : " + champion.getChampionAttributes().getMagicResist());
            System.out.println("The champion vision range is : " + champion.getChampionAttributes().getVisionRange());


            System.out.println("The champion attack range is : " + champion.getChampionAttributes().getAttackRange());
            System.out.println("The champion attack Damage is : " + champion.getChampionAttributes().getAttackDamage());


            System.out.println("The champion movement speed is : " + champion.getChampionAttributes().getMovementSpeed());
            System.out.println("The champion critical strike chance : " + champion.getChampionAttributes().getCriticalStrikeChance());


            System.out.println("The champion Critical strike damage is : " + champion.getChampionAttributes().getCriticalStrikeDamage());
            System.out.println("The champion mana Start : " + champion.getChampionAttributes().getManaStart());


            System.out.println("The champion mana Cost is : " + champion.getChampionAttributes().getManaCost());
            System.out.println("The champion ability : " + champion.getChampionAttributes().getAbility());
            System.out.println("The current location : " + champion.getCurrentSquare().getX() + " " + champion.getCurrentSquare().getY());

            System.out.println("The Mana Burner : " + champion.getChampionAttributes().getManaBurnCost());

            System.out.print("\t\t\t\t\t\t\t\t\t\t");

//            if (checkIfThereAvailableCopies(champion.getNumber()))
//                System.out.print("This champion is available if you want to buy it : ");
//            else
//                System.out.print("This champion is not available for buying : ");

            System.out.print("-------------------------------------------------------------------------------------");
            System.out.println();
            i++;
        }
        i = getChosenChampion();

        int x = getSquareX();
        int y = getSquareY();
        HashMap<Integer, Champion> te = new HashMap<>();
        Champion champion = tempList.get(i - 1);
        //  champion.getNumber();
        Square square = new Square(x, y);
        champion.setCurrentSquare(square);

  /*      System.err.println("printAllAvailableChampionChosenChampionFromPlayer ");
        System.err.println("The x : " + champion.getCurrentSquare().getX());
        System.err.println("The y : " + champion.getCurrentSquare().getY());*/
        te.put(champion.getNumber(), champion);

        return te;
    }

    public static void printAllAvailableChampionChosenChampionFromPlayer(List<Player> tempList) {
        System.out.println("\t\t\t\t" + "//////////////////////////////////////// \t\t\t\t The current list of Players" +
                "\t\t\t\t " +
                "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        int i = 1;
        for (Player player : tempList) {
            System.out.println("Player name : " + player.getFirstName());
            System.out.println("Gold coin : " + player.getNumberOfGoldCoin());

            for (Champion champion : player.getCurrentChampions()) {

                //    System.out.println("The champion number to choose if you want ==============> " + i);
                System.out.println("The Champion name is : " + champion.getChampionAttributes().getChampionName());
                System.out.println("The cost of this champion is : " + champion.getChampionAttributes().getGoldCost());


                System.out.println("The first Group that Champion belongs to is : " + champion.getChampionAttributes().getClass1());
                System.out.println("The second Group that Champion belongs to is : " + champion.getChampionAttributes().getClass2());

                if (!champion.getChampionAttributes().getClass3().equalsIgnoreCase("-")) {
                    System.out.println("The third Group that Champion belongs to is : " + champion.getChampionAttributes().getClass3());
                }


                System.out.println("The champion health is : " + champion.getChampionAttributes().getHealth());
                System.out.println("The champion armor is : " + champion.getChampionAttributes().getArmor());


                System.out.println("The champion magic resist is : " + champion.getChampionAttributes().getMagicResist());
                System.out.println("The champion vision range is : " + champion.getChampionAttributes().getVisionRange());


                System.out.println("The champion attack range is : " + champion.getChampionAttributes().getAttackRange());
                System.out.println("The champion attack Damage is : " + champion.getChampionAttributes().getAttackDamage());


                System.out.println("The champion movement speed is : " + champion.getChampionAttributes().getMovementSpeed());
                System.out.println("The champion critical strike chance : " + champion.getChampionAttributes().getCriticalStrikeChance());


                System.out.println("The champion Critical strike damage is : " + champion.getChampionAttributes().getCriticalStrikeDamage());
                System.out.println("The champion mana Start : " + champion.getChampionAttributes().getManaStart());


                System.out.println("The champion mana Cost is : " + champion.getChampionAttributes().getManaCost());
                System.out.println("The champion ability : " + champion.getChampionAttributes().getAbility());
                System.out.println("The current location : " + champion.getCurrentSquare().getX() + " " + champion.getCurrentSquare().getY());
                System.out.println("The Mana Burner : " + champion.getChampionAttributes().getManaBurnCost());

                System.out.print("\t\t\t\t\t\t\t\t\t\t");

//            if (checkIfThereAvailableCopies(champion.getNumber()))
//                System.out.print("This champion is available if you want to buy it : ");
//            else
//                System.out.print("This champion is not available for buying : ");

                System.out.print("-------------------------------------------------------------------------------------");
                System.out.println();
                i++;
            }
        }
    }

    private static int getSquareX() {
        return getInteger(
                Constants.HINT_NUMBER_OF_SQUARE_X,
                Constants.HINT_RANGE_OF_NUMBER_SQUARE,
                Constants.START_ARENA_NUMBER,
                Constants.END_ARENA_NUMBER);
    }

    private static int getSquareY() {
        return getInteger(
                Constants.HINT_NUMBER_OF_SQUARE_Y,
                Constants.HINT_RANGE_OF_NUMBER_SQUARE,
                Constants.START_ARENA_NUMBER,
                Constants.END_ARENA_NUMBER);
    }


    private static int getChosenChampion() {
        return getNumber(
                Constants.HINT_NUMBER_OF_CHAMPIONS,
                Constants.HINT_RANGE_OF_NUMBER_CHAMPIONS,
                Constants.START_CHAMPIONS_NUMBER,
                Constants.END_CHAMPIONS_NUMBER
        );
    }

    public static int printAllAvailableChampionToMove(List<Champion> currentChampions) {
        print(currentChampions);
//        System.out.println("Please select the champion that you want to Move: ");
        return getInteger("Please select the champion that you want to Move: ",
                "you should enter a number between 1 ... " + currentChampions.size(),
                1,
                currentChampions.size());

    }


    public static boolean askForCompleteMission(String name) {
        System.err.println("Do you wanna to do anything with this " + name +" champion !!");
        System.err.println("Your choice [y/n] : ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String Charchoice = scanner.nextLine().substring(0, 1);
            if (Charchoice.equalsIgnoreCase("y"))
                return true;
            if (Charchoice.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }
//    private static boolean checkIfThereAvailableCopies(Integer championName) {
//
//        return (getChampions()
//                .getNumberOfChampionsCopy()
//                .get(championName) > 0);
//    }

    private static void print(Object object) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(object);
    }

    public static int printPlanningListPhase2MovesList() {

//        System.out.println("1- Sell champions.");
//        System.out.println("2- Walk move.");
//        System.out.println("3- Attack a champion.");
//        System.out.println("4- Use ability for specific champion.");
//        System.out.println("5- Swap.");
//        System.out.println("6- None.");
//
//
//        System.out.println("Your choice is: ");

        return getInteger(
                Constants.HINT_RANGE_OF_NUMBER_CHOICE,
                Constants.HINT_RANGE_OF_NUMBER_CHOICE_ERROR,
                1,
                4
        );


    }

    public static void printAllChampionOnArena(List<Player> temp) {


     /*   temp.sort((champion1, champion2) -> {

            // for comparison
            int XCompare = champion1.getCurrentSquare().getX().compareTo(champion2.getCurrentSquare().getX());
            int YCompare = champion1.getCurrentSquare().getY().compareTo(champion2.getCurrentSquare().getY());

            // 2-level comparison using if-else block
            if (XCompare == 0) {
                return ((YCompare == 0) ? XCompare : YCompare);
            } else {
                return XCompare;
            }
        });*/

        Utility.printAllAvailableChampionChosenChampionFromPlayer(temp);
        /*int i = 0;
        for (Champion champion : temp) {
            System.out.println(champion.getChampionAttributes().getChampionName().substring(0, 2) +
                    champion.getCurrentSquare().getX() + "," + champion.getCurrentSquare().getY()); //+
            //    champion.getCurrentSquare().getY() + "" + champion.getChampionName().substring(0, 2));
//            if (i == 10) {
//                i = 0;
//                System.out.println();
//            }
            i++;

        }*/
    }

    public static int getAppropriateManaBurnerCost(int num) {
        int n = -1;
        switch (num) {
            case 1:
                n = 0;
                break;
            case 2:
            case 3:
                n = Constants.MANA_BURNER_COST_20;
                break;
            default:
                n = Constants.MANA_BURNER_COST_40;
                break;
        }
        return n;
    }

    public static OChampionAttributes makeCopyOfChampionAttributes(ChampionAttributes tempChampionAttributes) {
        OChampionAttributes championAttributes = new OChampionAttributes();

        championAttributes.setChampionName(tempChampionAttributes.getChampionName());
        championAttributes.setClass1(tempChampionAttributes.getClass1());
        championAttributes.setClass2(tempChampionAttributes.getClass2());
        championAttributes.setClass3(tempChampionAttributes.getClass3());
        championAttributes.setGoldCost(tempChampionAttributes.getGoldCost());
        championAttributes.setHealth(tempChampionAttributes.getHealth());
        championAttributes.setArmor(tempChampionAttributes.getArmor());
        championAttributes.setMagicResist(tempChampionAttributes.getMagicResist());
        championAttributes.setVisionRange(tempChampionAttributes.getVisionRange());
        championAttributes.setAttackRange(tempChampionAttributes.getAttackRange());
        championAttributes.setAttackDamage(tempChampionAttributes.getAttackDamage());
        championAttributes.setMovementSpeed(tempChampionAttributes.getMovementSpeed());
        championAttributes.setCriticalStrikeChance(tempChampionAttributes.getCriticalStrikeChance());
        championAttributes.setCriticalStrikeDamage(tempChampionAttributes.getCriticalStrikeDamage());
        championAttributes.setManaStart(tempChampionAttributes.getManaStart());
        championAttributes.setManaCost(tempChampionAttributes.getManaCost());
        championAttributes.setAbility(tempChampionAttributes.getAbility());
        return championAttributes;
    }


}
