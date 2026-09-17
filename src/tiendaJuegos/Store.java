package tiendaJuegos;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<Game> games;
	private ArrayList<Customer> customers;
	private ArrayList<Purchase> purchases;
	
	public Store () {
		games=new ArrayList<Game>();//vacio
		customers= new ArrayList<Customer>();
		purchases= new ArrayList<Purchase>();
	}

	public ArrayList<Game> getGames() {
		return games;
	}

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
	//METODO PARA BUSCAR POR TEXTO
	
	

}

