package dataStructure.searching;
/*
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        key = 3
        Output : Found at index 8
*/
public class PivotedSearch {

    //  binary search function
        public static int binarySearch(int arr[], int low, int high, int key)
        {
            //base case
            if(high<low)
                return -1;

            //find mid
            int mid= low+(high-1)/2;
            if(arr[mid]==key)
                return mid;
            if(key>arr[mid])
                return binarySearch(arr, mid+1, high, key );
            return  binarySearch(arr, low, mid-1, key);

        }

        //find pivot element: the only element for which the next element to it is smaller than it.
        public static int findPivot(int arr[], int low, int high)
        {
            // find mid
            int mid=low+(high-low)/2;

            //base cases
            if(high<low)
                return -1;
            if(high==low)
                return low;

            if(mid>low && arr[mid] > arr[mid-1])
                return (mid-1);
            if(mid<high && arr[mid]>arr[mid+1])
                return mid;
            if(arr[low]>=arr[mid])
                return findPivot(arr, low,mid-1);
            return findPivot(arr, mid+1, high);

        }

        //function to search key in pivoted array
        public static int pivotedBinarySearch(int arr[], int n, int key)
        {
            //find pivot element
            int pivot=findPivot(arr,0,n-1);

            if(pivot==-1)
                return binarySearch(arr,0,n-1,key);
            if(key==arr[pivot])
                return pivot;
            if(arr[0]<=key)
                return binarySearch(arr, 0, pivot-1, key);
            return binarySearch(arr, pivot+1, n-1, key);

        }
}
