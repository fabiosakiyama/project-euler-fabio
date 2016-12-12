import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Triangle Tn=n(n+1)/2 1, 3, 6, 10, 15, ... Pentagonal Pn=n(3n−1)/2 1, 5, 12,
 * 22, 35, ... Hexagonal Hn=n(2n−1) 1, 6, 15, 28, 45, ... It can be verified
 * that T285 = P165 = H143 = 40755.
 * 
 * @author fsakiyama
 *
 */
public class TriangularPentagonalHexagonal {

	public static void main(String[] args) {

		// 40755 -> Hexagonal, 143
		Map<BigInteger, List<TrianglePentHexa>> mapa = new HashMap<>();

		for (int i = 0; i < 999999; i++) {
			BigInteger triangle = calculateTriangle(i);
			putOnMap(mapa, i, triangle, TriangularPentagonalHexagonalEnum.T);
			// if (mapa.get(triangle).size() == 3) {
			// System.out.println("Valor: " + triangle + " " +
			// mapa.get(triangle).toString());
			// }
		}

		for (int i = 0; i < 999999; i++) {
			BigInteger penta = calculatePentagonal(i);
			putOnMap(mapa, i, penta, TriangularPentagonalHexagonalEnum.P);
		}

		for (int i = 0; i < 999999; i++) {
			BigInteger hexa = calculateHexagonal(i);
			putOnMap(mapa, i, hexa, TriangularPentagonalHexagonalEnum.H);

		}

		// mapa.entrySet().stream().sorted(Map.Entry.comparingByKey())
		// .filter(t -> (t.getValue().size() == 3) && (t.getKey() >=
		// 0)).forEach(System.out::println);
	}

	private static void putOnMap(Map<BigInteger, List<TrianglePentHexa>> mapa, int i, BigInteger value,
			TriangularPentagonalHexagonalEnum enumType) {
		if (!mapa.containsKey(value) && !enumType.equals(TriangularPentagonalHexagonalEnum.T)) {
			return;
		}
		if (!mapa.containsKey(value) && enumType.equals(TriangularPentagonalHexagonalEnum.T)) {
			TrianglePentHexa type = new TrianglePentHexa(enumType, i);
			List<TrianglePentHexa> list = new ArrayList<TrianglePentHexa>();
			list.add(type);
			mapa.put(value, list);
		} else {
			List<TrianglePentHexa> mapValue = mapa.get(value);
			mapValue.add(new TrianglePentHexa(enumType, i));
			if (mapa.get(value).size() == 3) {
				System.out.println("Valor: " + value + " " + mapa.get(value).toString());
			}
		}
	}

	private static BigInteger calculateTriangle(int i) {
		BigInteger triangle = BigInteger.valueOf(i);
		// i * (i + 1) / 2;
		triangle = triangle.multiply(triangle.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
		return triangle;
	}

	private static BigInteger calculateHexagonal(int i) {
		BigInteger hexa = BigInteger.valueOf(i);
		// i * (2 * i - 1);
		hexa = hexa.multiply(BigInteger.valueOf(2).multiply(hexa).subtract(BigInteger.ONE));
		return hexa;
	}

	private static BigInteger calculatePentagonal(int i) {
		BigInteger penta = BigInteger.valueOf(i);
		// i * (3 * i - 1) / 2;
		penta = penta.multiply(BigInteger.valueOf(3).multiply(penta).subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2));
		return penta;

	}

}

enum TriangularPentagonalHexagonalEnum {

	T, P, H;
}

class TrianglePentHexa {

	private TriangularPentagonalHexagonalEnum type;

	private int index;

	public TrianglePentHexa(TriangularPentagonalHexagonalEnum type, int index) {
		this.type = type;
		this.index = index;
	}

	@Override
	public String toString() {
		return this.type + "" + this.index;
	}

	public TriangularPentagonalHexagonalEnum getType() {
		return this.type;
	}

	public void setType(TriangularPentagonalHexagonalEnum type) {
		this.type = type;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
