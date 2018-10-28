/*
A ideia do do mergesort é: divide o array no meio em duas partes. Sabendo que
ambas as partes estejam ordenadas, é rápido inseri-las novamente de forma ordenada
no array comparando sempre a "cabeça" de cada parte. Seguindo essa ideia, podemos
chamar o algoritmo recursivamente até que cada parte tenha tamanho 1 e, portanto, esteja
ordenada. A partir de então podemos voltar na recursão inserindo de volta no array
de forma linear.

Complexidade:
Como sempre o array é dividido em 2 a cada iteração, será necessário O(log(n))
iterações até chegar no caso base. Em cada iteração é necessário juntar as metades,
o que pode ser feito em O(n). Logo, o algoritmo tem complexidade O(n.log(n)).
*/

import java.util.LinkedList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

	public void sort(T[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int meio = (left + right) / 2;
		sort(array, left, meio);
		sort(array, meio+1, right);
		this.merge(array, left, meio, right);
	}

	private void merge(T[] array, int left, int meio, int right) {
		int limite1 = meio - left;
		int limite2 = right - meio;

		List<T> lista1 = new LinkedList<>();
		List<T> lista2 = new LinkedList<>();

		for (int i = 0; i <= limite1; i++) {
			lista1.add(array[left + i]);
		}

		for (int i = 0; i < limite2; i++) {
			lista2.add(array[meio + 1 + i]);
		}

		int i = 0;
		int j = 0;
		int k = left;

		while((i <= limite1) && (j < limite2)) {
			if (lista1.get(i).compareTo(lista2.get(j)) > 0) {
				array[k] = lista2.get(j);
				j++;
			} else {
				array[k] = lista1.get(i);
				i++;
			}
			k++;
		}
		while (i <= limite1) {
			array[k] = lista1.get(i);
			i++;
			k++;
		}

		while (j < limite2) {
			array[k] = lista2.get(j);
			j++;
			k++;
		}
	}
}
