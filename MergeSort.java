/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */

 class MergeSort
{
	// Fusiona dos subarrays de arr[].
	// Primer subarray es arr[l..m]
	// Segundo subarray es arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Encuentra tamaño de dos subarrays para ser fusionados
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Crea arrays temporales */
		int L[] = new int [n1];
		int R[] = new int [n2];

		/*Copia datos al array temporal*/
		for (int i=0; i<n1; ++i)
			L[i] = arr[l + i];
		for (int j=0; j<n2; ++j)
			R[j] = arr[m + 1+ j];


		/* Fusiona arrays temporales */

		// Indices iniciales del primer y segundo subarrays
		int i = 0, j = 0;

		// Indice inicial del subarray fusionado 
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copia elementos restantes de L[] si hay alguno */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copia elementos restantes de R[] si hay alguno */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Funcion principal que ordena arr[l..r] 
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Encuentra el punto medio
			int m = (l+r)/2;

			// Ordena primera y segundas mitades
			sort(arr, l, m);
			sort(arr , m+1, r);

			// Fusionar las mitades seleccionadas
			merge(arr, l, m, r);
		}
	}

	/* Funcion para imprimir array de tamaño n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7};

		System.out.println("Array Dado");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length-1);

		System.out.println("Array Ordenado");
		printArray(arr);
	}
}

   

