
public class CartItem {
	private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public boolean needsShipping() {
        return product instanceof Shippable;
    }
}
