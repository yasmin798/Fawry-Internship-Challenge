import java.util.ArrayList;
import java.util.List;

public class Order {
	private ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
        	System.out.println("Please add items to the cart");
        }else {

        double subtotal = 0;
        List<CartItem> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (item.getQuantity() > product.getQuantity()) 
            	throw new IllegalStateException(product.getName() + " is out of stock");
           
            if (product.isExpired()) 
            	throw new IllegalStateException(product.getName() + " is expired");
          
            subtotal += item.getSubtotal();
            
            if (item.needsShipping()) {
                shippableItems.add(item);
            }
        }

        double shippingFee = 0;
        if (!shippableItems.isEmpty()) {
            shippingFee = shippingService.ship(shippableItems);
        }

        double total = subtotal + shippingFee;

        if (total > customer.getBalance()) 
        	throw new IllegalStateException("Not enough balance");
        

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getSubtotal());
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFee);
        System.out.println("Amount " + total);

        customer.deductBalance(total);
        System.out.println("Customer balance: " + customer.getBalance());
    }}
}
