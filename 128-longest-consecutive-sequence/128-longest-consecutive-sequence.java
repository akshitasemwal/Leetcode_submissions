import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0)
        {
            return 0;
        }
        NavigableSet <Integer> ts= new TreeSet<> ();
        for(int i=0;i<n;i++)
        {
            ts.add(nums[i]);
        }
        int value=ts.first();
        int max=0;
        int count=0;
        for(int val: ts)
        {
            if(value==val)
            {
                count++;
            }
            else
            {
                count=1;
            }
            if(count> max)
            {
                max=count;
            }
            value=val+1;
        }
        return max;
    }
}