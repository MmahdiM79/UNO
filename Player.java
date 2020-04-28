import java.util.ArrayList;




/**
 * This class repersent a player int Run class
 * it holds the player score, password and player cards
 * 
 * its extends from the person class
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.2.0
 * 
 * @see Person
 */
public class Player extends Person
{
            /* Feilds */

    // the score of the player
    protected int score;

    // the password of the player in the game
    private String playerPass;

    // a list of player cards
    private ArrayList<Card> playerCards;




    

          /* Constructor */

    /**
     * Create a new Pleyer with given name and password
     *  
     * @param firstName : name of the player
     * @param playerPass : password of player
     */
    public Player(String firstName, String playerPass)
    {
        // set the super class
        super(firstName, "nevermind", 0, "nevermind");


        this.score = 0;
        this.playerPass = playerPass;
        
        playerCards = new ArrayList<>();
    }







            /* Methods */

    // * getter methods *

    /**
     * @return : the score of the player
     */
    public int getScore() 
    {
        return score;
    }
    /**
     * @return : the password of the player
     */
    public String getPlayerPass() 
    {
        return playerPass;
    }
    /**
     * @return the player Cards
     */
    public ArrayList<Card> getPlayerCards() 
    {
        return playerCards;
    }
    /**
     * @return the number of the player cards
     */
    public int getNumberOfPlayerCards()
    {
        return playerCards.size();
    }





    /**
     * Add a new card to player cards
     * 
     * @param cardToAdd : new card to add
     */
    public void addCard(Card cardToAdd)
    {
        score += cardToAdd.getCardScore();
        playerCards.add(cardToAdd);
    }


    /**
     * Remove a card from player cards
     * 
     * @param cardCodeToRemove
     * @return the removed Card
     */
    public Card removeCard(int cardCodeToRemove)
    {
        Card cardToRemove = null;
        for (Card card: playerCards)
        {
            if (card.getCardCode() == cardCodeToRemove)
            {
                cardToRemove = card;
                break;
            }
        } 

        score -= cardToRemove.getCardScore();
        playerCards.remove(cardToRemove);

        return cardToRemove;
    }


    /**
     * This method check that the player have a card with given code number or not
     * 
     * @param cardCode : the code of card that you want to check
     * @return {@code true} if player have card with given code number 
     */
    public boolean haveCard(int cardCode)
    {
        for (Card card: playerCards)
        {
            if (card.getCardCode() == cardCode)
                return true;
        }

        return false;
    }
}
