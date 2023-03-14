/*
RESUMO      : Exercício 04, Implementação do Merge Sort (algoritmo de ordenação de dados)
PROGRAMADORA: Luiza Felix
DATA        : 14/03/2023
 */

package br.edu.fateczl.ordenacao;

public class MergeSort {
	public MergeSort() {

	}

	public int[] main(int[] vetor, int tamanho) {
		int[] aux = new int[tamanho];
		particao(vetor, aux, 0, (tamanho - 1));
		return vetor;

	}

	private static void particao(int[] vetor, int[] aux, int inicio, int fim) {
		if (fim != inicio) {
//		se os vetores ainda não têm [0], eu continuo a repartição
			int meio = (inicio + fim) / 2;
			/* primeira metade de um pedaço do vetor */particao(vetor, aux, inicio, meio);
			/* segunda metade de um pedaço do vetor */particao(vetor, aux, (meio + 1), fim);
			/* aqui temos a INTERCALAÇÃO dos mini-vetores */ordenacao(vetor, aux, inicio, meio, fim);
		} 
	}

	private static void ordenacao(int[] vetor, int[] aux, int inicio, int meio, int fim) {
		for (int copia = inicio; copia <= fim; copia++) {
//			nesse momento faço a cópia das variáveis entre as posições selecionadas para meu auxiliar;
			aux[copia] = vetor[copia];

			int v1 = inicio, v2 = meio + 1; // inicio das duas partições do vetor

			for (int intercalacao = inicio; intercalacao <= fim; intercalacao++) {
//				aqui eu estou fazendo a intercalação das duas partes do vetor existentes nessa linha utilizando as regras determinadas no documento
				if (v1 > meio) {
//					acabou a 1º "metade" repartida do vetor
					vetor[intercalacao] = aux[v2++];
				} else {
					if (v2 > fim) {
//						acabou a 2º "metade" repartida do vetor
						vetor[intercalacao] = aux[v1++];
					} else {
//						aqui eu faço a CONCATENAÇÃO de fato
						if (aux[v1] < aux[v2]) {
							vetor[intercalacao] = aux[v1++];
						} else {
							vetor[intercalacao] = aux[v2++];
						}
					}
				}
			}
		}
	}
}
