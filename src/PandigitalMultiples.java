import java.util.HashSet;
import java.util.Set;

public class PandigitalMultiples {
	
	public static void main(String[] args) {
		
		long maiorNumero = 0;
		Set<String> numerosJaUsados = new HashSet<>();
		String valorTotal = "";
		for(int i = 1; i < 9999999; i++){
			for(int j = 1; j< 9999999; j++){
				int result = i * j;
				String produto = Integer.toString(result);
				
				if((valorTotal.length() + produto.length()) > 9){
					// Ja passou dos 9 dígitos
					break;
				}else{
					valorTotal = valorTotal  + (i * j);
				}
				
				for(String c : produto.split("")){
					if(c.equals("0") || numerosJaUsados.contains(c)){
						// Ja nao é mais pandigital
						break;
					}
					numerosJaUsados.add(c);
				}
			}
			if(valorTotal.length() == 9 && numerosJaUsados.size() == 9){
				long parseLong = Long.parseLong(valorTotal);
				if(maiorNumero < parseLong){
					maiorNumero = parseLong;
				}
			}
			valorTotal = "";
			numerosJaUsados.clear();
		}
		System.out.println(maiorNumero);
		System.out.println("fim");
	}
}