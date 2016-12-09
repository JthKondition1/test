/**
 * Menu of options for store items. 
 * @author Jason Heyer
 */
package listPackage;

import java.util.Scanner;
import utilities.Prompt;

public class StoreItemAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOstoreItem data = new DAOstoreItem();
    int[] x = new int [2000];
    public StoreItemAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        String section;
        double price;
        int quantity;
        double weight;

        while (choice != 0) {
            System.out.println("\nStore Items");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Name");
            System.out.println("8 = Retrieve All: Order by Section");
            System.out.println("9 = Retrieve All: Order by Price");
            System.out.println("10 = Retrieve All: Order by Quantity");
            System.out.println("11 = Retrieve All: Order by Quantity / Price Descending");
            System.out.println("12 = Retrieve All: Order by Quantity / Price Descending version 2");
            System.out.println("13 = Retrieve All: Order by Weight");
            System.out.println("14 = Statistics for Quantity");
            choice = Prompt.getInt("Number of choice: ", 0, 14);
            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter Item id: ");
                name = Prompt.getLine("Enter Name(Label): ");
                section = Prompt.getLine("Enter Section: ");
                price = Prompt.getDouble("Enter Price: ");
                quantity = Prompt.getInt("Enter Quantity: ");
                weight = Prompt.getDouble("Enter Weight: ");
                StoreItem storeItem = new StoreItem(id, name, section, price, quantity, weight);
                data.create(storeItem);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter item id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {
                id = Prompt.getInt("Enter item id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByName());
            } else if (choice == 8) {
                System.out.println(data.orderBySection());
            } else if (choice == 9) {
                System.out.println(data.orderByPrice());
            } else if (choice == 10) {
                System.out.println(data.orderByQuantity());
            } else if (choice == 11) {
                System.out.println(data.orderByQuantityPrice());
            } else if (choice == 12) {
                System.out.println(data.orderByQuantityPriceRev());
            } else if (choice == 13) {
                System.out.println(data.orderByWeight());
            } else if (choice == 14) { 
                this.x = data.quantityArray(x);
                System.out.println("Statistics for Quantity:");
                //System.out.println(Arrays.toString(data.quantityStats(qArray)));
                System.out.println("Total items: " + data.sumQ());
                System.out.println("Highest value: " + data.maxQ(x));
                System.out.println("Lowest value: ");
                System.out.println("Average: ");
                System.out.println("Standard deviation: "); 
            } else if (choice == 0) {
                ;
            }

        }
    }

    public static void main(String[] args) {
        StoreItemAppMenu Menu = new StoreItemAppMenu();
        System.out.println(Menu);
    }
}
