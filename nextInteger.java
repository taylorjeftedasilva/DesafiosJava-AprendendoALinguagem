import java.util.Arrays;
import java.util.Collections;

public class Kata {
	//Declarando variaveis
	private static String[] convertStringToArray;
	private static int tamanhoDaString, TamanhoDaStringNaoMutavel;
	private static long resultado;
	//end
	
	// Converte posições de um Array em um inteiro
	private static long ConvertCharParaInt(String[] arrayEntrada, long n) {
		int v = (int) n;
		long retorno = Long.parseLong(Arrays.asList(arrayEntrada).get(v));
		return retorno;
	}
	//end
	
	// Inicializa as variaveis
	private static void InicializandoVariaveis(String e) {
		String convertIntToString = e;
		convertStringToArray = convertIntToString.split("(?!^)");
		tamanhoDaString = convertIntToString.length() - 1;
		TamanhoDaStringNaoMutavel = convertIntToString.length();
		resultado = 0;
	}
	// end
	
	private static void processaResultadoDoProximoMaiorNumero(int subTamanho) {
		// declarando variaveis locais
		String maior, menor, meio, antMaior, antMenor, concatenandoResultado, concatFinalDaString, finalDaStringFormatado;
		String[] numeroAntesDoMaiorValor,numeroAntesDoMenor, numeroMaior, numeroMenor, finalString, numeroEntreMenorEMaior;
		//end
		
		//Capturando seus valores extraindo do array String[]
		numeroAntesDoMaiorValor = Arrays.copyOfRange(convertStringToArray, tamanhoDaString+1,TamanhoDaStringNaoMutavel);
		numeroAntesDoMenor = Arrays.copyOfRange(convertStringToArray, 0, subTamanho);
		numeroEntreMenorEMaior =  Arrays.copyOfRange(convertStringToArray, subTamanho+1, tamanhoDaString);
		numeroMaior = Arrays.copyOfRange(convertStringToArray, tamanhoDaString,tamanhoDaString+1);
		numeroMenor = Arrays.copyOfRange(convertStringToArray, subTamanho,subTamanho+1);
		//end
		// juntando elementos de um array para formatar uma string
		maior = String.join("",numeroMaior);
		menor = String.join("",numeroMenor);
		antMaior = String.join("",numeroAntesDoMaiorValor);
		antMenor = String.join("",numeroAntesDoMenor);
		meio = String.join((""),  numeroEntreMenorEMaior);
		concatFinalDaString = menor + antMaior + meio;
		//end
		
		//Quebrando String em um array para ordenar
		finalString = concatFinalDaString.split("(?!^)");
		//end
		
		//Ordenando de forma crescente tudo que vem antes da troca de posições do maior número e o menor 
		Collections.sort(Arrays.asList(finalString));
		//end
		
		concatFinalDaString = String.join("", finalString);
		concatenandoResultado = antMenor + maior + concatFinalDaString;

		long res = Long.parseLong(concatenandoResultado);
		if(res < resultado || resultado ==0 ) { 
			resultado =  Long.parseLong(concatenandoResultado);
			}
	}

	// pega a String que foi formada a partir do número de entrada e varre cada posição como se fosse um array.
	private static void varreTodasPosicoesDoNumeroQueFoiInserido() {
		for (int i = 0; i <= tamanhoDaString; tamanhoDaString--) {
			long atualNumero = ConvertCharParaInt(convertStringToArray, tamanhoDaString);
			int subTamanho = tamanhoDaString;
			for(int j = 0; j <= subTamanho; subTamanho--) { 
				if (tamanhoDaString != 0) {
					long proximoNumero = ConvertCharParaInt(convertStringToArray, subTamanho);
					if (atualNumero > proximoNumero) {
						processaResultadoDoProximoMaiorNumero(subTamanho);
						break;
					}
				}else {
					//Caso não houver um maior número formado por um anagrama ele deve retornar -1
					if(resultado ==0) {
						resultado =  -1;
					}
				}
			}
		}
	}
	//end
	
	// methodo do desafio do codewars
	public static long nextBiggerNumber(long n)
	{
		String convertIntToString = "" + n;
	    InicializandoVariaveis(convertIntToString);
		varreTodasPosicoesDoNumeroQueFoiInserido();
		return resultado;
	}
	//end
	
	public static void main(String[] args) {
		/* ###############################################
		 * 
		 * ESCOLHA O NÚMERO PARA RETORNAR O PRÓXIMO MAIOR
		 * Ex: System.out.println(nextBiggerNumber(SEU NUMERO VAI AQUI));
		 * ###############################################
		 * */
		System.out.println(nextBiggerNumber(18715));
	}
}






