package jogoVelha;

import java.util.Random;

public class ComputadorC extends Pc {

	Random num_aleatorio = new Random();

	@Override
	public void jogar(String[][] mapa) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mapa[i][j].equals("x")) {
					// opcao para verificar se os lados horizontais ja foram marcados
					try {
						if (mapa[i + 1][j].equals(" ")) {
							mapa[i + 1][j] = "o";
							return;
						}
					} catch (Exception e) {
					}
					try {
						if (mapa[i - 1][j].equals(" ")) {
							mapa[i - 1][j] = "o";
							return;
						}
					} catch (Exception e) {
					}

					// opcao para verificar se os lados verticais ja foram marcados
					try {
						if (mapa[i][j + 1].equals(" ")) {
							mapa[i][j + 1] = "o";
							return;
						}
					} catch (Exception e) {
					}
					try {
						if (mapa[i][j - 1].equals(" ")) {
							mapa[i][j - 1] = "o";
							return;
						}
					} catch (Exception e) {
					}
				}
			}
		}
		// opcao alternativa para ser usada no caso de falha
		int x;
		while (true) {
			x = num_aleatorio.nextInt(3);
			for (int j = 0; j < 3; j++) {
				if (mapa[x][j].equals(" ")) {
					mapa[x][j] = "o";
					return;
				}
			}
		}
	}
}
