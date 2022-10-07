class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> mp= new HashMap<>();
        int[] arr=new int[2];
        for(int i=0;i<n;i++)
        {
            int x=nums[i];
            if(mp.containsKey(target-x))
            {
                arr[0]=mp.get(target-x);
                arr[1]=i;
            }
            mp.put(x,i);
        }
        return arr;
    }
}