import java.util.Scanner;

/**
 * This class do all required prints
 * This class designed for UNIX bash
 * ( may not work on windows )
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.4
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