/**
 * The Cell class represents a cell in a othello map
 * @author Amirreza
 * @version 1.0
 */

public class Cell
{
    //x of cell : 0 <= x < 9
    private int x;
    //y of cell : 0 <= y < 9
    private int y;
    //type of cell : 1 ---> white and -1 ---> black and 0 ---> nothing
    private int type;

    /**
     * create new marble
     * @param x x of marble
     * @param y y of marble
     * @param type type of marble
     */
    public Cell(int x , int y , int type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * set a cell
     * @param type type of cell
     * @return 1:can , 0:cant
     */
    public void setCell(int type)
    {
        if (type == 0)
        {
            System.out.println(":/");
        }
        this.type = type;
    }
    /**
     * get type of marble
     * @return type
     */
    public int getType()
    {
        return type;
    }
    /**
     * change type of marble
     */
    public void changeType()
    {
        this.type = this.type * - 1;
    }
    /**
     * get x of cell
     * @return x field
     */
    public int getX()
    {
        return x;
    }
    /**
     * get y of cell
     * @return y field
     */
    public int getY()
    {
        return y;
    }
}