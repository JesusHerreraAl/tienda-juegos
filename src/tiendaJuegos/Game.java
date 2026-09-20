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

	public void aumentarStock(int cantidad) throws Exception {
		//IMPLEMENTAR MEJORA
		if(cantidad<=0) {
			throw new Exception("No puedes introducir una cantidad negativa ni cantidad 0");
		}
		this.stock = stock + cantidad;
	}

	public void reducirStock(int cantidad) throws Exception {
		//IMPLEMENTAR MEJORA
		if(stock-cantidad<0 || cantidad<=0) {
			throw new Exception("El stock no puede bajar menor que cero y la cantidad que quieres reducir no puede ser un numero negativo");
		}
		this.stock = stock - cantidad;
	}

	public boolean comprobarDisponibilidad() {
		boolean disponible = true;
		if (stock <= 0) {
			disponible = false;
		}
		return disponible;
	}
	//MENSAJE POR SI SE QUIERE USAR
	public void comprobarDisponibilidadMensaje() {
		if (stock <= 0) {
			System.out.println("El juego no esta disponible");
		} else {
			System.out.println("El juego esta disponible");
		}
	}

	public String toString() {
		return "\nNombre: " + title + "\nGenero: " 
	+ genero.toString() + "\nPrecio: " 
				+ price + "\nCantidad: " + stock +" \n";
	}

}
