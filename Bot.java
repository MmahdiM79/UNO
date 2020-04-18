import java.util.Random;

/**
 * This class is a simple bot that play insted player
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Bot extends Player
{








            /* Constructor */

    /**
     * Creat a new Bot 
     * @param num : the number of the bot
     */
    public Bot(int num)
    {
        super("Bot"+num, ""+num);
    }




    /**
     * This method is a kind of main method for bot
     * It makes bot decision
     */ 
    public void playTurn()
    {
        Card botChoosenCard = null;
        for (int n = 0; n < super.getPlayerCards().size(); n++)
        {
            botChoosenCard = super.getPlayerCards().get(n);
            if (Rules.checkChoose(botChoosenCard, this))
                break;
        }

        if (botChoosenCard instanceof WildCard || botChoosenCard instanceof WildDrawCard)
        {
            Random rand = new Random();
            switch (rand.nextInt(4)+1)
            {
                case 1:
                    Rules.applyChoose(botChoosenCard, Color.RED);
                break;

                case 2:
                    Rules.applyChoose(botChoosenCard, Color.YELLOW);
                break;

                case 3:
                    Rules.applyChoose(botChoosenCard, Color.GREEN);
                break;

                case 4:
                    Rules.applyChoose(botChoosenCard, Color.BLUE);
                break;
            }
        }
        else
            Rules.applyChoose(botChoosenCard, botChoosenCard.getCardColor());
    }
}