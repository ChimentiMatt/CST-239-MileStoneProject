package app;

public class RustySword {
	private String name;
	private int basePrice;
	private int quantity;
	private String description;
	
	RustySword(){
		this.name = "RustySword";
		this.basePrice = 5;
		this.quantity = 99;
		this.description = "A sword for those low on copper";
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getBasePrice() {
		return this.basePrice;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

	public void getDescription() {
		System.out.println("");
		System.out.println(this.name + ": " + this.description);
		System.out.println("");
	}
	
	public void reduceStock(int num) {
		this.quantity = this.quantity - num;
	}
	
	public void increaseStock() {
		this.quantity = this.quantity + 1;
	}

}
