import java.util.Arrays;

public class Embaralhador2 implements Embaralhador {

	@Override
	public String embaralha(String palavra) {
		char[] charArray = palavra.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
