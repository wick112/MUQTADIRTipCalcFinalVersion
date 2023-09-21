import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Tip Calculator");
        double total = 0;
        double totalWithTip = 0;
        double tip = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("How many people are in your group: ");
        int people = scan.nextInt();

        System.out.println("Whats the tip percentage? (0-100): ");
        int percent = scan.nextInt();

        double order = 0;

        while (order != -1) {
            System.out.println("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            order = scan.nextDouble();
            total += order;
        }

        tip = total * percent;
        totalWithTip = total + tip;


        System.out.println("---------------------------------");
        System.out.println("Total percentage: " + percent + "%");
        System.out.println("Total Before Tip: " + (total + 1));
        System.out.println("Total Tip: $" + tip);
        System.out.println("Total bill with tip: $" + totalWithTip);

    }
}