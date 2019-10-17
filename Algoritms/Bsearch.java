class Bsearch
{
	int lowBinarySearch(int arr[],int left,int right,int key)
	{
		if(left>right)
			return -1;
		int mid=(left+right)/2;
		if(arr[mid]==key && (key>arr[mid-1]  || mid==0))
			return mid;
		if(key>arr[mid])
			return lowBinarySearch(arr,mid+1,right,key);
		return lowBinarySearch(arr,left,mid-1,key);
	}
	int highBinarySearch(int arr[],int left,int right,int key,int n)
	{
		if(left>right)
			return -1;
		int mid=(left+right)/2;
		if(arr[mid]==key && (key<arr[mid+1]  || mid==n-1))
			return mid;
		if(key<arr[mid])
			return highBinarySearch(arr,left,mid-1,key,n);
		return highBinarySearch(arr,mid+1,right,key,n);
	}
	public static void main(String args[])
	{
		Bsearch b=new Bsearch();
		int arr[] = { 2, 3, 4, 10,10,10,10,10, 10,40 }; 
        int n = arr.length; 
        int x = 10; 
        int result = b.highBinarySearch(arr, 0, n - 1, x,n); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("high found at index " + result); 
		
		int result1 = b.lowBinarySearch(arr, 0, n - 1, x); 
        if (result1 == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("low found at index " + result1); 
	}
}