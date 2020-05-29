/**
 * The player class represents a player in a othello game
 * @author Amirreza
 * @version 1.0
 */

import java.util.ArrayList;

public class Player
{
    //name of player
    private String name;
    //player : 1 ---> white -1 ---> black
    private int type;
    //list of cell
    private ArrayList<Cell> cells;
    /**
     * create player
     * @param name name of player
     * @param type tpe of player
     */
    public Player (String name , int type)
    {
        this.type = type;
        this.name = name;
        cells = new ArrayList<Cell>();
    }

    /**
     * get type
     * @return type field
     */
    public int getType()
    {
        return type;
    }
    /**
     * get name
     * @return name field
     */
    public String getName()
    {
        return name;
    }

    /**
     * add cell to cells
     * @param cell cell to add
     */
    public void addCell(Cell cell)
    {
        int j = 0;
        for (int i = 0;i < cells.size();i++)
        {
            if (cell.getX() == cells.get(i).getX() && cell.getY() == cells.get(i).getY())
                j = j + 1;
        }
        if (j == 0)
            cells.add(cell);
    }
    /**
     * remove cell of cells
     * @param cell cell to remove
     */
    public void removeCell(Cell cell)
    {
        int j = -1;
        for (int i = 0;i < cells.size();i++)
        {
            if (cell.getX() == cells.get(i).getX() && cell.getY() == cells.get(i).getY())
                j = i;
        }
        if (j != -1)
            cells.remove(j);
    }
    public int getSize()
    {
        return cells.size();
    }
}
