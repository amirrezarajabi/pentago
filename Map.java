/**
 * The player class represents a player in a othello game
 * @author Amirreza
 * @version 1.0
 */
public class Map
{
    //player 1 & 2
    private Player player1;
    private Player player2;
    //create map
    private Cell [][] cells;

    /**
     * crate map
     * @param player1 player1
     * @param player2 player2
     */
    public Map(Player player1 , Player player2)
    {
        cells = new Cell [8][8];
        this.player1 = player1;
        this.player2 = player2;
        for(int i = 0;i < 8;i++)
        {
            for(int j = 0;j < 8;j++)
            {
                cells[i][j] = new Cell(i, j, 0);
            }
        }
        cells[3][3].setCell(player1.getType());
        cells[4][4].setCell(player1.getType());
        cells[3][4].setCell(player2.getType());
        cells[4][3].setCell(player2.getType());
        player1.addCell(cells[3][3]);
        player1.addCell(cells[4][4]);
        player2.addCell(cells[4][3]);
        player2.addCell(cells[3][4]);
    }

    /**
     * unicode for print
     * @param type type of cell
     * @return unicode for cell
     */
    public char prCell(int type)
    {
        if (type == 0)
            return '\u2610';
        if (type == 1)
            return '\u26AB';
        return '\u26AA';
    }

