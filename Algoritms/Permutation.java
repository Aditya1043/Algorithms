import java.util.*;
class Permutation
{
	void calculate(String str,int l,int h)
	{
		if(l==h)
			System.out.println(str);
		else
		{
			for(int i=l;i<=h;i++)
			{
				str=swap(str,l,i);
				calculate(str,l+1,h);
				str=swap(str,l,i);
			}
		}
	}
	String swap(String str,int i,int j)
	{
		char arr[]=str.toCharArray();
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return String.valueOf(arr); 
	}
	public static void main(String args[])
	{
		Permutation p=new Permutation();
		String str = "ABCD";  
		int n = str.length();  
		p.calculate(str, 0, n-1);  
	}
}