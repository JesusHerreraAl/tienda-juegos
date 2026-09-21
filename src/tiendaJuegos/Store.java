package tiendaJuegos;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

	private ArrayList<Game> games;
	private ArrayList<Customer> customers;
	private ArrayList<Purchase> purchases;

	public Store() {
		// CREA LAS LISTAS VACIAS
		// METEMOS VALORES AHORA MISMO PARA IR PROBANDO
		games = new ArrayList<Game>();// vacio
		customers = new ArrayList<Customer>();
		purchases = new ArrayList<Purchase>();
		
		/*AQUI PODEMOS CREAR LOS JUEGOS PARA HACER PRUEBAS*/
	}
	
	public void loadGames(String filename) {
		//FILE REPRESENTA EL ARCHIVO Y SE LE PASARA UNA RUTA 
		File file = new File(filename);
		try(Scanner scanner= new Scanner(file)){
			String line = null;
			//MIENTRAS SIGA HABIENDO LINEA ESTARA DENTRO DEL BUCLE
			while(scanner.hasNextLine()) {
				//ESA LINEA ESTA GUARDADA EN LINE
				line=scanner.nextLine();
				//TENDREMOS UN STRING USANDO SEPARADORES ; cada parteser un string guardado
				
				String [] splitLine =line.split(";");
				int id= Integer.parseInt(splitLine[0]);
				String name= splitLine[1];
				Genre genre= Genre.valueOf(splitLine[2]);
				double price= Double.parseDouble(splitLine[3]);
				int stock=Integer.parseInt(splitLine[4]);
				//CONSTRUCTOR: int id, String title, int stock , Genre genero, double price
				Game g= new Game(id, name, stock, genre, price);
				games.add(g);
			}
		}catch(Exception e) {
			//imprimir "no se pudo cargar el archivo"
			System.out.println("No se pudo cargar el archivo");
		}
	}
	public void loadCustomers(String filename) {
		File file = new File (filename);
		try(Scanner scanner =new Scanner(file)){
			String line= null;
			while(scanner.hasNextLine()) {
				line=scanner.nextLine();
				String [] splitLine=line.split(";");
				int id=Integer.parseInt(splitLine[0]);
				String name=splitLine[1];
				double balance=Double.parseDouble(splitLine[2]);
				//int id, String name, double balance
				Customer c=new Customer(id, name, balance);
				customers.add(c);
			}
		}catch(Exception e) {
			System.out.println("Error al cargar el archivo");
		}
	}
	

	public ArrayList<Game> getGames() {
		return games;
	}

	// METODO AÑADIR JUEGO Y NO SE PUEDE REPETIR 8.1
	public void addVideojuego(Game juegoNuevo) throws Exception {

		// ANTES DE AÑADIR EL JUEGO QUE RECIBO ES COMPROBAR QUE ESE JUEGO NO SEA NULO.
		if (juegoNuevo == null) {
			throw new Exception("El juego es nulo");
		}
		// BUCLE QUE RECORRERA LA LISTA DE VIDEOJUEGOS PARA COMPROBAR QUE ESE JUEGO
		// NUEVO
		// NO ESTA DENTRO DE LA LISTA CON ESE MISMO ID, ES DECIR QUE NO SE REPITA EL ID
		/*
		 * HECHO POR MI
		 * for (Game juego : games) {
			if (juegoNuevo.getId() == juego.getId()) {
				throw new Exception("El juego con ese id ya existe, por lo tanto no se podra guardar");
			}
		}
		// SE GUARDA EL JUEGONUEVO A LA LISTA DE GAMES
		games.add(juegoNuevo);*/
		
		//DENTRO USAMOS EL EQUALS DE LA CLASE GAME
		for(Game juego: games) {
			//TU DEFINES QUE JUEGO SON IGUALES EN EQUALS DE GAME
			if(juegoNuevo.equals(juego)) {
				throw new Exception("El juego con id xx ya existe");
			}
		}
		games.add(juegoNuevo);

	}
	
	/*
	 * METODO PARA AÑADIR CLIENTES A LA LISTA DE CLIENTE DE STORE
	 */
	public void addCliente(Customer clienteNuevo) throws Exception {
		//QUE EL CLIENTE NO ES NULO
		if(clienteNuevo==null) {
			throw new Exception("El cliente no existe o es nulo");
			
		}
		//COMPROBAMOS QUE NO TENGA ID REPETIDO
		for(Customer cliente: customers) {
			if(clienteNuevo.getId()==cliente.getId()) {
				throw new Exception("Ya hay clientes con ese ID");
			}
		}
		//SI PASA LOS FILTROS ANTERIORES LO AGREGAMOS
		customers.add(clienteNuevo);
	}

	/*
	 * metodo generado automaticamente, no lo usare public void
	 * setGames(ArrayList<Game> games) { }
	 */

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	/*
	 * metodo generado automaticamente, no lo usare public void
	 * setCustomers(ArrayList<Customer> customers) { this.customers = customers; }
	 */

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}
	/*
	 * metodo generado automaticamente, no lo usare public void
	 * setPurchases(ArrayList<Purchase> purchases) { this.purchases = purchases; }
	 */

	/*
	 * NOTA: necesito metodo que pille de un juego del arraylist el id en main hacer
	 * un bloque try catch
	 */
	
	
	/*
	 *ESTE METODO ES PARA OBTENER UN JUEGO CON UN ID 
	 */
	public Game juegoPorId(int id) throws Exception {

		Game juegoObtenidoPorId = null;

		for (Game juego : games) {
			if (juego.getId() == id) {
				juegoObtenidoPorId = juego;
			}
		}
		if (juegoObtenidoPorId == null) {
			throw new Exception("Juego no encontrado");
		}
		return juegoObtenidoPorId;
		
		/*
		 * EJEMPLO PROFESOR
		 * for (Game juego: games){
			if(juego.getId()==id) {
				return juego;
			}
		}
		return null;*/

	}

	// METODO PARA OBTENER CLIENTES POR ID EJERCICIO 8.3
	public Customer clientePorId(int id) throws Exception {
		Customer clienteObtenidoPorId = null;
		for (Customer cliente : customers) {
			if (cliente.getId() == id) {
				clienteObtenidoPorId = cliente;
			}
		}
		if (clienteObtenidoPorId == null) {
			throw new Exception("Cliente no encontrado");
		}
		return clienteObtenidoPorId;

	}

	// METODO PARA BUSCAR POR TEXTO, CREO QUE DEVOLVERIA SOLO UN JUEGO EJERCICIO 8.4
	public Game buscarJuegoPorNombre(String nombre) throws Exception {
		Game juegoObtenidoPorNombre = null;
		for (Game juego : games) {
			if (juego.getTitle().toUpperCase().contains(nombre.toUpperCase())) {
				juegoObtenidoPorNombre = juego;
			}
		}
		if (juegoObtenidoPorNombre == null) {
			throw new Exception("No hay ningun juego que tenga esa palabra");
		}
		return juegoObtenidoPorNombre;
	}

	// METODO PARA HACER UNA LISTA CON LOS JUEGOS QUE CONTENGAN UNA PALABRA 8.4
	public ArrayList<Game> listaJuegosBuscadosPorNombre(String nombre) throws Exception {
		ArrayList<Game> listaConJuegosBuscados = new ArrayList<>();
		for (Game juego : games) {
			if (juego.getTitle().toUpperCase().contains(nombre.toUpperCase())) {
				listaConJuegosBuscados.add(juego);
			}
		}
		if (listaConJuegosBuscados == null) {
			throw new Exception("No hay ningun juego que tenga esa palabra");
		}

		return listaConJuegosBuscados;

	}

	// METODO PARA FILTRAR POR GENERO Y DEVOLVER UNA LISTA CON TODOS LOS JUEGOS DE
	// ESE GENERO
	// EJERCICIO 8.5
	public ArrayList<Game> filtrarPorGenero(String genero) throws Exception {
		// QUIZAS PUEDO DECIR QUE RECIBA UN GENERO EN MAIN Y ESTE MISMO LO CONVIERTA A
		// ENUM

		ArrayList<Game> listaConJuegosBuscados = new ArrayList<>();
		for (Game juego : games) {
			// SI EL GENERO DEL JUEGO CONVERTIDO A STRING ES IGUAL AL GENERO INTRODUCIDO
			// COMO STRING
			if (juego.getGenre().toString().equalsIgnoreCase(genero)) {
				listaConJuegosBuscados.add(juego);
			}
		}
		if (listaConJuegosBuscados == null) {
			throw new Exception("No hay juegos con ese genero");
		}

		return listaConJuegosBuscados;
	}
	public ArrayList<Game> filtrarPorGeneroENUM(Genre genero) throws Exception {

		ArrayList<Game> listaConJuegosBuscados = new ArrayList<>();
		for (Game juego : games) {
			// SI EL GENERO DEL JUEGO CONVERTIDO A STRING ES IGUAL AL GENERO INTRODUCIDO
			// COMO STRING
			if (juego.getGenre()==genero) {
				listaConJuegosBuscados.add(juego);
			}
		}
		if (listaConJuegosBuscados == null) {
			throw new Exception("No hay juegos con ese genero");
		}

		return listaConJuegosBuscados;
	}

	// METODO PARA COMPRAR VIDEOJUEGO PURCHASE
	public Purchase comprarVideojuego(int idCliente, int idJuego, int cantidad) throws Exception {
		Customer clienteEncontrado = null;
		Game juegoEncontrado = null;
		// COMPROBAR QUE LA CANTIDAD NO ES 0 NI MENOR QUE 0
		if (cantidad <= 0) {
			throw new Exception("La cantidad no puede ser menor que 0");
		}

		
		/* recorremos la lista de games buscando que ese id Exista, si lo hace creamos
		 el juego*/
		for (Game game : games) {
			if (idJuego == game.getId()) {
				//tengo que añadir que si hay stock !!SEGUN YO COMO EL JUEGO CON ID EXISTE AHORA COMPRUEBO SU DISPONIBILIDAD!!
				//ATENTO PORQUE HAY DOS CLASES UNA DE COMPROBOBAR(USANDO ENTERO) Y HAY STOCK
				if(game.hayStock()) {
					juegoEncontrado = game;
				}
			}
		}
		if (juegoEncontrado == null) {
			throw new Exception("Juego no existe");
		}

		// COMPROBAR QUE EL CLIENTE EXISTE, recorro la lista y si existe guardo ese
		// cliente
		for (Customer cliente : customers) {
			if (idCliente == cliente.getId()) {
				/* !!!IMPORTANTE!!! hay que comprobar el balance dentro, pendiente de hacer, 
				 * quizas use truco aqui... jajaja creando antes el juego y accediendo al precio y a ese precio multiplico por la cantidad
				*/
				if (cliente.comprobarDisponibilidadBoolean(juegoEncontrado.getPrice()*cantidad)) {
					clienteEncontrado = cliente;
				}else {
					throw new Exception("Balance insuficiente");
				}
			}
		}
		// si el cliente anterior sigue siendo null, entonces es que no lo encontro
		if (clienteEncontrado == null) {
			throw new Exception("Cliente no existe");
		}

		// cuando los anteriores filtros ya pasan damos de alto la compra
		Purchase compra = new Purchase(clienteEncontrado, juegoEncontrado, cantidad);
		juegoEncontrado.reducirStock(cantidad);
		clienteEncontrado.retirarSaldo(compra.getTotalPrice());

		/*
		 * NOSE MUY BIEN UQE ESTOY HACIENDO. PERO del cliente que sabemos que existe,
		 * usamos el metodo para saber que tiene saldo suficiente, usamos que la compra
		 * que se genero me dara el totalPrice, que es el precio por cantidad ENTONCES
		 * ESTE IF DEBERIA DEVOLVER TRUE SI EL BALANCE DEL CLIENTE ES MAYOR O IGUAL A LO
		 * QUE CUESTA LA COMPRA
		 
		if (clienteEncontrado.comprobarDisponibilidadBoolean(compra.getTotalPrice())) {

		}*/
		return compra;

	}
	public void comprarJuego(int clienteID, int juegoID, int cantidad) throws Exception {
		Game g=juegoPorId(juegoID);
		if(g==null) {
			throw new Exception("No existe el juego");
		}
		Customer c=clientePorId(clienteID);
		if(c==null) {
			throw new Exception("No existe el cliente");
		}
		if(cantidad<1) {
			throw new Exception ("Cantidad no valida");
		}
		if(!g.comprobarDisponibilidad(cantidad)) {
			throw new Exception("No hay stock suficiente");
		}
		double precio=g.getPrice()*cantidad;
		if(!c.comprobarDisponibilidadBoolean(g.getPrice()*cantidad)) {
			throw new Exception("No hay dinero suficiente");
		}
		//ACTUALIZAMOS LOS DATOS POR QUE TODAS LAS CONDICIONES SE CUMPLIERON
		//Purchase p = new Purchase(c, g, cantidad, precio );
		Purchase p = new Purchase(c, g, cantidad);
		purchases.add(p); //AÑADIMOS LA COMPRA
		g.modificarStock(cantidad);//MODIFICAMOS EL STOCK
		c.retirarSaldo(precio); //RETIRAMOS EL SALDO
		
	}

}
