import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 * This class is Monitoring on the enforcement of game rules
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.5
 */
public class Rules 
{
            /* Feilds */

    // the players
    private static ArrayList<Player> players = new ArrayList<>();

    // the cards of the game
    private static ArrayList<Card> gameCards = new ArrayList<>();

    // last card on the board
    private static Card boardCard;

    // last color of the board that plyers should put cards as the same color with it
    private static Color boardColor;

    // hold the penalty cards
    private static ArrayList<Card> penaltyCards = new ArrayList<>();







            /* Methods */
            
    /**
     * This mehtod preparation the game cards to start the game
     */
    public static void preparationGameCards()
    {
        makeGameCards();
        suffleCards();
    }


    /**
     * This method add the given player to the game
     * 
     * @param playerToAdd : player to add to the game
     * @return {@code true} (as specified by {@link ArrayList#add(Object)})
     */
    public static boolean addPlayer(Player playerToAdd)
    {
        return players.add(playerToAdd);
    }


    /**
     * This methed return the player at given index
     * 
     * @param playerIndex : the index of the player that you want
     * @return the player at the given index
     */
    public static Player getPlayer(int playerIndex)
    {
        return players.get(playerIndex);
    }


    /**
     * @return the players
     */
    public static ArrayList<Player> getPlayers()
    {
        return players;
    }


    /**
     * This method distribute the cards between players
     * At the start the game each player should have 7 cards
     */
    public static void distributeCards()
    {
        for (int n = 0; n < 7; n++)
        {
            for (Player p: players)
            {
                // get the card to the player
                p.addCard(gameCards.get(0));
                gameCards.remove(0);
            }
        }


        // set the board card
        while (!(gameCards.get(0) instanceof NumberCard))
        {
            boardCard = gameCards.get(0);
            gameCards.remove(0);
            gameCards.add(boardCard);
        }

        boardCard = gameCards.remove(0);
        boardColor = Color.getBackgroundColor(boardCard.getCardColor());
        gameCards.remove(0);
    }


    /**
     * This method check the player choosen card
     * 
     * 
     * @param playerChoosenCard : the player choosen card
     * @param player : chooser player
     *  
     * @return {@code ture} if player choose is valid(as specified by UNO rules).
     *         otherwise {@code false}.
     */
    public static boolean checkChoose(Card playerChoosenCard, Player player)
    {
        // check the wild cards
        if (playerChoosenCard instanceof WildCard)
            return true;


        // check the wild draw cards
        if (playerChoosenCard instanceof WildDrawCard)
        {
            for (Card card: player.getPlayerCards())
            {
                if (card instanceof WildDrawCard)
                    continue;

                if (checkChoose(card, player))
                    return false;
            }
        

            return true;
        }
 

        // check draw2 cards
        if (boardCard instanceof Draw2Card && penaltyCards.size() != 0)
        {
            if (playerChoosenCard instanceof Draw2Card)
                return true;
            else
                return false;
        }
          

        // revers card case
        if (boardCard instanceof ReverseCard && playerChoosenCard instanceof ReverseCard)
            return true;
        

        // check the color of cards
        if (Color.getBackgroundColor(playerChoosenCard.getCardColor()) == boardColor)
            return true;


        // check the number of number cards
        if (playerChoosenCard instanceof NumberCard && boardCard instanceof NumberCard)
            if (playerChoosenCard.getCardScore() == boardCard.getCardScore())
        
            return true;

        // check the skip cards
        if (playerChoosenCard instanceof SkipCard && boardCard instanceof SkipCard)
            return true;
            

        return false;
    }


