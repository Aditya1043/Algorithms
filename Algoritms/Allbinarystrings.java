class Allbinarystrings
{
	void calculate(char arr[],int low,int high)
	{
		if(low==high)
		{
			System.out.println(arr);
		}
		else
		{
			arr[low]='0';
			calculate(arr,low+1,4);
			arr[low]='1';
			calculate(arr,low+1,4);
		}
	}
	public static void main(String args[])
	{
		Allbinarystrings a=new Allbinarystrings();
		char arr[]=new char[4];
		a.calculate(arr,0,4);
	}
}