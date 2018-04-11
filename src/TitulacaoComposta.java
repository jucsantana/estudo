import java.util.Arrays;
import java.util.List;

public class TitulacaoComposta implements TitulacaoStrategy {
	
	private List<TitulacaoStrategy> lista;
	
	public TitulacaoComposta(TitulacaoStrategy... lista) {
		super();
		this.lista = Arrays.asList(lista);
	}

	@Override
	public String adicionaTitulo() {
		
		StringBuilder titulo = new StringBuilder();
		
		lista.forEach(t -> titulo.append(t.adicionaTitulo()));
		
		return titulo.toString();
	
	}

}
