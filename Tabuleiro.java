package jogoVelha;

public class Tabuleiro {

	// x = (humano)
	// o = (maquina)
	
	public String posicoesTabuleiro[][] = new String[3][3];
	public int numeroJogadas;
	private String marcaDoVencedor;

	public Tabuleiro() {
		this.numeroJogadas = 0;
		iniciarPosicoes();
		this.marcaDoVencedor = "";
	}

	private void iniciarPosicoes() {
		// inicializa as posicoes
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.posicoesTabuleiro[i][j] = " ";
			}
		}
	}

	private void renovarTela() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.println("_____JOGO DA VELHA_____");
		System.out.println("X (humano) | O (maquina)\n");
	}

	public void mostrarTabuleiro() {
		renovarTela();

		// mostra as posicoes do tabuleiro
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(this.posicoesTabuleiro[i][j]);
				if (j < 2) {
					System.out.print("|");
				}
			}
			if (i < 2) {
				System.out.println("\n-|-|-");
			}
		}
		System.out.println("\n");
	}

	public boolean verificarVitoria() {
		// Verificar possibilidade de vitoria por número de jogadas
		if (numeroJogadas < 5) {
			return false;
		}
		// opcao para verificar se houve vitoria na diagonal
		if (posicoesTabuleiro[0][0].equals(posicoesTabuleiro[1][1])
				&& posicoesTabuleiro[1][1].equals(posicoesTabuleiro[2][2]) && !(posicoesTabuleiro[1][1].equals(" "))) {
			this.marcaDoVencedor = posicoesTabuleiro[0][0];
			return true;
		}
		if (posicoesTabuleiro[2][0].equals(posicoesTabuleiro[1][1])
				&& posicoesTabuleiro[1][1].equals(posicoesTabuleiro[0][2]) && !(posicoesTabuleiro[1][1].equals(" "))) {
			this.marcaDoVencedor = posicoesTabuleiro[2][0];
			return true;

		}
		// opcao para verificar todas as possibilidades de vitoria nas linhas e colunas
		for (int i = 0; i < 3; i++) {
			if (posicoesTabuleiro[i][0].equals(posicoesTabuleiro[i][1])
					&& posicoesTabuleiro[i][1].equals(posicoesTabuleiro[i][2])
					&& !(posicoesTabuleiro[i][1].equals(" "))) {
				this.marcaDoVencedor = posicoesTabuleiro[i][0];
				return true;
			}
			if (posicoesTabuleiro[0][i].equals(posicoesTabuleiro[1][i])
					&& posicoesTabuleiro[1][i].equals(posicoesTabuleiro[2][i])
					&& !(posicoesTabuleiro[1][i].equals(" "))) {
				this.marcaDoVencedor = posicoesTabuleiro[0][i];
				return true;
			}
		}
		return false;
	}

	public String status() {
		// opcao que mostra o status da partida
		boolean statusVitoria = verificarVitoria();
		if (statusVitoria == false && numeroJogadas == 9) {
			return "Empatou!";
		} else if (statusVitoria == false) {
			return "Nao terminou!";
		} else {
			if (this.marcaDoVencedor == "x") {
				return "Parabens voce venceu!!!";
			} else {
				return "Maquina venceu!!!";
			}
		}
	}
}
