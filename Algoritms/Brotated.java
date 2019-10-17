class Brotated
{
	int rotated(int arr[],int left,int right,int key)
	{
		if(left>right)
			return -1;
		int mid=(left+right)/2;
		if(arr[mid]==key)
			return mid;
		if(arr[left]<=arr[mid-1])
		{
			if(key>=arr[left] && key<=arr[mid-1])
				return rotated(arr,left,mid-1,key);
			return rotated(arr,mid+1,right,key);
		}
		if(key>=arr[mid+1] && key<=arr[right])
			return rotated(arr,mid+1,right,key);
		return rotated(arr,left,mid-1,key);	
	}
	public static void main(String args[])
	{
		Brotated b=new Brotated();
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3}; 
        int n = arr.length; 
        int key = 6; 
        int i = b.rotated(arr, 0, n-1, key); 
        if (i != -1)  
            System.out.println("Index: " + i); 
        else
            System.out.println("Key not found"); 
	}
}