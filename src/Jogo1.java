import java.util.ArrayList;
import java.util.List;

public class Jogo1 implements MecanicaDoJogo {
	
	boolean rodando = false;
	List<Boolean> acertos = new ArrayList<>();
	String palavraCerta;
	String embaralhado;
	
	@Override
	public String rodada(String tentativa) {
		if (!rodando) {
			rodando = true;
			novaPalavra();
			return "Começando um jogo no modo de morte súbita. Tente adivinhar: "+embaralhado;
		}
		
		
		if(tentativa.equals(palavraCerta)) {
			acertos.add(true);
			novaPalavra();
			return "Resposta certa! Você está com "+contaCertos(acertos)+" pontos. Tente adivinhar: "+embaralhado;
		}
		else {
			acertos.add(false);
			rodando = false;
			int pontos = contaCertos(acertos);
			acertos = new ArrayList<>();
			palavraCerta = "";
			embaralhado = "";
			return "Resposta errada. Fim de jogo. Você fez "+pontos+" ponto(s).";	
		}
	}
	
	@Override
	public void novaPalavra() {
		Embaralhador meuEmbaralhador = FabricaEmbaralhadores.embaralhadorAleatorio();
		palavraCerta = BancoDePalavras.getPalavra();
		embaralhado = meuEmbaralhador.embaralha(palavraCerta);
	}
	
	@Override
	public int contaCertos(List<Boolean> acertos) {
		int numero = 0;
		for (Boolean i : acertos) {
			if(i) {
				numero++;
			}
		}
		return numero;
	}
	
	//erros totais
	@Override
	public int contaErros(List<Boolean> acertos) {
		int numero = 0;
		for (Boolean i : acertos) {
			if(!i) {
				numero++;
			}
		}
		return numero;
	}
	
	public int contaErrosSeguidos(List<Boolean> acertos) {
		int numero = 0;
		for (Boolean i : acertos) {
			if(!i) {
				numero++;
			} else {
				numero = 0;
			}
		}
		return numero;
	}
	
	@Override
	public boolean getRodando() {
		return rodando;
	}
}
