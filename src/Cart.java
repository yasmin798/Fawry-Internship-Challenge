import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) 
        	throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("Requested quantity exceeds stock for " + product.getName());
        if (product.isExpired())
            throw new IllegalArgumentException(product.getName() + " is expired");

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
    	return items;
    	}
    public boolean isEmpty() {
    	return items.isEmpty(); 
    	}
}
