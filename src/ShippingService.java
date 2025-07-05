import java.util.List;

public class ShippingService {
    public double ship(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (CartItem item : items) {
            Shippable shipItem = (Shippable) item.getProduct();
            for (int i = 0; i < item.getQuantity(); i++) {
                System.out.println("1x " + shipItem.getName() + " " + shipItem.getWeight() + "g");
                totalWeight += shipItem.getWeight();
            }
        }
        System.out.println("Total package weight " + (totalWeight / 1000) + "kg");
        return (totalWeight / 1000) * 10; // $10 per kg
    }
}