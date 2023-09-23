import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Tip Calculator");
        double total = 0;
        double totalWithTip = 0;
        double tip = 0;

        List<String> itemsList = new ArrayList<>();

        /*I learned to create and append a list here:
         https://www.digitalocean.com/community/tutorials/java-list-add-addall-methods */

        Scanner scan = new Scanner(System.in);
        System.out.println("How many people are in your group: ");
        int people = scan.nextInt();

        System.out.println("Whats the tip percentage? (0-100): ");
        int percent = scan.nextInt();

        double order = 0;

        while (order != -1) {
            System.out.println("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            order = scan.nextDouble();
            scan.nextLine();
            if (order == -1) {
                break;
            }
            System.out.println("Enter the item: ");
            String item = scan.nextLine();
            itemsList.add(item);

            total += order;
        }

        tip = total * ((double) percent /100);
        totalWithTip = total + tip;

        /*learned to round from:
        https://youtu.be/nLDWeTz3Zgc */

        total  = Math.round(total * 100)/100.0;
        tip  = Math.round(tip * 100)/100.0;
        totalWithTip = Math.round(totalWithTip * 100)/100.0;

        double costByPerson = (total / people);
        costByPerson = Math.round(costByPerson * 100)/100.0;

        double tipByPerson = (tip / people);
        tipByPerson = Math.round(tipByPerson * 100)/100.0;

        double costPersonWithTip = (totalWithTip / people);
        costPersonWithTip = Math.round(costPersonWithTip * 100)/100.0;

        //receipt
        System.out.println("---------------------------------");
        System.out.println("Total percentage: " + percent + "%");
        System.out.println("Total Before Tip: $" + total);
        System.out.println("Total Tip: $" + tip);
        System.out.println("Total bill with tip: $" + totalWithTip);
        System.out.println("Cost per person before tip: $" + costByPerson );
        System.out.println("Tip per person: $" + tipByPerson );
        System.out.println("Total cost per person: $" + costPersonWithTip );
        System.out.println("---------------------------------");
        System.out.println("Items Ordered: ");
        for (String items : itemsList) {
            System.out.println(items);
        }
    }

}