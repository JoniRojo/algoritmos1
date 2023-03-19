package practica5.Sorting;

// Java program to sort an array
// of dates using Radix Sort
import java.util.*;
class GFG{

// Utilitiy function to obtain
// maximum date or month or year
static int getMax(int arr[][], int n, int q)    //n cantidad de fechas, q=0 dia q=1 mes q=2 ano
{
	int maxi = Integer.MIN_VALUE;
	for(int i = 0; i < n; i++)
	{
		maxi = Math.max(maxi, arr[i][q]);
	}
	return maxi;
}

// A function to do counting sort of arr[]
// according to given q i.e.
// (0 for day, 1 for month, 2 for year)
static void sortDatesUtil(int arr[][],
				int n, int q)
{
	int maxi = getMax(arr,n,q);
	int p = 1;
	while(maxi > 0)
	{
		// to extract last digit divide
		// by p then %10
		// Store count of occurrences in cnt[]
		int []cnt = new int[10];
		
		for(int i = 0; i < n; i++)
		{
			cnt[(arr[i][q]/p) % 10]++;
		}
		for(int i = 1; i < 10; i++)
		{
			cnt[i] += cnt[i - 1];
		}
		int [][]ans = new int[n][3];
		for(int i = n - 1; i >= 0; i--)
		{
			int lastDigit = (arr[i][q]/p) % 10;
			
			// Build the output array
			for(int j = 0; j < 3; j++)
			{
				ans[cnt[lastDigit]-1][j]
				=arr[i][j];	
			}
			cnt[lastDigit]--;
		}
		
		// Copy the output array to arr[],
		// so that arr[] now
		// contains sorted numbers
		// according to current digit
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				arr[i][j] = ans[i][j];
			}
		}
		
		// update p to get
		// the next digit
		p *= 10;
		maxi /= 10;
	}
}

// The main function that sorts
// array of dates
// using Radix Sort
static void sortDates(int dates[][], int n)
{
	
	// First sort by day
	sortDatesUtil(dates, n, 0);
	
	// Then by month
	sortDatesUtil(dates, n, 1);
	// Finally by year
	sortDatesUtil(dates, n, 2);
}

// A utility function to print an array
static void printArr(int arr[][], int n)
{
for(int i = 0; i < 6; i++)
{
		for(int j = 0; j < 3; j++)
		{
			System.out.print(arr[i][j] + " ");
		}
		System.out.println();
	}
}

// Driver Code
public static void main(String[] args)
{
	int dates[][] = {{20, 1, 2014},
					{25, 3, 2010},
					{ 3, 12, 2000},
					{18, 11, 2000},
					{19, 4, 2015},
					{ 9, 7, 2005}};
	int n = dates.length;
	
	// Function Call
	sortDates(dates,n);
	System.out.print("\nSorted Dates\n");
	printArr(dates,n);
}
}

// This code is contributed by Rajput-Ji
