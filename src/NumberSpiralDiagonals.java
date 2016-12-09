import java.util.ArrayList;
import java.util.List;

public class NumberSpiralDiagonals {

	static int maxColunas = 1001;
	static int maxLinhas = 1001;
	static List<Integer> numerosNaDiagonal = new ArrayList<>();

	static long limite = maxColunas * maxLinhas;

	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();

		int[][] matriz = new int[maxLinhas][maxColunas];

		// setar posição inicial
		int xAtual = maxLinhas / 2;
		int yAtual = maxColunas / 2;
		matriz[xAtual][yAtual] = 1;

		// Mover para segunda posição (x mantem)
		yAtual++;

		// setar segunda posição
		matriz[xAtual][yAtual] = 2;
		for (int i = 3; i <= limite; i++) {
			// Consigo mover p/ baixo?
			if (temNumeroAEsquerda(matriz, xAtual, yAtual) && !temNumeroAbaixo(matriz, xAtual, yAtual)) {
				// Move posição p/ baixo
				xAtual++;
				// Seta valor
				matriz[xAtual][yAtual] = i;
				continue;
			}

			// Consigo mover p/ esquerda?
			if (temNumeroAcima(matriz, xAtual, yAtual) && !temNumeroAEsquerda(matriz, xAtual, yAtual)) {
				// Move posição p/ esquerda
				yAtual--;
				// Seta valor
				matriz[xAtual][yAtual] = i;
				continue;
			}

			// Consigo mover p/ cima?
			if (temNumeroADireita(matriz, xAtual, yAtual) && !temNumeroAcima(matriz, xAtual, yAtual)) {
				// Move posição p/ cima
				xAtual--;
				// Seta valor
				matriz[xAtual][yAtual] = i;
				continue;
			}

			// Consigo mover p/ direita?
			if (temNumeroAbaixo(matriz, xAtual, yAtual) && !temNumeroADireita(matriz, xAtual, yAtual)) {
				// Move posição p/ direita
				yAtual++;
				// Seta valor
				matriz[xAtual][yAtual] = i;
				continue;
			}
		}

		for (int i = 0; i < maxLinhas; i++) {
			addNaLista(matriz[i][i]);
		}

		int contador = 0;
		int x = 0;
		int y = maxColunas - 1;
		while (contador < maxLinhas) {
			addNaLista(matriz[x][y]);
			x++;
			y--;
			contador++;
		}

		long sum = 0;
		for (Integer i : numerosNaDiagonal) {
			sum += i;
		}
		System.out.println("Soma: " + (sum-1));
		long finishtime = System.currentTimeMillis();
		System.out.println("Time: " + (finishtime - starttime));
	}

	private static boolean addNaLista(int valor) {
		return numerosNaDiagonal.add(valor);
	}

	private static boolean temNumeroAEsquerda(int[][] matriz, int x, int y) {
		if (temPosicaoAEsquerda(y)) {
			// mesma linha (x), coluna a esquerda (y-1)
			return matriz[x][y - 1] != 0;
		}
		return false;
	}

	private static boolean temNumeroAbaixo(int[][] matriz, int x, int y) {
		if (temPosicaoAbaixo(x)) {
			// linha abaixo (x+1), mesma coluna (y)
			return matriz[x + 1][y] != 0;
		}
		return false;
	}

	private static boolean temNumeroADireita(int[][] matriz, int x, int y) {
		if (temPosicaoADireita(y)) {
			// mesma linha (x), coluna a direita (y+1)
			return matriz[x][y + 1] != 0;
		}
		return false;
	}

	private static boolean temNumeroAcima(int[][] matriz, int x, int y) {
		if (temPosicaoAcima(x)) {
			// linha acima (x - 1), mesma coluna (y)
			return matriz[x - 1][y] != 0;
		}
		return false;
	}

	private static boolean temPosicaoAEsquerda(int yAtual) {
		if (yAtual == 0) {
			return false;
		}
		return true;
	}

	private static boolean temPosicaoAbaixo(int xAtual) {
		if (xAtual == maxLinhas - 1) {
			return false;
		}
		return true;
	}

	private static boolean temPosicaoADireita(int yAtual) {
		if (yAtual == maxColunas - 1) {
			return false;
		}
		return true;
	}

	private static boolean temPosicaoAcima(int xAtual) {
		if (xAtual == 0) {
			return false;
		}
		return true;
	}

}