

/**
 * This class repersent a player int Run class
 * it holds the player score, ID and player character
 * 
 * its extends from the person class
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Player extends Person
{
            /* Feilds */

    // the score of the player
    private int score;

    // the id of the player in the game
    private int playerID;

    // the character of the player
    private char playerCharacter;





    

          /* Constructor */

    public Player(String firstName, String lastName, int age, int playerID, char playerCharacter, String gender)
    {
        super(firstName, lastName, age, gender);

        this.score = 0;
        this.playerID = playerID;
        this.playerCharacter = playerCharacter;
    }







            /* Methods */


    // * setter methods *

    /**
     * set the score of the player
     * @param score : the score of player to set
     */
    public void setScore(int score) 
    {
        this.score = score;
    }
    /**
     * set the ID of the player
     * @param playerID : the ID of palyer to set
     */
    public void setPlayerID(int playerID) 
    {
        this.playerID = playerID;
    }
    /**
     * set the character of the player
     * @param playerCharacter : the Character of player to set
     */
    public void setPlayerCharacter(char playerCharacter) 
    {
        this.playerCharacter = playerCharacter;
    }


    // * getter methods *

    /**
     * @return : the score of the player
     */
    public int getScore() 
    {
        return score;
    }
    /**
     * @return : the ID of the player
     */
    public int getPlayerID() 
    {
        return playerID;
    }
    /**
     * @return : the Character of the player
     */
    public char getPlayerCharacter() 
    {
        return playerCharacter;
    }
}
