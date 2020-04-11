


/**
 * This class represent a Wild card in UNO game. 
 * It extends from {@code Card} class
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.1
 * 
 * @see Card
 */
public class WildCard extends Card
{
           /* Constructor */

    /**
     * Creat a new Wild card with given details
     * 
     * @param cardCode : the code number of the card. an int in range [1, 108]
     */ 
    public WildCard(int cardCode)
    {
        super(20, Color.BLACK, cardCode);
    }


    


            /* Methods */

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


        switch (lineNumber)
        {
            // the top and bottom of the card
            case 1:
            case 7: 
                return Color.getColorCodeString(Color.WHITE) + "•~~~~~~~•" +
                        Color.getColorCodeString(Color.RESET);

            case 2:
                return Color.getColorCodeString(Color.WHITE) + "|☯︎      |" +
                        Color.getColorCodeString(Color.RESET);

            case 3:
            case 5:
                return Color.getColorCodeString(Color.WHITE) + "|       |" +
                        Color.getColorCodeString(Color.RESET);

            case 4:
                return Color.getColorCodeString(Color.WHITE) + "|" + 
                       Color.getColorCodeString(Color.RED) + "W " + 
                       Color.getColorCodeString(Color.YELLOW) + "i " +
                       Color.getColorCodeString(Color.GREEN) + "l " +
                       Color.getColorCodeString(Color.BLUE) + "d" +
                       Color.getColorCodeString(Color.WHITE) + "|" +
                        Color.getColorCodeString(Color.RESET);

            case 6:
                return Color.getColorCodeString(Color.WHITE) + "|      ☯︎|" + 
                        Color.getColorCodeString(Color.RESET);

            case 8:
                return Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                        Color.getColorCodeString(Color.RESET);
        }

        return null;
    }
}