import java.time.LocalDate;

public class ExpirableNonShippableProduct extends Product {
	 private LocalDate expiryDate;

	    public ExpirableNonShippableProduct(String name, double price, int quantity, LocalDate expiryDate) {
	        super(name, price, quantity);
	        this.expiryDate = expiryDate;
	    }
	@Override
	public boolean isExpired() {
		 return LocalDate.now().isAfter(expiryDate);
	}

}
