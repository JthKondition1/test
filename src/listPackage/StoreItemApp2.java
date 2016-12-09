/**
 *
 * @author Jason Heyer
 */
package listPackage;

public class StoreItemApp2 {

    public static void main(String[] args) {
        System.out.println("StoreItem App 2");
        // public StoreItem(int id, String name, String section, double price, int quantity, double weight)
        DAOstoreItem data = new DAOstoreItem();
//        data.create(new StoreItem(1, "Kiwi", "Fruit", 3.00, 1, 12));
//        data.create(new StoreItem(2, "Chips", "Snack", 4.29, 1, 32));
//        data.create(new StoreItem(3, "Milk", "Dairy", 5.00, 1, 16));
//        System.out.println(data);
//
////        System.out.println(data.retrieve(1)); 
////        System.out.println(data.retrieve(3)); 
//        StoreItem item2 = new StoreItem(2, "Eggs", "Dairy", 2.50, 1, 23.17);
//        data.update(item2);
//        System.out.println(data);
////         
       data.delete(4);
        System.out.println(data);
     
    }

}
