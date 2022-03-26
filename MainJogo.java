package jogoVelha;

import java.util.Scanner;

public class MainJogo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Jogador jogador = new Jogador();
		ComputadorA pc_a = new ComputadorA();
		ComputadorB pc_b = new ComputadorB();
		ComputadorC pc_c = new ComputadorC();

		while (true) {
			Tabuleiro tab = new Tabuleiro();
			// menu contendo os niveis das jogadas
			int nivel = menu();
			boolean vitoriaJogador;

			do {
				// este bloco faz a verificacao do tabuleiro se ja foi completado
				if (tab.numeroJogadas == 9) {
					break;
				}
				// variavel para entrada dos dados do jogador
				String x, y;
				x = y = "";
				tab.mostrarTabuleiro();
				// opcao para o usuario escolher um numero permitido no jogo
				do {
					System.out.print("Escolha a linha: ");
					x = entrada.next();
					System.out.print("Escolha a coluna: ");
					y = entrada.next();

				} while (!(jogador.jogar(tab.posicoesTabuleiro, x, y)));
				tab.numeroJogadas++;

				// verificando se após a jogada passada já houve vitória para mostrar o
				// tabuleiro sem jogadas da máquina
				vitoriaJogador = tab.verificarVitoria();
				if (!(vitoriaJogador)) {
					// efetuando jogada de acordo com o nível do jogo
					switch (nivel) {
					case 1:
						pc_a.jogar(tab.posicoesTabuleiro);
						break;
					case 2:
						pc_b.jogar(tab.posicoesTabuleiro);
						break;
					case 3:
						pc_c.jogar(tab.posicoesTabuleiro);
						break;
					}
					tab.numeroJogadas++;
				}

			} while (!(tab.verificarVitoria()));
			tab.mostrarTabuleiro();
			System.out.println(tab.status());
			System.out.println("Digite um caracter e pressione enter para jogar outra vez!!");
			entrada.next();
		}
	}

	public static int menu() {
		// este menu é resposavel pela escolha do nivel
		Scanner entrada = new Scanner(System.in);
		int nivel = 0;

		// opcao para selecionar um dos 3 níveis do jogo
		while (true) {
			try {
				System.out.print("Escolha um nivel [1] [2] [3]: ");
				nivel = Integer.parseInt(entrada.next());
				switch (nivel) {
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				default:
					System.out.println("Opcao invalida!");
				}
			} catch (Exception e) {
				System.out.println("Dados invalidos!");
			}
		}
	}
}