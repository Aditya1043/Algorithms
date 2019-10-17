class Minplatform
{
	static void merge(int arr[],int low,int mid,int high)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		int first[]=new int[n1];
		int second[]=new int[n2];
		for(int i=0;i<n1;i++)
		{
			first[i]=arr[low+i];
		}
		for(int i=0;i<n2;i++)
		{
			second[i]=arr[mid+1+i];
		}
		int i=0,j=0,k=low;
		while(i<n1 && j<n2)
		{
			if(first[i]<=second[j])
			{
				arr[k++]=first[i++];
			}
			else
			{
				arr[k++]=second[j++];
			}
		}
		while(i<n1)
		{
			arr[k++]=first[i++];
		}
		while(j<n2)
		{
			arr[k++]=second[j++];
		}
	}
	static void mergeSort(int arr[],int low,int high)
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
	    int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		mergeSort(arr,0,arr.length-1);
		mergeSort(dep,0,dep.length-1);
		int max=1,plat=1;
		int i=1,j=0;
		while(i<arr.length && j<dep.length)
		{
			if(arr[i]<=dep[j])
			{
				plat++;
				i++;
				if(plat>max)
					max=plat;
			}
			else
			{
				plat--;
				j++;
			}
		}
		System.out.println(max);
	}
}