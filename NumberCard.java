



/**
 * This method represent a numeral card in UNO game
 * It extends from {@code Card} class.
 * The score of this cards is equal with its number
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.4
 * 
 * @see Card
 */
public class NumberCard extends Card
{
            /* Feilds */
    
    // the number of card. an int in range [0, 9]
    private int cardNumber;







          /* Constructor */
    
    /**
     * Creat a new number card with given details
     * 
     * @param cardNumber : the number of the card. an int in range [0, 9]
     * @param cardColor : the color of the card
     * @param cardCode : the code of the card. an int in range [1, 108]
     */
    public NumberCard(int cardNumber, Color cardColor, int cardCode)
    {
        // set the super class
        super(cardNumber, cardColor, cardCode);

        // set the number of the card
        this.cardNumber = cardNumber;
    }





    

            /* Methods */

    /**
     * @return the number of the card
     */
    public int getCardNumber() 
    {
        return cardNumber;
    }


    /**
     * This method return the {@code String} of the each line of the visual card for print it 
     *  in terminal. if the given number be less than 0, the super class toSetirng will be called.
     *
     * 
     * @param lineNumber : the number of the card line
     * @return a {@code String} of the given card line
     * 
     * @see cardsOutput.txt, (in project repository)
     */
    @Override
    public String toString(int lineNumber)
    {
        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);

        String cardColorCode = Color.getColorCodeString(super.getCardColor());

        switch (lineNumber)
        {
            // the top and bottom of the card
            case 1:
            case 7: 
                return cardColorCode + "•~~~~~~~•" + 
                        Color.getColorCodeString(Color.RESET);

            case 2:
                return cardColorCode + "|" + cardNumber + "      |" + 
                        Color.getColorCodeString(Color.RESET);

            case 3:
            case 5:
                return cardColorCode + "|       |" + 
                        Color.getColorCodeString(Color.RESET);

            case 4:
                return cardColorCode + "|   " + cardNumber + "   |" +
                        Color.getColorCodeString(Color.RESET);

            case 6:
                return cardColorCode + "|      " + cardNumber + "|" +
                        Color.getColorCodeString(Color.RESET);

            case 8:
                return Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                        Color.getColorCodeString(Color.RESET);
        }

        return null;
    }
}