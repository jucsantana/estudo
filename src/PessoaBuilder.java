import java.util.Arrays;

public class PessoaBuilder {
	
	private Pessoa emConstrucao;
	
	
	public DepoisDaConstrucao criarSenhorChamado(String nome) {
		emConstrucao = new Senhor(nome);
		return new DepoisDaConstrucao();
	}
	
	public DepoisDaConstrucao criarSenhoraChamada(String nome) {
		emConstrucao = new Senhora(nome);
		return new DepoisDaConstrucao();
	}

	
	public class DepoisDaConstrucao{
		
		public Pessoa get() {
			return emConstrucao;
		}
		
		public DepoisDaConstrucao queEReitor() {
			titulacao(new Reitor());
			return this;
		}
		
		public DepoisDaConstrucao queEDeputado() {
			titulacao(new Deputado());
			return this;
		}

		private void titulacao(TitulacaoStrategy titulo) {
			if(emConstrucao.getTitulacao() instanceof SemTitulacao) {
				emConstrucao.setTitulacao(titulo);
			}else {
				emConstrucao.setTitulacao(
						new TitulacaoComposta(
								emConstrucao.getTitulacao(), titulo
								)
						);
			}
		}
		
		public DepoisDoAdicionando adicionando(String palavra) {
			
			DepoisDoAdicionando dp = new DepoisDoAdicionando(this, palavra);
			
			return dp;
			
		}

	}
	
	public class DepoisDoAdicionando{
		
		private DepoisDaConstrucao depoisDaConstrucao;
		private String nome;
		
		public DepoisDoAdicionando(DepoisDaConstrucao depoisDaConstrucao, String nome) {
			super();
			this.depoisDaConstrucao = depoisDaConstrucao;
			this.nome = nome;
		}
		
		public DepoisDaConstrucao antes() {
			emConstrucao = new TratamentoAntesProxy(emConstrucao, nome);
			return this.depoisDaConstrucao;
		}
		
		public DepoisDaConstrucao depois() {
			emConstrucao = new TratamentoDepoisProxy(emConstrucao, nome);
			return this.depoisDaConstrucao;
		}
	}
	
}
