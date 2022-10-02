class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        double median;
        ArrayList <Integer> arr= new ArrayList<>();
        int j=0,k=0;
        while(k<n && j<m)
        {
            if(nums1[k]>nums2[j])
                {
                    arr.add(nums2[j]);
                    j++;
                }
            else 
                {
                    arr.add(nums1[k]);
                    k++;
                }
        }
        while(k<n)
            {
                arr.add(nums1[k]);
                k++;
            }
         while(j<m)
            {
                arr.add(nums2[j]);
                j++;
            }
        n=n+m;
        if(n%2==0)
        {
            median=(double)(arr.get(n/2)+ arr.get((n/2)-1))/2;
            
        }
        else
        {
            median=arr.get(n/2);
        }
        return median;
    }
}