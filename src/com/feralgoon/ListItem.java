package com.feralgoon;

public class ListItem implements Comparable
{
    private String itemName;
    private int amount;

    public ListItem(String itemName)
    {
        this.itemName = itemName;
        amount = 1;
    }

    public void increaseAmount()
    {
        amount++;
    }

    public int getAmount()
    {
        return amount;
    }

    public void decreaseAmount()
    {
        amount--;
    }

    public String toString()
    {
        return itemName;
    }

    @Override
    public int compareTo(Object o)
    {
        return this.toString().compareToIgnoreCase((o).toString());
    }
}
