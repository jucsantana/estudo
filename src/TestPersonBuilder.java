import static org.junit.Assert.*;

import org.junit.Test;

public class TestPersonBuilder {

	
	@Test
	public void deveCriarUmSenhor() {
		Pessoa p = new PessoaBuilder()
				.criarSenhorChamado("Fulano")
				.get();
		assertEquals("Sr. Fulano", p.titulo());
	}
	
	@Test
	public void deveCriarUmaSenhora() {
		Pessoa p = new PessoaBuilder()
				.criarSenhoraChamada("Ciclana")
				.get();
		assertEquals("Sra. Ciclana", p.titulo());
	}

	@Test
	public void deveCriarUmSenhorQueEReitor() {
		Pessoa p = new PessoaBuilder()
				.criarSenhorChamado("Fulano")
				.queEReitor()
				.get();
		assertEquals("Magnífico(a) Sr. Fulano", p.titulo());
	}
	
	@Test
	public void deveCriarUmaSenhoraEDeputada() {
		Pessoa p = new PessoaBuilder()
				.criarSenhoraChamada("Ciclana")
				.queEDeputado()
				.get();
		assertEquals("Excelentíssimo(a) Sra. Ciclana", p.titulo());
	}
	
	@Test
	public void deveCriarUmSenhorQueEReitorDeputado() {
		Pessoa p = new PessoaBuilder()
				.criarSenhorChamado("Fulano")
				.queEReitor()
				.queEDeputado()
				.get();
		assertEquals("Magnífico(a) Excelentíssimo(a) Sr. Fulano", p.titulo());
	}
	
	@Test
	public void amigoAntesReitor() {
		Pessoa p = new PessoaBuilder()
				.criarSenhorChamado("Fulano")
				.adicionando("Amigo")
				.antes()
				.queEReitor()
				.queEDeputado()
				.get();
		assertEquals("Amigo Magnífico(a) Excelentíssimo(a) Sr. Fulano", p.titulo());
	}
	
	@Test
	public void amigoDepoisReitor() {
		Pessoa p = new PessoaBuilder()
				.criarSenhorChamado("Fulano")
				.adicionando("amigo")
				.depois()
				.queEReitor()
				.queEDeputado()
				.get();
		assertEquals("Magnífico(a) Excelentíssimo(a) Sr. Fulano amigo", p.titulo());
	}
}
