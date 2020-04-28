



/**
 * This class represent a Card in UNO game.
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.7
 */
public class Card
{
            /* Feilds */

    // the score of the card
    private int cardScore;

    // the color of the card
    private Color cardColor;

    // the code of the card. (UNO game has 108 cards)
    private int cardCode;







          /* Constructor */
    
    /**
     * Creat a new card with given details
     * 
     * @param cardScore : the score of the card 
     * @param cardColor : the color of the card
     * @param cardCode : the code of the card 
     */
    public Card(int cardScore, Color cardColor, int cardCode) 
    {
        this.cardScore = cardScore;
        this.cardColor = cardColor;
        this.cardCode = cardCode;
    }
    







            /* Methods */


    // * getter methods *

    /**
     * @return the score of the card
     */
    public int getCardScore() 
    {
        return cardScore;
    }
    /**
     * @return the color of the card
     */
    public Color getCardColor() 
    {
        return cardColor;
    }
    /**
     * @return the code of the card
     */
    public int getCardCode() 
    {
        return cardCode;
    }


    /**
     * This method check the equality between this card and the geven object
     * This method check the code number of the cards
     * 
     * @param obj : the given object to check the equality 
     * @return {@code true} if and only if the given card has a same code number with this card
     */
    @Override
    public boolean equals(Object obj) 
    {
        // check the pointers
        if (obj == this)
            return true;

        // check the class
        if (!(obj instanceof Card)) 
            return false;
        
        Card card = (Card) obj;
        return cardCode == card.cardCode;
    }


    /**
     * This method return the {@code String} of the behind the gmae cards
     * 
     * @param lineNumber : the number of the card line
     * @return a {@code String} of the given card line
     * 
     * @see cardsOutput.txt, (in project repository)
     */
    public String toString(int lineNumber)
    {
        switch (lineNumber)
        {
            // the top and bottom of the card
            case 1:
            case 7: 
                return Color.getColorCodeString(Color.WHITE) + "•~~~~~~~•" + 
                        Color.getColorCodeString(Color.RESET);

            case 2:
                return Color.getColorCodeString(Color.WHITE) + "|◉  " +
                       Color.getColorCodeString(Color.GREEN) + "♢  " +
                       Color.getColorCodeString(Color.WHITE) + "◎|" +
                        Color.getColorCodeString(Color.RESET);

            case 3:
            case 5:
                return Color.getColorCodeString(Color.WHITE) + "|  " + 
                       Color.getColorCodeString(Color.GREEN) + "♢♢♢  " +
                       Color.getColorCodeString(Color.WHITE) + "|" +
                        Color.getColorCodeString(Color.RESET);

            case 4:
                return Color.getColorCodeString(Color.WHITE) + "| " + 
                       Color.getColorCodeString(Color.RED) + "U " + 
                       Color.getColorCodeString(Color.YELLOW) + "N " +
                       Color.getColorCodeString(Color.BLUE) + "O " +
                       Color.getColorCodeString(Color.WHITE) + "|" +
                        Color.getColorCodeString(Color.RESET); 

            case 6:
                return Color.getColorCodeString(Color.WHITE) + "|◎  " +
                       Color.getColorCodeString(Color.GREEN) + "♢  " + 
                       Color.getColorCodeString(Color.WHITE) + "◉|" +
                        Color.getColorCodeString(Color.RESET);
        }

        return null;
    }
}