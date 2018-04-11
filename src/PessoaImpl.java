public abstract class PessoaImpl implements Pessoa {
	
	private String nome;
	private TitulacaoStrategy titulacao;

	protected PessoaImpl(String nome) {
		this.titulacao = new SemTitulacao();
		this.nome = nome;
	}
	

	@Override
	public String titulo() {
		return titulacao.adicionaTitulo()+ tratamento()+ " " + nome;
	}
	


	@Override
	public TitulacaoStrategy getTitulacao() {
		return titulacao;
	}


	@Override
	public void setTitulacao(TitulacaoStrategy titulacao) {
		this.titulacao = titulacao;
	}

	protected abstract String tratamento();

}
