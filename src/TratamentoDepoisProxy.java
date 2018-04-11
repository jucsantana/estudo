
public class TratamentoDepoisProxy implements Pessoa {

	private Pessoa p;
	private String palavra;
	
	public TratamentoDepoisProxy(Pessoa p, String palavra) {
		this.p = p;
		this.palavra = palavra;
	}

	public String titulo() {
		return p.titulo() + " " +palavra;
	}

	public TitulacaoStrategy getTitulacao() {
		return p.getTitulacao();
	}

	public void setTitulacao(TitulacaoStrategy titulacao) {
		p.setTitulacao(titulacao);
	}
	

}
