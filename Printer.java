import java.util.ArrayList;
import java.util.Scanner;



/**
 * This class do all required prints
 * This class designed for UNIX bash
 * ( may not work on windows )
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.5
 */
public class Printer 
{
            /* Feilds */

    // indent
    private static final String INDENT = "\t\t\t      ";





            /* Methods */

    /**
     * This mehtod calibrate the font size of the terminal
     * 
     * @param finish : the players input source
     */
    public static void calibrate(Scanner finish)
    {
        clear();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(Color.getColorCodeString(Color.RESET) + INDENT + "\b\b\b\b\b\b\b" +
                                "please use (cntrl, +) and (cntrl, -) to fit this line to your screen");

        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        finishEnter(finish);
    }


    /**
     * This method print the game menu
     */
    public static void printMenu()
    {
        clear();
        System.out.println(Color.getColorCodeString(Color.RESET));

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(INDENT + "\t       " + "🃏 <@••••••. UNO Game .••••••@> 🀄️");
        System.out.print("\n\n");
        System.out.println(INDENT + "\t      " + "            1. New game");
        System.out.print("\n");
        System.out.println(INDENT + "\t      " + "              2. exit");
        System.err.println(INDENT + "\t       " + "🀄️ <@••••••••••••••••••••••••@> 🃏");
        System.out.print("\n\n");
        System.out.print(  INDENT + "\t      " + "                0_0? ");
    }  
    

