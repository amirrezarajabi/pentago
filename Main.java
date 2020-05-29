import java.util.Scanner;
public class Main {
    /**
     * x of input
     * @param input string for choose
     * @return x
     */
    public static int x (String input)
    {
        if (input.contains("A"))
            return 0;
        if (input.contains("B"))
            return 1;
        if (input.contains("C"))
            return 2;
        if (input.contains("D"))
            return 3;
        if (input.contains("E"))
            return 4;
        if (input.contains("F"))
            return 5;
        if (input.contains("G"))
            return 6;
        if (input.contains("H"))
            return 7;
        return -1;
    }
    /**
     * y of input
     * @param input string for choose
     * @return y
     */
    public static int y(String input)
    {
        if (input.contains("1"))
            return 0;
        if (input.contains("2"))
            return 1;
        if (input.contains("3"))
            return 2;
        if (input.contains("4"))
            return 3;
        if (input.contains("5"))
            return 4;
        if (input.contains("6"))
            return 5;
        if (input.contains("7"))
            return 6;
        if (input.contains("8"))
            return 7;
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //get mode of game
        System.out.println("player-bot: 1 , player-player: 2 , bot-player: 3 , bot-bot: 4");
        Integer game = input.nextInt();
        if (game == 1) {
            //creat players and bots
            Player player2 = new Player("AI", -1);
            Player player1 = new Player("player", 1);
            Map map = new Map(player1, player2);
            map.print();
            while (map.checkEnd() == 0) {
                if (map.checkCanMove(player1) == 0) {
                    System.out.println("pass");
                }
                //get input for player 1
                if (map.checkCanMove(player1) == 1) {
                    int flag = 0;
                    while (flag == 0) {
                        map.print();
                        //suggestion for player 1
                        map.printCan(player1);
                        System.out.println("input yx for example: 1A");
                        System.out.println("player1:");
                        String turn = input.next();
                        if (map.canBe(x(turn), y(turn), player1) == 1) {
                            map.choose(x(turn), y(turn), 1);
                            flag = 1;
                        }
                    }
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
                if (map.checkCanMove(player2) == 0) {
                    System.out.println("pass");
                }
                //bot move
                if (map.checkCanMove(player2) == 1) {
                    map.choose(map.xMaxValue(player2), map.yMaxValue(player2), 2);
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
            }
        }
        if (game == 2)
        {
            //creat players and bots
            Player player2 = new Player("player2", -1);
            Player player1 = new Player("player1", 1);
            Map map = new Map(player1, player2);
            map.print();
            while(map.checkEnd() == 0)
            {
                if (map.checkCanMove(player2) == 0)
                {
                    System.out.println("pass");
                }
                //get input for player 1
                if(map.checkCanMove(player2) == 1)
                {
                    int flag = 0;
                    while (flag == 0)
                    {
                        map.print();
                        //suggestion for player 1
                        map.printCan(player2);
                        System.out.println("input yx for example: 1A");
                        System.out.println("player2:");
                        String turn = input.next();
                        if(map.canBe(x(turn),y(turn),player2) == 1)
                        {
                            map.choose(x(turn),y(turn),1);
                            flag = 1;
                        }
                    }
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1)
                {
                    map.winner(player1,player2);
                    return;
                }
                if (map.checkCanMove(player1) == 0)
                {
                    System.out.println("pass");
                }
                //get input for player 2
                if(map.checkCanMove(player1) == 1)
                {
                    int flag = 0;
                    while (flag == 0)
                    {
                        map.print();
                        //suggestion for player 2
                        map.printCan(player1);
                        System.out.println("input yx for example: 1A");
                        System.out.println("player1:");
                        String turn = input.next();
                        if(map.canBe(x(turn),y(turn),player1) == 1)
                        {
                            map.choose(x(turn),y(turn),2);
                            flag = 1;
                        }
                    }
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1)
                {
                    map.winner(player1,player2);
                    return;
                }
            }
        }
        if (game == 3)
        {

            //creat players and bots
            Player player1 = new Player("AI", 1);
            Player player2 = new Player("player", -1);
            Map map = new Map(player1, player2);
            map.print();
            while (map.checkEnd() == 0) {
                if (map.checkCanMove(player1) == 0) {
                    System.out.println("pass");
                }
                //move bot
                if (map.checkCanMove(player1) == 1) {
                    map.choose(map.xMaxValue(player1), map.yMaxValue(player1), 1);
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
                if (map.checkCanMove(player2) == 0) {
                    System.out.println("pass");
                }
                //get input for player
                if (map.checkCanMove(player2) == 1) {
                    int flag = 0;
                    while (flag == 0) {
                        map.print();
                        //suggestion for player 1
                        map.printCan(player2);
                        System.out.println("input yx for example: 1A");
                        System.out.println("player2:");
                        String turn = input.next();
                        if (map.canBe(x(turn), y(turn), player2) == 1) {
                            map.choose(x(turn), y(turn), 2);
                            flag = 1;
                        }
                    }
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
            }
        }
        if (game == 4)
        {
            //creat players and bots
            Player player1 = new Player("AI1", 1);
            Player player2 = new Player("AI2", -1);
            Map map = new Map(player1, player2);
            map.print();
            while (map.checkEnd() == 0)
            {
                if (map.checkCanMove(player1) == 0) {
                    System.out.println("pass");
                }
                //move bot 1
                if (map.checkCanMove(player1) == 1) {
                    map.choose(map.xMaxValue(player1), map.yMaxValue(player1), 1);
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
                if (map.checkCanMove(player2) == 0) {
                    System.out.println("pass");
                }
                //move bot 2
                if (map.checkCanMove(player2) == 1) {
                    map.choose(map.xMaxValue(player2), map.yMaxValue(player2), 2);
                }
                map.print();
                //check for win
                if (map.checkEnd() == 1) {
                    map.winner(player1, player2);
                    return;
                }
            }
        }
    }
}
