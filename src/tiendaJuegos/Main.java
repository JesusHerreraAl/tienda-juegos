package tiendaJuegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Hola");
		String menu = ""; // POSIBLE MENU PARA INTERACTUAR CON TECLAS.. POSIBLE IMPLEMENTACION
		String comando;
		Store tiendaJuegos=new Store();
		//String title, Genre genero, double price, int stock
		//Game juego=new Game ("Minecraft", Genre.SIMULATION, 29.99, 5 );
		//BUSQUE EL AGREGAR UNA LISTA Y TENER AHI TODO, NO VAYA A SER QUE LUEGO TENGA QUE IR DANDO GAME JUEGO2 = NEW GAME... ETC
		//PEDI EN LA IA LOS JUEGOS JAJAJA ASI NO TENGO QUE PENSAR TANTO EN DISTINTOS JUEGOS
		List<Game> juegosAgregados =  List.of(
				new Game ("Minecraft", Genre.SIMULATION, 29.99, 5 ),
				new Game ("Hollow Knight", Genre.ADVENTURE, 14.99, 3 ),
				new Game("Grand Theft Auto V", Genre.ACTION, 29.99, 15),
			    new Game("The Legend of Zelda: Tears of the Kingdom", Genre.ADVENTURE, 69.99, 10),
			    new Game("The Witcher 3: Wild Hunt", Genre.RPG, 39.99, 8),
			    new Game("Age of Empires II: Definitive Edition", Genre.STRATEGY, 19.99, 12),
			    new Game("EA Sports FC 24", Genre.SPORTS, 59.99, 20),
			    new Game("Minecraft", Genre.SIMULATION, 29.99, 25),
			    new Game("Super Mario Odyssey", Genre.PLATAFORM, 49.99, 14),
			    new Game("Portal 2", Genre.PUZZLE, 9.99, 18));
		for(Game game: juegosAgregados) {
			try {
				tiendaJuegos.addVideojuego(game);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//CONSTRUYENDO LOS CLIENTES
		//(String name, double balance)
		List<Customer> clientesAgregados = List.of(
				new Customer("Jesús", 300),
				new Customer("Alberto", 0),
				new Customer("Rodrigo", 300),
				new Customer("Brian", 420),
				new Customer("Alexandra", 5),
				new Customer("Alejandra", 10),
				new Customer("Jenniffer", 500),
				new Customer("Yared", 240),
				new Customer("Yaiza", 100)
				);
		for (Customer cliente: clientesAgregados) {
			try {
				tiendaJuegos.addCliente(cliente);
			}catch(Exception e) {
				System.out.println("Ha habido un error ya sea que el cliente no tiene todos los datos, o el id esta repetido");
			}
			
		}
		/*
		 * DADO POR ANA
		 */
		try(Scanner scanner = new Scanner(System.in)) {
			Store store= new Store();
			String input = "";
			while(!input.equals("quit")) {
				input = scanner.nextLine().toLowerCase();
				String [] command = input.split(" ");//SEPARADOR DEL STRING 
				
				switch(command[0]) {
				case "games":
					for(Game g: store.getGames()) {
						System.out.println(g.toText());
					}
					break;
				case "game":
					if(command.length<2) {
						throw new Exception("Faltan argumentos");
					}
					int id=Integer.parseInt(command[1]);
					store.juegoPorId(id).toText();
					break;
					
				case "customers":
					System.out.println(store.getCustomers());
					break;
				case "customer":
					break;
				case "search":
					
					System.out.println(store.listaJuegosBuscadosPorNombre(command[1]));
					break;
				default:
					System.out.println("Opcion no disponible");
				}
			}
		}
		/*
		 * ESTA PARTE ES UN BUCLE PARA LOS COMANDOS DE LA CONSOLA
		 */
		do {
			System.out.println("Introduce el comando");
			comando = entrada.next().toLowerCase();
			switch (comando) {
			case "games":
				System.out.println(tiendaJuegos.getGames());
				break;
			case "game":
				int idJuego;
				System.out.println("Introduce el id del juego");
				idJuego=entrada.nextInt();
				try {
					System.out.println(tiendaJuegos.juegoPorId(idJuego));
					//el catch puse el error que me salia... que es java.lang.Exception cuando introduzco un codigo que no hay de juego
				}catch(java.lang.Exception jle) {
					System.out.println("Juego con ese id no encontrado");
					
				}
				break;
			case "customers":
				int idCliente;
				System.out.println("Introduce el id del cliente");
				idCliente=entrada.nextInt();
				try {
					System.out.println(tiendaJuegos.clientePorId(idCliente));
				}catch(java.lang.Exception jle) {
					System.out.println("El cliente con ese id no ha sido encontrado");
				}
				
				break;
			case "salir":
				System.out.println("Adios");
				break;
			default:
				System.out.println("Entrada invalida");
				break;

			}
		}while(comando!="salir");
		

	}

}
