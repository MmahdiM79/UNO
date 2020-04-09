

/**
 * an {@code enum} of card colors. 
 * 0: black, 1: red, 2: yellow, 3: green, 4: blue
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.5
 */
public enum Color 
{
    // text colors
    BLACK, RED, YELLOW, GREEN, BLUE, WHITE,

    // background colors
    BLACK_B, BLACK_BRIGHT_B, RED_B, YELLOW_B, GREEN_B, BLUE_B, WHITE_B;



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
        BLACK_BRIGHT_B.colorCodeString = "\033[0;100m";
        RED_B.colorCodeString = "\033[0;101m";
        YELLOW_B.colorCodeString = "\033[0;103m";
        GREEN_B.colorCodeString = "\033[0;102m";
        BLUE.colorCodeString = "\033[0;106m";
        WHITE_B.colorCodeString = "\033[0;107m";
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
}