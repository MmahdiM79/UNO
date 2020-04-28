import java.util.ArrayList;
import java.util.Random;



/**
 * This class is a simple bot that play insted player
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.2.0
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
     * 
     * 
     * @param players : the players of the game
     * @param botIndex : the index of the bot in the player arraylist
     * 
     * @return the bot choosen card
     */ 
    public Card playTurn(ArrayList<Player> players, ArrayList<Card> penaltyCards, int botIndex)
    {
        Card botChoosenCard = null;
        for (int n = 0; n < super.getPlayerCards().size(); n++)
        {
            botChoosenCard = super.getPlayerCards().get(n);
            if (Rules.checkChoose(botChoosenCard, this))
            {
                this.getPlayerCards().remove(botChoosenCard);
                score -= botChoosenCard.getCardScore();
                break;
            }
        }


        // the cases that bot must choose a color
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

        

        // wild draw case
        if (botChoosenCard instanceof WildDrawCard)
        {
            int index = (botIndex+1)%players.size();
            int n = penaltyCards.size();

            for (; n > 0; n--)
            {
                players.get(index).addCard(penaltyCards.get(0));;
                penaltyCards.remove(0);
            }
        }


        return botChoosenCard;
    }
}