package conta.model;

public abstract class Conta {

	//public class Conta {
	
	 
	private int numero;
	private int agencia;
	private int  tipo;
	private String titular;
	private float saldo;
	private int numeroCelular;
	public Conta(int numero, int agencia, int tipo, String titular, float saldo, int numeroCelular) {
	
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
		this.numeroCelular = numeroCelular;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero( int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public int getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo()- valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(getSaldo() + valor);
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = " Conta corrente";
			break;
		case 2:
			tipo = " Conta Poupança";
			break;
		}
		
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Numero de Celular do titular: " + this.numeroCelular);
		System.out.println("Saldo: " + this.saldo);
	}
}
