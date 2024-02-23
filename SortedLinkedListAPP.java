
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author julekhakhatun
 */
// SortedLinkedListApp class contains list of numbers.
public class SortedLinkedListAPP {

    /**
     * Adds a number to the Linkedlist in sorted order.
     *
     * <p>
     * If the list is empty, then just add number to the list, If the given
     * number is less then first number of list, then insert the given number as
     * the first number of the list. If the given number is greater then last
     * number in the list, insert given number to end of the list. Else find the
     * location of the given number in the list and insert the given number in
     * the list.
     *
     *
     * @param list the linked list to insert,
     * @param num the number to be inserted into the list in sorted order
     */
    public static void addElementInSortedOrder(LinkedList<Integer> list, int num) {
        //check if the list is empty, then add the number to the list 
        if (list.isEmpty()) {
            list.add(num);
        } 
        // If the given number is less than the first number in the list
        // then insert given number at the begining
        else if (list.get(0) > num) {  
            list.add(0, num);
        } 
        // If the given number is greater than last number in the list, then insert
        // the given number at the end.
        else if (list.get(list.size() - 1) < num) {
            list.add(list.size(), num);
        } 
        // otherwise find the location i for the given number such that all the numbers
        // at index less than i, are less than the given number and all the numbers at index
        // greater than i, are greater than the given number, then insert the given number at 
        // index i
        else {
            int i = 0;
            while (list.get(i) < num) {
                i++;
            }
            list.add(i, num);
        }
    }

    /**
     * Main method takes user input as comma separated string 
     * and split user input by ','. then convert the each string of number
     * to integer , then add to linkedlist in sorted order using addElementInSortedOrder
     * and finally print the elements of list in sorted order.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.print("Enter a list of integer numbers separated by comma: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LinkedList<Integer> linklist = new LinkedList<>();
        String[] numbersAsString = input.split(",");

        for (String s : numbersAsString) {
            int num = Integer.parseInt(s.trim());
            addElementInSortedOrder(linklist, num);
        }

        System.out.println("\nSorted linked list numbers are: ");
        for (int i = 0; i < linklist.size(); i++) {
            System.out.print(" " + linklist.get(i));
        }
        System.out.println("");

    }
}
