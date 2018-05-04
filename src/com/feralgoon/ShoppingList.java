/*======================================
    This area is to follow along with
    how louis does parts of the code.
========================================

String input = scan.nextLine();
String[] words = input.split(" ");
String firstEntryCommand = words[0].toUpperCase();


with while(firstEntryCommand.equals("EXIT"); at end of do while loop
can use switch statement for firstEntryCommand after splitting string.

*/

package com.feralgoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShoppingList
{
    private void run()
    {
        List<String> itemList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String input;
        printHeader();

        do
        {
            printOptions();
            System.out.println();
            System.out.println("What would you like to do?");
            input = scan.nextLine();

            handleChoice(itemList, input);

        }while (!input.equalsIgnoreCase("Exit"));

        System.out.println("Exiting Program...");
    }

    private boolean findItem(List<String> itemList, String item)
    {
        Boolean found = false;

        for(String s : itemList)
        {
            if (s.equals(item))
            {
                found = true;
            }
        }
        return found;
    }

    private void sortList(List<String> itemList)
    {
        Collections.sort(itemList);
    }

    private void handleChoice(List<String> itemList, String input)
    {
        if (input.startsWith("Add"))
        {
            itemList.add(input.substring(4));
            System.out.println("Added " + input.substring(4) + " to list.");
            System.out.println();
        }
        else if (input.startsWith("Find"))
        {
            String item = input.substring(5);
            boolean found = findItem(itemList,item);

            if (found)
            {
                System.out.println("Item Found!");
            }
            else
            {
                System.out.println("No Such Item!");
            }
            System.out.println();
        }
        else if (input.startsWith("Print"))
        {
            if (itemList.size() == 0)
            {
                System.out.println("List is Empty.");
            }

            for(int i = 0; i < itemList.size(); i ++)
            {
                System.out.println(i + " " + itemList.get(i));
            }
            System.out.println();
        }
        else if (input.startsWith("Remove"))
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
            else
            {
                System.out.println("Removed " + itemList.get(selection) + " from list.");
                itemList.remove(selection);
            }
            System.out.println();
        }
        else if (input.startsWith("Sort"))
        {
            sortList(itemList);
            System.out.println("List sorted.");
            System.out.println();
        }
        else if (input.startsWith("Clear"))
        {
            itemList.clear();
            System.out.println("Item list cleared!");
            System.out.println();
        }
        else if (!input.equals("Exit"))
        {
            System.out.println("Invalid Command.");
            System.out.println();
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
        ShoppingList shoppingList = new ShoppingList();

        shoppingList.run();
    }
}
