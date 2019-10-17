class Alphapermutation
{
	void merge(char arr[],int low,int mid,int high)
	{
		char first[]=new char[mid-low+1];
		char second[]=new char[high-mid];
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
	String mergeSort(char arr[],int low,int high)
	{
		if(low<high)
		{
			int temp=(low+high)/2;
			mergeSort(arr,low,temp);
			mergeSort(arr,temp+1,high);
			merge(arr,low,temp,high);
		}
		return String.valueOf(arr);
	}
	void swap(char arr[],int i,int j)
	{
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	void permutations(char arr[])
	{
		int n=arr.length;
		mergeSort(arr,0,n-1);
		
		boolean flag=true;
		while(flag)
		{
			System.out.println(arr);
			int i;
			for(i=n-2;i>=0;i--)
				if(arr[i]<arr[i+1])
					break;
			
			if(i==-1)
				flag=false;
			else
			{
				int ceilIndex=i+1;
				for(int j=i+1;j<n;j++)
					if(arr[j]>arr[i]&&arr[j]<arr[ceilIndex])
						ceilIndex=j;
				
				swap(arr,i,ceilIndex);
				
				mergeSort(arr,i+1,n-1);
			}
		}
	}
	public static void main(String args[])
	{
		Alphapermutation ap=new Alphapermutation();
		String str = "CDAB";  
		char arr[]=str.toCharArray();
		ap.permutations(arr);  
	}
}