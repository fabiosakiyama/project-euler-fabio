import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PandigitalProducts2 {

	public static void main(String[] args) {

		new ExecutorPandigital().executa();
	}
}

class ExecutorPandigital {
	
	public static Set<Long> numerosPandigitalProduct = new HashSet<>();

	public void executa() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				int startI = 1;
				int finishI = 999;
				int startJ = 1;
				int finishJ = 500;
				metodoPandigital(startI, finishI, startJ, finishJ);
				System.out.println("Processo 1 terminado");
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				int startI = 1;
				int finishI = 999;
				int startJ = 500;
				int finishJ = 1000;
				metodoPandigital(startI, finishI, startJ, finishJ);
				System.out.println("Processo 2 terminado");
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				int startI = 1;
				int finishI = 999;
				int startJ = 1000;
				int finishJ = 1500;
				metodoPandigital(startI, finishI, startJ, finishJ);
				System.out.println("Processo 3 terminado");
			}
		});

		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				int startI = 1;
				int finishI = 999;
				int startJ = 1500;
				int finishJ = 2000;
				metodoPandigital(startI, finishI, startJ, finishJ);
				System.out.println("Processo 4 terminado");
			}
		});

		Thread t5 = new Thread(new Runnable() {

			@Override
			public void run() {
				int startI = 1;
				int finishI = 999;
				int startJ = 2000;
				int finishJ = 2500;
				metodoPandigital(startI, finishI, startJ, finishJ);
				System.out.println("Processo 5 terminado");
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	private void metodoPandigital(int startI, int finishI, int startJ, int finishJ) {
		long sum = 0;
		long starttime = System.currentTimeMillis();
		for (int i = startI; i < finishI; i++) {
			for (int j = startJ; j < finishJ; j++) {
				try {
					new ExecutorPandigital().executaMetodo(i, j, numerosPandigitalProduct);
				} catch (IllegalArgumentException ex) {
					// next j
				}
			}
		}
		for (Long pandigitalProduct : numerosPandigitalProduct) {
		//	System.out.println(pandigitalProduct);
			sum += pandigitalProduct;
		}
		System.out.println("Soma: " + sum);
		long finishtime = System.currentTimeMillis();
		System.out.println("Time: " + (finishtime - starttime));
	}

	private void executaMetodo(int i, int j, Set<Long> numerosPandigitalProduct) {
		// 39 × 186 = 7254
		String numeroi = Integer.toString(i);
		String numeroj = Integer.toString(j);
		int result = i * j;
		String produto = Integer.toString(result);
		String total = numeroi + numeroj + produto;

		String[] totalSplitted = total.split("");
		HashSet<String> totalSplittedHashSet = new HashSet<>(Arrays.asList(totalSplitted));
		if (!(totalSplitted.length == totalSplittedHashSet.size())) {
			throw new IllegalArgumentException();
		}

		if (totalSplittedHashSet.contains("0")) {
			throw new IllegalArgumentException();
		}

		if (isPandigital1to9(produto, numeroi, numeroj)) {
			numerosPandigitalProduct.add((long) result);
			// System.out.println("Produto: " + produto + ". i = " + i + ", j =
			// " + j);
		}
	}

	private boolean isPandigital1to9(String produto, String numeroi, String numeroj) {
		if (produto.length() + numeroi.length() + numeroj.length() == 9) {
			return true;
		}
		return false;
	}

}
