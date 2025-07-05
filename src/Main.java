import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
        // Create products
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 8, 1), 200);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, LocalDate.of(2025, 9, 1), 700);
        Product tv = new NonExpirableShippableProduct("TV", 1000, 2, 5000);
        Product scratchCard = new ExpirableNonShippableProduct("Mobile Scratch Card", 50, 10, LocalDate.of(2025, 12, 1));

        Customer customer = new Customer("John Doe", 1000);
        Cart cart = new Cart();

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            Order order1 = new Order();
            order1.checkout(customer, cart);

            // Test: empty cart
            System.out.println("\n--- Testing empty cart ---");
            Cart emptyCart = new Cart();
            order1.checkout(customer, emptyCart);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test: insufficient balance
            System.out.println("\n--- Testing insufficient balance ---");
            Cart expensiveCart = new Cart();
            expensiveCart.add(tv, 2);
            Order order2 = new Order();
            order2.checkout(customer, expensiveCart);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test: out of stock
            System.out.println("\n--- Testing out of stock ---");
            Cart outOfStockCart = new Cart();
            outOfStockCart.add(cheese, 10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
