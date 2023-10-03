import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        System.out.println("Welcome to my Tip Calculator");
        double total = 0;
        double totalWithTip = 0;
        double tip = 0;

        List<String> itemsList = new ArrayList<>();
        List<String> Menu = List.of( /*appetizer*/"Buffalo Wings", "Crab Cakes", "Nachos", /* entree */"Fillet Mignon", "Spaghetti with Meatballs", "Butter Chicken", /* dessert */ "Chocolate Lava Cake", "Creme Brulee", "Apple Tart");
        List<String> MenuPrice = List.of( /*appetizer*/"$6.50", "$6.25", "$5.50", /* entree */"$25.50", "$17.00", "$20.00", /* dessert */ "$8.25", "$12.00", "$4.50");
        /*I learned to create and append a list here:
         https://www.digitalocean.com/community/tutorials/java-list-add-addall-methods */

        //Prints menu when the user first runs the code with menu items and its corresponding price
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------*MENU*----------------");
        System.out.println("Appetizers: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(Menu.get(i));
            System.out.println("----" + MenuPrice.get(i));
        }
        System.out.println("-------------------------------------");
        System.out.println("Entree's: ");
        for (int i = 3; i < 6; i++) {
            System.out.print(Menu.get(i));
            System.out.println("----" + MenuPrice.get(i));
        }
        System.out.println("-------------------------------------");
        System.out.println("Dessert's: ");
        for (int i = 6; i <= 8; i++) {
            System.out.print(Menu.get(i));
            System.out.println("----" + MenuPrice.get(i));
        }
        System.out.println("-------------------------------------");
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
            //Only accepts real food items present on the menu and prompts the user to enter a correct value
            boolean found = false;
            while (found != true){
                for (String choice : Menu) {
                    if (choice.equals(item)) {
                        found = true;
                        itemsList.add(item);
                    }
                }
                if (!found){
                    System.out.println("Try again");
                    System.out.print("Enter an option from the menu: ");
                    item = scan.nextLine();
                }
            }
            total += order;
        }
        tip = total * ((double) percent /100);
        totalWithTip = total + tip;

        /*learned to round from:
        https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/ */

        //rounds all neccessary printed statements to the nearest hundreths

        double costByPerson = (total / people);
        double tipByPerson = (tip / people);
        double costPersonWithTip = (totalWithTip / people);


        //receipt -- prints out all required values including the list of items ordered
        //df.format() method rounds each value to the hundreths place
        System.out.println("---------------------------------");
        System.out.println("Total Percentage: " + percent + "%");
        System.out.println("Total before tip: $" + df.format(total));
        System.out.println("Total Tip: $" + df.format(tip));
        System.out.println("Total bill with tip: $" + df.format(totalWithTip));
        System.out.println("Cost per person before tip: $" + df.format(costByPerson));
        System.out.println("Tip per person: $" + df.format(tipByPerson));
        System.out.println("Total cost per person: $" + df.format(costPersonWithTip));
        System.out.println("---------------------------------");
        System.out.println("Items Ordered: ");
        System.out.println("--------------");

        for (String items : itemsList) {
            System.out.println(items);
        }
    }
}