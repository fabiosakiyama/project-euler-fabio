import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

	List<>

	public static void main(String[] args) {

		// 40755 -> Hexagonal, 143
		Map<Long, List<TrianglePentHexa>> mapa = new HashMap<>();

		for (int i = 2; i < 1000000; i++) {
			Long triangle = calculateTriangle(i);
			putOnMap(mapa, i, triangle, TriangularPentagonalHexagonalEnum.T);

			Long penta = calculatePentagonal(i);
			putOnMap(mapa, i, penta, TriangularPentagonalHexagonalEnum.P);

			Long hexa = calculateHexagonal(i);
			putOnMap(mapa, i, hexa, TriangularPentagonalHexagonalEnum.H);
		}

		mapa.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(t -> (t.getValue().size() == 3) && (t.getKey() > 0)).forEach(System.out::println);
	}

	private static void putOnMap(Map<Long, List<TrianglePentHexa>> mapa, int i, Long value, TriangularPentagonalHexagonalEnum enumType) {
		if (!mapa.containsKey(value)) {
			TrianglePentHexa type = new TrianglePentHexa(enumType, i);
			List<TrianglePentHexa> list = new ArrayList<TrianglePentHexa>();
			list.add(type);
			mapa.put(value, list);
		} else {
			List<TrianglePentHexa> mapValue = mapa.get(value);
			mapValue.add(new TrianglePentHexa(enumType, i));
		}
		
	}

	private static Long calculateTriangle(int i) {
		return (long) (i * (i + 1) / 2);
	}

	private static Long calculateHexagonal(int i) {
		return (long) (i * (2 * i - 1));
	}

	private static Long calculatePentagonal(int i) {
		return (long) (i * (3 * i - 1) / 2);
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
