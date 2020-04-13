import java.util.Scanner;


/**
 * The main class of the game.
 * This game designed for UNIX bash !. 
 * (may not work on windows)
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0 
 */
public class Run 
{
    // for get the players inputs
    private static Scanner inputs = new Scanner(System.in);


    public static void main(String[] args) 
    {
        // calibrate the font size of the terminal
        Printer.calibrate(inputs);



        // hold the input to check that its valid or not
        String holdInput;


        // while player choose exit option 
        while (true)
        {
            // while player choose valid option
            while (true)
            {
                // show the game menu tho the player and get his/her choice
                Printer.printMenu();
                holdInput = inputs.nextLine();

                // check the player input
                if (holdInput.length() == 1 && (holdInput.charAt(0) == '1' || holdInput.charAt(0) == '2'))
                    break;
                else 
                    Printer.inValidInputError(inputs);
            }


            switch (holdInput)
            {
                case "1":
                    // while the plahyer choose a valid int
                    while (true)
                    {
                        // get the player choice
                        Printer.getNumberOfThePlayers();
                        holdInput = inputs.nextLine();

                        // check the player input
                        if (holdInput.length() == 1 && holdInput.charAt(0) > '0' && holdInput.charAt(0) < '8')
                            break;
                        else 
                            Printer.inValidInputError(inputs);
                    }

                break;

                case "2":
                    return;
            }
        }
    }
}