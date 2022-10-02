class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> vec(2,-1);
        
        if(nums.size()==0)
            return vec;
        int start =-1;
        int end = -1;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i] == target)
            {
                if(start==-1)
                {
                    start=i;
                }
                end = i;
            }
        }
        
        //cout<<start <<" "<<end;
        vec[0] =start;
        vec[1] = end;
        
        return vec;
    }
};