    /**
     * This method ask the number of the players
     */
    public static void getNumberOfThePlayers()
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(INDENT + "\b\b\b" + 
                    "Please enter the number of the players (1 < n < 8):  ");
    }


    /**
     * This method ask the player name
     * 
     * @param playerID : the player number
     */
    public static void getPlayerName(int playerNum)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(INDENT + "\b\b\b\b\b\b\b\b\b\b\b" + 
                    "Please type the name of the player" + playerNum +" (if you want to make bot type bot):  ");
    }


    /**
     * This method ask the player password
     * 
     * @param playerName : the name of the player
     */
    public static void getPlayerPass(String playerName)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(INDENT + "\b" + 
                            "Hi " +  Color.getColorCodeString(Color.BLACK_BRIGHT_B) + playerName +
                    Color.getColorCodeString(Color.RESET) + " Please choose a password for yourself:  ");
    }


    /**
     * This method ask the player pass to start his/her turn.
     * 
     * @param player : the player to start his/her turn
     */
    public static void getPassToStartTurn(Player player)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(Color.getColorCodeString(Color.RESET) + "\t\t  " +
                    "Hey " + Color.getColorCodeString(Color.BLACK_BRIGHT_B) +  player.getFirstName() + 
                                Color.getColorCodeString(Color.RESET) + 
                            " it's your turn. enter your pass to continue: ");
    }


    /**
     * This method ask the board color when player play a wild card
     */
    public static void getPlayerChoosenColor()
    {
        System.out.print("You uesed a wild card. now choose a color ( " + Color.getColorCodeString(Color.WHITE) +
                                Color.getColorCodeString(Color.RED_B) + " 1 " + Color.getColorCodeString(Color.RESET) +
                                ", " + Color.getColorCodeString(Color.WHITE) +
                                Color.getColorCodeString(Color.YELLOW_B) + " 2 " + Color.getColorCodeString(Color.RESET) + 
                                ", " + Color.getColorCodeString(Color.WHITE) + 
                                Color.getColorCodeString(Color.GREEN_B) + " 3 " + Color.getColorCodeString(Color.RESET) + 
                                ", " + Color.getColorCodeString(Color.WHITE) + 
                                Color.getColorCodeString(Color.BLUE_B) + " 4 " + Color.getColorCodeString(Color.RESET) + 
                                " ) :   ");
    }


    /**
     * This method print the game board. t
     * The card on the table and the color that plyers given card must have the same color as it
     * 
     * @param theCardOnTheBoard : the last card on the board
     * @param colorOnTheBoard : the color of the game board
     */
    public static void printGameBoard(Card theCardOnTheBoard, Color colorOnTheBoard)
    {
        clear();


        for (int j = 1; j <= 7; j++)
        {
            System.out.print(INDENT + "\t\t\b" + theCardOnTheBoard.toString(-j) + "    " + theCardOnTheBoard.toString(j));

            if (j == 2)
                System.out.print("  table color");
            else if (j > 2 && j < 6)
                System.out.print("    " + Color.getColorCodeString(colorOnTheBoard) + "      " + 
                    Color.getColorCodeString(Color.RESET));

            System.out.print("\n");
        }

        System.out.print("\n\n\n");
    }


    /**
     * This method show the number of the players cards and the current player and next player
     * 
     * @param players : the game players
     * @param currentPlayerIndex : the index of the current player
     */
    public static void printNumberOfPlayersCards(ArrayList<Player> players, int currentPlayerIndex)
    {
        System.out.println("\nNumber Of The Players Cards:\n");

        int cntr = 0;
        for (Player player: players)
        {
            System.out.print("\t " + player.getFirstName() + ":  " + player.getNumberOfPlayerCards());

            if (cntr == 0 && (currentPlayerIndex == (players.size()-1)))
                System.out.print("\t---> (next player)");

            if (cntr == currentPlayerIndex)
                System.out.print("\t---> (currrent player)");
            else if ((cntr-1) == currentPlayerIndex)
                System.out.print("\t---> (next player)");
            

            System.out.print("\n");
            cntr++;
        }

        System.out.print("\n\n");
    }


    /**
     * This method show the given player cards in terminal 
     * 
     * @param player : the player that want to see his/her cards
     */
    public static void printPlayerCards(Player player)
    {
        for (int j = 0; j < player.getPlayerCards().size(); j += 9)
        {
            for (int i = 1; i <= 8; i++)
            {
                System.out.print("\t\b");
                for (int k = j; (k < j+9) && (k < player.getPlayerCards().size()); k++)
                {
                    System.out.print(player.getPlayerCards().get(k).toString(i) + "  ");
                   
                    if (i == 8)
                        //      space = lenght of the previous line - current line lenght 
                        for(int space =  player.getPlayerCards().get(k).toString(i-1).length() - player.getPlayerCards().get(k).toString(i).length(); 
                            space > 0; space--)
                            System.out.print(" ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }


    /**
     * This method ask the code of the player choosen card
     * 
     * @param player : the player whose turn it is
     */
    public static void getPlayerChoice(Player player)
    {
        System.out.print("\nhey " + Color.getColorCodeString(Color.BLACK_BRIGHT_B) +
                            player.getFirstName() + Color.getColorCodeString(Color.RESET) +
                                " choose a Card (enter the code of your choosen card):  ");
    }


    public static void printScores(ArrayList<Player> players, Scanner finish)
    {
        clear();
        System.out.print(Color.getColorCodeString(Color.WHITE)  + "\n\n\n\n\n\n\n");


        System.out.println(INDENT + "\b\b\b\b\b\bPlayers  name |  Players  Score         Number Of Players Cards");
        System.out.println(INDENT + "\b\b\b\b\b\b–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");

        Player currPlayer;
        for (int index = 0; index < players.size(); index++)
        {
            currPlayer = players.get(index);
            System.out.printf("%s\b\b\b\b\b\b%13s :  %7d                      %8d\n", INDENT, 
                                                                        currPlayer.getFirstName(), 
                                                                        currPlayer.getScore(),  
                                                                        currPlayer.getNumberOfPlayerCards());
        }

        System.out.print("\n\n\n\n" + Color.getColorCodeString(Color.RESET));
        finishEnter(finish);
    }


    /**
     * This method warn the player that his/her input is in valid
     * 
     * @param finish : the player input source
     */
    public static void inValidInputError(Scanner finish)
    {
        System.out.println(INDENT + "\t         " + 
                                Color.getColorCodeString(Color.YELLOW)+ Color.getColorCodeString(Color.RED) +
                                            "<@ ! YOUR INPUT IS INVALID ! @>" + 
                                            Color.getColorCodeString(Color.RESET));
        finishEnter(finish);
    }


    /**
     * This method says to player that he/she can't choose any card
     * 
     * @param finish : the player input source
     */
    public static void noChoiceError(Scanner finish)
    {
        System.out.println("\t\t\t" + 
                                Color.getColorCodeString(Color.YELLOW)+ Color.getColorCodeString(Color.RED) +
                                            "<@ ! YOU CAN'T CHOOSE ANY CARD. ONE CARD HAVE GIVEN TO YOU ! @>" + 
                                            Color.getColorCodeString(Color.RESET));

        finishEnter(finish);
    }





    


    // this method wait until player push 'enter' bottom
    private static void finishEnter(Scanner inputsSource)
    {
        System.out.println(INDENT + "\t\t    " + "(press enter to continue)");
        inputsSource.nextLine();
    }


    // this method clear the terminal
    private static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}