import java.util.*;
class Job
{
	void merge(int arr[][],int low,int mid,int high)
	{
		int first[][]=new int[mid-low+1][3];
		int second[][]=new int[high-mid][3];
		for(int i=0;i<mid-low+1;i++)
			first[i]=arr[low+i];
		for(int i=0;i<high-mid;i++)
			second[i]=arr[mid+1+i];
		int k=low;
		int z=0;
		int x=0;
		while(z<mid-low+1 && x<high-mid)
		{
			if(first[z][2]<=second[x][2])
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
	void mergeSort(int arr[][],int low,int high)
	{
		if(low>=high)
			return;
		int temp=(low+high)/2;
		mergeSort(arr,low,temp);
		mergeSort(arr,temp+1,high);
		merge(arr,low,temp,high);
	}
	
	int findmaxdur(int arr[][])
	{
		int max=0;
		for(int i=0;i<4;i++)
		{
			if(arr[i][1]>max)
				max=arr[i][1];
		}
		return max;
	}
	
	public static void main(String args[])
	{
		int arr[][]={ {'a', 2, 6}, {'b', 1, 8}, {'c', 1, 5}, 
                   {'d', 2, 10}};
		Job j=new Job();
		j.mergeSort(arr,0,3);
		int done[]=new int[j.findmaxdur(arr)];
		int sum=0;
		for(int i=3;i>=0;i--)
		{
			int temp=arr[i][1]-1;
			while(temp>=0)
			{
				if(done[temp]==0)
				{
					done[temp]=1;
					sum=sum+arr[i][2];
					System.out.println(arr[i][2]);
					break;
				}
				temp--;
			}
		}
		System.out.println(sum);
	}
}