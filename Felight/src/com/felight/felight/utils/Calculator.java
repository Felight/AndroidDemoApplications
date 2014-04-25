package com.felight.felight.utils;


public class Calculator {
	
	
	public static void bubbleSort(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
    }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	
	public static int[] selectionSort(int[] array){
        
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[index]) 
                    index = j;
      
            int smallerNumber = array[index];  
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        return array;
    }
	

					// Sum of all Integers in an Array
					public static long sumOfArray(int[] array) {
						long sum = 0;
						for (int i = 0; i < array.length; i++)
							sum = sum + array[i];
						return sum;
					}
	
	
	
	
		
			// Generate Random Array of Integers of size N
			public static int[] generateRandomIntArray(int size) {
				int[] result = new int[size];
				for (int i = 0; i < size; i++)
					result[i] = (int) (Math.random() * 100);
				return result;
			}

			
			
			
			
			
				// Generate Random Array of double elements of size N
				public static double[] generateRandomDoubleArray(int size) {
					double[] result = new double[size];
					for (int i = 0; i < size; i++)
						result[i] = Math.random() * 100;
					return result;
				}

				
				
				
				// Generate Random Array of char elements of size N
				public static char[] generateRandomCharArray(int size) {
					char temp;
					char[] result = new char[size];
					int i = 0;
					while (i < size) {
						temp = (char) (Math.random() * 100);
						if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z'))
							result[i++] = temp;
					}
					return result;
				}

				
				
				
				// Print Integer Array to Console
				public static void printIntArray(int[] array) {
					for (int i = 0; i < array.length; i++)
						System.out.print(array[i] + ",");
				}

				
				
				// Print double Array to Console
				public static void printDoubleArray(double[] array) {
					for (int i = 0; i < array.length; i++)
						System.out.print(array[i] + ",");
				}

				
				
				
				// Print char Array to Console
				public static void printCharArray(char[] array) {
					for (int i = 0; i < array.length; i++)
						System.out.print(array[i] + ",");
				}

	
	
	
	
					// Print Maximum integer present in Array
					public static int getMaxOfArray(int[] array) {
						int max = 0;
						for (int i = 0; i < array.length; i++)
							if (max < array[i])
								max = array[i];
						return max;
					}

	
	
	
				// Reverse an Array
				public static int[] reverseArray(int[] array) {
					int[] rev = new int[array.length];
					for (int i = 0; i < array.length; i++)
						rev[array.length - i - 1] = array[i];
					return rev;
				}
				
				
				
				

				// Reverse char Array
				public static char[] reverseArray(char[] array) {
			
					char[] reverse = new char[array.length];
					for (int i = 0; i < array.length; i++)
						reverse[array.length - i - 1] = array[i];
					return reverse;
				}

	
	
	
				// Count number of vowels in char Array
				public static int countVowels(char[] array) {
					int count = 0;
					for (int i = 0; i < array.length; i++)
						if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i'
								|| array[i] == 'o' || array[i] == 'u' || array[i] == 'A'
								|| array[i] == 'E' || array[i] == 'I' || array[i] == 'O'
								|| array[i] == 'U')
							count++;
					return count;
				}

				
				
				
				
			// Generate an array of even numbers with range
			public static int[] generateEvenArray(int from, int to) {
				int[] result = new int[50];
				for (int i = from, j = 0; i <= to; i++, j++)
					if (i % 2 == 0)
						result[j] = i;
					else
						j--;
				return result;
			}

			
			
			
				// Generate array of Odd Number with range provided
				public static int[] generateOddArray(int from, int to) {
					int[] arr = new int[50];
					for (int i = from, j = 0; i <= to; i++, j++)
						if (!(i % 2 == 0))
							arr[j] = i;
						else
							j--;
					return arr;
				}

				
				
				
			// Generate array of prime numbers with range provided
			public static int[] generatePrimeArray(int from, int to) {
		
				int[] arr = new int[50];
				for (int i = from, j = 0; i <= to; i++, j++)
					if (isPrime(i))
						arr[j] = i;
					else
						j--;
				return arr;
			}

			
			
			
			// check is the number is prime or not
			public static boolean isPrime(long num) {
				boolean result = false;
				long count = 0;
				long i = 2;
				while (i <= num / 2) {
		
					if (num % i == 0)
						count++;
					i++;
				}
				if (count == 0 && num != 1 && num != 0)
					result = true;
				return result;
			}

			
			
			// Linear Search Algorithm
			public static int linearSearch(int[] arr, int key) {
		
				int pos = -1;
				for (int i = 0; i < arr.length; i++)
					if (arr[i] == key)
						pos = i + 1;
				return pos;
			}

	
	
	
			// Binary Search Algorithm
			public static int binarySsearch(int[] array, int key) {
		
				int pos = -1;
				int low = 0;
				int high = array.length - 1;
				int mid = (low + high) / 2;
				while (low <= high) {
					mid = (low + high) / 2;
					if (key < array[mid])
						high = mid - 1;
					else if (key > array[mid])
						low = mid + 1;
					else {
						pos = mid + 1;
						break;
					}
				}
				return pos;
			}


	
			// Generate fibonacci Series
			public static int[] generateFibonacci(int num) {
		
				int[] result = new int[num];
		
				result[0] = 0;
				result[1] = 1;
				for (int i = 2; i < num; i++)
					result[i] = result[i - 1] + result[i - 2];
		
				return result;
			}
			
			

	
	
			// Print two dimensional Array to console
			public static void printMatrix(int[][] matrix) {
				int i, j;
				for (i = 0; i < matrix.length; i++) {
					for (j = 0; j < matrix[i].length; j++) {
						System.out.print(matrix[i][j] + "  ");
					}
					System.out.println(" ");
				}
			}

			
			
			
			// Sum of all elements in an two dimensional Array
			public static long sumMatrix(int[][] matrix) {
				long sum = 0;
				for (int i = 0; i < matrix.length; i++)
					for (int j = 0; j < matrix[i].length; j++)
						sum = sum + matrix[i][j];
				return sum;
			}

			
			
			// Sum of all each row in an two dimensional Array
			public static int[] sumRow(int[][] matrix) {
				int sum[] = new int[matrix.length];
				for (int i = 0; i < matrix.length; i++)
					for (int j = 0; j < matrix[i].length; j++)
						sum[i] = sum[i] + matrix[i][j];
				return sum;
			}

			
			
			
			// Sum of each column in an two dimensional Array
			public static int[] sumColumn(int[][] matrix) {
				int sum[] = new int[matrix[0].length];
				for (int i = 0; i < matrix.length; i++)
					for (int j = 0; j < matrix[i].length; j++)
						sum[j] = sum[j] + matrix[i][j];
				return sum;
			}
	
			
			
			
	//
	
}
