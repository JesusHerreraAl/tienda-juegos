package tiendaJuegos;

public class Purchase {
	
	//REPRESENTA LAS COMPRAS DE LA TIENDAS DE UN CLIENTE
	
	private Customer customer; //CLIENTE 
	private Game game;
	private int quantity; //CANTIDAD
	private double totalPrice; //TOTAL DE LO QUE SE GASTO EN LOS JUEGOS
	
	public Purchase (Customer customer, Game game, int quantity, double precio) {
		this.customer=customer;
		this.game=game;
		this.quantity=quantity;
		this.totalPrice=game.getPrice()*quantity; //ENTENDER BIEN ESTA PARTE
	}
	public Purchase(Customer customer, Game game, int quantity) {
		this.customer=customer;
		this.game=game;
		this.quantity=quantity;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public Game getGame(){
		return game;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", game=" + game + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	
	
	
	
	
	
	

}
