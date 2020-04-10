

/**
 * This class represent a skip card in UNO game. 
 * It extends from {@code Card} class
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 * 
 * @see Card
 */
public class SkipCard extends Card
{
           /* Constructor */

    /**
     * Creat a new skip card card with given details
     * 
     * @param cardColor : the color of the card
     * @param cardCode : the code number of the card. an int in range [1, 108]
     */ 
    public SkipCard(Color cardColor, int cardCode)
    {
        super(20, cardColor, cardCode);
    }


    


            /* Methods */

    /**
     * This method return the {@code String} of the each line of the visual card for print it 
     *  in terminal
     *
     * 
     * @param lineNumber : the number of the card line
     * @return a {@code String} of the given card line
     * 
     * @see cardsOutput.txt, (in project repository)
     */
    public String toString(int lineNumber)
    {
        String cardColorCode = Color.getColorCodeString(super.getCardColor());

        switch (lineNumber)
        {
            // the top and bottom of the card
            case 1:
            case 7: 
                return cardColorCode + "•~~~~~~~•";

            case 2:
                return cardColorCode + "|⍉      |";

            case 3:
            case 5:
                return cardColorCode + "|       |";

            case 4:
                return cardColorCode + "|S k i p|";

            case 6:
                return cardColorCode + "|      ⍉|";

            case 8:
                return Color.getColorCodeString(Color.WHITE_B) + "code: " + super.getCardCode();
        }

        return null;
    }
}