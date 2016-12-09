/**
 * Data Access Object for StoreItem class. 
 * @author Jason Heyer
 */
package listPackage;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOstoreItem {

    private final String fileName = "itemdata.txt";
    private List<StoreItem> itemList;
    private int[] x = new int[2000];    
    private int n;

    public DAOstoreItem() {

        itemList = new ArrayList();

        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOstoreItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public int[] quantityArray(int[] x) {
           //  qArray = new int[2000];
        int count = 0;
        for (StoreItem storeItem : itemList) {
            this.x[count] = storeItem.getQuantity();
            count++;
        }
        return this.x;
    }

    public int sumQ() {
        for (StoreItem qu: itemList) { 
            n+=qu.getQuantity(); 
        }
        return this.n;
    }

        public int maxQ(int[] x) {
        int biggest = Integer.MIN_VALUE; //starts at smallest value
        // System.out.println("The biggest int is " + biggest);
        for (int i = 0; i < x.length; i++) {
            if (x[i] > biggest) {
                biggest = x[i];
            }
        }
        return biggest;

    }
    
    public void create(StoreItem storeItem) {
        itemList.add(storeItem);
        writeList();
    }

    public StoreItem retrieve(int id) {
        for (StoreItem storeItem : itemList) {
            if (storeItem.getId() == id) {
                return storeItem;
            }
        }
        return null;
    }

    public void update(StoreItem storeItem) {
        for (StoreItem s : itemList) {
            if (s.getId() == storeItem.getId()) {
                s.setName(storeItem.getName());
                s.setSection(storeItem.getSection());
                s.setPrice(storeItem.getPrice());
                s.setQuantity(storeItem.getQuantity());
                s.setWeight(storeItem.getWeight());
                break;
            }
        }
        writeList();
    }

    public void delete(int id) {
        StoreItem myItem = null;
        for (StoreItem s : itemList) {
            if (id == s.getId()) {
                myItem = s;
                break;
            }
        }
        itemList.remove(myItem);
//        itemList.stream().filter((storeItem) -> (id == storeItem.getId())).forEach(itemList::remove);
        writeList();
    }

    public String orderById() {
        itemList.sort(Comparator.comparing(StoreItem::getId));
        return this.toString();
    }

    public String orderByName() {
        itemList.sort(Comparator.comparing(StoreItem::getName));
        return this.toString();
    }

    public String orderBySection() {
        itemList.sort(Comparator.comparing(StoreItem::getSection));
        return this.toString();
    }

    public String orderByPrice() {
        itemList.sort(Comparator.comparing(StoreItem::getPrice));
        return this.toString();
    }

    public String orderByQuantity() {
        itemList.sort(Comparator.comparing(StoreItem::getQuantity));
        return this.toString();
    }

    public String orderByQuantityPrice() {
        itemList.sort(Comparator.comparing(StoreItem::getQuantity).thenComparing(StoreItem::getPrice));
        return this.toString();
    }

    public String orderByQuantityPriceRev() {
        itemList.sort(Comparator.comparing(StoreItem::getQuantity).thenComparing(StoreItem::getPrice).reversed());
        return this.toString();
    }

    public String orderByWeight() {
        itemList.sort(Comparator.comparing(StoreItem::getWeight));
        return this.toString();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data; //.split(",")
                data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String section = data[2];
                double price = Double.parseDouble(data[3]);
                int quantity = Integer.parseInt(data[4]);
                double weight = Double.parseDouble(data[5]);
                StoreItem myitem = new StoreItem(id, name, section, price, quantity, weight);
                itemList.add(myitem);

            }
        } catch (IOException ex) {
            Logger.getLogger(StoreItem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (StoreItem storeItem : itemList) {
                writer.write(String.format("%d,%s,%s,%.2f,%d,%.3f\n",
                        storeItem.getId(),
                        storeItem.getName(),
                        storeItem.getSection(),
                        storeItem.getPrice(),
                        storeItem.getQuantity(),
                        storeItem.getWeight()));

            }
        } catch (IOException ex) {
            Logger.getLogger(DAOstoreItem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        //return "Item{" + "itemList=" + itemList + '}'; 
        StringBuilder sb = new StringBuilder();
        for (StoreItem storeItem : itemList) {              //for each loop
            sb.append(storeItem).append("\n");
        }
        return sb.toString();
    }
}
