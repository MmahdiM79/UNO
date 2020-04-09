

/**
 * This class represent a Card in UNO game.
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.3
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
}