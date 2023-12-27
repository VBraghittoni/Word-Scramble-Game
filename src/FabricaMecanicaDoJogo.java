import java.util.Random;

public class FabricaMecanicaDoJogo {
	private static final MecanicaDoJogo[] IMPLEMENTACOES = {
        new Jogo1(),
        new Jogo2(),
        new Jogo3()
    };
	
	public static MecanicaDoJogo jogoAleatorio() {
		Random random = new Random();
        int indiceAleatorio = random.nextInt(IMPLEMENTACOES.length);
        return IMPLEMENTACOES[indiceAleatorio];
	}
}
