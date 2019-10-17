import java.util.*;
class Msort
{
	void merge(int arr[],int low,int mid,int high)
	{
		int first[]=new int[mid-low+1];
		int second[]=new int[high-mid];
		for(int i=0;i<mid-low+1;i++)
			first[i]=arr[low+i];
		for(int i=0;i<high-mid;i++)
			second[i]=arr[mid+1+i];
		int k=low;
		int z=0;
		int x=0;
		while(z<mid-low+1 && x<high-mid)
		{
			if(first[z]<=second[x])
			{
				arr[k]=first[z];
				z++;
			}
			else
			{
				arr[k]=second[x];
				x++;
			}
			k++;
		}
		while(z<mid-low+1)
		{
			arr[k++]=first[z++];
		}
		while(x<high-mid)
		{
			arr[k++]=second[x++];
		}
	}
	void mergeSort(int arr[],int low,int high)
	{
		if(low>=high)
			return;
		int temp=(low+high)/2;
		mergeSort(arr,low,temp);
		mergeSort(arr,temp+1,high);
		merge(arr,low,temp,high);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//int arr[][]={{'a',2,6},{'b',1,8},{'c',1,5},{'d',2,10}};
		Msort j=new Msort();
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		j.mergeSort(arr,0,n-1);
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
}