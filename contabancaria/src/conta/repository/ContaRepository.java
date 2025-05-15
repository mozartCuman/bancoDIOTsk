package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	public void sacar(int numero, float valor);
	public void depositar( int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
	
}
/*Like a waiter and Digital Menu responsavel por receber e processar o pedido, anota e passa a solicitação para 
o lugar certo. Vai mapear, e a parte de logistica vai saber para onde vai cada coisa, vai poder dizer se não tem mais alguma coisa, e pode ter
ter entrada no banco de dados o dado sem necessariamente

*No linkedin fazemos o login e botamos a senha xptoerreiasenha, quando apertamos o botao o repository pega no back end a informacao e comunica se esta certo ou errado
ao devolver para o controller */ 