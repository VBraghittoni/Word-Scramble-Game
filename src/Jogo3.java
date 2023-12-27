import java.util.ArrayList;
import java.util.List;

public class Jogo3 implements MecanicaDoJogo {
	boolean rodando = false;
	List<Boolean> acertos = new ArrayList<>();
	String palavraCerta;
	String embaralhado;
	int vidasIniciais = 3;
	
	@Override
	public String rodada(String tentativa) {
		if (!rodando) {
			rodando = true;
			novaPalavra();
			return "Começando um jogo no modo de vidas por rodada. Você tem 3 vidas por rodada. Acertar uma palavra restaura as suas vidas. Tente adivinhar: "+embaralhado;
		}
		
		
		if(tentativa.equals(palavraCerta)) {
			acertos.add(true);
			novaPalavra();
			return "Resposta certa! Você está com "+contaCertos(acertos)+" pontos. Tente adivinhar: "+embaralhado;
		}
		else {
			acertos.add(false);
			
			if (vidasIniciais - contaErros(acertos) <= 0) {
				rodando = false;
				int pontos = contaCertos(acertos);
				acertos = new ArrayList<>();
				palavraCerta = "";
				embaralhado = "";
				return "Resposta errada. Fim de jogo. Você fez "+pontos+" pontos.";	
			} else {
				return "Resposta errada. Você ainda tem "+(vidasIniciais - contaErros(acertos))+" vida(s) restante(s). Continue tentando!";	
			}
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
	
	//erros seguidos
	@Override
	public int contaErros(List<Boolean> acertos) {
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
