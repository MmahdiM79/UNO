

/**
 * This class reprsent a Card in UNO game.
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Card
{
            /* Feilds */
    
    // the kind of the card
    private Kind cardKind;

    // the score of the card
    private int cardScore;

    // the color of the card
    private Color cardColor;

    // the number of the card. (UNO game has 108 cards)
    private int cardCode;







          /* Constructor */
    
    /**
     * Creat a new card with given details
     * 
     * @param cardKind : the kind of the card
     * @param cardScore : the score of the card 
     * @param cardColor : the color of the card
     * @param cardCode : the code of the card 
     */
    public Card(Kind cardKind, int cardScore, Color cardColor, int cardCode) 
    {
        this.cardKind = cardKind;
        this.cardScore = cardScore;
        this.cardColor = cardColor;
        this.cardCode = cardCode;
    }
    







            /* Methods */


    // * getter methods *

    /**
     * @return the kind of the card
     */
    public Kind getCardKind() 
    {
        return cardKind;
    }
    /**
     * @return the score of the card
     */
    public int getCardScore() 
    {
        return cardScore;
    }
    /**
     * @return the color of card
     */
    public Color getCardColor() 
    {
        return cardColor;
    }
    /**
     * @return the number card
     */
    public int getCardNumber() 
    {
        return cardNumber;
    }
}