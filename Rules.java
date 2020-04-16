import java.util.ArrayList;
import java.util.Random;


/**
 * This class is Monitoring on the enforcement of game rules
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.6
 */
public class Rules 
{
            /* Feilds */

    // the players
    private static ArrayList<Player> players = new ArrayList<>();

    // the cards of the game
    private static ArrayList<Card> gameCards = new ArrayList<>();

    // last card on the board
    private static Card boardCard;

    // last color of the board that plyers should put cards as the same color with it
    private static Color boardColor;







            /* Methods */
            
    /**
     * This mehtod preparation the game cards to start the game
     */
    public static void preparationGameCards()
    {
        makeGameCards();
        suffleCards();
    }


    /**
     * This method add the given player to the game
     * 
     * @param playerToAdd : player to add to the game
     * @return {@code true} (as specified by {@link ArrayList#add(Object)})
     */
    public static boolean addPlayer(Player playerToAdd)
    {
        return players.add(playerToAdd);
    }


    /**
     * This methed return the player at given index
     * 
     * @param playerIndex : the index of the player that you want
     * @return the player at the given index
     */
    public static Player getPlayer(int playerIndex)
    {
        return players.get(playerIndex);
    }


    /**
     * @return the players
     */
    public static ArrayList<Player> getPlayers()
    {
        return players;
    }


    /**
     * This method distribute the cards between players
     * At the start the game each player should have 7 cards
     */
    public static void distributeCards()
    {
        for (int n = 0; n < 7; n++)
        {
            for (Player p: players)
            {
                // get the card to the player
                p.addCard(gameCards.get(0));
                gameCards.remove(0);
            }
        }
    }







    // this method reverse the players array list
    private static void revesePlayers()
    {
        // hold the player for swap
        Player holdPlayer;

        for (int first = 0, end = players.size()-1; first < players.size()/2; first++, end--)
        {
            holdPlayer = players.get(first);
            players.set(first, players.get(end));
            players.set(end, holdPlayer);
        }
    }


    // this method sort the players by their scores
    private static void sortPlayers()
    {
        // hold the player for swap
        Player holdPlayer;

        for (int i = 0; i < players.size(); i++)
            for (int j = i; j < players.size(); j++)
                if (players.get(i).getScore() < players.get(j).getScore())
                {
                    holdPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, holdPlayer);
                }
    }


    // this method creat the game cards
    private static void makeGameCards()
    {
        // the code of the cards
        int cardCode = 0;



        // make red cards
        makeCards(Color.RED, cardCode);
        cardCode += 25;

        // make yellow cards
        makeCards(Color.YELLOW, cardCode);
        cardCode += 25;

        // make green cards
        makeCards(Color.GREEN, cardCode);
        cardCode += 25;

        // make blue cards
        makeCards(Color.BLUE, cardCode);
        cardCode += 25;


        // make wild cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildCard(++cardCode));

        // make wild draw cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildDrawCard(++cardCode));
    }


    // this method creat the cards of the given color
    private static void makeCards(Color cardColor, int cardCode)
    {
        // set the first set of cards
        gameCards.add(new NumberCard(0, cardColor, ++cardCode));
        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));


        // set the second set of cards
        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));
            

        // set the skip cards
        gameCards.add(new SkipCard(cardColor, ++cardCode));
        gameCards.add(new SkipCard(cardColor, ++cardCode));

        // set the reverse cards
        gameCards.add(new ReverseCard(cardColor, ++cardCode));
        gameCards.add(new ReverseCard(cardColor, ++cardCode));

        // set the draw2 cards
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
    }


    // this method suffle the game cards
    private static void suffleCards()
    {
        // hold the code number of the suffled cards
        ArrayList<Integer> suffledCards = new ArrayList<>();



        // hold the cards for swap
        Card holdCard;

        // for make random numbers
        Random rand = new Random();

        // hold the random numbers
        int randNum1 = 0, randNum2 = 0;



        // shuffle 80 cards (40 * 2 cards)
        for (int n = 0; n < 40; n++)
        {
            //   * generate the first random number *
            // while find a valid number
            while (true)
            {
                // generate the random number
                randNum1 = rand.nextInt(108);

                // check the generated number
                if (!suffledCards.contains(randNum1))
                    break;
            }
            suffledCards.add(randNum1);


            //   * generate the second random number *
            // while find a valid number
            while (true)
            {
                // generate the random number
                randNum2 = rand.nextInt(108);

                // check the generated number
                if (!suffledCards.contains(randNum2) && randNum2 != randNum1) 
                    break;
            }
            suffledCards.add(randNum2);

            // swap the cards
            holdCard = gameCards.get(randNum1);
            gameCards.set(randNum1, gameCards.get(randNum2));
            gameCards.set(randNum2, holdCard);
        }
    }
}
