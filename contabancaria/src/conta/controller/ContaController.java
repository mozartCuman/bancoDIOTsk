package conta.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;
import java.util.ArrayList;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null)
			conta.visualizar();
		else
			System.out.print("\n Conta número: " + numero + " não foi encontrada!");

	}

	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n A Conta Número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\n A conta número: " + conta.getNumero() + " não foi encontrada!");
		}
		
	}

	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\n A conta número: " + numero + " foi deletada com sucesso");
		} else {
			System.out.println(" A conta não foi encontrada!");
		}
	}

	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (conta.sacar(valor) == true) 
				System.out.println("\n O Saque da Conta numero: " + numero + " foi efetuado com sucesso!");
			
		}else {
			System.out.println("\n A Conta numero: " + numero + " não foi encontrada!" );
		}
		
	}

	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor); 
			System.out.println("\n O Deposito da Conta numero: " + numero + " foi efetuado com sucesso!");
		}else 
			System.out.println(
					"\n A Conta numero: " + numero + " não foi encontrada ou a conta destino não é uma conta corrente!" );
		
	}

	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\n A transferencia foi efetuada com sucesso!");
			}
			
		}else {
			System.out.println("\n A Conta de Origem e/ou Destino não foram encontradas!" );
		}
		
	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
