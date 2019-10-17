class Nqueens
{
	static final int n=4;
	static boolean isSafe(int arr[][],int col,int row)
	{		
		for(int i=0;i<col;i++)
			if(arr[row][i]==1)
				return false;
			
		for (int i = row,j = col; i >= 0 && j >= 0; i--, j--) 
            if (arr[i][j] == 1) 
                return false; 
  
        for (int i = row,j = col; j >= 0 && i < n; i++, j--) 
            if (arr[i][j] == 1) 
                return false; 
  
        return true; 
	}
	static boolean nQueen(int arr[][],int col)
	{
		if(col>=n)
			return true;
		for(int i=0;i<n;i++)
		{
			if(isSafe(arr,col,i))
			{
				arr[i][col]=1;
				if(nQueen(arr,col+1)==true)
					return true;
				arr[i][col]=0;
			}
		}
		return false;
	}
	public static void main(String args[])
	{
		int arr[][]=new int[n][n];
		if(nQueen(arr,0))
		{
			System.out.println("yes");
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
	}
}