    /**
     * This method apply the player choice
     * 
     * @param playerChoosenCard : the player choosen card
     * @param choosenColor : the choosen player color (in wild card cases)
     */
    public static void applyChoose(Card playerChoosenCard, Color choosenColor)
    {
        changeBoardCard(playerChoosenCard);
        boardColor = Color.getBackgroundColor(choosenColor);




        if (playerChoosenCard instanceof WildDrawCard)
        {
            for (int n = 0; n < 4; n++)
            {
                penaltyCards.add(gameCards.get(0));
                gameCards.remove(0);
            }
        }

        
        else if (playerChoosenCard instanceof Draw2Card)
        {
            for (int n = 0; n < 2; n++)
            {
                penaltyCards.add(gameCards.get(0));
                gameCards.remove(0);
            }
        } 
    }


    public static void runGame(Scanner inputs)
    {
        //  * Required variables *

        Player currentPlayer; // hold the current player
        int currentPlayerindex = firstPlayer(); // hold the current player index
        Card playerChoosenCard; // hold the player choosen card
        String holdInput; // hold the player inputs
        Bot bot; // when bot want to play




        while (!endGame())
        {
            // set the current player
            currentPlayer = players.get(currentPlayerindex);

            
        
            // while the player enter his/her password 
            if (!(currentPlayer instanceof Bot))
            {
                while (true)
                {
                    // ask the player password
                    Printer.getPassToStartTurn(currentPlayer);
                    holdInput = inputs.nextLine();
                    
                    // check player input
                    if (currentPlayer.getPlayerPass().equals(holdInput))
                    break;
                    
                    // say that player input is incorrect
                    Printer.inValidInputError(inputs);
                }
            }

            // the draw2 case
            if (penaltyCards.size() != 0)
            {
                boolean check = false;
                for (Card card: currentPlayer.getPlayerCards())
                {
                    if (card instanceof Draw2Card)
                    {
                        check = true;
                        break;
                    }
                }
                
                if (!check)
                {
                    int n = penaltyCards.size();
                    for (; n > 0; n--)
                    {
                        currentPlayer.addCard(penaltyCards.get(0));
                        penaltyCards.remove(0);
                    }
                }

                // go the the next player
                currentPlayerindex = ((currentPlayerindex+1)%players.size());
                continue;
            }
            

            // check the player cards
            if (!checkPlayerCards(currentPlayer))
            {
                // get a card to player
                giveCardToPlayer(currentPlayer);

                // check the player cards again
                if (!checkPlayerCards(currentPlayer))
                {
                    // show the board, number of the other players cards and current player cards
                    Printer.printGameBoard(boardCard, boardColor);
                    Printer.printNumberOfPlayersCards(players, currentPlayerindex );
                    Printer.printPlayerCards(currentPlayer);


                    // say to player that he/she can't choose any card
                    if (!(currentPlayer instanceof Bot))
                        Printer.noChoiceError(inputs);

                    // go the the next player
                    currentPlayerindex = ((currentPlayerindex+1)%players.size());
                    continue;
                }
            }
            

            // it the current player is a bot
            if (currentPlayer instanceof Bot)
            {
                bot = (Bot)currentPlayer;

                playerChoosenCard = bot.playTurn(players,  penaltyCards, currentPlayerindex);


                // go to the next player
                currentPlayerindex = setIndex(playerChoosenCard, currentPlayerindex);
                continue;
            }


            // while player choose a valid card
            while (true)
            {
                // while player choose a valid card code
                while (true)
                {
                    // show the board, number of the other players cards and current player cards
                    Printer.printGameBoard(boardCard, boardColor);
                    Printer.printNumberOfPlayersCards(players, currentPlayerindex );
                    Printer.printPlayerCards(currentPlayer);


                    // ask the player choice
                    Printer.getPlayerChoice(currentPlayer);
                    holdInput = inputs.nextLine();


                    // check player choice
                    if (holdInput.length() > 0 && holdInput.length() < 4 && isInt(holdInput))
                        if (Integer.valueOf(holdInput) <= 108  &&  Integer.valueOf(holdInput) > 0)
                            if (currentPlayer.haveCard(Integer.valueOf(holdInput)))
                                break;
                

                    // say that player input is incorrect
                    Printer.inValidInputError(inputs);
                }


                // get player choosen card
                playerChoosenCard = currentPlayer.removeCard(Integer.valueOf(holdInput));

                // check the player choosen card
                if (checkChoose(playerChoosenCard, currentPlayer))
                {
                    if (playerChoosenCard instanceof WildCard || playerChoosenCard instanceof WildDrawCard)
                    {
                        // while player choose a currect input
                        while (true)
                        {
                            // ask the player choosen color
                            Printer.getPlayerChoosenColor();
                            holdInput = inputs.nextLine();

                            // check the player input
                            if (holdInput.length() == 1 && holdInput.charAt(0) > '0' && holdInput.charAt(0) < '5')
                                break;

                            
                            // say that player input is incorrect
                            Printer.inValidInputError(inputs);

                             // show the board, number of the other players cards and current player cards
                            Printer.printGameBoard(boardCard, boardColor);
                            Printer.printNumberOfPlayersCards(players, currentPlayerindex );
                            Printer.printPlayerCards(currentPlayer);
                        }

                        switch (holdInput)
                        {
                            case "1":
                                applyChoose(playerChoosenCard, Color.RED);
                            break;

                            case "2":
                                applyChoose(playerChoosenCard, Color.YELLOW);
                            break;

                            case "3":
                                applyChoose(playerChoosenCard, Color.GREEN);
                            break;

                            case "4":
                                applyChoose(playerChoosenCard, Color.BLUE);
                            break;
                        }
                        
                    } 

                    else 
                        applyChoose(playerChoosenCard, playerChoosenCard.getCardColor());

                    
                    break;
                }


                // give back the card to the player
                currentPlayer.addCard(playerChoosenCard);

                // say that player input is incorrect
                Printer.inValidInputError(inputs);
            }

            // wild draw case
            if (playerChoosenCard instanceof WildDrawCard)
            {
                int index = (currentPlayerindex+1)%players.size();
                int n = penaltyCards.size();

                for (; n > 0; n--)
                {
                    players.get(index).addCard(penaltyCards.get(0));;
                    penaltyCards.remove(0);
                }
            }


            // go to the next player
            currentPlayerindex = setIndex(playerChoosenCard, currentPlayerindex);
        }

        sortPlayers();
        Printer.printScores(players, inputs);
    }


