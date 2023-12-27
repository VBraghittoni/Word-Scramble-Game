
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDePalavras {
	public static String getPalavra() {
        String caminhoDoArquivo = "ListaDePalavras.txt";
        
        List<String> listaPalavras = new ArrayList<String>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));

            String linha;
            while ((linha = leitor.readLine()) != null) {
            	listaPalavras.add(linha);
            }
            leitor.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        double posicao = Math.random();
        posicao *= listaPalavras.size();
        posicao = Math.floor(posicao);
        return listaPalavras.get((int) posicao);
	}
}
