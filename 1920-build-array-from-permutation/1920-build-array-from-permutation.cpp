class Solution {
public:
    vector<int> buildArray(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n;i++)
        {
            int a=nums[nums[i]];
            nums.push_back(a);
        }
        for(int i=0;i<n;i++)
        {
            nums.erase(nums.begin());
        }
        return nums;
    }
};