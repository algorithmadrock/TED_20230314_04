/*
RESUMO      : Exercício 04, Implementação do Bubble Sort (algoritmo de ordenação de dados)
PROGRAMADORA: Luiza Felix
DATA        : 14/03/2023
 */

package br.edu.fateczl.ordenacao;

public class BubbleSort {
	public BubbleSort() {

	}

	public  int[] main(int[] vetor, int tamanho) {
		for (int rodada = 1; rodada < tamanho; rodada++) {
//		no contexto do bubble sort "de fábrica" ele roda a mesma quantidade de "colunas no vetor", aqui ele "para" uma casa antes, pois a [0] já estará ordenada
			for (int i = 0; i < (tamanho - rodada); i++) {
//			aqui ele tem que parar sempre na PENÚLTIMA casa, se avançar mais uma o vetor estoura e o código morre
				if (vetor[i] > vetor[i + 1]) {
					int aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
				}
			}
		}
		return vetor;
	}
}
