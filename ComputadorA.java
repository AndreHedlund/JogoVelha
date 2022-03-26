package jogoVelha;

public class ComputadorA extends Pc {

	@Override
	public void jogar(String mapa[][]) {
		// opcao para encontrar a primeira ocorrência de espaço não marcado
		// realizando uma varredura horizontal

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mapa[i][j].equals(" ")) {
					mapa[i][j] = "o";
					return;
				}
			}
		}
	}

}
