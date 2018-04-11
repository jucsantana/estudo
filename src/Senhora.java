
public class Senhora extends PessoaImpl {

	public Senhora(String nome) {
		super(nome);
	}

	@Override
	protected String tratamento() {
		return "Sra.";
	}

}
