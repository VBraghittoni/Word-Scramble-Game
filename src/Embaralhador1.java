
public class Embaralhador1 implements Embaralhador {
	
	@Override
	public String embaralha(String palavra) {
		char[] charArray = palavra.toCharArray();
		for (int i = 0; i < 500; i++) {
			
			int posicao1 = (int) Math.floor(Math.random()*palavra.length());
			int posicao2 = (int) Math.floor(Math.random()*palavra.length());
			
			if (posicao1 != posicao2) {
				char tmp = charArray[posicao1];
				charArray[posicao1] = charArray[posicao2];
				charArray[posicao2] = tmp;
			}
		}
		
		return new String(charArray);
	}
}
