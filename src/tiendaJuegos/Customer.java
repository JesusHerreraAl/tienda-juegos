package tiendaJuegos;

public class Customer {
	
	//REPRESENTA A UN CLIENTE EN LA TIENDA
	
	private int id;
	private String name;
	private double balance; //SALDO
	private static int contador=1;
	
	public Customer (String name, double balance){
		this.name=name;
		this.balance=balance;
		this.id=contador++;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getBalance(){
		//PODEMOS PONER MEJORA, NO PUEDE SER MENOR QUE 0
		return balance;
	}
	public void anadirSaldo(double saldoMas) {
		//REVISAR SALDO
		if(saldoMas<=0) {
			System.out.println("No puedes añadir saldo negativo");
		}else {
			this.balance=this.balance+saldoMas;
		}
	}
	public void retirarSaldo(double saldoRetirado) {
		//COMPROBAR QUE LO QUE QUIERES RETIRAR TENGAS EN EL BALANCE
		if((this.balance-saldoRetirado)<0) {
			System.out.println("No tienes saldo suficiente para retirar la cantidad solicitada");
		}else {
			System.out.println("Has retirado el saldo: "+saldoRetirado);
			System.out.println("Te queda: "+this.balance);
		}
	}
	public void comprobarDisponibilidad(double cantidad) {
		//COMPARE TO TAMBIEN PODEMOS HACER
		if(this.balance>=cantidad) {
			System.out.println("Si dispones de esa cantidad");
			
		}else {
			System.out.println("No dispones de esa cantidad");
		}
	}
	public boolean comprobarDisponibilidadBoolean(double cantidad){
		boolean disponible = false;
		if(this.balance>=cantidad) {
			disponible= true ;
		}
		return disponible;
		
	}
public String toString() {
	return "Cliente [ID: " + id + ", Nombre: " + name + ", Saldo= "+ balance + "]";
}

}
