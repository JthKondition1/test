/**
 *
 * @author Jason Heyer
 */
package listPackage;

public class StoreItemApp {

    public static void main(String[] args) {
// public StoreItem(int id, String name, String section, double price, int quantity, double weight)
        StoreItem item1 = new StoreItem(1,"Kiwi", "Fruit", 3.00, 1, 12);
        StoreItem item2 = new StoreItem(2,"Chips", "Snack", 4.29, 1, 32);
        StoreItem item3 = new StoreItem(3,"Milk", "Dairy", 5.00, 1, 16); 
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(" ");
        
        StoreItemArray sa = new StoreItemArray(); 
        sa.create(new StoreItem(1,"Kiwi", "Fruit", 3.00, 1, 12));
        sa.create(new StoreItem(2,"Chips", "Snack", 4.29, 1, 32));
        sa.create(new StoreItem(3,"Milk", "Dairy", 5.00, 1, 16)); 
        System.out.println(sa);
        
    }

}

   
