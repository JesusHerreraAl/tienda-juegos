package tiendaJuegos;

public class Game {

	private int id;
	private String title;
	private Genre genero;
	private double price;
	private int stock;
	private static int contador=0;
	
	public Game() {
		this.id=contador++;
	}
	
	public Game (String title, Genre genero, double price, int stock) {
		this.title=title;
		this.genero=genero;
		this.price=price;
		this.stock=stock;
		this.id=contador++;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Genre getGenre() {
		return genero;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void aumentarStock(int cantidad) {
		//IMPLEMENTAR MEJORA
		this.stock = stock + cantidad;
	}

	public void reducirStock(int cantidad) {
		//IMPLEMENTAR MEJORA
		
		this.stock = stock - cantidad;
	}

	public boolean comprobarDisponibilidad() {
		boolean disponible = true;
		if (stock <= 0) {
			disponible = false;
		}
		return disponible;
	}

	public void comprobarDisponibilidadMensaje() {
		if (stock <= 0) {
			System.out.println("El juego no esta disponible");
		} else {
			System.out.println("El juego esta disponible");
		}
	}

	public String toString() {
		return "Nombre: " + title + "\nGenero: " 
	+ genero.toString() + "\nPrecio: " 
				+ price + "\nCantidad: " + stock;
	}

}
