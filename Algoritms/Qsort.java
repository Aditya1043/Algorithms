import java.util.*;
class Qsort
{
	static void qsort(int arr[],int low,int par)
	{
		if(low>=par)
			return;
		int j=par;
		for(int i=low;i<j;i++)
		{
			if(arr[i]>arr[par])
			{
				j--;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i--;
			}
		}
		if(par!=j)
		{
			int temp=arr[par];
			arr[par]=arr[j];
			arr[j]=temp;
		}
		qsort(arr,0,j-1);
		qsort(arr,j+1,par);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		qsort(arr,0,n-1);
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
}