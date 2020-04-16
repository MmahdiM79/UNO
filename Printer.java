import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class do all required prints
 * This class designed for UNIX bash
 * ( may not work on windows )
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.12
 */
public class Printer 
{
            /* Feilds */

    // indent
    private static final String indent = "\t\t\t      ";




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
        System.out.println(Color.getColorCodeString(Color.RESET) + indent + "\b\b\b\b\b\b\b" +
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
        System.out.println(indent + "\t       " + "🃏 <@••••••. UNO Game .••••••@> 🀄️");
        System.out.print("\n\n");
        System.out.println(indent + "\t      " + "            1. New game");
        System.out.print("\n");
        System.out.println(indent + "\t      " + "              2. exit");
        System.err.println(indent + "\t       " + "🀄️ <@••••••••••••••••••••••••@> 🃏");
        System.out.print("\n\n");
        System.out.print(  indent + "\t      " + "                0_0? ");
    }  
    

    /**
     * This method ask the number of the players
     */
    public static void getNumberOfThePlayers()
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(indent + "\b\b\b" + 
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
        System.out.print(indent + "\t  " + 
                    "Please type the name of the player" + playerNum +":  ");
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
        System.out.print(indent + "\b" + 
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
     * This method print the game board. t
     * The card on the table and the color that plyers given card must have the same color as it
     * 
     * @param theCardOnTheBoard : the last card on the board
     * @param colorOnTheBoard : the color of the game board
     */
    public static void printGameBoard(Card theCardOnTheBoard, Color colorOnTheBoard)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        for (int j = 1; j <= 7; j++)
        {
            System.out.print(indent + "\t\t\b" + theCardOnTheBoard.toString(-j) + "    " + theCardOnTheBoard.toString(j));

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
     * This method show the number of the players cards
     * 
     * @param players : the game players
     */
    public static void printNumberOfPlayersCards(ArrayList<Player> players)
    {
        System.out.println("Number Of The Players Cards:");
        for (Player player: players)
        {
            System.out.println("\t " + player.getFirstName() + ":  " + player.getNumberOfPlayerCards());
        }
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
        System.out.println("hey " + Color.getColorCodeString(Color.BLACK_BRIGHT_B) +
                            player.getFirstName() + Color.getColorCodeString(Color.RESET) +
                                "choose a Card (enter the code of your choosen card):  ");
    }


    /**
     * This method warn the player that his/her input is in valid
     * 
     * @param finish : the player input source
     */
    public static void inValidInputError(Scanner finish)
    {
        System.out.println(indent + "\t         " + 
                                Color.getColorCodeString(Color.YELLOW)+ Color.getColorCodeString(Color.RED) +
                                            "<@ ! YOUR INPUT IS INVALID ! @>" + 
                                            Color.getColorCodeString(Color.RESET));
        finishEnter(finish);
    }


    


    // this method wait until player push 'enter' bottom
    private static void finishEnter(Scanner inputsSource)
    {
        System.out.println(indent + "\t\t    " + "(press enter to continue)");
        inputsSource.nextLine();
    }


    // this method clear the terminal
    private static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}