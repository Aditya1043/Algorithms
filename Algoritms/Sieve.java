class Sieve
{
	void sieveOfEratosthenes(int n)
	{
		int arr[]=new int[n];
		for(int i=2;i<n;i++)
			arr[i]=1;
		for(int i=2;i*i<n;i++)
		{
			if(arr[i]==1)
			{
				for(int j=2;i*j<n;j++)
				{
					arr[i*j]=-1;
				}
			}
		}
		for(int i=2;i<n;i++)
		{
			if(arr[i]==1)
				System.out.println(i);
		}
	}
	public static void main(String args[])
	{
		int n=100;
		Sieve s = new Sieve(); 
        s.sieveOfEratosthenes(n); 
	}
}