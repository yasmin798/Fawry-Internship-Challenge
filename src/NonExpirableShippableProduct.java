
public class NonExpirableShippableProduct extends Product implements Shippable {
	private double weight;

    public NonExpirableShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}
}
