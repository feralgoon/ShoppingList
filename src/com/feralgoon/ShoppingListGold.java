package com.feralgoon;

import java.util.*;

public class ShoppingListGold
{

    private List<ListItem> itemList;

    private ShoppingListGold()
    {
        itemList = new ArrayList<>();
    }

    private void run()
    {

        Scanner scan = new Scanner(System.in);
        String input;
        printHeader();

        do
        {
            printOptions();
            System.out.println();
            System.out.println("What would you like to do?");
            input = scan.nextLine();

            handleChoice(input);

        }while (!input.equalsIgnoreCase("Exit"));

        System.out.println("Exiting Program...");
    }

    //Returns the index of the found item, or if not found, finds -1.
    private int findItem(String item)
    {
        int found = -1;

        for(int i = 0; i < itemList.size(); i++)
        {
            if (itemList.get(i).toString().equalsIgnoreCase(item))
            {
                found = i;
                break;
            }
        }
        return found;
    }


    private void handleChoice(String input)
    {
        if (input.toUpperCase().startsWith("ADD"))
        {
            addItem(input);
        }
        else if (input.toUpperCase().startsWith("FIND"))
        {
            String item = input.substring(5);
            int found = findItem(item);

            if (found == -1)
            {
                System.out.println("No Such Item!");
            }
            else
            {
                System.out.println("Item Found!");
            }
            System.out.println();
        }
        else if (input.toUpperCase().startsWith("PRINT"))
        {
           printList();
        }
        else if (input.toUpperCase().startsWith("REMOVE"))
        {
           removeItem(input);
        }
        else if (input.toUpperCase().startsWith("SORT"))
        {
            Collections.sort(itemList);
            System.out.println("List sorted.");
            System.out.println();
        }
        else if (input.toUpperCase().startsWith("CLEAR"))
        {
            itemList.clear();
            System.out.println("Item list cleared!");
            System.out.println();
        }
        else if (!input.toUpperCase().equals("EXIT"))
        {
            System.out.println("Invalid Command.");
            System.out.println();
        }
    }

    private void printList()
    {
        if (itemList.size() == 0)
        {
            System.out.println("List is Empty.");
        }
        else
        {
            System.out.println("Index\t\tCount\t\tItem Name");
            System.out.println("---------------------------------");
            for(int i = 0; i < itemList.size(); i ++)
            {
                System.out.println(i + "\t\t\t" + itemList.get(i).getAmount() + "\t\t\t" + itemList.get(i));
            }
        }
        System.out.println();
    }

    private void removeItem(String input)
    {
        int selection;

        try
        {
            selection = Integer.parseInt(input.substring(7));
        } catch (NumberFormatException e)
        {
            System.out.println("Invalid Item Selection");
            System.out.println();

            return;
        }

        if (selection >= itemList.size() || selection < 0)
        {
            System.out.println("Invalid item selection.");
        }
        else if (itemList.get(selection).getAmount() > 1)
        {
            System.out.println("Removed 1 " + itemList.get(selection) + " from list.");
            itemList.get(selection).decreaseAmount();
        }
        else
        {
            System.out.println("Removed " + itemList.get(selection) + " from list.");
            itemList.remove(selection);
        }
        System.out.println();
    }

    private void addItem(String itemName)
    {
        int itemIndex = findItem(itemName.substring(4));

        if (itemIndex == -1)
        {
            itemList.add(new ListItem(itemName.substring(4)));
            System.out.println("Added " + itemName.substring(4) + " to list.");
            System.out.println();
        }
        else if (itemList.get(itemIndex).getAmount() == 5)
        {
            System.out.println();
            System.out.println("I'm sorry, Dave, I'm afraid I can't do that.");
            System.out.println();
        }
        else
        {
            itemList.get(itemIndex).increaseAmount();
            System.out.println("Added 1 " + itemName.substring(4) + " to list.");
        }
    }

    private void printOptions()
    {
        System.out.println("Options: ");
        System.out.println("Add <item name>");
        System.out.println("Print List");
        System.out.println("Find <item name>");
        System.out.println("Remove <item index>");
        System.out.println("Sort List Alphabetically");
        System.out.println("Clear");
        System.out.println("Exit");
        System.out.println();

    }

    private void printHeader()
    {
        System.out.println("--------------------------");
        System.out.println("|Groovy Shopping List App|");
        System.out.println("--------------------------");
        System.out.println();
    }

    public static void main(String[] args)
    {
        ShoppingListGold shoppingListGold = new ShoppingListGold();

        shoppingListGold.run();
    }
}