    /**
     * This method reset the game variables
     */
    public static void reset()
    {
        players = new ArrayList<>();
        gameCards = new ArrayList<>();
        penaltyCards = new ArrayList<>();
    }














    // this method choose the first player randomly
    private static int firstPlayer()
    {
        Random rand = new Random();
        return rand.nextInt(players.size());
    }


    // this method reverse the players array list
    private static void revesePlayers()
    {
        // hold the player for swap
        Player holdPlayer;

        for (int first = 0, end = players.size()-1; first < players.size()/2; first++, end--)
        {
            holdPlayer = players.get(first);
            players.set(first, players.get(end));
            players.set(end, holdPlayer);
        }
    }


    // this method sort the players by their scores
    private static void sortPlayers()
    {
        // hold the player for swap
        Player holdPlayer;

        for (int i = 0; i < players.size(); i++)
            for (int j = i; j < players.size(); j++)
                if (players.get(i).getScore() > players.get(j).getScore())
                {
                    holdPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, holdPlayer);
                }
                else if (players.get(i).getScore() == players.get(j).getScore()
                         &&
                        (players.get(i).getNumberOfPlayerCards() > players.get(j).getNumberOfPlayerCards()))
                {
                    holdPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, holdPlayer);
                }
    }


    // this method return ture if player have at least one card to play
    private static boolean checkPlayerCards(Player player)
    {
        for (Card card: player.getPlayerCards())
        {
            if (checkChoose(card, player))
                return true;
        }

        return false;
    }


    // this method give a card to player from game cards
    private static void giveCardToPlayer(Player currentPlayer)
    {
        currentPlayer.addCard(gameCards.get(0));
        gameCards.remove(0);
    }


    // this method change the board card
    private static void changeBoardCard(Card newCard)
    {
        gameCards.add(boardCard);
        boardCard = newCard;
    }


    // this method get the next player index due to the player choosen card
    private static int setIndex(Card playerChoosenCard, int currentPlayerindex)
    {
        // skip card case
        if (playerChoosenCard instanceof SkipCard || playerChoosenCard instanceof WildDrawCard)
            currentPlayerindex = currentPlayerindex+2;


        // reverse card case
        else if (playerChoosenCard instanceof ReverseCard)
        {
            revesePlayers();
            currentPlayerindex = (players.size() - currentPlayerindex);
        }


        // finish one round case
        else if (currentPlayerindex+1 == players.size())
            currentPlayerindex = 0;


        // other cases
        else 
            currentPlayerindex++;


    
        
        return (currentPlayerindex%players.size());
    }


    // this method return true if game endded
    private static boolean endGame()
    {
        for (Player player: players)
        {
            if (player.getNumberOfPlayerCards() == 0)
                return true;
        }

        return false;
    }


    // this method creat the game cards
    private static void makeGameCards()
    {
        // the code of the cards
        int cardCode = 0;



        // make red cards
        makeCards(Color.RED, cardCode);
        cardCode += 25;

        // make yellow cards
        makeCards(Color.YELLOW, cardCode);
        cardCode += 25;

        // make green cards
        makeCards(Color.GREEN, cardCode);
        cardCode += 25;

        // make blue cards
        makeCards(Color.BLUE, cardCode);
        cardCode += 25;


        // make wild cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildCard(++cardCode));

        // make wild draw cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildDrawCard(++cardCode));
    }


    // this method creat the cards of the given color
    private static void makeCards(Color cardColor, int cardCode)
    {
        // set the first set of cards
        gameCards.add(new NumberCard(0, cardColor, ++cardCode));
        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));


        // set the second set of cards
        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));
            

        // set the skip cards
        gameCards.add(new SkipCard(cardColor, ++cardCode));
        gameCards.add(new SkipCard(cardColor, ++cardCode));

        // set the reverse cards
        gameCards.add(new ReverseCard(cardColor, ++cardCode));
        gameCards.add(new ReverseCard(cardColor, ++cardCode));

        // set the draw2 cards
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
    }


    // this method suffle the game cards
    private static void suffleCards()
    {
        // hold the code number of the suffled cards
        ArrayList<Integer> suffledCards = new ArrayList<>();



        // hold the cards for swap
        Card holdCard;

        // for make random numbers
        Random rand = new Random();

        // hold the random numbers
        int randNum1 = 0, randNum2 = 0;



        // shuffle 80 cards (40 * 2 cards)
        for (int n = 0; n < 40; n++)
        {
            //   * generate the first random number *
            // while find a valid number
            while (true)
            {
                // generate the random number
                randNum1 = rand.nextInt(108);

                // check the generated number
                if (!suffledCards.contains(randNum1))
                    break;
            }
            suffledCards.add(randNum1);


            //   * generate the second random number *
            // while find a valid number
            while (true)
            {
                // generate the random number
                randNum2 = rand.nextInt(108);

                // check the generated number
                if (!suffledCards.contains(randNum2) && randNum2 != randNum1) 
                    break;
            }
            suffledCards.add(randNum2);

            // swap the cards
            holdCard = gameCards.get(randNum1);
            gameCards.set(randNum1, gameCards.get(randNum2));
            gameCards.set(randNum2, holdCard);
        }
    }


    // this method check that the given string can refer to a int or not
    private static boolean isInt(String stringToCheck)
    {
        for (int n = 0; n < stringToCheck.length(); n++)
        {
            if (!('0' <= stringToCheck.charAt(n) && stringToCheck.charAt(0) <= '9'))
                return false;
        }

        return true;
    }
}
