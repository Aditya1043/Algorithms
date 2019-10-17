class Knapsack
{
	static void merge(item arr[],int low,int mid,int high)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		item first[]=new item[n1];
		item second[]=new item[n2];
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
			if(first[i].pw>=second[j].pw)
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
	static void mergeSort(item arr[],int low,int high)
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
		int p[]={10,5,15,7,6,18,3};
		int w[]={2,3,5,7,1,4,1};
		int cap=15;
		int n=7;
		double out=0;
		item pw[]=new item[n];
		for(int i=0;i<n;i++)
		{
			pw[i]=new item(p[i],w[i]);
		}
		mergeSort(pw,0,n-1);
		for(int i=0;i<n;i++)
		{
			if(pw[i].w<=cap)
			{
				cap-=pw[i].w;
				out+=pw[i].p;
			}
			else
			{
				out=out+(double)cap/pw[i].w*pw[i].p;
				break;
			}
		}
		System.out.println(out);
	}
}
class item
{
	int p;
	int w;
	double pw;
	item(int p,int w)
	{
		this.p=p;
		this.w=w;
		this.pw=(double)p/w;
	}
}