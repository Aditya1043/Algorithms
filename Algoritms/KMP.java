class KMP
{
	public static void main(String args[])
	{
        String txt = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB"; 
		int n=txt.length();
		int n1=pat.length();
		int arr[]=new int[n1];
		arr[0]=0;
		int start=0,i=1;
		while(i<n1)
		{
			if(pat.charAt(start)==pat.charAt(i))
			{
				start++;
				arr[i]=start;
				i++;
			}
			else
			{
				if(start!=0)
				{
					start=arr[start-1];
				}
				else
				{
					arr[i]=start;
					i++;
				}
			}
		}
		int k=0,j=0;
		while(j<n)
		{
			if(txt.charAt(j)==pat.charAt(k))
			{
				k++;
				j++;
			}
			if(k==n1)
			{
				System.out.println("pattern found"+j);
				k=arr[k-1];
			}
			else if(j<n && txt.charAt(j)!=pat.charAt(k))
			{
				if(k!=0)
					k=arr[k-1];
				else
					j++;
			}
		}
	}
}