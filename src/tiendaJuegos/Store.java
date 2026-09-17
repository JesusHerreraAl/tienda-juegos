package tiendaJuegos;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<Game> games;
	private ArrayList<Customer> customers;
	private ArrayList<Purchase> purchases;
	
	public Store () {
		//CREA LAS LISTAS VACIAS
		//METEMOS VALORES AHORA MISMO PARA IR PROBANDO
		games=new ArrayList<Game>();//vacio
		customers= new ArrayList<Customer>();
		purchases= new ArrayList<Purchase>();
	}

	public ArrayList<Game> getGames() {
		return games;
	}
	
	//METODO AÑADIR JUEGO Y NO SE PUEDE REPETIR ME FALTA 8.1

	public void setGames(ArrayList<Game> games) {
		//Tendria que crear un exception que no deje añadir otro juego con el mismo id
		this.games = games;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}
	//necesito metodo que pille de un juego del arraylist el id
	//en main hacer un bloque try catch
	public Game juegoPorId(int id) throws Exception{
		
		Game juegoObtenidoPorId=null;
		
		for(Game juego: games) {
			if(juego.getId()==id) {
				juegoObtenidoPorId=juego;
			}	
		}
		if (juegoObtenidoPorId==null){
			throw new Exception("Juego no encontrado");
		}
		return juegoObtenidoPorId;
		
	}
	//METODO PARA OBTENER CLIENTES POR ID EJERCICIO 8.3
	public Customer clientePorId(int id) throws Exception{
		Customer clienteObtenidoPorId=null;
		for (Customer cliente: customers) {
			if(cliente.getId()==id) {
				clienteObtenidoPorId=cliente;
			}
		}
		if(clienteObtenidoPorId==null) {
			throw new Exception ("Cliente no encontrado");
		}
		return clienteObtenidoPorId;
		
	}
	//METODO PARA BUSCAR POR TEXTO, CREO QUE DEVOLVERIA SOLO UN JUEGO EJERCICIO 8.4
	public Game buscarJuegoPorNombre(String nombre) throws Exception {
		Game juegoObtenidoPorNombre=null;
		for (Game juego: games) {
			if(juego.getTitle().toUpperCase().contains(nombre.toUpperCase())){
				juegoObtenidoPorNombre=juego;
			}
		}
		if (juegoObtenidoPorNombre==null) {
			throw new Exception ("No hay ningun juego que tenga esa palabra");
		}
		return juegoObtenidoPorNombre;
	}
	
	//METODO PARA HACER UNA LISTA CON LOS JUEGOS QUE CONTENGAN UNA PALABRA
	public ArrayList<Game> listaJuegosBuscadosPorNombre (String nombre) throws Exception{
		ArrayList<Game> listaConJuegosBuscados = new ArrayList <>();
		for(Game juego: games) {
			if(juego.getTitle().toUpperCase().contains(nombre.toUpperCase())){
				listaConJuegosBuscados.add(juego);
			}
		}
		if(listaConJuegosBuscados==null) {
			throw new Exception ("No hay ningun juego que tenga esa palabra");
		}
		
		return listaConJuegosBuscados;
		
	}
	//METODO PARA FILTRAR POR GENERO Y DEVOLVER UNA LISTA CON TODOS LOS JUEGOS DE ESE GENERO
	//EJERCICIO 8.5
	public ArrayList<Game> filtrarPorGenero (String genero) throws Exception {
		//QUIZAS PUEDO DECIR QUE RECIBA UN GENERO EN MAIN Y ESTE MISMO LO CONVIERTA A ENUM
		
		ArrayList<Game> listaConJuegosBuscados = new ArrayList <>();
		for(Game juego: games) {
			//SI EL GENERO DEL JUEGO CONVERTIDO A STRING ES IGUAL AL GENERO INTRODUCIDO COMO STRING
			if(juego.getGenre().toString().equalsIgnoreCase(genero)) {
				listaConJuegosBuscados.add(juego);
			}
		}
		if (listaConJuegosBuscados==null) {
			throw new Exception("No hay juegos con ese genero");
		}
		
		return listaConJuegosBuscados;
	}
	//METODO PARA COMPRAR VIDEOJUEGO PURCHASE
	public Purchase comprarVideojuego(int idCliente, int idJuego, int cantidad) throws Exception {
		
		if (cantidad<=0) {
			throw new Exception("La cantidad no puede ser menor que 0");
		}
		
		//MODIFICAR ESTA PARTE LUEGO 
		//Purchase compra = new Purchase(Customer customer, Game game, int quantity);
		return null;
	}
	
	

}

