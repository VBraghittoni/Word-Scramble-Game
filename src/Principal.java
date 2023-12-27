import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    	
		MecanicaDoJogo meuJogo;
        System.out.println("Começando o programa. Selecione o modo de jogo. \n 1 - morte súbita \n 2 - vidas totais \n 3 - vidas por rodada \n 4 - Modo aleatório");
        
        try (Scanner in = new Scanner(System.in)) {
        	String input = in.nextLine();
        	if(input.equals("1")) {
        		meuJogo = new Jogo1();
        	} else if(input.equals("2")) {
        		meuJogo = new Jogo2();
        	} else if(input.equals("3")) {
        		meuJogo = new Jogo3();
        	} else {
        		meuJogo = FabricaMecanicaDoJogo.jogoAleatorio();
        	}
        	System.out.println(meuJogo.rodada("Começo de jogo"));
        	
			while (true) {

			    if(!meuJogo.getRodando()) {
			    	System.out.println("Vamos jogar outra partida? Selecione o modo de jogo. \n 1 - morte súbita \n 2 - vidas totais \n 3 - vidas por rodada \n 4 - Modo aleatório");
			    	input = in.nextLine();
		        	if(input.equals("1")) {
		        		meuJogo = new Jogo1();
		        	} else if(input.equals("2")) {
		        		meuJogo = new Jogo2();
		        	} else if(input.equals("3")) {
		        		meuJogo = new Jogo3();
		        	} else {
		        		meuJogo = FabricaMecanicaDoJogo.jogoAleatorio();
		        	}
		        	System.out.println(meuJogo.rodada("Começo de novo jogo"));
			    } else {
					input = in.nextLine();
				    System.out.println(meuJogo.rodada(input));
			    }
			}
		}
    }
}