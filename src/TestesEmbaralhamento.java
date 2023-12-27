import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesEmbaralhamento {

	@Test
	void Embaralhamento1() {
		Embaralhador meuEmbaralhador = new Embaralhador1();
		String palavra = "abc";
		String embaralhado = meuEmbaralhador.embaralha(palavra);
		
		if(!embaralhado.equals("abc") && !embaralhado.equals("acb") && !embaralhado.equals("bac") && !embaralhado.equals("bca") && !embaralhado.equals("cab") && !embaralhado.equals("cba")) {
			fail();
		}
	}
	
	@Test
	void Embaralhamento2() {
		Embaralhador meuEmbaralhador = new Embaralhador2();
		String palavra = "bca";
		String embaralhado = meuEmbaralhador.embaralha(palavra);
		
		if(!embaralhado.equals("abc")) {
			fail();
		}
	}

}
