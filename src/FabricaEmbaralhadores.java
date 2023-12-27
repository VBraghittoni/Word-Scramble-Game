import java.util.Random;

public class FabricaEmbaralhadores {
	
	private static final Embaralhador[] IMPLEMENTACOES = {
        new Embaralhador1(),
        new Embaralhador2()
    };
	
	public static Embaralhador embaralhadorAleatorio() {
		Random random = new Random();
        int indiceAleatorio = random.nextInt(IMPLEMENTACOES.length);
        return IMPLEMENTACOES[indiceAleatorio];
	}
}
