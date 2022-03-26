package jogoVelha;

public class Jogador {

	public boolean jogar(String mapa[][], String linha, String coluna) {

		// opcao para verificar se a posição encontra-se ocupada
		// caso negativo marca com x(jogador humano)
		try {
			int x = Integer.parseInt(linha);
			int y = Integer.parseInt(coluna);
			if (mapa[x - 1][y - 1].equals(" ")) {
				mapa[x - 1][y - 1] = "x";
				return true;
			} else {
				// opcao que verifica se a posicao encontra-se disponivel
				System.out.println("Esta posicao ja esta ocupada!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Valor invalido!");
			return false;
		}
	}
}
