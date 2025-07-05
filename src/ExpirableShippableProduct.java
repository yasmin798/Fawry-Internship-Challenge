import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Shippable {
	 private LocalDate expiryDate;
	    private double weight;

	    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
	        super(name, price, quantity);
	        this.expiryDate = expiryDate;
	        this.weight = weight;
	    }

	   
	    public boolean isExpired() {
	        return LocalDate.now().isAfter(expiryDate);
	    }

	    
	    public double getWeight() { 
	    	return weight;
	    	}
}