    /**
     * print map
     */
    public void print()
    {
        for (int j = 0;j < 8;j++)
        {
            for (int i = 0;i < 8;i++)
            {
                System.out.print(prCell(cells[i][j].getType()));
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
    }

    /**
     * get the cells
     * @return cells field
     */
    public Cell[][] getCells() {
        return cells;
    }

    /**
     * check direction
     * @param i set R L direction
     * @param j set u D direction
     * @param x x of choose cell
     * @param y x of choose cell
     * @param player playwe want be checked
     * @return 1 can 0 cant
     */
    public int check(int i , int j , int x , int y, Player player)
    {
        int xx = x , yy = y;
        if (xx == -1 || xx == 8 || yy==-1||yy==8)
            return 0;
        xx = xx + i;
        yy = yy + j;
        if (xx == -1 || xx == 8 || yy==-1||yy==8)
            return 0;
        if (cells[xx][yy].getType() == 0)
        {
            return 0;
        }
        if (cells[xx][yy].getType() == player.getType())
            return 0;
        xx = xx + i;
        yy = yy + j;
        while((xx != -1 && xx != 8 && yy!=-1&& yy!=8))
        {
            if(cells[xx][yy].getType() == 0)
                return 0;
            if (cells[xx][yy].getType() == player.getType()) {
                return 1;
            }
            xx = xx + i;
            yy = yy + j;
        }
        return 0;
    }

    /**
     * can be here
     * @param x x of cell
     * @param y y of cell
     * @param player player choose cell
     * @return 1 can 0 cant
     */
    public int canBe(int x , int y ,Player player)
    {
        if (cells[x][y].getType() != 0)
            return 0;
        if (check(1,1,x,y,player)+check(1,0,x,y,player)+check(1,-1,x,y,player)+check(0,1,x,y,player)+check(0,-1,x,y,player)+check(-1,1,x,y,player)+check(-1,0,x,y,player)+check(-1,-1,x,y,player)>0)
        {
         //   System.out.println("X");
            return 1;}
        return 0;
    }

    /**
     * can move player
     * @param player player want  to moving
     * @return 1 can 0 cant
     */
    public int checkCanMove(Player player)
    {
        int k = 0;
        for (int i = 0;i < 8;i++)
        {
            for (int j = 0;j < 8;j++)
            {
                //System.out.println("X= "+i+" Y= "+j+" Can: "+ canBe(i,j,player) );
                k = k + canBe(i,j,player);
            }
        }
        if (k != 0)
            return 1;
        return 0;
    }

    /**
     * check the game is finish
     * @return 0 not 1 finish
     */
    public int checkEnd()
    {
        if(checkCanMove(player1)== 0  && checkCanMove(player2) == 0)
            return 1;
        return 0;
    }

    /**
     * print cell can player be here
     * @param player player
     */
    public void printCan(Player player)
    {
        for (int i = 0;i < 8;i++)
        {
            for (int j = 0;j < 8;j++)
            {
                if (canBe(i,j,player) == 1)
                {
                    if(i == 0)
                    {
                        int c = j + 1;
                        System.out.println("X:  A  Y:"+c);
                    }
                    if(i == 1)
                    {
                        int c = j + 1;
                        System.out.println("X:  B  Y:"+c);
                    }
                    if(i == 2)
                    {
                        int c = j + 1;
                        System.out.println("X:  C  Y:"+c);
                    }
                    if(i == 3)
                    {
                        int c = j + 1;
                        System.out.println("X:  D  Y:"+c);
                    }
                    if(i == 4)
                    {
                        int c = j + 1;
                        System.out.println("X:  E  Y:"+c);
                    }
                    if(i == 5)
                    {
                        int c = j + 1;
                        System.out.println("X:  F  Y:"+c);
                    }
                    if(i == 6)
                    {
                        int c = j + 1;
                        System.out.println("X:  G  Y:"+c);
                    }
                    if(i == 7)
                    {
                        int c = j + 1;
                        System.out.println("X:  H  Y:"+c);
                    }
                }
            }
        }
    }
    /**
     * achieve x of next cell
     * @param i step of x
     * @param j step of y
     * @param x x of my cell
     * @param y y of my cell
     * @param player player want
     * @return x or -1
     */
    public int xNextCell(int i , int j , int x , int y , Player player)
    {
        int xx = x + i, yy = y+j;
        if (check(i,j,x,y,player) == 1)
        {
            while (cells[xx][yy].getType() == -player.getType())
            {
                xx = xx + i;
                yy = yy + j;
            }
            return xx;
        }
        return -1;
    }
    /**
     * achieve y of next cell
     * @param i step of x
     * @param j step of y
     * @param x x of my cell
     * @param y y of my cell
     * @param player player want
     * @return y or -1
     */
    public int yNextCell(int i , int j , int x , int y , Player player)
    {
        int xx = x+i, yy = y+j;
        if (check(i,j,x,y,player) == 1)
        {
            while (cells[xx][yy].getType() == -player.getType())
            {
                xx = xx + i;
                yy = yy + j;
            }
            return yy;
        }
        return -1;
    }

    /**
     * change cell in this direct
     * @param i show x direct
     * @param j show y direct
     * @param x x of cell
     * @param y y of cell
     * @param which player 1 0r 2
     */
    public void chooseInDirect(int i, int j,int x,int y,int which)
    {
        if(which == 1)
        {
            if (check(i,j,x,y,player1) == 1)
            {
                int nx =xNextCell(i,j,x,y,player1);
                int ny =yNextCell(i,j,x,y,player1);
                int xx = x , yy = y;
                if (i == 1 && j==1)
                {
                    xx = xx + 1;
                    yy = yy + 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx > xx && ny > yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                        yy = yy + 1;
                    }
                }
                if (i == 1 && j==0)
                {
                    xx = xx + 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx > xx)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                    }
                }
                if (i == 1 && j==-1)
                {
                    xx = xx + 1;
                    yy = yy - 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx > xx && ny < yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                        yy = yy - 1;
                    }
                }
                if (i == 0 && j==1)
                {
                    yy = yy + 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (ny > yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        yy = yy + 1;
                    }
                }
                if (i == 0 && j==-1)
                {
                    yy = yy - 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (ny < yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        yy = yy - 1;
                    }
                }
                if (i == -1 && j==1)
                {
                    xx = xx - 1;
                    yy = yy + 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx < xx && ny > yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                        yy = yy + 1;
                    }
                }
                if (i == -1 && j==0)
                {
                    xx = xx - 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx < xx)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                    }
                }
                if (i == -1 && j==-1)
                {
                    xx = xx - 1;
                    yy = yy - 1;
                    cells[xx][yy].setCell(player1.getType());
                    player1.addCell(cells[xx][yy]);
                    player2.removeCell(cells[xx][yy]);
                    while (nx < xx && ny < yy)
                    {
                        cells[xx][yy].setCell(player1.getType());
                        player1.addCell(cells[xx][yy]);
                        player2.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                        yy = yy - 1;
                    }
                }
            }
            cells[x][y].setCell(player1.getType());
            player1.addCell(cells[x][y]);
        }
        if(which == 2)
        {
            if (check(i,j,x,y,player2) == 1)
            {
                int nx =xNextCell(i,j,x,y,player2);
                int ny =yNextCell(i,j,x,y,player2);
                int xx = x , yy = y;
                if (i == 1 && j==1)
                {
                    xx = xx + 1;
                    yy = yy + 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx > xx && ny > yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                        yy = yy + 1;
                    }
                }
                if (i == 1 && j==0)
                {
                    xx = xx + 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx > xx)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                    }
                }
                if (i == 1 && j==-1)
                {
                    xx = xx + 1;
                    yy = yy - 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx > xx && ny < yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx + 1;
                        yy = yy - 1;
                    }
                }
                if (i == 0 && j==1)
                {
                    yy = yy + 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (ny > yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        yy = yy + 1;
                    }
                }
                if (i == 0 && j==-1)
                {
                    yy = yy - 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (ny < yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        yy = yy - 1;
                    }
                }
                if (i == -1 && j==1)
                {
                    xx = xx - 1;
                    yy = yy + 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx < xx && ny > yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                        yy = yy + 1;
                    }
                }
                if (i == -1 && j==0)
                {
                    xx = xx - 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx < xx)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                    }
                }
                if (i == -1 && j==-1)
                {
                    xx = xx - 1;
                    yy = yy - 1;
                    cells[xx][yy].setCell(player2.getType());
                    player2.addCell(cells[xx][yy]);
                    player1.removeCell(cells[xx][yy]);
                    while (nx < xx && ny < yy)
                    {
                        cells[xx][yy].setCell(player2.getType());
                        player2.addCell(cells[xx][yy]);
                        player1.removeCell(cells[xx][yy]);
                        xx = xx - 1;
                        yy = yy - 1;
                    }
                }
            }
            cells[x][y].setCell(player2.getType());
            player2.addCell(cells[x][y]);
        }
    }

    /**
     * chang all map
     * @param x x of cell
     * @param y y of cell
     * @param which player 1 or 2
     */
    public void choose(int x,int y,int which)
    {
        chooseInDirect(1,1,x,y,which);
        chooseInDirect(1,0,x,y,which);
        chooseInDirect(1,-1,x,y,which);
        chooseInDirect(0,1,x,y,which);
        chooseInDirect(0,-1,x,y,which);
        chooseInDirect(-1,1,x,y,which);
        chooseInDirect(-1,0,x,y,which);
        chooseInDirect(-1,-1,x,y,which);
    }

    /**
     * which one is winner
     * @param p player
     * @param q player
     */
    public void winner(Player p,Player q)
    {
        System.out.println(player1.getName()+": "+player1.getSize());
        System.out.println(player2.getName()+": "+player2.getSize());
        if (p.getSize()>q.getSize())
            System.out.println("player1 is winner");
        if (p.getSize()<q.getSize())
            System.out.println("player2 is winner");
        if (p.getSize()==q.getSize())
            System.out.println("draw :|");
    }

    /**
     * value of cell for player : how many change cells
     * @param x x of cell
     * @param y y of cell
     * @param player player
     * @return value
     */
    public int value(int x , int y , Player player)
    {
        int value = 0;
        if (canBe(x,y,player) == 1)
        {
            if(check(1,1,x,y,player) == 1)
            {
                value = value - 1 + xNextCell(1,1,x,y,player) - x;
            }
            if(check(1,0,x,y,player) == 1)
            {
                value = value - 1 + xNextCell(1,0,x,y,player) - x;
            }
            if(check(1,-1,x,y,player) == 1)
            {
                value = value - 1 + xNextCell(1,-1,x,y,player) - x;
            }
            if(check(-1,1,x,y,player) == 1)
            {
                value = value - 1 - xNextCell(-1,1,x,y,player) + x;
            }
            if(check(-1,0,x,y,player) == 1)
            {
                value = value - 1 - xNextCell(-1,0,x,y,player) + x;
            }
            if(check(-1,-1,x,y,player) == 1)
            {
                value = value - 1 - xNextCell(-1,-1,x,y,player) + x;
            }
            if(check(0,1,x,y,player) == 1)
            {
                value = value - 1 + yNextCell(0,1,x,y,player) - y;
            }
            if(check(0,-1,x,y,player) == 1)
            {
                value = value - 1 - yNextCell(0,-1,x,y,player) + y;
            }
        }
        return value;
    }

    /**
     * maximum value fpor player
     * @param player player
     * @return maximum value
     */
    public int maxValue(Player player)
    {
        int max = 0;
        for (int i = 0;i < 8;i++)
        {
            for (int j = 0;j < 8;j++)
            {
                if(max < value(i,j,player))
                    max = value(i,j,player);
            }
        }
        return max;
    }

    /**
     * x of cell with maximum value
     * @param player player
     * @return x
     */
    public int xMaxValue(Player player)
    {
        int x = -1;
        for (int i = 0;i < 8;i++)
        {
            for (int j = 0;j < 8;j++)
            {
                if(value(i,j,player) == maxValue(player)) {
                    x = i;
                }
            }
        }
        return x;
    }
    /**
     * y of cell with maximum value
     * @param player player
     * @return y
     */
    public int yMaxValue(Player player)
    {
        int y = -1;
        int max = 0;
        for (int i = 0;i < 8;i++)
        {
            for (int j = 0;j < 8;j++)
            {
                if(value(i,j,player) == maxValue(player))
                    y = j;
            }
        }
        return y;
    }
}
