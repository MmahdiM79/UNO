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
 * @version 0.1.6
 * 
 * @see Person
 */
public class Player extends Person
{
            /* Feilds */

    // the score of the player
    private int score;

    // the password of the player in the game
    private String playerPass;

    // a list of player cards
    private ArrayList<Card> playerCards;




    

          /* Constructor */

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
     * @param cardToRemove
     * @return {@code true} if and only if the player have the given card
     */
    public boolean removeCard(Card cardToRemove)
    {
        score -= cardToRemove.getCardScore();
        return playerCards.remove(cardToRemove);
    }
}
