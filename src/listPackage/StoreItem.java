/**
 * StoreItem class. Represents an item you would find in a store. 
 * Comment 2.
 * @author Jason Heyer 
 */
package listPackage;

public class StoreItem {

    private int id;
    private int quantity;
    private String section;
    private String name;
    private double price;
    private double weight; 
    
    public StoreItem() {

    }

    public StoreItem(int id, String name, String section, double price, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        //return "storeItem{" + "id=" + id + ", quantity=" + quantity + ", section=" + section + ", name=" + name + ", price=" + price + ", weight=" + weight + '}';
        //return String.format("%d, %d, %s,  %-8s %8.2f, %8.2f", id, quantity, section, name, price, weight);
        return String.format("%d %-12s %-12s %-5.2f %-4d %-7.3f", id, name, section, price, quantity, weight);
            //public StoreItem(int id, String name, String section, double price, int quantity, double weight) {
    }

}
