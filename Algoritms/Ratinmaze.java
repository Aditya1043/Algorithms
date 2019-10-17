class Ratinmaze
{
	static int N=4;
	static boolean solveMaze(int arr[][],int i,int j,int sol[][])
	{
		if(i==N-1 && j==N-1)
		{
			sol[i][j]=1;
			return true;
		}
		if(i>=0 && j>=0 && i<N && j<N && arr[i][j]==1)
		{
			sol[i][j]=1;
			if(solveMaze(arr,i+1,j,sol))
				return true;
			if(solveMaze(arr,i,j+1,sol))
				return true;
			sol[i][j]=0;
			return false;
		}
		return false;
	}
	public static void main(String args[])
	{	
		int maze[][] = { { 1, 0, 0, 0 }, 
						   { 1, 1, 0, 1 }, 
						   { 0, 1, 0, 0 }, 
						   { 1, 1, 1, 1 } }; 
		int sol[][] = { { 0, 0, 0, 0 }, 
                      { 0, 0, 0, 0 }, 
                      { 0, 0, 0, 0 }, 
                      { 0, 0, 0, 0 } }; 
		if(solveMaze(maze,0,0,sol))
		{
		for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(sol[i][j]+" ");
				}
				System.out.println("");
			}
		}
		else
		{
			System.out.println("No solution exits");
		}
	}
}