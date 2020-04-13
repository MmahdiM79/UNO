import java.util.ArrayList;


/**
 * This class is Monitoring on the enforcement of game rules
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
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
}
