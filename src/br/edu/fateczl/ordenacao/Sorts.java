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
		vetor = particao(vetor, 0, vetor.length);
		return vetor;
	}

	private static int[] particao(int[] vetor, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		if (inicio != fim) {
//			ainda não cheguei na "raiz" (vetor de 1 posição)
			/* 1/2 */particao(vetor, inicio, meio);
			/* 2/2 */particao(vetor, (meio + 1), fim);
			  /* 2/2 */particao(vetor, (meio + 1), fim);
	    } else{ //PORQUE ORDENA SÓ NO FIM????
//			a ordenacao sempre se faz necessária quando se chega na última rodada, quando meu vetor tem só [1] em referencia de memória eu retorno ele ordenando as partes 
	      vetor = ordenacao(vetor, inicio, meio, fim);
//			vou voltando recursivamente o vetor ordenado por rodadas
	    }
		return vetor;
	}

	private static int[] ordenacao(int[] vetor, int inicio, int meio, int fim) {
		int[] aux = new int[vetor.length];

//		cópia dos valores dentro do intervalo sub-vetor para o vetor auxiliar;
		for (int c = inicio; c < fim; c++) {
											//   se deixar <= a fim ele estoura 
			aux[c] = vetor[c];
		}

		int in1 = inicio, in2 = (meio + 1); // marca o começo das duas partes

//		ordenação dos valores copiados dentro do auxiliar SEGUINDO AS "REGRAS DE CONVIVÊNCIA"
		for (int o = inicio; o < fim; o++) {
//								quero que ele chegue na última posição, para encaixar em uma condições
			if (in1 > meio) {
//				essa partição inteira foi checada antes do fim da outra, vetor "menor". A partir dessa posição O, todos os valores serão da parte2
				vetor[o] = aux[in2];
				in2++;
			} else {
				if (in2 > fim) {
//					 A partir dessa posição O, todos os valores serão da parte1
					vetor[o] = aux[in1];
					in1++;
				} else {
//					as regras para a INTERCALAÇÃO das variáveis; intercala as posiçõoes existentes no auxiliar, vendo se a primeira particão é maior que a segunda
					if (aux[in1] < aux[in2]) {
						vetor[o] = aux[in1];
						in1++;
					} else {
						vetor[o] = aux[in2];
						in2++;
					}
				}

			}
		}

		return vetor;
	}

}
