



/**
 * an {@code enum} of card colors. 
 * 0: black, 1: red, 2: yellow, 3: green, 4: blue
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.2.0
 */
public enum Color 
{
    // text colors
    BLACK, RED, YELLOW, GREEN, BLUE, WHITE,

    // background colors
    BLACK_B, BLACK_BRIGHT_B, RED_B, YELLOW_B, GREEN_B, BLUE_B, WHITE_B,

    // reset the terminal color. default colors: text color > green, background color > black.
    RESET;

    // hold the ansi code of the colors
    private String colorCodeString;
    static 
    {
        // text colors
        BLACK.colorCodeString = "\033[0;30m";
        RED.colorCodeString = "\033[0;91m";
        YELLOW.colorCodeString = "\033[0;93m";
        GREEN.colorCodeString = "\033[0;92m";
        BLUE.colorCodeString = "\033[0;96m";
        WHITE.colorCodeString = "\033[0;97m";

        // background colors
        BLACK_B.colorCodeString = "\033[40m";
        BLACK_BRIGHT_B.colorCodeString = "\033[100m";
        RED_B.colorCodeString = "\033[101m";
        YELLOW_B.colorCodeString = "\033[103m";
        GREEN_B.colorCodeString = "\033[102m";
        BLUE_B.colorCodeString = "\033[106m";
        WHITE_B.colorCodeString = "\033[107m";

        // reset colors code
        RESET.colorCodeString = "\033[92;40m";
    }


    /**
     * This method return the ANSI code of the given color
     * 
     * @param color : the color that you want its ANSI code
     * @return the ANSI code of the color
     */
    public static String getColorCodeString(Color color)
    {
        return color.colorCodeString;
    }


    /**
     * This method the background color of the input text color
     * 
     * @param textColor : the color that you want 
     * @return the background color
     */
    public static Color getBackgroundColor(Color textColor)
    {
        switch (textColor)
        {
            case RED:
                return RED_B;

            case YELLOW:
                return YELLOW_B;

            case GREEN:
                return GREEN_B;

            case BLUE:
                return BLUE_B;

            case WHITE:
                return WHITE_B;

            case BLACK:
                return BLACK_BRIGHT_B;

            default:
                return BLACK_B;
        }
    } 
}