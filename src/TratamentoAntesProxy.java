
public class TratamentoAntesProxy implements Pessoa {

	private Pessoa p;
	private String palavra;
	
	public TratamentoAntesProxy(Pessoa p, String palavra) {
		this.p = p;
		this.palavra = palavra;
	}

	public String titulo() {
		return palavra + " " +p.titulo();
	}

	public TitulacaoStrategy getTitulacao() {
		return p.getTitulacao();
	}

	public void setTitulacao(TitulacaoStrategy titulacao) {
		p.setTitulacao(titulacao);
	}
	
	

}
