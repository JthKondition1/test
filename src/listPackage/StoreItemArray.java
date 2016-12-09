/**
 *
 * @author Jason Heyer
 */
package listPackage;


public class StoreItemArray {
    private final StoreItem[] items;
    private int n; 

    public StoreItemArray() { 
        items = new StoreItem[100]; 
        n = 0;  
    }

       public void create(StoreItem storeItem) {
        items[n] = storeItem;
        n++;
    }
    
     @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++) {
            sb.append(items[i]).append("\n");
        }
        return sb.toString();
    }
}
