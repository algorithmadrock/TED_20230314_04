/*
RESUMO      : Exercício 04, Implementação de bubble e merge sort; algoritmos de ordenação
PROGRAMADORA: Luiza Felix
DATA        : 15/03/2023
 */

package br.edu.fateczl.ordenacao;

public class Sorts {
	public Sorts() {
		super();
	}

//	BUBBLE SORT
	public static int[] Bubble(int[] vetor) {
		int tamanho = vetor.length;

		for (int rodada = 1; rodada < tamanho; rodada++) {
//		no contexto do bubble sort "de fábrica" ele roda a mesma quantidade de "colunas no vetor", aqui ele "para" uma casa antes, pois a [0] já estará ordenada
			for (int i = 0; i < (tamanho - rodada); i++) {
//			aqui ele tem que parar sempre na PENÚLTIMA casa, se avançar mais uma o vetor estoura e o código morre, por não alterar o TAMANHO do vetor, se deixar nessa condição, ele para sempre na penúltima casa
				if (vetor[i] > vetor[i + 1]) {
					int aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
				}
			}
		}
		return vetor;
	}

//	MERGE SORT
	public static int[] Merge(int[] vetor) {
		vetor = subMERGE(vetor, 0, (vetor.length - 1));
		return vetor;
	}

	private static int[] subMERGE(int[] vetor, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		if ( inicio == fim) {
			return vetor; // se for igual eu obrigatoriamente retorno o vetor
	    } else{ 
	    	/* 1/2 */subMERGE(vetor, inicio, meio);
			/* 2/2 */subMERGE(vetor, (meio + 1), fim);
			ordeMERGE(vetor, inicio, meio, fim);
//			vou voltando recursivamente o vetor ordenado por rodada 
			return vetor;
	    }	
	}

	private static void ordeMERGE(int[] vetor, int inicio, int meio, int fim) {
		int[] aux = new int[vetor.length];

//		cópia dos valores dentro do intervalo sub-vetor para o vetor auxiliar;
		for (int c = inicio; c <= fim; c++) {
											//   se deixar <= a fim ele estoura 
			aux[c] = vetor[c];
		}

		int in1 = inicio, in2 = (meio + 1); // marca o começo das duas partes DENTRO do subvetor, para a ordenação de seus "sub vetores"

//		ordenação dos valores copiados dentro do auxiliar SEGUINDO AS "REGRAS DE CONVIVÊNCIA"
		for (int o = inicio; o <= fim; o++) {
//								quero que ele chegue na última posição, para encaixar em uma condições
			if (in1 > meio) {
//				essa partição inteira foi checada antes do fim da outra, vetor "menor". A partir dessa posição O, todos os valores serão da parte2
				vetor[o] = aux[in2++];
			} else {
				if (in2 > fim) {
//					 A partir dessa posição O, todos os valores serão da parte1
					vetor[o] = aux[in1];
					in1++;
				} else {
//					as regras para a INTERCALAÇÃO das variáveis; intercala as posiçõoes existentes no auxiliar, vendo se a primeira particão é maior que a segunda
					if (aux[in1] < aux[in2]) {
						vetor[o] = aux[in1++];
//						agrego o in1 e já acumulo nele +1
					} else {
						vetor[o] = aux[in2++];
					}
				}

			}
		}

	}
	
//	QUICK SORT
	public static int[] Quick(int[] vetor) {
		vetor = subQUICK(vetor, 0, vetor.length-1);
		return vetor;
	}

	private static int[] subQUICK(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			// enquanto o fim for maior que o começo, o pivô não estoura pro negativo eu sigo repartindo com base no pivô fixo determinado anteriormente preciso saber a posição onde o pivo foi fixado para depois determinar os subvetores, como o "meio" em mergesort
			int pivofixado = pivotQUICK(vetor, inicio, fim);
			/* subvetor da esquerda */ subQUICK(vetor, inicio, (pivofixado-1));
			/* subvetor da direita */ subQUICK(vetor, (pivofixado + 1), fim);
		}
		return vetor;
		
	}

	private static int pivotQUICK(int[] vetor, int inicio, int fim) {
		// agoritmo seguindo a lógica passada no vídeo, para a ordenação do vetor

		/* ponteiro começo-fim */int red = (inicio + 1);
		/* ponteirofim-começo */int green = fim;

		// caminhada das setas
		while (red <= green) {
			
			while (red <= green && vetor[red] <= vetor[inicio]) {
				// o vermelho pode estourar o comprimento do vetor, se só houverem números menores que o pivô, fazendo com que ele se encaixe na útima posição do vetor(e se isso for executado, estourar ele). o WHILE faz com que isso se repita sem sobrecarregar a pilha de execução abrindo um while só consecutivamente
				red++;
			} // a incrementação dele cessa e a do verde começa
			while (green >= red && vetor[green] > vetor[inicio]) {
//					se não for especificado esse limite, o código estoura tbm (decrementa para além do 0)
					green--;
			}// parou a decrementação e achou uma variável menor ou igual, se eles não estão referenciados na mesma posição, eu devo fazer uma troca
			if (red < green) {
//				nesse caso eles não se cruzaram ainda, depois dessa troca eu continuo rodando
				int aux = vetor[red];
				vetor[red] = vetor[green];
				vetor[green] = aux;
				
//				logicamente se eles ainda não se cruzaram eu sigo andando
				red++;
				green--;
			}
			}
		
//		troca dos valores, determinando o novo pivô (número que ocupava a casa 0)
		int aux = vetor[inicio];
		vetor[inicio] = vetor[green];
		vetor[green] = aux;
		

		return green;
	}

}
