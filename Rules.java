import java.util.ArrayList;
import java.util.Random;


/**
 * This class is Monitoring on the enforcement of game rules
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.1
 */
public class Rules 
{
            /* Feilds */

    // the cards of the game
    public static ArrayList<Card> gameCards = new ArrayList<>();

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
        System.out.println(gameCards.add(new NumberCard(0, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(1, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(2, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(3, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(4, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(5, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(6, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(7, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(8, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(9, cardColor, ++cardCode)));


        // set the second set of cards
        System.out.println(gameCards.add(new NumberCard(1, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(2, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(3, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(4, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(5, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(6, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(7, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(8, cardColor, ++cardCode)));
        System.out.println(gameCards.add(new NumberCard(9, cardColor, ++cardCode)));
            

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
