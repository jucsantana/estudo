
public class Senhor extends PessoaImpl {
	
	public Senhor(String nome) {
		super(nome);
	}

	@Override
	protected String tratamento() {
		// TODO Auto-generated method stub
		return "Sr.";
	}

}
