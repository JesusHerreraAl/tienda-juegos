package tiendaJuegos;

public class Game {

	private int id;
	private String title;
	private Genre genero;
	private double price;
	private int stock;
	private static int contador=0;
	
	public Game (int id) {
		this.id=id;
	}
	
	public Game (String title, Genre genero, double price, int stock) {
		this.title=title;
		this.genero=genero;
		this.price=price;
		this.stock=stock;
		this.id=contador++;
	}
	//CONSTRUCTOR PARA RECIBIR PARAMETRO ID
	public Game(int id, String title, int stock , Genre genero, double price) {
		this.id=id;
		this.title=title;
		this.genero=genero;
		this.price=price;
		this.stock=stock;
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
	//MODIFICAR STOCK
	public void setStock(int stock) {
		
		this.stock = stock;
	}
	public void modificarStock(int cantidad) {
		
	}

	public void aumentarStock(int cantidad) throws Exception {
		//IMPLEMENTAR MEJORA
		if(cantidad<=0) {
			throw new Exception("No puedes introducir una cantidad negativa ni cantidad 0");
		}
		this.stock = stock + cantidad;
		
		/* VERSION PROFESORA
		if(cantidad>0) {
			aumentarStock(cantidad);
		}else {
			reducirStock(-cantidad);
		}*/
	}

	public void reducirStock(int cantidad) throws Exception {
		//IMPLEMENTAR MEJORA
		if(stock-cantidad<0 ) {
			throw new Exception("El stock no puede bajar menor que cero y la cantidad que quieres reducir no puede ser un numero negativo");
		}
		if (cantidad > stock) {
			throw new Exception("Cantidad mayor que el stock");
		}
		this.stock = stock - cantidad;
	}

	public boolean comprobarDisponibilidad(int cantidad) {
		/*boolean disponible = true;
		if (stock <= 0) {
			disponible = false;
		}
		return disponible;*/
		//COMPRUEBAS STOCK DE LA CANTIDAD QUE TU INTRODUCES
		return stock >=cantidad;
	}
	public boolean hayStock() {
		//COMPROBACION DE SI EXISTE STOCK
		return stock>0;
	}
	//MENSAJE POR SI SE QUIERE USAR
	public void comprobarDisponibilidadMensaje() {
		if (stock <= 0) {
			System.out.println("El juego no esta disponible");
		} else {
			System.out.println("El juego esta disponible");
		}
	}
	//STRING PARA IMPRIMIR CON FORMATO
	public String toText(){
		return String.format("""
				ID: %d
				Title: %s
				Genre: %s
				Price: %.2f
				Stock: %d
				"""
				, id, title, genero, price, stock);
	}

	public String toString() {
		return "\nNombre: " + title + "\nGenero: " 
	+ genero.toString() + "\nPrecio: " 
				+ price + "\nCantidad: " + stock +" \n";
	}
	@Override
	public boolean equals(Object other) {
		
		if(other==this) {
			return true;
		}
		//si el objeto que me has pasado no e sun juego
		if(!(other instanceof Game)) {
			return false;
		}
		
		Game g = (Game)other; //HACEMOS CAST DEL OBJETO COMO SABEMOS QUE ES UN JUEGO
		g.getId();
		//comparamos y devolvemos si los ID son iguales
		//PODEMOS AÑADIR MAS VALORES DE GAME
		return id==g.getId();
	}

}
