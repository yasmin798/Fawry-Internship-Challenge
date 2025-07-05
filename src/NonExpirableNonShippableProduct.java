
public class NonExpirableNonShippableProduct extends Product {

	public NonExpirableNonShippableProduct(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}
