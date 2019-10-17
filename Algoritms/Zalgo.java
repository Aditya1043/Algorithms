import java.util.*;
class Zalgo
{
	public static void main(String args[])
	{
		Zalgo z=new Zalgo();
        String text = "GEEKS FOR GEEKS"; 
        String pattern = "GEEK";
		String concat=pattern+"$"+text;
		int n=concat.length();
		int arr[]=new int[n];
		for(int i=1;i<n;i++)
		{
			int count=0;
			int temp=i;
			for(int j=0;j<n && i<n;j++)
			{
				if(concat.charAt(i++)==concat.charAt(j))
					count++;
				else 
					break;
			}
			i=temp;
			arr[i]=count;
		}
		for(int i=0;i<n;i++)
		{
			if(arr[i]==pattern.length())
				System.out.println("pattern found at index "+(i-pattern.length()-1));
		}
	}
}