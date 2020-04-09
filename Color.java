

/**
 * an {@code enum} of card colors. 
 * 0: black, 1: red, 2: yellow, 3: green, 4: blue
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.2
 */
public enum Color 
{
    // the game colors
    BLACK, RED, YELLOW, GREEN, BLUE;

    // hold the ansi code of the colors
    private String colorCodeString;
    static 
    {
        BLACK.colorCodeString = "\033[0;30m";
        RED.colorCodeString = "\033[0;91m";
        YELLOW.colorCodeString = "\033[0;93m";
        GREEN.colorCodeString = "\033[0;92m";
        BLUE.colorCodeString = "\033[0;96m";
    }
    /**
     * This method return the ANSI code of the given color
     * 
     * @param color : the color that you want its ANSI code
     * @return the ANSI code of the color
     */
    public String getColorCodeString(Color color)
    {
        return color.colorCodeString;
    }
}