class All2ndbit1
{
	void calculate(char arr[],int low,int high)
	{
		if(low==high)
		{
			System.out.println(arr);
		}
		else
		{
			if(low!=1)
			{
				arr[low]='0';
				calculate(arr,low+1,high);
			}
			arr[low]='1';
			calculate(arr,low+1,high);
		}
	}
	public static void main(String args[])
	{
		All2ndbit1 a=new All2ndbit1();
		int n=3;
		char arr[]=new char[n];
		a.calculate(arr,0,n);
	}
}