import java.util.List;

public interface MecanicaDoJogo {
	public String rodada(String palavra);
	public int contaCertos(List<Boolean> acertos);
	public int contaErros(List<Boolean> acertos);
	public void novaPalavra();
	public boolean getRodando();
}

