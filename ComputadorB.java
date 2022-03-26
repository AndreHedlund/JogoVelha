package jogoVelha;

import java.util.Random;

public class ComputadorB extends Pc {

	Random num_aleatorio = new Random();

	@Override
	public void jogar(String[][] mapa) {
		
		// opcao para gerar uma posição aleatória
		int x, y;
		while (true) {
			x = num_aleatorio.nextInt(3);
			y = num_aleatorio.nextInt(3);
			if (mapa[x][y].equals(" ")) {
				mapa[x][y] = "o";
				return;
			}
		}
	}
}
